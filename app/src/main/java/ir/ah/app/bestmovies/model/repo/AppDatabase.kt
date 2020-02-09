package ir.ah.app.bestmovies.model.repo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.ah.app.bestmovies.model.data.StringTypeConverter
import ir.ah.app.bestmovies.model.data.genre.Genre
import ir.ah.app.bestmovies.model.data.movies.Data
import ir.ah.app.bestmovies.model.repo.genre.GenreLocalDataSource
import ir.ah.app.bestmovies.model.repo.movies.MoviesLocalDataSource

@TypeConverters( StringTypeConverter::class)
@Database(
    entities = [Genre::class, Data::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun genreLocalDataSource(): GenreLocalDataSource
    abstract fun moviesLocalDataSource(): MoviesLocalDataSource

    companion object {
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context, AppDatabase::class.java, "besrmovie.sql"
                ).build()
            }
            return instance
        }

    }


}