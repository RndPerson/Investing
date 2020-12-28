package shekarno.investing

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class News(val title: String, val description: String, val image: String, val url: String, val date: String) : Parcelable