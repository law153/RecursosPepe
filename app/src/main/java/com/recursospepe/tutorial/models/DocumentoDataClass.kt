package com.recursospepe.tutorial.models

data class DocumentoDataClass (
    val idDocumento: Int,
    val tipo: String,
    val fechaSubidaDoc: String,  // Proximamente Date
    val descripcionDoc: String,
    val file: String, //Seguramente blob despues
    val usuarioPropietario: Int,
    val usuarioCreador: Int
)