package co.hidoc.infedisapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.hidoc.infedisapp.data.models.BooksModel
import co.hidoc.infedisapp.data.models.ServicesSetterGetter
import co.hidoc.infedisapp.data.repositories.MainActivityRepository

class BooksViewModel : ViewModel() {
    var servicesLiveData: MutableLiveData<BooksModel>? = null

    fun getUser() : LiveData<BooksModel>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall()
        Log.d("servicesLiveData====>>>",servicesLiveData.toString())

        return servicesLiveData
    }
}