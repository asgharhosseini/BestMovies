package ir.ah.app.bestmovies.model.repo.search

import io.reactivex.Flowable
import ir.ah.app.bestmovies.model.data.movies.Movies
import ir.ah.app.bestmovies.service.http.ApiServiceContainer

class SearchCouldDataSource {
    private val apiService=ApiServiceContainer.apiService()

    fun getSearchMovies(name:String):Flowable<Movies>{
        return apiService.getSearchMovies(name)
    }


}