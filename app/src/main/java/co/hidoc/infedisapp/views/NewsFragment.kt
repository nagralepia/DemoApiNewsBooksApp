@file:Suppress("DEPRECATION")

package co.hidoc.infedisapp.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import co.hidoc.infedisapp.databinding.NewsFragmentBinding
import co.hidoc.infedisapp.viewmodels.NewsViewModel
import co.hidoc.infedisapp.views.adapters.NewsAdapter
import com.example.rickandmorty.utils.autoCleared
import java.util.*


class NewsFragment : Fragment() {

    companion object {
        fun newInstance() = NewsFragment()
    }

    private val viewModel: NewsViewModel by viewModels()
    private var binding: NewsFragmentBinding by autoCleared()
    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewsFragmentBinding.inflate(inflater, container, false)
        return binding.root
//        var root = inflater.inflate(R.layout.news_fragment, container, false)
//
//        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progressBarNews.visibility = View.VISIBLE

        setupObservers()

//        setupRecyclerView()
//        progress_barNews.visibility = View.VISIBLE

//
//        viewModel = ViewModelProvider(this).get(BooksViewModel::class.java)
//
//        viewModel.getUser()!!.observe(viewLifecycleOwner, Observer {
//            bookModels ->
//
////
////            recycler_view.setHasFixedSize(true)
////
////            recycler_view.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//////            val msg=serviceGettersetter.totalItems
//            Log.d("servicesLiveDataData=>",bookModels.toString())
////
////            recycler_view.adapter = BooksAdapter(bookModels)
//
//        })
////        recycler_view.setHasFixedSize(true)
////
////        recycler_view.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
////
////        launch {
////            context?.let {
////                var notes = NotesDatabase.getDatabase(it).noteDao().getAllNotes()
////                recycler_view.adapter = NotesAdapter(notes)
////            }
////        }

//        private fun setupRecyclerView() {
//            adapter = BooksAdapter(this)
//            binding.charactersRv.layoutManager = LinearLayoutManager(requireContext())
//            binding.charactersRv.adapter = adapter
    }


    fun setupObservers(){
        viewModel.getNewsVM()?.observe(viewLifecycleOwner, Observer {
                        Log.d("JSONObject===>>>","onPreExecute====>>" +it.toString() )

            adapter = NewsAdapter()
//            binding.recyclerViewNews.layoutManager = GridLayoutManager(requireContext(),3)

            binding.recyclerViewNews.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerViewNews.addItemDecoration(DividerItemDecoration(binding.recyclerViewNews.getContext(), DividerItemDecoration.VERTICAL))

            binding.recyclerViewNews.adapter = adapter
//                adapter.setItems(it.items)
            adapter.setItems(ArrayList(it.articles))
            binding.progressBarNews.visibility = View.GONE

        })
    }
//
//    inner class WeatherTask : AsyncTask<String, Void, String>() {
//        override fun onPreExecute() {
//            super.onPreExecute()
//            Toast.makeText(requireContext(),"onPreExecute",Toast.LENGTH_SHORT).show()
////            progress_barNews.visibility = View.VISIBLE
//            Log.d("JSONObject===>>>","onPreExecute====>>" )
//
//            /* Showing the ProgressBar, Making the main design GONE */
////            findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
////            findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.GONE
////            findViewById<TextView>(R.id.errorText).visibility = View.GONE
//        }

