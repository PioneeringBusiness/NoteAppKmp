package com.pbussolutions.noteappkmp.data.local

import android.content.Context
import com.pbussolutions.noteappkmp.database.NoteDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

/**
 * Created by Charles Yost on 9/28/23.
 * <p>
 * </p>
 */
actual class DatabaseDriverFactory(private val context: Context) {
	actual fun createDriver(): SqlDriver {
		return AndroidSqliteDriver(NoteDatabase.Schema, context, "note.db")
	}
}