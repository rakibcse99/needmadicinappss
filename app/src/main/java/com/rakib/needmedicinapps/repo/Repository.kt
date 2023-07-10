package com.rakib.needmedicinapps.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rakib.needmedicinapps.data.local.Product
import com.rakib.needmedicinapps.db.ProductDao
import com.rakib.needmedicinapps.paging.ProductPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val productDao: ProductDao) {
    val data = Pager(
        PagingConfig(
            pageSize = 20,
            enablePlaceholders = false,
            initialLoadSize = 20
        ),
    ) {
        ProductPagingSource(productDao)
    }.flow

    //search by title

    fun searchByTitleRepo(searchTitle: String): Flow<PagingData<Product>> {
        return Pager(
            config = PagingConfig(pageSize = 20,  enablePlaceholders = false, initialLoadSize = 20),
            pagingSourceFactory = { productDao.searchByTitle(searchTitle) }
        ).flow
    }
    //search by product
    fun searchProductsRepo(
        searchTitle: String?,
        searchSubTitle: String?,
        createdDate: String?,
        isInStock: String?
    ): Flow<PagingData<Product>> {
        return Pager(
            config = PagingConfig(pageSize = 20,  enablePlaceholders = false, initialLoadSize = 20),
            pagingSourceFactory = {
                productDao.searchProducts(
                    searchTitle,
                    searchSubTitle,
                    createdDate,
                    isInStock
                )
            }
        ).flow
    }
    //

    suspend fun insertProductRepo(item: Product) {
        productDao.insert(item)
    }

    suspend fun insertAllProductRepo(item: List<Product>) {
        productDao.insertAll(item)
    }




    suspend fun updateProductRepo(item: Product) {
        productDao.insert(item)

    }



}