//        override fun doInBackground(vararg params: String?): String? {
//            var response:String?
//            try{
////                response = URL("http://newsapi.org/v2/everything?q=bitcoin&from=2020-11-29&sortBy=publishedAt&apiKey=69fcf58639e745398defdc4bfedf466a").readText(
//                //                response = URL("https://api.openweathermap.org/data/2.5/weather?q=delhi,in&units=metric&appid=8118ed6ee68db2debfaaa5a44c832918").readText(
//
//                response = URL("https://newsapi.org/v2/top-headlines?country=us&apiKey=69fcf58639e745398defdc4bfedf466a").readText(
//                        Charsets.UTF_8
//                )
//                Log.d("JSONObject===>>>","doInBackground====>>" )
//
////                print("JSONObject===>>>"+"doInBackground====>>" )
//
//            } catch (e: Exception){
//                response = null
//            }
//            return response
//        }
//
//        override fun onPostExecute(result: String?) {
//            super.onPostExecute(result)
//            Log.d("JSONObject===>>>","Data====>>  " + result )
//
////            progress_barNews.visibility = View.GONE
//            print("JSONObject===>>>"+"Data====>>" + result)
//
//            try {
//                /* Extracting JSON returns from the API */
//                val jsonObj = JSONObject("articles")
//                print("JSONObject===>>>"+"hi====>>")
//
//                val articles = jsonObj.getJSONArray("articles")
////                        .getJSONObject(0)
//
//                print("article===>>>"+articles.length())
//
////                for (i in 0 until articles.length()) {
////                    val jObj: JSONObject = articles.getJSONObject(i)
//////                    val menu_id = jObj.getString("M_id")
//////                    val menu_Name =  jObj.getString("M_name")
//////                    val menu_rate = jObj.getString("M_rate")
//////                    val item_code = jObj.getString("Item_Code")
//////                    val Cat_name =jObj.getString("Cat_name")
////                    var dataDTO = NewsViewModel()
//////                    dataDTO.setMenu_id(menu_id)
//////                    dataDTO.setM_name(menu_Name)
//////                    dataDTO.setRate(menu_rate)
//////                    dataDTO.setItem_code(item_code)
//////                    dataDTO.setCat_name(Cat_name)
//////                    dataList.add(dataDTO)
////                }
//
////                val menulable: MutableList<String> = ArrayList()
////                menulable.add("Select Menu")
////                for (i in 0 until dataList.size()) {
////                    menulable.add(dataList.get(i).getM_name().toString())
////                }
//
//
//
////                val adp3 = ArrayAdapter(activity!!, android.R.layout.simple_list_item_1, menulable)
////                adp3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
////                spnMenu.setAdapter(adp3)
////
////
////                val categorylable: MutableList<String> = ArrayList()
////
////                for (i in 0 until dataList.size()) {
////                    categorylable.add(dataList.get(i).getCat_name())
////                }
//////                System.out.printf("\ncategorylable----->", categorylable);
////
////                //                System.out.printf("\ncategorylable----->", categorylable);
////                val categorylableHasSet: List<String>
////                categorylableHasSet = sortList(categorylable)
////
////                val adp2 = ArrayAdapter(activity!!, android.R.layout.simple_list_item_1, categorylableHasSet)
////                adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
////                spnCategory.setAdapter(adp2) // spn category
//
//
//
//
//
//
//
//
//
//
//
////                val updatedAt:Long = jsonObj.getLong("dt")
////                val updatedAtText = "Updated at: "+ SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(
////                        Date(updatedAt*1000)
////                )
////                val temp = main.getString("temp")+"°C"
////                val tempMin = "Min Temp: " + main.getString("temp_min")+"°C"
////                val tempMax = "Max Temp: " + main.getString("temp_max")+"°C"
////                val pressure = main.getString("pressure")
////                val humidity = main.getString("humidity")
////
////                val sunrise:Long = sys.getLong("sunrise")
////                val sunset:Long = sys.getLong("sunset")
////                val windSpeed = wind.getString("speed")
////                val weatherDescription = weather.getString("description")
////
////                val address = jsonObj.getString("name")+", "+sys.getString("country")
//
////                /* Populating extracted data into our views */
////                findViewById<TextView>(R.id.address).text = address
////                findViewById<TextView>(R.id.updated_at).text =  updatedAtText
////                findViewById<TextView>(R.id.status).text = weatherDescription.capitalize()
////                findViewById<TextView>(R.id.temp).text = temp
////                findViewById<TextView>(R.id.temp_min).text = tempMin
////                findViewById<TextView>(R.id.temp_max).text = tempMax
////                findViewById<TextView>(R.id.sunrise).text = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(
////                        Date(sunrise*1000)
////                )
////                findViewById<TextView>(R.id.sunset).text = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(
////                        Date(sunset*1000)
////                )
////                findViewById<TextView>(R.id.wind).text = windSpeed
////                findViewById<TextView>(R.id.pressure).text = pressure
////                findViewById<TextView>(R.id.humidity).text = humidity
////
////                /* Views populated, Hiding the loader, Showing the main design */
////                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
////                findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.VISIBLE
//
//            } catch (e: Exception) {
////                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
////                findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
//            }
//
//        }
//    }
}