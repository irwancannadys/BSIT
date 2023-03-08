package com.irwan.bsit.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.irwan.bsit.databinding.ItemTransactionBinding
import com.irwan.bsit.model.TransactionResponse

class TransactionAdapter(
    private val data: List<TransactionResponse>
) : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = TransactionViewHolder(
        ItemTransactionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bindingView(data[position])
    }

    override fun getItemCount() = data.size

    inner class TransactionViewHolder(val binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindingView(item: TransactionResponse) {
            binding.tvUser.text = item.name
            binding.tvMethod.text = item.metode_trf
            binding.tvNominal.text = item.nominal_saldo
            Glide
                .with(binding.root.context)
                .load(item.image_url)
                .centerCrop()
                .into(binding.ivUser)


        }
    }
}