package co.hidoc.infedisapp.data.models


import com.google.gson.annotations.SerializedName

data class RetailPrice(
    val amountInMicros: Int,
    val currencyCode: String
)