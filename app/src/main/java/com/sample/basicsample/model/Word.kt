package com.sample.basicsample.model

class Word {
    private val word: String
    private val key: Int

    constructor(word: String, key: Int) {
        this.word = word
        this.key = key
    }

    fun getWord() = this.word
    fun getKey() = this.key
}
