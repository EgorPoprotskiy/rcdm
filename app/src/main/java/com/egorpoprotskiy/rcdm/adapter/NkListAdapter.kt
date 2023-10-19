package com.egorpoprotskiy.rcdm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egorpoprotskiy.rcdm.databinding.ItemNk1Binding
import com.egorpoprotskiy.rcdm.model.Nk

//48
class NkListAdapter(private val dataset: List<Nk>, private val onNkClicked: (Nk) -> Unit) :
    RecyclerView.Adapter<NkListAdapter.NkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NkListAdapter.NkViewHolder {
        return NkViewHolder(ItemNk1Binding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: NkListAdapter.NkViewHolder, position: Int) {
        val current = dataset[position]
        holder.bind(current)
        holder.itemView.setOnClickListener {
            onNkClicked(current)
        }
    }

    override fun getItemCount(): Int = dataset.size

    inner class NkViewHolder(private var binding: ItemNk1Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(nk: Nk) {
            binding.nkLabel.text = nk.nkHeading
        }
    }
}