package com.jsandroid.paging.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.ItemKeyedDataSource
import com.sample.basicsample.model.Word

class WordDataSource : ItemKeyedDataSource<Int, Word>() {

    companion object {
        const val TAG = "WordDataSource"
    }

    val networkErrors: MutableLiveData<String> = MutableLiveData()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Word>) {
        Log.i(TAG, "Initial Loading, count: ${params.requestedLoadSize}")
        val initKey = 1
        val items = getWordItems(initKey, params.requestedLoadSize)
        callback.onResult(items)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Word>) {
        Log.i(TAG, "Loading key: ${params.key}, count: ${params.requestedLoadSize}")
        val items = getWordItems(params.key, params.requestedLoadSize)
        callback.onResult(items)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Word>) {
    }

    override fun getKey(item: Word): Int {
        return item.getKey()
    }

    fun getWordItems(key: Int, size: Int): List<Word> {
        val list = ArrayList<Word>()
        for (i in 0..(size - 1)) {
            val itemKey = key + i
            list.add(Word("Content of key $itemKey", itemKey))
        }
        return list
    }

}

