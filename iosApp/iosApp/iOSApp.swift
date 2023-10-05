import SwiftUI
import shared

@main
struct iOSApp: App {
    
    private let databasModule = DatabaseModule()
	var body: some Scene {
		WindowGroup {
            NavigationView {
                NoteListScreen(noteDataSource: databasModule.noteDataSource)
            }.accentColor(.black)
            
		}
	}
}
