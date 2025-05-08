package com.recursospepe.tutorial.models

data class DocumentoDataClass (
    val idDocumento: Int,
    val tipo: String,
    val fechaSubidaDoc: String,  // Proximamente Date
    val descripcionDoc: String,
    val file: String, //Seguramente blob despues
    val usuarioPropietario: Int, //El admin que tiene acceso
    val usuarioCreador: Int, //El usuario que lo creó
    val prioridad: String //Alta, media, leve
)