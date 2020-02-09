package ir.ah.app.bestmovies.model.repo.movies

import android.content.Context
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import ir.ah.app.bestmovies.model.data.movies.Movies
import ir.ah.app.bestmovies.model.repo.AppDatabase

class MoviesRepository constructor(context: Context) {

    private val moviesLocalDataSource =
        AppDatabase.getInstance(context)!!.moviesLocalDataSource()

    private val moviesCouldDataSource = MoviesCouldDataSource()


    fun getGenresMovies(id: Int): Flowable<Movies> {
        return moviesCouldDataSource.getGenresMovies(id)
    }


    fun getMoviesInLocal(id: Int): Flowable<Movies> {
        moviesCouldDataSource.getGenresMovies(id)
            .subscribeOn(Schedulers.newThread())
            .observeOn(Schedulers.newThread())
            .map {
                moviesLocalDataSource.insertMovies(it.data)

            }
            .subscribe()
        return moviesCouldDataSource.getGenresMovies(id)
        //  return moviesLocalDataSource.getMovies(id)
    }


}