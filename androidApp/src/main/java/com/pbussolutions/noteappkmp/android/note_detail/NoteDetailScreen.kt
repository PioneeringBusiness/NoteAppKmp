package com.pbussolutions.noteappkmp.android.note_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pbussolutions.noteappkmp.android.R

/**
 * Created by Charles Yost on 10/1/23.
 * <p>
 * </p>
 */

@Composable
fun NoteDetailScreen(
	noteId: Long,
	viewModel: NoteDetailViewModel = hiltViewModel()
) {
	val state by viewModel.state.collectAsState()
	val hasNoteBeenSaved by viewModel.hasNoteBeenSaved.collectAsState()

	LaunchedEffect(key1 = hasNoteBeenSaved) {
		if(hasNoteBeenSaved) {
			// TODO: Navigate Pop back stack
		}
	}

	Scaffold(
		floatingActionButton = {
			FloatingActionButton(
				onClick = viewModel::saveNote,
				backgroundColor = Color.Black
			) {
				Icon(
					imageVector = Icons.Default.Check,
					contentDescription = stringResource(R.string.save_note),
					tint = Color.White
				)
			}
		}
	) { padding ->
		Column(
			modifier = Modifier
				.background(Color(state.noteColor))
				.fillMaxSize()
				.padding(padding)
				.padding(16.dp)
		) {
			TransparentHintTextField(
				text = state.noteTitle,
				hint = "Enter Title..",
				isHintVisible = state.isNoteTitleHintVisible,
				onValueChanged = viewModel::onNoteTitleChanged,
				onFocusChanged = {
					viewModel.onNoteTitleFocusChanged(it.isFocused)
				},
				singleLine = true,
				textStyle = TextStyle(fontSize = 20.sp)
			)
			Spacer(modifier = Modifier.height(16.dp))
			TransparentHintTextField(
				text = state.noteContent,
				hint = "Enter some contnet..",
				isHintVisible = state.isNoteContentHintVisible,
				onValueChanged = viewModel::onNoteContentChanged,
				onFocusChanged = {
					viewModel.onNoteContentFocusChanged(it.isFocused)
				},
				singleLine = false,
				textStyle = TextStyle(fontSize = 20.sp),
				modifier =  Modifier.weight(1f)
			)
		}
	}

}