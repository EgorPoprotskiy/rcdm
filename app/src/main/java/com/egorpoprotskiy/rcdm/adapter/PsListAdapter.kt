package com.egorpoprotskiy.rcdm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egorpoprotskiy.rcdm.databinding.ItemPs1Binding
import com.egorpoprotskiy.rcdm.model.Ps

class PsListAdapter(private val dataset: List<Ps>, private val onPsClicked: (Ps) -> Unit): RecyclerView.Adapter<PsListAdapter.PsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PsListAdapter.PsViewHolder {
        return PsViewHolder(ItemPs1Binding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PsListAdapter.PsViewHolder, position: Int) {
        val current = dataset[position]
        holder.bind(current)
        holder.itemView.setOnClickListener {
            onPsClicked(current)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    inner class PsViewHolder(private var binding: ItemPs1Binding): RecyclerView.ViewHolder(binding.root) {
        fun bind(ps: Ps) {
            binding.psLabel.text = ps.psHeading
        }
    }
}