package com.pbussolutions.noteappkmp.domain.note

import com.pbussolutions.noteappkmp.domain.time.DateTimeUtil

/**
 * Created by Charles Yost on 9/28/23.
 * <p>
 * </p>
 */
class SearchNotes {

	fun execute(notes: List<Note>, query: String): List<Note> {
		if(query.isBlank()) {
			return notes
		}
		return notes.filter {
			it.title.trim().lowercase().contains(query.lowercase()) ||
					it.content.trim().lowercase().contains(query.lowercase())
		}.sortedBy {
			DateTimeUtil.toEpochMilllis(it.created)
		}
	}
}