package co.hidoc.infedisapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import co.hidoc.infedisapp.databinding.BooksFragmentBinding
import co.hidoc.infedisapp.viewmodels.BooksViewModel
import co.hidoc.infedisapp.views.adapters.BooksAdapter
import com.example.rickandmorty.utils.autoCleared

class BooksFragment : Fragment() {

    companion object {
        fun newInstance() = BooksFragment()
    }

    //    private lateinit var viewModel: BooksViewModel
    private val viewModel: BooksViewModel by viewModels()
    private var binding: BooksFragmentBinding by autoCleared()
    private lateinit var adapter: BooksAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = BooksFragmentBinding.inflate(inflater, container, false)
//         var root = inflater.inflate(R.layout.books_fragment, container, false)




        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setupRecyclerView()
        binding.progressBar.visibility = View.VISIBLE

        setupObservers()
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

    fun setupObservers() {

        viewModel.getUser()?.observe(viewLifecycleOwner, Observer {
//            Log.d("servicesLiveDataData=>", it.toString())


            adapter = BooksAdapter()
            binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),3)

//            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerView.adapter = adapter
//                adapter.setItems(it.items)
            adapter.setItems(ArrayList(it.items))

            binding.progressBar.visibility = View.GONE

        })

//            viewModel.getUser.observe(viewLifecycleOwner, Observer {
//                when (it.status) {
//                    Resource.Status.SUCCESS -> {
//                        binding.progressBar.visibility = View.GONE
//                        if (!it.data.isNullOrEmpty())
//                            adapter = BooksAdapter(this)
//                        binding.charactersRv.layoutManager = LinearLayoutManager(requireContext())
//                        binding.charactersRv.adapter = adapter
//                        adapter.setItems(ArrayList(it.data))
//                    }
//                }
//            })

    }

//        override fun onClickedCharacter(characterId: Int) {
//            findNavController().navigate(
//                    R.id.action_charactersFragment_to_characterDetailFragment,
//                    bundleOf("id" to characterId)
//            )
//        }
}