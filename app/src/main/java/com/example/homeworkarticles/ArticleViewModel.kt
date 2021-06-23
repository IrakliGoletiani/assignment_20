package com.example.homeworkarticles

import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homeworkarticles.RetrofitService.api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArticleViewModel : ViewModel() {

    private val _articles = MutableLiveData<Articles>()
    val articles: LiveData<Articles> = _articles

    fun getArticles() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = api.getArticles()

                if (response.isSuccessful) {
                    _articles.postValue(response.body())
                } else {
                    d("mainLog", response.errorBody()!!.toString())
                }
            }
        }
    }
}