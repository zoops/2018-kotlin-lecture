package com.moberan.zoops.rndhub.mainfragment.adapter

import android.content.Context
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.moberan.zoops.rndhub.BR
import com.moberan.zoops.rndhub.data.RnDInfo
import com.moberan.zoops.rndhub.databinding.FragmentCategoryBinding


class MyCategoryRecyclerViewAdapter(private val mContext: Context, private val mValues: List<RnDInfo>)
    : RecyclerView.Adapter<MyCategoryRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ViewDataBinding = FragmentCategoryBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.setBinding(item)
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(private val mBinding: ViewDataBinding) : RecyclerView.ViewHolder(mBinding.root) {
        fun onItemClick(v: View, item: RnDInfo) {
            Toast.makeText(v.context, "Category Item Click : $item", Toast.LENGTH_SHORT).show()
        }

        fun setBinding(item: RnDInfo) {
            mBinding.setVariable(BR.item, item)
            mBinding.setVariable(BR.listener, this)
        }
    }
}
