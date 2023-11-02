package com.example.recyclerview_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val FoodList:ArrayList<Foods>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener)
    {
        mListener=listener

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView,mListener)
    }

    override fun getItemCount(): Int {

        return FoodList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
     val currentItem=FoodList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text=currentItem.heading
        holder.briefNews.text=currentItem.briefNews

        val isVisible:Boolean=currentItem.visibility
        holder.constraintLayout.visibility=if (isVisible)View.VISIBLE else View.GONE
        holder.tvHeading.setOnClickListener{
            currentItem.visibility=!currentItem.visibility
            notifyItemChanged(position)
        }



    }

    class MyViewHolder(itemView: View,listener: onItemClickListener):RecyclerView.ViewHolder(itemView)
    {
        val titleImage:ShapeableImageView=itemView.findViewById(R.id.title_image)
        val tvHeading:TextView=itemView.findViewById(R.id.tvHeading)
        val briefNews:TextView=itemView.findViewById(R.id.briefNews)
        val constraintLayout:ConstraintLayout=itemView.findViewById(R.id.expandableLayout)


        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }
}