package com.luiz.kotlin.service

import com.luiz.kotlin.documents.Empresa

interface EmpresaService {
    fun buscarPorCnpj(cnpj: String): Empresa?
    fun persistir(empresa: Empresa): Empresa?
}
