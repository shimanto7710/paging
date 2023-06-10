package com.example.pagging3.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagging3.model.PassengerModel
import com.example.pagging3.retrofit.RetrofitAPI
import java.lang.Exception

class PassengerPagingSource(private val quoteAPI: RetrofitAPI) : PagingSource<Int, PassengerModel.Data>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PassengerModel.Data> {
        return try {
            val position = params.key ?: 1
            val size = params.loadSize ?: 10
            val response = quoteAPI.getPassenger(position, size)

            return LoadResult.Page(
                data = response.data,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == response.totalPages) null else position + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PassengerModel.Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}