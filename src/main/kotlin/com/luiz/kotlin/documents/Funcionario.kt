package com.luiz.kotlin.documents

import com.luiz.kotlin.enums.PerfilEnum
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Funcionario(
        @Id val id: String? = null,
        val nome: String,
        val email: String,
        val senha: String,
        val cpf: String,
        val perfil: PerfilEnum,
        val emprasaId: String,
        val valorHora: Double? = 0.0,
        val qtdHorasTrabalhoDia: Float? = 0.0f,
        val qtdHorasAlmoco: Float? = 0.0f)
