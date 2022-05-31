package io.caused.calculator;

import io.caused.dto.ArmazemValoresDTO;
import io.caused.dto.OperacaoDTO;

public interface OperacaoCalculo {

	public void calcular(OperacaoDTO operacao, ArmazemValoresDTO valores);
}
