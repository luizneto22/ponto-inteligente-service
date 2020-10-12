package com.luiz.kotlin.utils

import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SenhaUtils {

    fun gerarBcrypt(senha: String): String = BCryptPasswordEncoder().encode(senha)

}
