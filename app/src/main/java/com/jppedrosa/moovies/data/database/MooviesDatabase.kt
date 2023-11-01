package com.jppedrosa.moovies.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jppedrosa.moovies.data.database.dao.MovieDatabaseDao
import com.jppedrosa.moovies.data.database.entities.MovieEntity

/**
 * @author João Pedro Pedrosa ([joaopopedrosa@gmail.com](mailto:joaopopedrosa@gmail.com)) on 26/09/2022.
 */

@Database(
    entities = [MovieEntity::class],
    version = 1
)
abstract class MooviesDatabase : RoomDatabase() {

    abstract fun getMovieDao(): MovieDatabaseDao
}
