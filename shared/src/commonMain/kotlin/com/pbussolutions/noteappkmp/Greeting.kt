package com.pbussolutions.noteappkmp

import database.NoteEntity

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello there, ${platform.name}!"
    }
}