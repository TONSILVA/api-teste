package co.urban.api.teste.produto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizacaoProduto(
        @NotNull
        Long id,
        String nome,
        BigDecimal preco,
        BigDecimal quantidade) {
}
