package shekarno.investing

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Equity(val name: String, val quantity: String) : Parcelable