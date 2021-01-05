package co.hidoc.infedisapp.data.remote

import co.hidoc.infedisapp.data.models.BooksModel
import co.hidoc.infedisapp.data.models.newsmodel.NewsModel
import co.hidoc.infedisapp.viewmodels.NewsViewModel
//import co.hidoc.infedisapp.models.BooksModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url


interface ApiInterface {
    @GET
    fun getBooks(@Url url: String?): Call<BooksModel>?

    @GET
    fun getNews(@Url url: String?): Call<NewsModel>?
}