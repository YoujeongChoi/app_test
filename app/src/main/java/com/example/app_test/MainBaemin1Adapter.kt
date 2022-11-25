package com.example.app_test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_test.databinding.MypageOrderedListBinding
import com.example.week3project.MainBaemin1Holder

class MainBaemin1Adapter(val category :ArrayList<MainBaemin1>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder =
        MainBaemin1Holder(MypageOrderedListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // val view = LayoutInflater.from(MainCategoryListItemBinding.context).inflate(R.layout.main_category_list_item, parent, false)
        val binding = (holder as MainBaemin1Holder).binding
        binding.mypageListNameTv.text = category.get(position).name.toString()
        binding.mypageListData.text = category.get(position).value.toString()
    }

    override fun getItemCount(): Int = category.size

}