package com.luiz.kotlin.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SenhaUtilsTest {

    private val senha ="12345"
    private val bCryptEncoder = BCryptPasswordEncoder()

    @Test
    @DisplayName("Verificando geração de senha")
    fun testGerarHashSenha() {
        val hash = SenhaUtils().gerarBcrypt(senha)
        Assertions.assertTrue(bCryptEncoder.matches(senha, hash))
    }
}
