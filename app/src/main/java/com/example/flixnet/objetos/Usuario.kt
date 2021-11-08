package com.example.flixnet.objetos

import java.io.Serializable

data class Usuario(val nombre: String,
                   val apellidos:String,
                   val email: String,
                   val password : String,
                   val edad: Int, ): Serializable
