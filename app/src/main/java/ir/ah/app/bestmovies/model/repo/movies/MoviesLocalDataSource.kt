package ir.ah.app.bestmovies.model.repo.movies

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import ir.ah.app.bestmovies.model.data.movies.Data

@Dao
abstract class MoviesLocalDataSource {




    @Query("SELECT *FROM tbl_data WHERE id=:id")
    abstract fun getMovies(id:Int): Flowable<List<Data>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(movies:List<Data>)


}