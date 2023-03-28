package com.example.assesment1

import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assesment1.databinding.ListItemBinding
import org.w3c.dom.Text

class MainAdapter(private val data: List<Hewan>) :


    RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    class ViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hewan: Hewan) = with(binding) {
            imageView.setImageResource(hewan.imageResId)
            binding.button.setOnClickListener { button() }

        }
        private fun button() {
            val benar = binding.input.text.toString()
            if (TextUtils.isEmpty(benar)){
                print("@string/benar")
                return
            }

        }
        

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }


    override fun getItemCount(): Int {
        return data.size
    }
}
