package ir.ah.app.bestmovies.model.repo.genre

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import ir.ah.app.bestmovies.model.data.genre.Genre

@Dao
abstract class GenreLocalDataSource {


    @Query("SELECT *FROM tbl_genre")
    abstract fun getGenre(): Flowable<List<Genre>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertGenre(genre: List<Genre>)



}