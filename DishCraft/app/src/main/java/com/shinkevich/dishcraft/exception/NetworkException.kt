package com.shinkevich.dishcraft.exception

class NetworkException : Exception {
    constructor() : super()
    constructor(message: String?) : super(message) {
    }
}