package co.hidoc.infedisapp.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import co.hidoc.infedisapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_tabs_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()


        val booksFragment = BooksFragment()
        val newsFragment = NewsFragment()

        setCurrentFragment(booksFragment)

        rlLib.setOnClickListener {
//            showHide(txtLibSelected, txtLib,txtNewsSelected)
            showHide(txtLib,txtLibSelected, txtNews, txtNewsSelected)
            setCurrentFragment(booksFragment)

        }

        rlNews.setOnClickListener {
//            showHide(txtNewsSelected, txtNews, txtLibSelected)
            showHide(txtNews,txtNewsSelected,txtLib, txtLibSelected)
//            showHide(txtNewsSelected)
//            showHide(txtNewsSelected)
            setCurrentFragment(newsFragment)
        }

//        bottomNavigationView.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//
//                R.id.books -> {
//                    setCurrentFragment(booksFragment)
//                }
//                R.id.news -> setCurrentFragment(newsFragment)
//
//            }
//            true
//        }

    }

    private fun init() {
        imageView2.setOnClickListener {
            toast("Working........")
        }
        rlSelectLocation.setOnClickListener {
            toast("Working........")
        }
        imgChangeLanguage.setOnClickListener {
            toast("Working........")
        }
        editTextSearch.setOnClickListener {
            toast("Working........")
        }
        imageView3.setOnClickListener {
            toast("Working........")
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }

    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


    fun showHide(view: View,viewSelected: View, viewGone: View, viewGoneSelected: View) {
//        viewGoneSelected.visibility = View.GONE
        viewGone.visibility = View.VISIBLE
        view.visibility = View.GONE
        viewGoneSelected.visibility = View.GONE
        viewSelected.visibility = if (view.visibility == View.VISIBLE) {
            View.GONE
        } else {
            View.VISIBLE
        }
//        viewGoneSelected.visibility = if (view.visibility == View.VISIBLE) {
//            View.GONE
//        } else {
//            View.VISIBLE
//        }
    }

//    fun showHide(view: View){
//        view.visibility = if (view.visibility == View.VISIBLE) {
//            View.GONE
//        } else {
//            View.VISIBLE
//        }
//    }
}