package com.moberan.zoops.rndhub.mainfragment

import android.content.Context
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

import com.moberan.zoops.rndhub.mainfragment.dummy.DummyContent
import com.moberan.zoops.rndhub.mainfragment.adapter.MyTrendRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_trend_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [TrendFragment.OnListFragmentInteractionListener] interface.
 */
class TrendFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {
    private var mListener: OnListFragmentInteractionListener? = null
    private var mDatas: MutableList<RnDInfo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_trend_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set the adapter
        if (list is RecyclerView) {
            with(list) {
                layoutManager = LinearLayoutManager(context)
                adapter = MyTrendRecyclerViewAdapter(mDatas, mListener)
            }
        }
        swipe_refresh_layout.setOnRefreshListener(this)
        requestData()
    }

    private fun requestData() {
        ApiUtil.mTendService!!.getRnDTrendList().enqueue(object : Callback<RnDInfoRes> {
            override fun onResponse(call: Call<RnDInfoRes>, response: Response<RnDInfoRes>) {
                try {
                    mDatas.clear()
                    response?.body()?.list?.forEach { mDatas.add(it) }
                    list.adapter?.notifyDataSetChanged()

                    Toast.makeText(this@TrendFragment.context, "onResponse", Toast.LENGTH_SHORT).show()
                } catch (ex: Exception) {
                } finally { swipe_refresh_layout.setRefreshing(false) }
            }

            override fun onFailure(call: Call<RnDInfoRes>, t: Throwable) {
                try {
                    mDatas.clear()
                    list.adapter?.notifyDataSetChanged()

                    Toast.makeText(this@TrendFragment.context, "onFailure", Toast.LENGTH_SHORT).show()
                } catch (ex: Exception) {
                } finally { swipe_refresh_layout.setRefreshing(false) }
            }
        })
    }

    override fun onRefresh() {
        requestData()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: RnDInfo?)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                TrendFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}