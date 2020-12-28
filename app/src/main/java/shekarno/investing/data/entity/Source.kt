package shekarno.investing.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
@Serializable
data class Source(
    @SerialName("id")
    val id: Any?,
    @SerialName("name")
    val name: String?
) : Parcelable