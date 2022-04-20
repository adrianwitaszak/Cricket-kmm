package com.adwi.buddy

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}