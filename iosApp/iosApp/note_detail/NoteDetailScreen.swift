//
//  NoteDetailScreen.swift
//  iosApp
//
//  Created by Charles Yost on 10/4/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct NoteDetailScreen: View {
    private var noteDataSource: NoteDataSource
    private var noteid: Int64? = nil
    
    @StateObject var viewModel = NoteDetalViewModel(noteDataSource: nil)
    
    @Environment(\.presentationMode) var presentation
    
    init(noteDataSource: NoteDataSource, noteid: Int64? = nil) {
        self.noteDataSource = noteDataSource
        self.noteid = noteid
    }
    
    var body: some View {
        VStack(alignment: .leading ) {
            TextField("Enter a title...", text: $viewModel.noteTitle)
                .font(.title)
            TextField("Enter note content...", text: $viewModel.noteContent)
            Spacer()
        }.toolbar(content: {
            Button(action: {
                viewModel.saveNote {
                    self.presentation.wrappedValue.dismiss()
                }
            }) {
                Image(systemName: "checkmark")
            }
        })
        .padding()
        .background(Color(hex: viewModel.noteColor))
        .onAppear {
            viewModel.setParamsAndLoadNote(noteDataSource: noteDataSource, noteId: noteid)
        }
    }
}

struct NoteDetailScreen_Previews: PreviewProvider {
    static var previews: some View {
        EmptyView()
    }
}
