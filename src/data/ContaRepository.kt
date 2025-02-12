package data

import domain.model.ContaBanco

class ContaRepository {
    private val contas = mutableListOf<ContaBanco>()
    private var proximoId = 3

    fun save(conta: ContaBanco) {
        val contaExistente = contas.find {it.id == conta.id }
        if (contaExistente != null) {
            contas.remove(contaExistente)
            contas.add(conta)
            return
        }
        var contaId = proximoId++
        if (conta.id > 0) {
            contaId = conta.id
        }
        contas.add(ContaBanco(contaId, conta.nome , conta.saldo))
    }

    fun findById(id: Int) : ContaBanco? {
        return contas.find { it. id == id }
    }

}