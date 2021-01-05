package co.hidoc.infedisapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.hidoc.infedisapp.data.models.BooksModel
import co.hidoc.infedisapp.data.models.newsmodel.NewsModel
import co.hidoc.infedisapp.data.repositories.MainActivityNewsRepository
import co.hidoc.infedisapp.data.repositories.MainActivityRepository

class NewsViewModel : ViewModel() {
    var servicesLiveData: MutableLiveData<NewsModel>? = null

    fun getNewsVM() : LiveData<NewsModel>? {
        servicesLiveData = MainActivityNewsRepository.getServicesApiCall()
        Log.d("servicesLiveData====>>>",servicesLiveData.toString())

        return servicesLiveData
    }}