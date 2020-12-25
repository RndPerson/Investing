package shekarno.investing

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Equity(val name: String, val quantity: String) : Parcelable