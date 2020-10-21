package com.jun.mock.Presentation.Adapter

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jun.mock.Model.CategoryResponseModel
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.jun.mock.Presentation.Activities.SubCategory
import com.jun.mock.R


class CategoryListAdapter(private val context: Context,private val category:ArrayList<CategoryResponseModel>): RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {

        return category.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {

                Glide.with(holder.image)
                    .load(category.get(position).imgUrl)
                    .into(holder.image)
                holder.name.text=category.get(position).name

        holder.itemView.setOnClickListener {
            val intent= Intent(context,SubCategory::class.java)
            intent.putExtra("category",category.get(position).id.toString())
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){

        val image: ImageView= itemview.findViewById(R.id.imageView)
        val name: TextView= itemview.findViewById(R.id.textView)
    }
}