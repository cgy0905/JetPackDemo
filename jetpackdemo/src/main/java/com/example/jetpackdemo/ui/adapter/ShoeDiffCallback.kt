package com.example.jetpackdemo.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.jetpackdemo.db.data.Shoe

/**
 * @author: cgy
 * @date: 2020/5/11 11:29
 * @description:
 */
class ShoeDiffCallback : DiffUtil.ItemCallback<Shoe>() {
    override fun areItemsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
        return oldItem == newItem
    }
}