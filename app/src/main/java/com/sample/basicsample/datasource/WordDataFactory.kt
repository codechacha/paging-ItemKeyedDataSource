package com.jsandroid.paging.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.sample.basicsample.model.Word

class WordDataFactory() : DataSource.Factory<Int, Word>() {

    val mutableLiveData: MutableLiveData<WordDataSource> = MutableLiveData<WordDataSource>()
    private var repoDataSource: WordDataSource? = null

    override fun create(): DataSource<Int, Word> {
        repoDataSource = WordDataSource()
        mutableLiveData.postValue(repoDataSource)
        return repoDataSource!!
    }

}