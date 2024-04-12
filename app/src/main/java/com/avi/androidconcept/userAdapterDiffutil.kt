package com.avi.androidconcept

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class userAdapterDiffutil:
    ListAdapter<userModel, userAdapterDiffutil.CustomViewModel>(DiffUtil()) {
//    private var filteredList: List<String> = listData.toList()
    
    class CustomViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameText = itemView.findViewById<TextView>(R.id.rv_item_text)
        fun bind(item: userModel) {
            Log.d("rawat", "bind: ")
            nameText.text = item.fruitName
        }
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<userModel>() {
        private  val TAG = "rawat"
        override fun areItemsTheSame(oldItem: userModel, newItem: userModel): Boolean {
            Log.d(TAG, "areItemsTheSame: ")
            return oldItem.fruitName == newItem.fruitName
        }

        override fun areContentsTheSame(oldItem: userModel, newItem: userModel): Boolean {
            Log.d(TAG, "areContentsTheSame: ")
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewModel {
        Log.d("rawat", "onCreateViewHolder: ")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_layout, parent, false)
        return CustomViewModel(view)
    }

    override fun onBindViewHolder(holder: CustomViewModel, position: Int) {
        Log.d("rawat", "onBindViewHolder: ")
//        holder.bind(filteredList[position])
        val item = getItem(position)
        holder.bind(item)
    }

//    override fun getFilter(): Filter {
//      return  object : Filter() {
//          override fun performFiltering(constants: CharSequence?): FilterResults {
//           val query = constants.toString().trim().lowercase()
//              val filteredList = mutableListOf<String>()
//              if (query.isEmpty()){
//                  filteredList.addAll(listData)
//              }
//              else {
//                  for (item in listData){
//                      if(query.contains(item.trim().lowercase())){
//                          filteredList.add(item)
//                      }
//                  }
//              }
//              val filterResult = FilterResults()
//              filterResult.values = filteredList
//              return filterResult
//          }
//
//          override fun publishResults(constants: CharSequence?, result: FilterResults?) {
//             //make global var initilize for publish
//              filteredList = result?.values as List<String>
//              notifyDataSetChanged()
//          }
//      }
//
//    }
}