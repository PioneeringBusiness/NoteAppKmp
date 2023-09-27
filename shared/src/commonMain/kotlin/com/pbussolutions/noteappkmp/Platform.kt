package com.pbussolutions.noteappkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform