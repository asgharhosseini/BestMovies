package ir.ah.app.bestmovies.model.repo.genre

import android.content.Context
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import ir.ah.app.bestmovies.model.data.genre.Genre
import ir.ah.app.bestmovies.model.repo.AppDatabase

class GenresRepository constructor(context: Context){

    private val genreLocalDataSource=
        AppDatabase.getInstance(context)!!.genreLocalDataSource()

    private val genresCouldDataSource =GenresCouldDataSource()





    fun getGenreInLocal(): Flowable<List<Genre>> {
        genresCouldDataSource.getGenre()
            .subscribeOn(Schedulers.newThread())
            .observeOn(Schedulers.newThread())
            .map {
                genreLocalDataSource.insertGenre(it)

            }
            .subscribe()

        return genreLocalDataSource.getGenre()
    }













}