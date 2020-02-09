package ir.ah.app.bestmovies.model.data.movies


import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class Metadata(
    @SerializedName("current_page")
    var currentPage: String,
    @SerializedName("page_count")
    var pageCount: Int,
    @SerializedName("per_page")
    var perPage: Int,
    @SerializedName("total_count")
    var totalCount: Int
) : Parcelable