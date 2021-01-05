package co.hidoc.infedisapp.data.repositories

//import co.hidoc.infedisapp.data.models.BookModel
import android.util.Log
import androidx.lifecycle.MutableLiveData
import co.hidoc.infedisapp.data.remote.RetrofitClient
import co.hidoc.infedisapp.data.models.BooksModel
import co.hidoc.infedisapp.data.models.newsmodel.NewsModel
import co.hidoc.infedisapp.data.remote.RetrofitClientNews
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityNewsRepository {

    val serviceSetterGetter = MutableLiveData<NewsModel>()

    fun getServicesApiCall(): MutableLiveData<NewsModel> {

        val callNews = RetrofitClientNews.apiInterfaceNews.getNews("everything?q=bitcoin&from=2020-11-29&sortBy=publishedAt&apiKey=69fcf58639e745398defdc4bfedf466a")



        callNews?.enqueue(object : Callback<NewsModel> {
            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())

            }

            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                Log.v("onResponse==> : ", response.body().toString())
//
                val data = response.body()

                val msg = data!!.articles
                serviceSetterGetter.value = data
            }

        })

        return serviceSetterGetter
    }
}
