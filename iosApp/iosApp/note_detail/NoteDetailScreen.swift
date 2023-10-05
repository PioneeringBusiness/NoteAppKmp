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
    private var noteDataSource: NoteDataSource?
    private var noteid: Int64? = nil
    
    init(noteDataSource: NoteDataSource? = nil, noteid: Int64? = nil) {
        self.noteDataSource = noteDataSource
        self.noteid = noteid
    }
    
    var body: some View {
        Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
    }
}

struct NoteDetailScreen_Previews: PreviewProvider {
    static var previews: some View {
        NoteDetailScreen()
    }
}
