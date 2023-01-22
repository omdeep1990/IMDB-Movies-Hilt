package com.omdeep.imdbmoviesdaggerhilt.data

import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getPopularMovies() =  apiHelper.getPopularMovies()

}