package co.hidoc.infedisapp.data.models


import com.google.gson.annotations.SerializedName

data class Offer(
    val finskyOfferType: Int,
    val listPrice: ListPriceX,
    val retailPrice: RetailPrice
)