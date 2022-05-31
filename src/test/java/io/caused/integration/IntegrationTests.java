package io.caused.integration;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.caused.GanhoCapitalApplication;

public class IntegrationTests {


	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	@DisplayName("Deve calcular taxas com uma operacao de compra e duas de venda")
	public void deveCalcularTaxasComUmaOperacaoDeCompraEDuasDeVenda() throws JsonMappingException, JsonProcessingException {
		String input = "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 100}, {\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 50}, {\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 50}]";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		GanhoCapitalApplication.main(null);

		Assertions.assertEquals("[{\"tax\":0.00},{\"tax\":0.00},{\"tax\":0.00}]\n", outContent.toString());
	}

	@Test
	@DisplayName("Deve calcular taxas com uma operação de compra e duas de venda com pagamento de taxas")
	public void deveCalcularTaxasComUmaOperacaoDeCompraEDuasDeVendaComPagamentoDeTaxas() throws JsonMappingException, JsonProcessingException {
		String input = "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000}, {\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 5000}, {\"operation\":\"sell\", \"unit-cost\":5.00, \"quantity\": 5000}]";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		GanhoCapitalApplication.main(null);

		Assertions.assertEquals("[{\"tax\":0.00},{\"tax\":10000.00},{\"tax\":0.00}]\n", outContent.toString());
	}

	@Test
	@DisplayName("Deve calcular duas linhas de operacao separada")
	public void deveCalcularDuasLinhasDeOperacaoSeparadas() throws JsonMappingException, JsonProcessingException {
		String input = "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 100}, {\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 50}, {\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 50}] [{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000}, {\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 5000}, {\"operation\":\"sell\", \"unit-cost\":5.00, \"quantity\": 5000}]";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		GanhoCapitalApplication.main(null);

		Assertions.assertEquals("[{\"tax\":0.00},{\"tax\":0.00},{\"tax\":0.00}]\n"
				+ "[{\"tax\":0.00},{\"tax\":10000.00},{\"tax\":0.00}]\n", outContent.toString());
	}

	@Test
	@DisplayName("Deve calcular taxas com uma operacao de compra e uma de venda com uma taxa de mil")
	public void deveCalcularTaxasComUmaOperacaoDeCompraEDuasDeVendaComTaxaDeMil() throws JsonMappingException, JsonProcessingException {
		String input = "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000}, {\"operation\":\"sell\", \"unit-cost\":5.00, \"quantity\": 5000}, {\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 3000}]";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		GanhoCapitalApplication.main(null);

		Assertions.assertEquals("[{\"tax\":0.00},{\"tax\":0.00},{\"tax\":1000.00}]\n", outContent.toString());
	}

	@Test
	@DisplayName("Deve calcular taxas com duas operações de compra e uma de venda")
	public void deveCalcularTaxasComDuasOperacoesDeCompraEUmaDeVenda() throws JsonMappingException, JsonProcessingException {
		String input = "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000}, {\"operation\":\"buy\", \"unit-cost\":25.00, \"quantity\": 5000}, {\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 10000}]";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		GanhoCapitalApplication.main(null);

		Assertions.assertEquals("[{\"tax\":0.00},{\"tax\":0.00},{\"tax\":0.00}]\n", outContent.toString());
	}

	@Test
	@DisplayName("Deve calcular taxas com duas operações de compra e duas de venda")
	public void deveCalcularTaxasComDuasOperacoesDeCompraEDuasDeVenda() throws JsonMappingException, JsonProcessingException {
		String input = "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000}, {\"operation\":\"buy\", \"unit-cost\":25.00, \"quantity\": 5000}, {\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 10000}, {\"operation\":\"sell\", \"unit-cost\":25.00, \"quantity\": 5000}]";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		GanhoCapitalApplication.main(null);

		Assertions.assertEquals("[{\"tax\":0.00},{\"tax\":0.00},{\"tax\":0.00},{\"tax\":10000.00}]\n", outContent.toString());
	}

	@Test
	@DisplayName("Deve calcular taxas com uma operação de compra e quatro de venda")
	public void deveCalcularTaxasComUmaOperacaoDeCompraEQuatroDeVenda() throws JsonMappingException, JsonProcessingException {
		String input = "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000}, {\"operation\":\"sell\", \"unit-cost\":2.00, \"quantity\": 5000}, {\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 2000}, {\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 2000}, {\"operation\":\"sell\", \"unit-cost\":25.00, \"quantity\": 1000}]";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		GanhoCapitalApplication.main(null);

		Assertions.assertEquals("[{\"tax\":0.00},{\"tax\":0.00},{\"tax\":0.00},{\"tax\":0.00},{\"tax\":3000.00}]\n", outContent.toString());
	}
	
	@Test
	@DisplayName("Deve calcular taxas com operações intercaladas de compra e venda")
	public void deveCalcularTaxasComOperacoesIntercaladasDeCompraEVenda() throws JsonMappingException, JsonProcessingException {
		String input = "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000}, {\"operation\":\"sell\", \"unit-cost\":2.00, \"quantity\": 5000}, {\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 2000}, {\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 2000}, {\"operation\":\"sell\", \"unit-cost\":25.00, \"quantity\": 1000}, {\"operation\":\"buy\", \"unit-cost\":20.00, \"quantity\": 10000}, {\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 5000}, {\"operation\":\"sell\", \"unit-cost\":30.00, \"quantity\": 4350}, {\"operation\":\"sell\", \"unit-cost\":30.00, \"quantity\": 650}]";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		GanhoCapitalApplication.main(null);

		Assertions.assertEquals("[{\"tax\":0.00},{\"tax\":0.00},{\"tax\":0.00},{\"tax\":0.00},{\"tax\":3000.00},{\"tax\":0.00},{\"tax\":0.00},{\"tax\":3700.00},{\"tax\":0.00}]\n", outContent.toString());
	}
	
	@Test
	@DisplayName("Deve calcular taxas com quatro operações intercaladas de compra e venda")
	public void deveCalcularTaxasComQuatroOperacoesIntercaladasDeCompraEVenda() throws JsonMappingException, JsonProcessingException {
		String input = "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000}, {\"operation\":\"sell\", \"unit-cost\":50.00, \"quantity\": 10000}, {\"operation\":\"buy\", \"unit-cost\":20.00, \"quantity\": 10000}, {\"operation\":\"sell\", \"unit-cost\":50.00, \"quantity\": 10000}]";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		GanhoCapitalApplication.main(null);

		Assertions.assertEquals("[{\"tax\":0.00},{\"tax\":80000.00},{\"tax\":0.00},{\"tax\":60000.00}]\n", outContent.toString());
	}
}
