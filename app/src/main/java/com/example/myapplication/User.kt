package com.example.myapplication

data class User(val name:String,
                val bio:String,
                val profilepicpath:String?) {
    constructor() : this("","",null)
}