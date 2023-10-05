package com.pbussolutions.noteappkmp.data.di

import com.pbussolutions.noteappkmp.data.local.DatabaseDriverFactory
import com.pbussolutions.noteappkmp.data.note.SqlDelightNoteDataSource
import com.pbussolutions.noteappkmp.database.NoteDatabase
import com.pbussolutions.noteappkmp.domain.note.NoteDataSource

/**
 * Created by Charles Yost on 10/4/23.
 * <p>
 * </p>
 */
class DatabaseModule {

	private val factory by lazy { DatabaseDriverFactory() }
		val noteDataSource: NoteDataSource by lazy {
		SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
	}
}