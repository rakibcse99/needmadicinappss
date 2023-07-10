package com.rakib.needmedicinapps.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rakib.needmedicinapps.data.local.Product
import com.rakib.needmedicinapps.db.ProductDao
import kotlinx.coroutines.delay

class ProductPagingSource(
    private val dao: ProductDao
) : PagingSource<Int,Product>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        val page = params.key ?: 0

        return try {
            val entities = dao.getProductList(params.loadSize, page * params.loadSize)

            // simulate page loading
            if (page != 0) delay(1000)

            LoadResult.Page(
                data = entities,
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (entities.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
