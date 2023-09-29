package com.pbussolutions.noteappkmp.data.note

import com.pbussolutions.noteappkmp.domain.note.Note
import database.NoteEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

/**
 * Created by Charles Yost on 9/27/23.
 * <p>
 * </p>
 */

fun NoteEntity.toNote(): Note {
	return Note(
		id = id,
		title = title,
		content = content,
		colorHex = colorHex,
		created = Instant
			.fromEpochMilliseconds(created)
			.toLocalDateTime(TimeZone.currentSystemDefault())
	)
}