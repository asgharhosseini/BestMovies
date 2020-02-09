package ir.ah.app.bestmovies.service.http

import io.reactivex.Flowable
import ir.ah.app.bestmovies.model.data.genre.Genre
import ir.ah.app.bestmovies.model.data.movie.Movie
import ir.ah.app.bestmovies.model.data.movies.Movies
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    //http://moviesapi.ir/api/v1/genres
    @GET("genres")
    fun getGenres(): Flowable<List<Genre>>



    //http://moviesapi.ir/api/v1/genres/1/movies
    @GET("genres/{id}/movies")
    fun getGenresMovies(@Path("id") id: Int):Flowable<Movies>



    //http://moviesapi.ir/api/v1/movies/id
    @GET("movies/{id}")
    fun getMovie(@Path("id") id: Int): Flowable<Movie>



    //http://moviesapi.ir/api/v1/movies?q=name
    @GET("movies")
    fun getSearchMovies(@Query("q") name: String): Flowable<Movies>










}