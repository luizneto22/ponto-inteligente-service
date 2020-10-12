package com.luiz.kotlin.repository

import com.luiz.kotlin.documents.Empresa
import org.springframework.data.mongodb.repository.MongoRepository


interface EmpresaRepository : MongoRepository<Empresa, String> {

    fun findByCnpj(cnpj: String): Empresa?

    fun persistir(empresa: Empresa): Empresa
}
