package com.sample.basicsample.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.jsandroid.paging.datasource.WordDataFactory
import com.sample.basicsample.model.Word


class WordViewModel(app: Application) : AndroidViewModel(app) {
    fun getAllWords(): LiveData<PagedList<Word>> {
        val dataSourceFactory = WordDataFactory()
        val pagedListConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(10) // default: page size * 3
            .setPrefetchDistance(10) // default: page size
            .setEnablePlaceholders(false) // default: true
            .build()

        val data = LivePagedListBuilder(dataSourceFactory, pagedListConfig)
            .build()
        return data
    }
}