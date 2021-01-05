package co.hidoc.infedisapp.data.models

import com.google.gson.annotations.SerializedName

data class BooksModel(
    val items: ArrayList<Item>,
    val kind: String,
    val totalItems: Int
//        val accessInfo: AccessInfo,
//        val etag: String,
//        val id: String,
//        val kind: String,
//        val saleInfo: SaleInfo,
//        val searchInfo: SearchInfo,
//        val selfLink: String,
//        val volumeInfo: VolumeInfo
)