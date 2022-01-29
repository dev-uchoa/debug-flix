package com.debug.debugflix.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debug.debugflix.domain.GetMoviesUseCase
import com.debug.debugflix.presenter.model.MovieViewObject
import com.debug.debugflix.presenter.model.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _movies = MutableLiveData<List<MovieViewObject>>()
    val movies: LiveData<List<MovieViewObject>> = _movies

    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = _viewState

    fun getMovies() {
        _viewState.postValue(ViewState.LOADING)

        viewModelScope.launch(Dispatchers.IO) {
            getMoviesUseCase().onSuccess { movies ->
                _movies.postValue(movies.map { movie ->
                    MovieViewObject(movie)
                })

                _viewState.postValue(ViewState.CONTENT)
            }.onFailure {
                _viewState.postValue(ViewState.ERROR)
            }
        }
    }
}