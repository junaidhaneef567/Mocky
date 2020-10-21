package com.jun.mock.Presentation.Activities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.jun.mock.Model.CategoryJSONResponse
import com.jun.mock.Network.RetrofitClient
import com.jun.mock.Presentation.Adapter.CategoryListAdapter
import com.jun.mock.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var categoryListAdapter: CategoryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        categoryList_rv.setHasFixedSize(true)
        categoryList_rv.layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        loadJSON()
    }


    private fun loadJSON() {
        val call:Call<CategoryJSONResponse> = RetrofitClient().api.getCategories()
        call.enqueue(object: Callback<CategoryJSONResponse>{

            override fun onFailure(call: Call<CategoryJSONResponse>, t: Throwable) {
                Log.d("Error",t.message!!.toString())
            }

            override fun onResponse(call: Call<CategoryJSONResponse>, response: Response<CategoryJSONResponse>) {

                val jsr = response.body()
                Log.d("jjjjjj",jsr.toString())
                jsr?.arr.let {
                    categoryListAdapter = CategoryListAdapter(this@MainActivity,it!!)
                    categoryList_rv.adapter = categoryListAdapter
                    progressBar_category.visibility = View.GONE
                }
            }
        })
    }
}
