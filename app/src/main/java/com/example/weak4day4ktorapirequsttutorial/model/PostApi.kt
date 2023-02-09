package com.example.weak4day4ktorapirequsttutorial.model

import com.example.weak4day4ktorapirequsttutorial.model.Post

interface PostsApi {
    suspend fun getPosts(): List<Post>
}