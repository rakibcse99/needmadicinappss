package com.rakib.needmedicinapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.rakib.needmedicinapps.data.local.Product
import com.rakib.needmedicinapps.databinding.ItemProductBinding
import com.rakib.needmedicinapps.utils.gone
import com.rakib.needmedicinapps.utils.show
import javax.inject.Inject

class ProductAdapter @Inject constructor() : PagingDataAdapter<Product, ProductAdapter.ProductViewHolder>(Comparator) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layOutBinding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(layOutBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        getItem(position)?.let {
            holder.binding.stockOut.gone()
            holder.binding.productName.text = it.productTitle
            holder.binding.productGenerics.text = it.productSubtitle
            holder.binding.productDate.text = it.createdDate
            holder.binding.productImg.load(it.productImage)
            if (!it.stock){
                holder.binding.stockOut.show()
            }else{
                holder.binding.stockOut.gone()
            }


        }

    }
    inner class ProductViewHolder(val binding: ItemProductBinding) : ViewHolder(binding.root) {
    }

    companion object {
        private val Comparator =
            object : DiffUtil.ItemCallback<Product>() {
                override fun areItemsTheSame(
                    oldItem: Product,
                    newItem: Product
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: Product,
                    newItem: Product
                ): Boolean {
                    return oldItem == newItem
                }

            }

    }
}