package com.pbussolutions.noteappkmp.android.di

import android.app.Application
import com.pbussolutions.noteappkmp.data.local.DatabaseDriverFactory
import com.pbussolutions.noteappkmp.data.note.SqlDelightNoteDataSource
import com.pbussolutions.noteappkmp.database.NoteDatabase
import com.pbussolutions.noteappkmp.domain.note.NoteDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Charles Yost on 10/1/23.
 * <p>
 * </p>
 */
@Module
@InstallIn(SingletonComponent::class)
object ApModule {

	@Provides
	@Singleton
	fun provideSqlDriver(app: Application): SqlDriver {
		return DatabaseDriverFactory(app).createDriver()
	}

	@Provides
	@Singleton
	fun provideSNoteDataSource(driver: SqlDriver): NoteDataSource {
		return SqlDelightNoteDataSource(NoteDatabase(driver))
	}
}