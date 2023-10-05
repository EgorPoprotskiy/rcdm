package com.egorpoprotskiy.rcdm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egorpoprotskiy.rcdm.databinding.ItemAit1Binding
import com.egorpoprotskiy.rcdm.model.Ait

//31 Создание адаптера для АиТ
class AitListAdapter(private val dataset: List<Ait>, private val onAitClicked: (Ait) -> Unit ) :
    RecyclerView.Adapter<AitListAdapter.AitViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AitViewHolder {
        return AitViewHolder(ItemAit1Binding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: AitViewHolder, position: Int) {
        val current = dataset[position]
//        holder.aitHeading.text = context.resources.getText(item.aitHeading)
        holder.bind(current)
        //данный слушатель кликов срабатывает на всём квадратике
        holder.itemView.setOnClickListener {
            onAitClicked(current)
        }
    }

    override fun getItemCount(): Int = dataset.size

    inner class AitViewHolder(private var binding: ItemAit1Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ait: Ait) {
            binding.aitLabel.text = ait.aitHeading.toString()
            //данный слушатель кликов срабатывает только на тексте
//            binding.aitLabel.setOnClickListener {
//                onAitClicked(ait)
//            }
        }
    }
}