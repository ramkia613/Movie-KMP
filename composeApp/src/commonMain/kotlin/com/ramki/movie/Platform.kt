package com.ramki.movie

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform