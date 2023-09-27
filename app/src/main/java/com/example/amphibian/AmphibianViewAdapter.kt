package com.example.amphibian
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class AmphibianViewAdapter(private val amphibianData: List<AmphibianData>, private val buttonClickListener: (AmphibianData) -> Unit):
    RecyclerView.Adapter<AmphibianViewAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.item_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return amphibianData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = amphibianData[position]

        holder.button.text = item.name
        holder.button.setOnClickListener{
            buttonClickListener(item)
        }
    }
}
