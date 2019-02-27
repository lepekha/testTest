package com.inhelp.view.main.tags

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Rect
import android.graphics.RectF
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.contains
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Transition
import androidx.transition.TransitionSet
import com.inhelp.R
import com.inhelp.utils.extension.afterTextChanged
import com.inhelp.utils.extension.onTransitionEnd
import com.inhelp.view.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_tags.*
import org.koin.android.ext.android.inject


class FragmentTags : BaseMvpFragment<ViewTags, PresenterTags>(), ViewTags {
    override fun backPress() {
    }


    override val presenter: PresenterTags by inject()

    private lateinit var mTagsRvAdapter: TagsRvAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tags, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.onTransitionEnd {
            initList()
            groupAll?.isVisible = true
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        presenter.tagsTitle = getCurrentContext().resources.getStringArray(R.array.tags_title)
        presenter.tagsText = getCurrentContext().resources.getStringArray(R.array.tags_text)
        presenter.initList()



        titleTags.setOnClickListener {
            presenter.onBackPress()
        }

        edFilter.afterTextChanged { presenter.changeFilter(it) }
    }

    private fun initList(){
        lstTags.layoutManager = LinearLayoutManager(getCurrentContext(), RecyclerView.VERTICAL, false)
        lstTags.setHasFixedSize(true)
        mTagsRvAdapter = TagsRvAdapter(presenter.tagsList, getCurrentContext()) {}
        lstTags?.adapter = mTagsRvAdapter

    }

    override fun setFilterList(tagsFilter: MutableList<Tags>){
        mTagsRvAdapter.setFilterList(tagsFilter)
    }

    override fun setVisiblePlaceholder(isVisible: Boolean) {
        txtPlaceholder.isVisible = isVisible
    }

}