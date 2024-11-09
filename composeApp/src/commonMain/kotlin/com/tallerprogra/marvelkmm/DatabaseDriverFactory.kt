package com.tallerprogra.marvelkmm

import app.cash.sqldelight.db.SqlDriver

const val DB_NAME = "marvel.db"

expect class DatabaseDriverFactory() {
     fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DatabaseDriverFactory): MarvelDatabase{
     return MarvelDatabase(driverFactory.createDriver())
}