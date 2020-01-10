package com.example.taskdvm02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskdvm02.model.DataModel
import com.example.taskdvm02.model.Value
import com.example.taskdvm02.retrofit.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView:RecyclerView
    lateinit var adapter:CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        button.setOnClickListener{fetchData()}

    }

    fun fetchData() {
        val call: Call<DataModel> = ApiClient.get().getData()
        call.enqueue(object : Callback<DataModel> {
            override fun onResponse(
                call: Call<DataModel>,
                response: Response<DataModel>
            ) { adapter = CustomAdapter(response.body()!!,this@MainActivity)
                recyclerView.adapter = adapter
                recyclerView.adapter?.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                Toast.makeText(
                    getApplicationContext(),
                    R.string.Activity_Failed,
                    Toast.LENGTH_SHORT
                ).show()

            }
            }
        )
    }
}