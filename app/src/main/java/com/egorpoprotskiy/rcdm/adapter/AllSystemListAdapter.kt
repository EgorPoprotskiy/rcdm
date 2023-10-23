package com.egorpoprotskiy.rcdm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egorpoprotskiy.rcdm.databinding.ItemAllSystemBinding
import com.egorpoprotskiy.rcdm.model.AllSystem


//54
class AllSystemListAdapter(
    private val dataset: List<AllSystem>,
    private val onAllSystemClicked: (AllSystem) -> Unit
) : RecyclerView.Adapter<AllSystemListAdapter.AllSystemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AllSystemListAdapter.AllSystemViewHolder {
        return AllSystemViewHolder(ItemAllSystemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: AllSystemListAdapter.AllSystemViewHolder, position: Int) {
        val current = dataset[position]
        holder.bind(current)
        holder.itemView.setOnClickListener {
            onAllSystemClicked(current)
        }
    }

    override fun getItemCount(): Int = dataset.size

    inner class AllSystemViewHolder(private var binding: ItemAllSystemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(allSystem: AllSystem) {
            binding.allSystemHeading.text = allSystem.allSystem
        }
    }
}