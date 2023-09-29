package com.pbussolutions.noteappkmp.data.note

import com.pbussolutions.noteappkmp.database.NoteDatabase
import com.pbussolutions.noteappkmp.domain.note.Note
import com.pbussolutions.noteappkmp.domain.note.NoteDataSource
import com.pbussolutions.noteappkmp.domain.time.DateTimeUtil

/**
 * Created by Charles Yost on 9/27/23.
 * <p>
 * </p>
 */
class SqlDelightNoteDataSource( db: NoteDatabase): NoteDataSource {
	private val queries = db.noteQueries

	override suspend fun insertNote(note: Note) {
		queries.insertNote(
			id = note.id,
			title = note.title,
			content = note.content,
			colorHex = note.colorHex,
			created = DateTimeUtil.toEpochMilllis(note.created)
		)
	}

	override suspend fun getNoteById(id: Long): Note? {
		// TODO: Create mapper 40:15 on https://www.youtube.com/watch?v=1w-LTUm_iDE
		return queries
			.getNoteById(id)
			.executeAsOneOrNull()
			?.toNote()
	}

	override suspend fun getAllNotes(): List<Note> {
		return queries
			.getAllNotes()
			.executeAsList()
			.map { it.toNote() }
	}

	override suspend fun deleteNoteById(id: Long) {
		queries.deleteNoteById(id)
	}
}