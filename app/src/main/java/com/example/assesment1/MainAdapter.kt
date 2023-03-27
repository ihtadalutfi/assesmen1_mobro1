package com.example.assesment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.assesment1.databinding.ListItemBinding

class MainAdapter(private val data: List<Hewan>) :


    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
//class MainAdapter : AppCompatActivity() {
//    var tekan: TextView? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContentView(android.R.layout.activity_main)
//        tekan = findViewById<View>(android.R.id.tekan) as TextView
//
//    }
//
//    fun ButtonOnClick(V: View?) {
//        tekan!!.text = "Jawaban Sedang di periksa"
//        this.tekan!!.visibility = View.VISIBLE
//    }
//}

    class ViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hewan: Hewan) = with(binding) {
            imageView.setImageResource(hewan.imageResId)

            root.setOnClickListener {
                val message = root.context.getString(R.string.message, hewan.nama)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
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
