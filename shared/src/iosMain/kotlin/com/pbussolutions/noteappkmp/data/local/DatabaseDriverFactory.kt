package com.pbussolutions.noteappkmp.data.local

import com.pbussolutions.noteappkmp.database.NoteDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

/**
 * Created by Charles Yost on 9/28/23.
 * <p>
 * </p>
 */
actual class DatabaseDriverFactory {
	actual fun createDriver(): SqlDriver {
		return NativeSqliteDriver(NoteDatabase.Schema, "note.db")
	}
}