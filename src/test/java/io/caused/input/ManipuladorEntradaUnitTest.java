package io.caused.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManipuladorEntradaUnitTest {

	@Test
	@DisplayName("Deve retornar uma linha a partir da entrada do usuário")
	public void deveRetornarUmaLinha() {
		
		String[] extrairLinhasDaEntrada = new ManipuladorEntrada().extrairLinhasDaEntrada("[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 100}, {\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 50}, {\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 50}]");
	
		Assertions.assertEquals(1, extrairLinhasDaEntrada.length);
	}
	
	@Test
	@DisplayName("Deve retornar uma linha a partir da entrada do usuário")
	public void deveRetornarDuasLinhas() {
		String[] extrairLinhasDaEntrada = new ManipuladorEntrada().extrairLinhasDaEntrada("[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 100}, {\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 50}, {\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 50}] [{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000}, {\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 5000}, {\"operation\":\"sell\", \"unit-cost\":5.00, \"quantity\": 5000}]");
		
		Assertions.assertEquals(2, extrairLinhasDaEntrada.length);
	}
}
