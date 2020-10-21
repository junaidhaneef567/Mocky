package com.jun.mock.Presentation.Activities
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.jun.mock.Model.SubCategoryJSONResponse
import com.jun.mock.Network.RetrofitClient
import com.jun.mock.Presentation.Adapter.SubCategoryListAdapter
import com.jun.mock.R
import kotlinx.android.synthetic.main.activity_sub_category.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.jun.mock.Model.SubCategoryModel


class SubCategory : AppCompatActivity() {

    lateinit var category: String
    lateinit var subCategoryListAdapter: SubCategoryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_category)

        getIntentData()
        initViews()

    }

    fun getIntentData()
    {
        val intent=getIntent()
        intent.getStringExtra("category")?.let {
            category=it
        }
    }

    private fun initViews() {
        sub_categoryList_rv.setHasFixedSize(true)
        sub_categoryList_rv.layoutManager= StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        loadSubJSON()
    }

    private fun loadSubJSON() {
        val call2: Call<SubCategoryJSONResponse> = RetrofitClient().api.getSubCategories()
        call2.enqueue(object: Callback<SubCategoryJSONResponse> {

            override fun onFailure(call: Call<SubCategoryJSONResponse>, t: Throwable) {
                Log.d("Error",t.message!!.toString())
            }

            override fun onResponse(call: Call<SubCategoryJSONResponse>, response: Response<SubCategoryJSONResponse>) {

                val newlist = ArrayList<SubCategoryModel>()
                val jsonResponse = response.body()
                jsonResponse?.arrayOfProducts.let {

                    for(i in 0 until it!!.size)
                    {
                        if(it.get(i).category.equals(category)){
                            newlist.add(it.get(i))
                        }
                    }
                    if(newlist.size>0) {
                        subCategoryListAdapter = SubCategoryListAdapter(this@SubCategory, newlist, category)
                        sub_categoryList_rv.adapter = subCategoryListAdapter
                        category_sub_progressBar.visibility = View.GONE
                        subCategoryListAdapter.notifyDataSetChanged()
                    }else
                    {
                        Toast.makeText(this@SubCategory,"No item",Toast.LENGTH_SHORT).show()
                        category_sub_progressBar.visibility = View.GONE
                    }
                }
            }
        })
    }
}
