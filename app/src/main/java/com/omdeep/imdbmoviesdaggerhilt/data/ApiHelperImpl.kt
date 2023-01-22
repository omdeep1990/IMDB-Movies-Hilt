package com.omdeep.imdbmoviesdaggerhilt.data

import com.omdeep.imdbmoviesdaggerhilt.BuildConfig.API_KEY
import com.omdeep.imdbmoviesdaggerhilt.data.model.PopularMovies
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getPopularMovies(): Response<PopularMovies> =
        apiService.getPopularMovies(API_KEY)
}