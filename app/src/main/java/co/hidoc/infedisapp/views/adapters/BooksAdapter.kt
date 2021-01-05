package co.hidoc.infedisapp.views.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.hidoc.infedisapp.data.models.BooksModel
import co.hidoc.infedisapp.data.models.Item
import co.hidoc.infedisapp.databinding.CrdBooksBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import java.util.ArrayList

class BooksAdapter() :
//class BooksAdapter(val arrList: List<BooksModel>) :
        RecyclerView.Adapter<BooksAdapter.NotesViewHolder>() {
    private val items = ArrayList<Item>()

    fun setItems(items: ArrayList<Item>) {
        println("setPopularGrocery==>$items")

        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
//
//    fun setItems(items: ArrayList<BooksModel>) {
//        println("setPopularGrocery==>$items")
//
//        this.items.clear()
//        this.items.addAll(items)
//        notifyDataSetChanged()
//    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {

        val binding: CrdBooksBinding = CrdBooksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) = holder.bind(items[position])


//    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
//
////        holder.itemView.txtTitle.text = arrList[position].items..volumeInfo.title
//
//
////        holder.itemView.tvTitle.text = arrList[position].title
////        holder.itemView.tvDesc.text = arrList[position].noteText
////        holder.itemView.tvDateTime.text = arrList[position].dateTime
//
////        if (arrList[position].color != null){
////            holder.itemView.cardView.setCardBackgroundColor(Color.parseColor(arrList[position].color))
////        }else{
////            holder.itemView.cardView.setCardBackgroundColor(Color.parseColor(R.color.ColorLightBlack.toString()))
////        }
////
////        if (arrList[position].imgPath != null){
////            holder.itemView.imgNote.setImageBitmap(BitmapFactory.decodeFile(arrList[position].imgPath))
////            holder.itemView.imgNote.visibility = View.VISIBLE
////        }else{
////            holder.itemView.imgNote.visibility = View.GONE
////        }
//
//       /* if (arrList[position].webLink != null){
//            holder.itemView.tvWebLink.text = arrList[position].webLink
//            holder.itemView.tvWebLink.visibility = View.VISIBLE
//        }else{
//            holder.itemView.tvWebLink.visibility = View.GONE
//        }
//*/
//    }

//    class NotesViewHolder(view:View) : RecyclerView.ViewHolder(view){
//
//    }


    class NotesViewHolder(private val itemBinding: CrdBooksBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        private lateinit var character: Item

//        init {
//            itemBinding.root.setOnClickListener(this)
//        }

        @SuppressLint("SetTextI18n")
        fun bind(item: Item) {
            this.character = item
            itemBinding.txtTitle.text = item.volumeInfo.title
            itemBinding.txtAvgRating.text = item.volumeInfo.averageRating.toString()
            itemBinding.txtRating.text = item.volumeInfo.ratingsCount.toString()
//            itemBinding.txtBookPrice.text = item.saleInfo.retailPrice.amount.toString()
//            print("title=>"+item.volumeInfo.title)
//            itemBinding.speciesAndStatus.text = """${item.species} - ${item.status}"""
            Glide.with(itemBinding.root)
                    .load(item.volumeInfo.imageLinks.thumbnail)
//                    .transform(CircleCrop())
                    .into(itemBinding.imgBook)
        }

//        override fun onClick(v: View?) {
//            listener.onClickedCharacter(character.id)
//        }
    }

}