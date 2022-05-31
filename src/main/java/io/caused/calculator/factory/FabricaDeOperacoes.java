package io.caused.calculator.factory;

import io.caused.calculator.OperacaoCalculo;
import io.caused.calculator.OperacaoCompra;
import io.caused.calculator.OperacaoVenda;
import io.caused.dto.OperationType;

public class FabricaDeOperacoes {

	public OperacaoCalculo obterOperacao(String tipo) {
		if(OperationType.BUY.getNome().equals(tipo)) {
			return new OperacaoCompra();
		}else {
			return new OperacaoVenda();
		}
	}
}
