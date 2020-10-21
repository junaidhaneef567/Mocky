package com.jun.mock.Presentation.Adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jun.mock.Model.CategoryResponseModel
import com.jun.mock.Model.SubCategoryModel
import com.jun.mock.Presentation.Activities.SingleItem
import com.jun.mock.R

class SubCategoryListAdapter(private val context: Context,
                             private val subcategory:ArrayList<SubCategoryModel>,
                             private val category:String
): RecyclerView.Adapter<SubCategoryListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return subcategory.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if(subcategory.size>0) {
            Glide.with(holder.image)
                    .load(subcategory.get(position).imgUrl)
                    .into(holder.image)
            holder.name.text = subcategory.get(position).name
        }

        holder.itemView.setOnClickListener {
            val intent= Intent(context,SingleItem::class.java)
            intent.putExtra("name",subcategory.get(position).name)
            intent.putExtra("price",subcategory.get(position).price)
            intent.putExtra("quantity",subcategory.get(position).quantity.toString())
            intent.putExtra("description",subcategory.get(position).description)
            intent.putExtra("imgUrl",subcategory.get(position).imgUrl)
            context.startActivity(intent)
        }

    }

    class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){

        val image: ImageView = itemview.findViewById(R.id.list_iv)
        val name: TextView = itemview.findViewById(R.id.list_tv)
    }
}