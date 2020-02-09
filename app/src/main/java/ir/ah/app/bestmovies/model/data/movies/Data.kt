package ir.ah.app.bestmovies.model.data.movies


import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import ir.ah.app.bestmovies.model.data.StringTypeConverter
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
@Entity(tableName = "tbl_data")
data class Data(
    @SerializedName("country")
    var country: String,
    @SerializedName("genres")
   @TypeConverters(StringTypeConverter::class)
    var genres: List<String>,
    @SerializedName("id")
 @PrimaryKey
    var id: Int,
    @SerializedName("images")
 @TypeConverters(StringTypeConverter::class)
    var images: List<String>,
    @SerializedName("imdb_rating")
    var imdbRating: String,
    @SerializedName("poster")
    var poster: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("year")
    var year: String
) : Parcelable