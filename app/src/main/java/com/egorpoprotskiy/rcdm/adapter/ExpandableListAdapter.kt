package com.egorpoprotskiy.rcdm.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.EasdChapter

//50
class ExpandableListAdapter internal constructor(
        private val context: Context,
    private val chapters: List<EasdChapter>
) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return chapters.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return chapters[groupPosition].topicsName.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return chapters[groupPosition].chapterName
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return chapters[groupPosition].topicsName[childPosition]
    }
    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }
    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return  childPosition.toLong()
    }
    override fun hasStableIds(): Boolean {
        return false
    }
    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var convertView = convertView
        val chapterTitle = getGroup(groupPosition) as String
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.chapter_list, null)
        }
        val tvChapter = convertView!!.findViewById<TextView>(R.id.tv_chapter)
        tvChapter.setText(chapterTitle)
        return convertView
    }
    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var convertView = convertView
        val topicsTitle = getChild(groupPosition, childPosition) as String
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.topics_list, null)
        }
        val tvTopics = convertView!!.findViewById<TextView>(R.id.tv_topics)
        tvTopics.setText(topicsTitle)
        return convertView
    }
    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

}