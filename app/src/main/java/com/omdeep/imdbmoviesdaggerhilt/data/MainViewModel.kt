package com.omdeep.imdbmoviesdaggerhilt.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omdeep.imdbmoviesdaggerhilt.data.model.MoviesResponse
import com.omdeep.imdbmoviesdaggerhilt.utils.NetworkHelper
import com.omdeep.imdbmoviesdaggerhilt.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _popularMovies = MutableLiveData<Resource<List<MoviesResponse>>>()
    val popularMovies: LiveData<Resource<List<MoviesResponse>>>
        get() = _popularMovies

    init {
        fetchPopularMovies()
    }

    private fun fetchPopularMovies() {
        viewModelScope.launch {
            _popularMovies.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getPopularMovies().let {
                    if (it.isSuccessful) {
                        _popularMovies.postValue(Resource.success(it.body()!!.moviesResponses))
                    } else _popularMovies.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _popularMovies.postValue(Resource.error("No internet connection", null))
        }
    }
}