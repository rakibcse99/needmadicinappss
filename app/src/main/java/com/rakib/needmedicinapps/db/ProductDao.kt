package com.rakib.needmedicinapps.db

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.*
import com.rakib.needmedicinapps.data.local.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM product_table ORDER BY id ASC LIMIT :limit OFFSET :offset")
    suspend fun getProductList(limit: Int, offset: Int): List<Product>

    @Query("SELECT * FROM product_table ORDER BY id ASC ")
    fun getProductListAll(): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(product: List<Product>)

    @Update
    suspend fun updateProduct(product: Product)

    @Query("SELECT * FROM product_table WHERE productTitle LIKE '%' || :searchTitle || '%'")
    fun searchByTitle(searchTitle: String): PagingSource<Int, Product>

    @Query("SELECT * FROM product_table WHERE productSubtitle LIKE '%' || :productSubtitle || '%'")
    fun searchBySubTitle(productSubtitle: String): PagingSource<Int, Product>

    @Query("SELECT * FROM product_table WHERE createdDate LIKE '%' || :createdDate || '%'")
    fun searchByCreatedDate(createdDate: String): PagingSource<Int, Product>

    @Query("SELECT * FROM product_table WHERE stock = 1 LIKE '%' || :stock || '%'")
    fun searchByCreatedStock(stock: String): PagingSource<Int, Product>

    @Query("SELECT * FROM product_table WHERE (:searchTitle = '' OR productTitle LIKE '%' || :searchTitle || '%') AND (:searchSubTitle = '' OR productSubtitle LIKE '%' || :searchSubTitle || '%') AND (:createdDate = '' OR createdDate LIKE '%' || :createdDate || '%') AND (:isInStock = '' OR stock = 1 LIKE '%' || :isInStock || '%')")
    fun searchProducts(
        searchTitle: String?,
        searchSubTitle: String?,
        createdDate: String?,
        isInStock: String?
    ): PagingSource<Int, Product>

}