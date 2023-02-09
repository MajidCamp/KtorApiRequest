package com.example.weak4day4ktorapirequsttutorial.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weak4day4ktorapirequsttutorial.model.Post
import com.example.weak4day4ktorapirequsttutorial.model.PostsApi
import com.example.weak4day4ktorapirequsttutorial.model.PostsApiImpl
import com.example.weak4day4ktorapirequsttutorial.util.Provider
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {

    private var postsApi: PostsApi = PostsApiImpl(Provider.client)
    private val _posts: MutableLiveData<List<Post>> = MutableLiveData(emptyList())
    val posts: LiveData<List<Post>> get() = _posts

    init {
        loadPostsFromApi()
    }

    fun loadPostsFromApi(){
        viewModelScope.launch {
            _posts.value = postsApi.getPosts()
        }
    }


}