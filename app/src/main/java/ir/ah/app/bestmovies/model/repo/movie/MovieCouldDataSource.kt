package ir.ah.app.bestmovies.model.repo.movie

import io.reactivex.Flowable
import ir.ah.app.bestmovies.model.data.movie.Movie
import ir.ah.app.bestmovies.service.http.ApiServiceContainer

class MovieCouldDataSource {

    private val apiService=ApiServiceContainer.apiService()


    fun getMovie(id: Int):Flowable<Movie>{
        return apiService.getMovie(id)
    }











}