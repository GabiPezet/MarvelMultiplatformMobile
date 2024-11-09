package com.tallerprogra.marvelkmm

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.tallerprogra.marvelkmm.initializer.AppContextWrapper


actual class DatabaseDriverFactory actual constructor() {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(MarvelDatabase.Schema, AppContextWrapper.appContext!!, DB_NAME )
    }
}

//actual class DatabaseDriverFactory(private val context: Context) {
//    actual fun createDriver(): SqlDriver {
//        return AndroidSqliteDriver(MarvelDatabase.Schema, context, "marvel.db" )
//    }
//}