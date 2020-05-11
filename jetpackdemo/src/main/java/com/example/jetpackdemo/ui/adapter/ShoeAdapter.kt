package com.example.jetpackdemo.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackdemo.common.BaseConstant
import com.example.jetpackdemo.databinding.ItemShoeRecyclerBinding
import com.example.jetpackdemo.db.data.Shoe
import com.example.jetpackdemo.ui.activity.DetailActivity
import kotlinx.android.synthetic.main.shoe_fragment.view.*

/**
 * @author: cgy
 * @date: 2020/5/11 11:12
 * @description: 鞋子的适配器 配合Data Binding使用
 */
class ShoeAdapter constructor(val context: Context) :
    PagedListAdapter<Shoe, ShoeAdapter.ViewHolder>(ShoeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemShoeRecyclerBinding.inflate(
                LayoutInflater.from(parent.context)
                , parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoe = getItem(position)
        holder.apply {
            bind(onCreateListener(shoe!!.id), shoe)
            itemView.tag = shoe
        }
    }

    /**
     * holder的点击事件
     */
    private fun onCreateListener(id : Long) : View.OnClickListener {
        return View.OnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(BaseConstant.DETAIL_SHOE_ID, id)
            context.startActivity(intent)
        }
    }


    class ViewHolder(private val binding: ItemShoeRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listener : View.OnClickListener, item : Shoe) {
            binding.apply {
                this.listener = listener
                this.shoe = item
                executePendingBindings()
            }
        }
    }

}