package ir.ah.app.bestmovies.future.search

import io.reactivex.Flowable
import ir.ah.app.bestmovies.model.data.movies.Movies
import ir.ah.app.bestmovies.model.repo.search.SearchRepository

class SearchViewModel {

    private val searchRepository =SearchRepository()

    fun getSearchMovies(name :String):Flowable<Movies>{
      return  searchRepository.getSearchMovies(name)
    }




}