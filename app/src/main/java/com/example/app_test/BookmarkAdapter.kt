package com.example.app_test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_test.databinding.BookmarkOrderedListBinding

import com.example.week3project.MainBaemin1Holder

class BookmarkAdapter (val category :ArrayList<Bookmark>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder = BookmarkHolder(BookmarkOrderedListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val view = LayoutInflater.from(MainCategoryListItemBinding.context).inflate(R.layout.main_category_list_item, parent, false)
        val binding = (holder as BookmarkHolder).binding
        binding.bookmarkListNameTv.text = category.get(position).address.toString()
        binding.bookmarkListData.text = category.get(position).pm10.toString()
        binding.bookmarkListDataFine.text = category.get(position).pm2_5.toString()

    }

    override fun getItemCount(): Int = category.size

}


