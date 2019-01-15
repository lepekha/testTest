package com.inhelp.view.main.save

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.inhelp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.element_preview_photos.view.*

class PreviewRvAdapter(val items: ArrayList<String>, val context: Context, val listener:(position: Int) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    private var mCurrentActiveImage = 0
    private val mPhotoBackground = context.getDrawable(R.drawable.ic_selected_preview)

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.element_preview_photos, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(items[position]).placeholder(R.drawable.ic_placeholder) .into(holder.imgPreview)
        if(position == mCurrentActiveImage){
            holder.imgSave.isVisible = true
            holder.imgPreview.background = mPhotoBackground
        }else{
            holder.imgSave.isVisible = false
            holder.imgPreview.background = null
        }


        holder.imgPreview.setOnClickListener {
            listener(position)
            mCurrentActiveImage = position
            notifyDataSetChanged()
        }
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imgPreview = view.imgPreview
    val imgSave = view.imgSave
}