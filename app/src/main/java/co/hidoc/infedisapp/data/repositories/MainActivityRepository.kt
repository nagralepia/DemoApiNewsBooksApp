package co.hidoc.infedisapp.data.repositories

//import co.hidoc.infedisapp.data.models.BookModel
import android.util.Log
import androidx.lifecycle.MutableLiveData
import co.hidoc.infedisapp.data.remote.RetrofitClient
import co.hidoc.infedisapp.data.models.BooksModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<BooksModel>()

    fun getServicesApiCall(): MutableLiveData<BooksModel> {

//        val callNews = RetrofitClient.apiInterface.getNews("everything?q=bitcoin&from=2020-11-29&sortBy=publishedAt&apiKey=69fcf58639e745398defdc4bfedf466a")
        val call = RetrofitClient.apiInterface.getBooks("volumes?q=quilting")



        call?.enqueue(object : Callback<BooksModel> {
            override fun onFailure(call: Call<BooksModel>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())

            }

            override fun onResponse(call: Call<BooksModel>, response: Response<BooksModel>) {
                Log.v("onResponse==> : ", response.body()?.items.toString())
//
                val data = response.body()

                val msg = data!!.items
                serviceSetterGetter.value = data
            }

        })

        return serviceSetterGetter
    }
}
