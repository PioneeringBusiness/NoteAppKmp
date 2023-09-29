package com.pbussolutions.noteappkmp.domain.note

/**
 * Created by Charles Yost on 9/27/23.
 * <p>
 * </p>
 */
interface NoteDataSource {
	suspend fun insertNote(note: Note)
	suspend fun getNoteById(id: Long): Note?
	suspend fun getAllNotes(): List<Note>
	suspend fun deleteNoteById(id: Long)
}