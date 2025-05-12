package com.recursospepe.tutorial.models

class UsuarioDataClass (
    val idUsuario: Int,
    val nombreUsuario: String,
    val apellidos: String,
    val correo: String,
    val clave: String,
    val direccion: String,
    val telefono: Int,
    val cargo: String,
    val creacionCuenta: String,//Proximamente Date
    val fotoUsario: String,  //Proximamente Blob
    val idRol: Int
)