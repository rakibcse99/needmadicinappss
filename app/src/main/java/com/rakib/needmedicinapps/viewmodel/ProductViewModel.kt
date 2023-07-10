package com.rakib.needmedicinapps.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.rakib.needmedicinapps.data.local.Product
import com.rakib.needmedicinapps.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepo: Repository) : ViewModel() {
    val productData = productRepo.data

    private val searchResults = MutableLiveData<List<Product>>()

    fun insertProductVM(product: Product) {
        viewModelScope.launch {
            productRepo.insertProductRepo(product)
        }

    }
    fun insertAllProductVM(product: List<Product>) {
        viewModelScope.launch {
            productRepo.insertAllProductRepo(product)
        }

    }

    fun updateProductVM(product: Product) {
        viewModelScope.launch {
            productRepo.updateProductRepo(product)
        }
    }


    fun getSearchResults(): LiveData<List<Product>> {
        return searchResults
    }

    fun getSearchResults(searchTitle: String): Flow<PagingData<Product>> {
        return productRepo.searchByTitleRepo(searchTitle)
    }

    fun searchProductsVM(
        searchTitle: String?,
        searchSubTitle: String?,
        createdDate: String?,
        isInStock: String?
    ): Flow<PagingData<Product>> {
        return productRepo.searchProductsRepo(
            searchTitle,
            searchSubTitle,
            createdDate,
            isInStock
        )
    }


}

