package com.moberan.zoops.rndhub.mainfragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.moberan.zoops.rndhub.R
import com.moberan.zoops.rndhub.api.ApiUtil
import com.moberan.zoops.rndhub.data.RnDInfo
import com.moberan.zoops.rndhub.data.RnDInfoRes
import com.moberan.zoops.rndhub.mainfragment.adapter.MyCategoryRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_category_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    private var mDatas: MutableList<RnDInfo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set the adapter
        if (list is RecyclerView) {
            with(list) {
                layoutManager = LinearLayoutManager(context)
                adapter = MyCategoryRecyclerViewAdapter(context, mDatas)
            }
        }
        swipe_refresh_layout.setOnRefreshListener(this)
        requestData()
    }

    override fun onRefresh() {
        requestData()
    }

    private fun requestData() {
        ApiUtil.mCategoryService!!.getRnDCategoryList().enqueue(object : Callback<RnDInfoRes> {
            override fun onResponse(call: Call<RnDInfoRes>, response: Response<RnDInfoRes>) {
                try {
                    mDatas.clear()
                    response.body()?.list?.forEach { mDatas.add(it) }
                    list.adapter?.notifyDataSetChanged()

                    Toast.makeText(this@CategoryFragment.context, "onResponse", Toast.LENGTH_SHORT).show()
                } catch (ex: Exception) {
                } finally { swipe_refresh_layout.setRefreshing(false) }
            }

            override fun onFailure(call: Call<RnDInfoRes>, t: Throwable) {
                try {
                    mDatas.clear()
                    list.adapter?.notifyDataSetChanged()

                    Toast.makeText(this@CategoryFragment.context, "onFailure", Toast.LENGTH_SHORT).show()
                } catch (ex: Exception) {
                } finally { swipe_refresh_layout.setRefreshing(false) }
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                CategoryFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}
