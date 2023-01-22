package com.omdeep.imdbmoviesdaggerhilt.data

import com.omdeep.imdbmoviesdaggerhilt.data.model.PopularMovies
import retrofit2.Response

interface ApiHelper {

    suspend fun getPopularMovies() : Response<PopularMovies>
}