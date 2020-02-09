package ir.ah.app.bestmovies.future.genre

import android.content.Context
import io.reactivex.Flowable
import io.reactivex.subjects.BehaviorSubject
import ir.ah.app.bestmovies.model.data.genre.Genre
import ir.ah.app.bestmovies.model.data.movies.Movies
import ir.ah.app.bestmovies.model.repo.genre.GenresRepository
import ir.ah.app.bestmovies.model.repo.movies.MoviesRepository

class GenreViewModel constructor(context: Context) {


    private val genresRepository =GenresRepository(context)
    private val moviesRepository=MoviesRepository(context)
    private val prgGenres: BehaviorSubject<Boolean> = BehaviorSubject.create()
    private val prgMovies: BehaviorSubject<Boolean> = BehaviorSubject.create()

    fun prgGenres(): BehaviorSubject<Boolean> {

        return prgGenres
    }
    fun prgMovies(): BehaviorSubject<Boolean> {

        return prgMovies
    }



    fun getGenres(): Flowable<List<Genre>> {
        prgGenres.onNext(false)
        return genresRepository.getGenreInLocal().doOnComplete {
            prgGenres.onNext(true)
        }

    }

    fun getGenresMovies(id:Int):Flowable<Movies>{
        return moviesRepository.getGenresMovies(id)
    }

    fun getMoviesInLocal(id: Int):Flowable<Movies>{
        prgMovies.onNext(false)
        return moviesRepository.getMoviesInLocal(id).doOnComplete {
            prgMovies.onNext(true)
        }

    }








}