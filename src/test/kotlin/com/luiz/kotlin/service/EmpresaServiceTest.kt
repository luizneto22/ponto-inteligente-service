package com.luiz.kotlin.service

import com.luiz.kotlin.documents.Empresa
import com.luiz.kotlin.repository.EmpresaRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureDataMongo
class EmpresaServiceTest {

    @Autowired
    val empresaService: EmpresaService? = null

    @MockBean
    private val empresaRepository: EmpresaRepository? = null


    private val cnpj = "51463645000100"

    @BeforeEach
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito.given(empresaRepository?.findByCnpj(cnpj)).willReturn(empresa())
        BDDMockito.given(empresaRepository?.save(empresa())).willReturn(empresa())
    }

    @Test
    fun `test buscando uma empresa a partir do cnpj`() {
    //fun testBuscarEmpresaPorCnpj() {
        //Mockito.`when`(empresaService?.buscarPorCnpj(cnpj)).thenReturn(empresa())
        val empresa: Empresa? = empresaService?.buscarPorCnpj(cnpj)
        Assertions.assertNotNull(empresa)
    }

    @Test
    fun testPersistirEmpresa() {
        val empresa: Empresa? = empresaService?.persistir(empresa())
        Assertions.assertNotNull(empresa)
    }

    private fun empresa(): Empresa = Empresa("Razao SOcial", cnpj, "1")

}
