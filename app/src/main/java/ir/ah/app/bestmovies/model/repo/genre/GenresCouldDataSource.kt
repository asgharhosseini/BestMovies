package ir.ah.app.bestmovies.model.repo.genre

import io.reactivex.Flowable
import ir.ah.app.bestmovies.model.data.genre.Genre
import ir.ah.app.bestmovies.service.http.ApiServiceContainer

class GenresCouldDataSource {

    private val apiService =ApiServiceContainer.apiService()



    fun getGenre(): Flowable<List<Genre>>{

        return apiService.getGenres()
    }




}