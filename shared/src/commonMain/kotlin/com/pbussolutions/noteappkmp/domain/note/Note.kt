package com.pbussolutions.noteappkmp.domain.note

import com.pbussolutions.noteappkmp.presentation.BabyBlueHex
import com.pbussolutions.noteappkmp.presentation.LightGreenHex
import com.pbussolutions.noteappkmp.presentation.RedOrangeHex
import com.pbussolutions.noteappkmp.presentation.RedPinkHex
import com.pbussolutions.noteappkmp.presentation.VioletHex
import kotlinx.datetime.LocalDateTime

/**
 * Created by Charles Yost on 9/27/23.
 * <p>
 * </p>
 */
data class Note(
	val id: Long?,
	val title: String,
	val content: String,
	val colorHex: Long,
	val created: LocalDateTime
) {
	companion object {
		private val colors = listOf(
			RedOrangeHex,
			RedPinkHex,
			LightGreenHex,
			BabyBlueHex,
			VioletHex
		)

		fun generateRandomColor() = colors.random()
	}
}
