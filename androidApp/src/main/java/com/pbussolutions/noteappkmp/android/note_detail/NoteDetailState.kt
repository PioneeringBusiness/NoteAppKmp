package com.pbussolutions.noteappkmp.android.note_detail


/**
 * Created by Charles Yost on 10/1/23.
 * <p>
 * </p>
 */
data class NoteDetailState(
	val noteTitle: String = "",
	val isNoteTitleHintVisible: Boolean = false,
	val noteContent: String = "",
	val isNoteContentHintVisible: Boolean = false,
	val noteColor: Long = 0xFFFFFF

)
