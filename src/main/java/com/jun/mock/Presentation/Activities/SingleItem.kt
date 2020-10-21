package com.jun.mock.Presentation.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.jun.mock.R
import kotlinx.android.synthetic.main.activity_single_item.*
import kotlinx.android.synthetic.main.category_item.*

class SingleItem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_item)

        getIntentData()
    }

    private fun getIntentData() {
        val intent=getIntent()
        val name=intent.getStringExtra("name")
        val price=intent.getStringExtra("price")
        val quantity=intent.getStringExtra("quantity")
        val description=intent.getStringExtra("description")
        val image=intent.getStringExtra("imgUrl")

        setUi(name,price,quantity,description,image)
    }

    private fun setUi(name: String?, price: String?, quantity: String?, description: String?, image:String?) {

        name_tv.text=name
        price_tv.text="Price: "+price
        inStock_tv.text="Left: "+quantity
        description_tv.text=description

        Glide.with(singleItem_iv).load(image).into(singleItem_iv)
    }
}
