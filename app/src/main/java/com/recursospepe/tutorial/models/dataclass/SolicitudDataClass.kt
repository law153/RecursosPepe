package com.recursospepe.tutorial.models.dataclass

data class SolicitudDataClass(
    val asunto: String,
    val descripcion: String,
    val estado: String,  // Aprobada, Rechazada, En revisión
    val fecha: String
)