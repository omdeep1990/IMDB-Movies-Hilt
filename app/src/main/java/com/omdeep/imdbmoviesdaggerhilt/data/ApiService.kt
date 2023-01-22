package com.omdeep.imdbmoviesdaggerhilt.data

import com.omdeep.imdbmoviesdaggerhilt.data.model.PopularMovies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("MostPopularMovies/{apiKey}")
    suspend fun getPopularMovies(@Path("apiKey") apikey : String) : Response<PopularMovies>
}