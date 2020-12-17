package shekarno.investing

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchParam(val costFrom: String, val costTo: String, val yearFrom: String, val yearTo: String) : Parcelable