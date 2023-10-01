package com.pbussolutions.noteappkmp.android.note_list

import com.pbussolutions.noteappkmp.domain.note.Note

/**
 * Created by Charles Yost on 9/28/23.
 * <p>
 * </p>
 */
data class NoteListState(
	val notes: List<Note> = emptyList(),
	val searchText: String = "",
	val isSearchActive: Boolean = false
)
