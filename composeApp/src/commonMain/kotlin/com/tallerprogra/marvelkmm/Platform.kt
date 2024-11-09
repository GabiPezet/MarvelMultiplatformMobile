package com.tallerprogra.marvelkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
