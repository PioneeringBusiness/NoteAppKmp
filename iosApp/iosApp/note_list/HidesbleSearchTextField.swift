//
//  HidesbleSearchTextField.swift
//  iosApp
//
//  Created by Charles Yost on 10/2/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

// TODO start at https://www.youtube.com/watch?v=1w-LTUm_iDE 2:12:28
struct HidesbleSearchTextField<Destination: View>: View {
    
    var onSearchToggled: () -> Void
    var destinationProvider: () -> Destination
    var isSearchActive: Bool
    @Binding var searchText: String
    
    var body: some View {
        HStack {
            TextField("Search...", text: $searchText)
                .textFieldStyle(.roundedBorder)
                .opacity(isSearchActive ? 1 : 0)
            if !isSearchActive {
                Spacer()
            }
            Button(action: onSearchToggled) {
                Image(systemName: isSearchActive ? "xmark" : "magnifyingglass")
                    .foregroundColor(.black)
            }
            NavigationLink(destination: destinationProvider()) {
                Image(systemName: "plus")
                    .foregroundColor(.black)
            }
        }
    }
}

struct HidesbleSearchTextField_Previews: PreviewProvider {
    static var previews: some View {
        HidesbleSearchTextField(
            onSearchToggled: {},
            destinationProvider: { EmptyView() },
            isSearchActive: true,
            searchText: .constant("Hello World")
        )
    }
}
