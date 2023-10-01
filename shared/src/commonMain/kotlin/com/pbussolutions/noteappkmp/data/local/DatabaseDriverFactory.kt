package com.pbussolutions.noteappkmp.data.local

import com.squareup.sqldelight.db.SqlDriver

/**
 * Created by Charles Yost on 9/28/23.
 * <p>
 * </p>
 */
expect class DatabaseDriverFactory {
	fun createDriver(): SqlDriver
}