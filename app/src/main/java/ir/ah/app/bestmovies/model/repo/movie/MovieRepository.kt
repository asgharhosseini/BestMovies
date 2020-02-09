package ir.ah.app.bestmovies.model.repo.movie

import io.reactivex.Flowable
import ir.ah.app.bestmovies.model.data.movie.Movie

class MovieRepository {


    private val movieCouldDataSource=MovieCouldDataSource()


    fun getMovie(id:Int):Flowable<Movie>{
        return movieCouldDataSource.getMovie(id)
    }
}