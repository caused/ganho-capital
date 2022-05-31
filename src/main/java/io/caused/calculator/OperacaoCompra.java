package io.caused.calculator;

import java.math.BigDecimal;

import io.caused.dto.ArmazemValoresDTO;
import io.caused.dto.OperacaoDTO;
import io.caused.dto.TaxDTO;

public class OperacaoCompra implements OperacaoCalculo{

	@Override
	public void calcular(OperacaoDTO operacao, ArmazemValoresDTO valores) {
		valores.setMediaPonderadaAtual(valores.getMediaPonderadaAtual().multiply(BigDecimal.valueOf(valores.getQuantidadeAcoesAtuais()))
				.add(operacao.getCustoUnitario().multiply(BigDecimal.valueOf(operacao.getQuantidade())))
				.divide(BigDecimal.valueOf(valores.getQuantidadeAcoesAtuais() + operacao.getQuantidade())));
		
		
		valores.setQuantidadeAcoesAtuais(valores.getQuantidadeAcoesAtuais() + operacao.getQuantidade());
		valores.getTaxas().add(new TaxDTO(BigDecimal.ZERO));
	}

}
