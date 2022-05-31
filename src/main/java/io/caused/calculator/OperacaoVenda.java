package io.caused.calculator;

import java.math.BigDecimal;

import io.caused.dto.ArmazemValoresDTO;
import io.caused.dto.OperacaoDTO;
import io.caused.dto.TaxDTO;

public class OperacaoVenda implements OperacaoCalculo{

	private static final Integer LIMITE_LUCRO = 20000;
	
	@Override
	public void calcular(OperacaoDTO operacao,ArmazemValoresDTO valores) {
		valores.setQuantidadeAcoesAtuais(valores.getQuantidadeAcoesAtuais() - operacao.getQuantidade());

		if( operacao.getCustoUnitario().compareTo(valores.getMediaPonderadaAtual()) >= 0) {
			Double lucro = operacao.getCustoUnitario().subtract(valores.getMediaPonderadaAtual())
					.multiply(BigDecimal.valueOf(operacao.getQuantidade())).doubleValue();
			
			Double valorOperacao = operacao.getCustoUnitario()
					.multiply(BigDecimal.valueOf(operacao.getQuantidade())).doubleValue();
			
			if(lucro > valores.getPrejuizo()) {
				lucro -=valores.getPrejuizo();
				valores.setPrejuizo(0D);
			}else {
				valores.setPrejuizo(valores.getPrejuizo() - lucro);
				lucro = 0D;
			}
			if(valorOperacao > LIMITE_LUCRO ) {
				valores.getTaxas().add(new TaxDTO(BigDecimal.valueOf(0.2*lucro)));
			}else {
				valores.getTaxas().add(new TaxDTO(BigDecimal.ZERO));
			}
		}else {
			BigDecimal prejuizoCustoUnitario = valores.getMediaPonderadaAtual().subtract(operacao.getCustoUnitario());
			valores.setPrejuizo(prejuizoCustoUnitario.multiply(BigDecimal.valueOf(operacao.getQuantidade())).doubleValue());
			valores.getTaxas().add(new TaxDTO(BigDecimal.ZERO));
		}
		
	}

}
