package ir.ah.app.bestmovies.future.detail

import io.reactivex.Flowable
import ir.ah.app.bestmovies.model.data.movie.Movie
import ir.ah.app.bestmovies.model.repo.movie.MovieRepository

class DetailViewModel {

    private val movieRepository =MovieRepository()

    fun getMovie(id:Int):Flowable<Movie>{
        return movieRepository.getMovie(id)
    }






}