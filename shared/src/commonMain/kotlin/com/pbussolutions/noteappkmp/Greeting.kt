package com.pbussolutions.noteappkmp

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello there, ${platform.name}!"
    }
}