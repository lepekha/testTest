package com.inhelp.view.main.tags

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.inhelp.R
import com.inhelp.utils.extension.clipboard
import com.inhelp.utils.extension.toast
import kotlinx.android.synthetic.main.element_tag.view.*
import android.R.attr.data
import android.content.ClipData


class TagsRvAdapter(tagsList: ArrayList<Tags>, val context: Context, val listener:(position: Int) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    var tags = tagsList.toMutableList()

    override fun getItemCount(): Int {
        return tags.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.element_tag, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtTags.text = tags[position].text
        holder.txtTitle.text = tags[position].title
        holder.root.setOnClickListener {
            context.clipboard = tags[position].text
            context.toast("Tags is copy", Toast.LENGTH_SHORT)
        }
        holder.root.setOnLongClickListener { view ->
            val data = ClipData.newPlainText("===", "===")
            val shadowBuilder = View.DragShadowBuilder(view)
            view.startDrag(data, shadowBuilder, view, 0)
        }
    }

    fun setFilterList(tagsList: MutableList<Tags>){
        tags = tagsList
        notifyDataSetChanged()
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val txtTitle = view.txtTitle
    val txtTags = view.txtTags
    val root = view.root
}

data class Tags(val title: String, val text: String)