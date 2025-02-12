import data.ContaRepository
import domain.model.ContaBanco
import domain.usecase.consulta.ConsultarChequeEspecialUseCase
import domain.usecase.consulta.ConsultarSaldoUseCase
import domain.usecase.credito.DepositarUseCase
import domain.usecase.debito.PagarBoletoUseCase
import domain.usecase.debito.QuitarJurosChequeEspecialUseCase
import domain.usecase.debito.SacarUseCase
import presentation.console.*
import service.ContaService

fun main() {
    val contaRepository = ContaRepository()
    val conta1 = ContaBanco(1, "John Doe",499.0)
    contaRepository.save(conta1)
    val conta2 = ContaBanco(2, "Jane Doe",500.0)
    contaRepository.save(conta2)

    val consultarSaldoUseCase = ConsultarSaldoUseCase(contaRepository)
    val depositarUseCase = DepositarUseCase(contaRepository)
    val sacarUseCase = SacarUseCase(contaRepository)
    val pagarBoletoUseCase = PagarBoletoUseCase(contaRepository)
    val consultarChequeEspecialUseCase = ConsultarChequeEspecialUseCase(contaRepository)
    var quitarJurosChequeEspecialUseCase = QuitarJurosChequeEspecialUseCase(contaRepository)

    val contaService = ContaService(
        consultarSaldoUseCase,
        depositarUseCase,
        sacarUseCase,
        pagarBoletoUseCase,
        consultarChequeEspecialUseCase,
        quitarJurosChequeEspecialUseCase
    )

    val adaptadorConsultarSaldo = AdaptadorConsultarSaldo(contaService)
    val adaptadorDepositar = AdaptadorDepositar(contaService)
    val adaptadorSacar = AdaptadorSacar(contaService)
    val adaptadorPagarBoleto = AdaptadorPagarBoleto(contaService)
    val adaptadorConsultarChequeEspecial = AdaptadorConsultarChequeEspecial(contaService)

    val menu = Menu(
        adaptadorConsultarSaldo,
        adaptadorDepositar,
        adaptadorSacar,
        adaptadorPagarBoleto,
        adaptadorConsultarChequeEspecial,
    )

    menu.exibirOpcoes(1)
}


