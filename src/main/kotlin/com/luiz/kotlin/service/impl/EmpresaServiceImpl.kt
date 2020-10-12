package com.luiz.kotlin.service.impl

import com.luiz.kotlin.documents.Empresa
import com.luiz.kotlin.repository.EmpresaRepository
import com.luiz.kotlin.service.EmpresaService
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl (val empresaRepository: EmpresaRepository) : EmpresaService {

    override fun buscarPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)

    override fun persistir(empresa: Empresa): Empresa? = empresaRepository.save(empresa)

}
