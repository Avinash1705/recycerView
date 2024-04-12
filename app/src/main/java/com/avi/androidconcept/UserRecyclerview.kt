package com.avi.androidconcept

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class UserRecyclerView(private var context: Context, private var listData: List<String>) :
    RecyclerView.Adapter<UserRecyclerView.ViewHolder>(), Filterable {
    private var filteredList: List<String> = listData.toList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //         var name :TextView
//        init {
//            name = itemView.findViewById(R.id.rv_item_text)
//        }
        fun bind(item: String) {
            itemView.findViewById<TextView>(R.id.rv_item_text).text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //setting values
        Log.d("TAG", "onBindViewHolder: ${listData}")
//       holder.name.text = listData[position]
//        holder.bind(listData[position])
        holder.bind(filteredList[position])
    }

    override fun getItemCount(): Int {
//        return listData.size
        return filteredList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredResults = mutableListOf<String>()
                val query = constraint.toString().lowercase().trim()
                if (query.isEmpty()) {
                    filteredResults.addAll(listData)
                } else {
                    //get contain item in list
                    for (item in listData) {
                        Log.d("compare", "performFiltering: $item $query")
                        if (item.lowercase().trim().contains(query)) {
                            filteredResults.add(item)
                        }
                    }
                }
                val filterResult = FilterResults()
                filterResult.values = filteredResults
                return  filterResult
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as List<String>
                notifyDataSetChanged()
                Log.d("TAG", "publishResults: ${filteredList}")
            }
        }
    }
}