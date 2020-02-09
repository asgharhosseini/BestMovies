package ir.ah.app.bestmovies.model.repo.movies

import io.reactivex.Flowable
import ir.ah.app.bestmovies.model.data.movies.Movies
import ir.ah.app.bestmovies.service.http.ApiServiceContainer

class MoviesCouldDataSource {

    private val apiService =ApiServiceContainer.apiService()

    fun getGenresMovies(id:Int):Flowable<Movies>{
        return apiService.getGenresMovies(id)
    }

}