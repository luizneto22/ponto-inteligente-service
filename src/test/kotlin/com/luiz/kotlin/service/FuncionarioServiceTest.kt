package com.luiz.kotlin.service

import com.luiz.kotlin.documents.Funcionario
import com.luiz.kotlin.enums.PerfilEnum
import com.luiz.kotlin.repository.FuncionarioRepository
import com.luiz.kotlin.utils.SenhaUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureDataMongo
class FuncionarioServiceTest {

    @Autowired
    val funcionarioService: FuncionarioService? = null

    @MockBean
    private val funcionarioRepository: FuncionarioRepository? = null

    private val email: String = "email@email.com"
    private val cpf: String  ="34234855948"
    private val id: String ="1"

    @BeforeEach
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java))).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findById(id)).willReturn(Optional.of(funcionario()))
        BDDMockito.given(funcionarioRepository?.findByEmail(email)).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findByCpf(cpf)).willReturn(funcionario())

    }

    @Test
    fun testPersistirFuncionario (){
        val funcionario: Funcionario? = this.funcionarioService?.persistir(funcionario())
        Assertions.assertNotNull(funcionario)
    }

    @Test
    fun testBuscarFuncionarioPorId() {
        val funcionario: Optional<Funcionario>? = this.funcionarioService?.buscarPorId(id)
        Assertions.assertNotNull(funcionario)

    }

    @Test
    fun testBuscarFuncionarioPorEmail() {
        val funcionario: Funcionario? = this.funcionarioService?.buscarPorEmail(email)
        Assertions.assertNotNull(funcionario)

    }

    @Test
    fun testBuscarFuncionarioPorCpf() {
        val funcionario: Funcionario? = this.funcionarioService?.buscarPorCpf(cpf)
        Assertions.assertNotNull(funcionario)

    }



    private fun funcionario(): Funcionario  = Funcionario( id,
            "Nome",
            email,
            SenhaUtils().gerarBcrypt("123456"),
            cpf,
            PerfilEnum.ROLE_USUARIO,
            id)


}

