package ir.ah.app.bestmovies.model.data.movies


import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class Movies(
    @SerializedName("data")
    var `data`: List<Data>,
    @SerializedName("metadata")
    var metadata: Metadata
) : Parcelable