package ir.ah.app.bestmovies.model.data.genre


import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
@Entity(tableName = "tbl_genre")
data class Genre(

    @SerializedName("id")
    @PrimaryKey
    var id: Int,
    @SerializedName("name")
    var name: String
) : Parcelable