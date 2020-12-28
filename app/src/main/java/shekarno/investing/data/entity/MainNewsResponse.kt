package shekarno.investing.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
@Serializable
data class MainNewsResponse(
    @SerialName("articles")
    val articles: List<Article>?,
    @SerialName("status")
    val status: String?,
    @SerialName("totalResults")
    val totalResults: Int?
) : Parcelable