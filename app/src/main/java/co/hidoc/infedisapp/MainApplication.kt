package co.hidoc.infedisapp

import android.app.Application
import io.reactivex.android.BuildConfig

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
        }
    }

}