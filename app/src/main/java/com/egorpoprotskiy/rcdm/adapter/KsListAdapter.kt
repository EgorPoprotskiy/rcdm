package com.egorpoprotskiy.rcdm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egorpoprotskiy.rcdm.databinding.ItemPs1Binding
import com.egorpoprotskiy.rcdm.model.Ks

//47
class KsListAdapter(private val dataset: List<Ks>, private val onKsClicked: (Ks) -> Unit):
    RecyclerView.Adapter<KsListAdapter.KsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KsViewHolder {
        return KsViewHolder(ItemPs1Binding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: KsListAdapter.KsViewHolder, position: Int) {
        val current = dataset[position]
        holder.bind(current)
        holder.itemView.setOnClickListener {
            onKsClicked(current)
        }
    }

    override fun getItemCount(): Int = dataset.size

    inner class KsViewHolder(private var binding: ItemPs1Binding): RecyclerView.ViewHolder(binding.root) {
        fun bind(ks: Ks) {
            binding.psLabel.text = ks.ksHeading
        }
    }

}