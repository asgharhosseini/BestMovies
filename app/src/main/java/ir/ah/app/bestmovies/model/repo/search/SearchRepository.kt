package ir.ah.app.bestmovies.model.repo.search

import io.reactivex.Flowable
import ir.ah.app.bestmovies.model.data.movies.Movies

class SearchRepository {

    private val searchCouldDataSource=SearchCouldDataSource()

    fun getSearchMovies(name :String):Flowable<Movies>{
        return searchCouldDataSource.getSearchMovies(name)
    }



}