package com.moberan.zoops.rndhub.mainfragment.adapter


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.moberan.zoops.rndhub.R
import com.moberan.zoops.rndhub.data.RnDInfo
import com.moberan.zoops.rndhub.mainfragment.PeerFragment.OnListFragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_peer.view.*

class MyPeerRecyclerViewAdapter(
        private val mValues: List<RnDInfo>,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<MyPeerRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as RnDInfo
            // Notify the active callbacks interface (the activity, if the fragment is attached to one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_peer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.title
        holder.mContentView.text = item.cat

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
