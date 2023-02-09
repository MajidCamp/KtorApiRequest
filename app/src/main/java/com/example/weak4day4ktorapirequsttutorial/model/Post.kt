package com.example.weak4day4ktorapirequsttutorial.model

import kotlinx.serialization.Serializable


@Serializable
data class Post(
//    val id: String,
//    val title: String,
//    val content: String,
//    val slug: String,
//    val picture: String,
//    val user: String,
    val status: String,
    val message: String
)