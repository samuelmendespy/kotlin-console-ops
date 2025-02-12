package domain.model

import java.time.LocalDate

class BoletoBancario (
    val codigo: Int,
    val valor: Double = 0.00,
    val vencimento: LocalDate,
) {
    var status: Status = Status.PENDENTE

    enum class Status {
                PAGO, PENDENTE
            }
}