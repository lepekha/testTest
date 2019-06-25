package com.inhelp.view.main.tags

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionManager
import com.inhelp.R
import kotlinx.android.synthetic.main.element_tag.view.*
import android.view.animation.AnticipateOvershootInterpolator
import androidx.transition.ChangeBounds


class TagsRvAdapter(tagsList: ArrayList<Tags>, val context: Context, val listener: (position: Int) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    companion object {
        const val COLLAPSED_TAG_MAX_LINE = 5
        const val EXPANDED_TAG_MAX_LINE = 100
    }

    val constraintSet1 = ConstraintSet()
    val constraintSet2 = ConstraintSet()
    var tags = tagsList.toMutableList()

    private var mPreventOpenItemHolder: ViewHolder? = null
        set(value) {
//            when {
//                field === value && field?.isOpen == true -> closeItem(field)
//                field === value && field?.isOpen == false -> openItem(field)
//                else -> {
                    closeItem(field)
                    openItem(value)
//                }
//            }
            field = value
        }

    private fun closeItem(holder: ViewHolder?) {
        holder?.btnCopy?.isVisible = false
        holder?.isOpen = false
        holder?.txtTags?.maxLines = COLLAPSED_TAG_MAX_LINE
    }

    private fun openItem(holder: ViewHolder?) {
        holder?.let { hr ->

        }

//        holder?.btnCopy?.isVisible = true
//        holder?.isOpen = true
//        holder?.txtTags?.maxLines = EXPANDED_TAG_MAX_LINE
    }

    override fun getItemCount(): Int {
        return tags.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        constraintSet1.clone(parent.context, R.layout.element_tag)
        constraintSet2.clone(parent.context, R.layout.element_tag_open)
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.element_tag, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtTags.text = tags[position].text
        holder.txtTitle.text = tags[position].title
        var changed = false

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1000
//        constraintSet1.clone(holder.root)
        holder.root.setOnClickListener {

            TransitionManager.beginDelayedTransition(holder.root, transition)
            val constraint = if (changed) {
                holder.txtTags.maxLines = COLLAPSED_TAG_MAX_LINE
                constraintSet1
            } else {
                holder.txtTags.maxLines = EXPANDED_TAG_MAX_LINE
                constraintSet2
            }
            constraint.applyTo(holder.root)
            changed = !changed
//            mPreventOpenItemHolder = holder
//            context.clipboard = tags[position].text
//            context.toast("Tags is copy", Toast.LENGTH_SHORT)
        }
    }

    fun setFilterList(tagsList: MutableList<Tags>) {
        tags = tagsList
        notifyDataSetChanged()
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val txtTitle = view.txtTitle
    val txtTags = view.txtTags
    val btnCopy = view.btnCopy
    val root = view.root

    var isOpen = false
}

data class Tags(val title: String, val text: String)