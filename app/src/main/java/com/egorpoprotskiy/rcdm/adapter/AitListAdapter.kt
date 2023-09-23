package com.egorpoprotskiy.rcdm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.Ait
import com.egorpoprotskiy.rcdm.ui.info.InfoFragment

class AitListAdapter(private val context: InfoFragment, private val dataset: List<Ait>) :
    RecyclerView.Adapter<AitListAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val aitHeading: TextView = view.findViewById(R.id.aitHeading)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AitListAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ait_1, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: AitListAdapter.ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.aitHeading.text = context.resources.getText(item.aitHeading)
    }

    override fun getItemCount(): Int = dataset.size
}