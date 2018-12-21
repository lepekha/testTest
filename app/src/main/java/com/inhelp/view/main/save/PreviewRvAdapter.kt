package com.inhelp.view.main.save

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inhelp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.element_preview_photos.view.*

class PreviewRvAdapter(val items: ArrayList<String>, val context: Context, val listener:(position: Int) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.element_preview_photos, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(items[position]).into(holder.imgPreview)

        holder.imgPreview.setOnClickListener {
            listener(position)
        }
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imgPreview = view.imgPreview
}