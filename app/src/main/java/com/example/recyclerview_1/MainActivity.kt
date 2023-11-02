package com.example.recyclerview_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.sql.RowId

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Foods>
    lateinit var imageId: Array<Int>
    lateinit var heading:Array<String>
    lateinit var foods:Array<String>
    lateinit var briefNews :Array<String>





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId= arrayOf(
            R.drawable.burger,
            R.drawable.cake,
            R.drawable.fries,
            R.drawable.maggi,
            R.drawable.ocean,
            R.drawable.pancake,
            R.drawable.pasta,
            R.drawable.pizza
        )
        heading= arrayOf(
            "Pizza is very Hot and Spicy,Tasty",
            "Pizza is very Hot and Spicy,Tasty",
            "Pizza is very Hot and Spicy,Tasty",
            "Pizza is very Hot and Spicy,Tasty",
            "Pizza is very Hot and Spicy,Tasty",
            "Pizza is very Hot and Spicy,Tasty",
            "Pizza is very Hot and Spicy,Tasty",
            "Pizza is very Hot and Spicy,Tasty"
        )

        briefNews= arrayOf(
            getString(R.string.Food_a),
            getString(R.string.Food_b),
            getString(R.string.Food_c),
            getString(R.string.Food_d),
            getString(R.string.Food_e),
            getString(R.string.Food_f),
            getString(R.string.Food_g),
            getString(R.string.Food_h),

        )





        newRecyclerView=findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<Foods>()
        getUserdata()
    }
    private fun getUserdata(){
        for (i in imageId.indices){
            val foods =Foods(imageId[i],heading[i],briefNews[i])
            newArrayList.add(foods)
        }

        var adapter=MyAdapter(newArrayList)
        newRecyclerView.adapter=adapter
        adapter.setOnItemClickListener(object: MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
              Toast.makeText(this@MainActivity,"You Clicked onItem No: $position",Toast.LENGTH_LONG).show()

//                val intent=Intent(this@MainActivity,FoodActivity::class.java)
//                intent.putExtra("heading",newArrayList[position].heading)
//                intent.putExtra("imageId",newArrayList[position].titleImage)
//                intent.putExtra("Foods",foods[position])




            }

        })
    }
}