package com.rakib.needmedicinapps.ui

import android.view.WindowManager
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.rakib.needmedicinapps.R
import com.rakib.needmedicinapps.adapter.LoaderAdapter
import com.rakib.needmedicinapps.adapter.ProductAdapter
import com.rakib.needmedicinapps.base.BaseFragment
import com.rakib.needmedicinapps.databinding.FragmentProductBinding
import com.rakib.needmedicinapps.utils.Utils
import com.rakib.needmedicinapps.utils.hideSoftKeyboard
import com.rakib.needmedicinapps.utils.onTextChanged
import com.rakib.needmedicinapps.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class ProductFragment : BaseFragment<FragmentProductBinding>() {
    private var searchTitle: String? = ""
    private var searchSubTitle: String? = ""
    var createdDate: String? = ""
    var isInStock: String? = ""

    @Inject
    lateinit var productAdapter: ProductAdapter
    private val viewModel by viewModels<ProductViewModel>()

    private var type: String = ""
    private var hasData = false

    override fun getFragmentView(): Int {
        return R.layout.fragment_product
    }

    override fun configUi() {
        viewModel.insertAllProductVM(Utils.productItems)
        binding.productRecyclerView.adapter = productAdapter.withLoadStateFooter(LoaderAdapter())
        lifecycleScope.launch {
            viewModel.productData.collectLatest {
                productAdapter.submitData(it)
            }
        }

    }

    override fun setupNavigation() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.homeIcon.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.filterBtn.setOnClickListener {
            showBottomSheetFilterType()
            hideSoftKeyboard()
        }
        binding.searchET.onTextChanged {
            if (!it.isNullOrBlank()) {
                when (binding.searchET.hint) {
                    "Search by productTitle", "Search here..." -> {

                        lifecycleScope.launch {
                            viewModel.searchProductsVM(
                                it.trim(),
                                "",
                                "",
                                ""
                            ).collectLatest { pagingData ->
                                productAdapter.submitData(pagingData)
                            }
                        }


                    }

                    "Search by productSubtitle" -> {
                        lifecycleScope.launch {
                            viewModel.searchProductsVM(
                                "",
                                it.trim(),
                                "",
                                isInStock
                            ).collectLatest { pagingData ->
                                productAdapter.submitData(pagingData)
                            }
                        }
                    }

                    "Search by createdDate" -> {
                        lifecycleScope.launch {
                            viewModel.searchProductsVM(
                                "",
                                "",
                                it.trim(),
                                ""
                            ).collectLatest { pagingData ->
                                productAdapter.submitData(pagingData)
                            }
                        }
                    }

                    "Search by stock" -> {
                        lifecycleScope.launch {
                            viewModel.searchProductsVM(
                                "",
                                "",
                                "",
                                it.trim()
                            ).collectLatest { pagingData ->
                                productAdapter.submitData(pagingData)
                            }
                        }
                    }
                }

            } else {

                lifecycleScope.launch {
                    viewModel.searchProductsVM(
                        "",
                        "",
                        "",
                        ""
                    ).collectLatest { pagingData ->
                        productAdapter.submitData(pagingData)
                    }
                }

            }


        }
    }

    private fun showBottomSheetFilterType() {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(R.layout.item_by_search)
        bottomSheetDialog.behavior.maxHeight = 2000 // set max height when expanded in PIXEL
        bottomSheetDialog.window!!.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        bottomSheetDialog.findViewById<LinearLayout>(R.id.productTitle)!!.setOnClickListener {
            type = it.tag.toString()
            hasData = false
            binding.searchET.hint = "Search by $type"
            binding.searchET.requestFocus()

            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.findViewById<LinearLayout>(R.id.productSubtitle)!!
            .setOnClickListener {

                type = it.tag.toString()
                hasData = false
                binding.searchET.hint = "Search by $type"
                binding.searchET.requestFocus()
                bottomSheetDialog.dismiss()
            }
        bottomSheetDialog.findViewById<LinearLayout>(R.id.createdDate)!!.setOnClickListener {
            type = it.tag.toString()
            hasData = false
            binding.searchET.hint = "Search by $type"
            binding.searchET.requestFocus()
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.findViewById<LinearLayout>(R.id.stock)!!.setOnClickListener {
            type = it.tag.toString()
            hasData = false
            binding.searchET.hint = "Search by $type"
            binding.searchET.requestFocus()
            lifecycleScope.launch {
                viewModel.searchProductsVM(
                    "",
                    "",
                    "",
                    "1"
                ).collectLatest { pagingData ->
                    productAdapter.submitData(pagingData)
                }
            }
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }
}
