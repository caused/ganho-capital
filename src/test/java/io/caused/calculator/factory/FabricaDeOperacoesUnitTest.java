package io.caused.calculator.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.caused.calculator.OperacaoCalculo;
import io.caused.calculator.OperacaoCompra;
import io.caused.calculator.OperacaoVenda;

public class FabricaDeOperacoesUnitTest {

	@Test
	@DisplayName("Deve retornar instancia de OperacaoVenda")
	public void deveRetornarInstanciaDeOperacaoVenda() {
		OperacaoCalculo operacao = new FabricaDeOperacoes().obterOperacao("sell");
		
		Assertions.assertTrue(operacao instanceof OperacaoVenda);
	}
	
	@Test
	@DisplayName("Deve retornar instancia de OperacaoCompra")
	public void deveRetornarInstanciaDeOperacaoCompra() {
		OperacaoCalculo operacao = new FabricaDeOperacoes().obterOperacao("buy");
		
		Assertions.assertTrue(operacao instanceof OperacaoCompra);
	}
}
