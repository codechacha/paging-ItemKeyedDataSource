package com.sample.basicsample.ui

import android.content.Context
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sample.basicsample.R
import com.sample.basicsample.model.Word


class WordListAdapter internal constructor(context: Context)
    : PagedListAdapter<Word, RecyclerView.ViewHolder>(REPO_COMPARATOR) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    inner class WordViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val wordItemView: TextView = itemView.findViewById(R.id.textView)
        fun bind(repo: Word?) {
            if (repo != null) {
                wordItemView.text = repo.getWord()
            } else {
                wordItemView.text = "No text"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val word = getItem(position)
        if (word != null) {
            (holder as WordViewHolder).bind(word)
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Word>() {
            override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean =
                oldItem.getWord() == newItem.getWord()

            override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean =
                oldItem.getWord() == newItem.getWord()
        }
    }
}
