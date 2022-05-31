package io.caused;

import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.caused.calculator.OperacaoCalculo;
import io.caused.calculator.factory.FabricaDeOperacoes;
import io.caused.dto.ArmazemValoresDTO;
import io.caused.dto.OperacaoDTO;
import io.caused.input.ManipuladorEntrada;

public class GanhoCapitalApplication {
	static final ObjectMapper MAPPER = new ObjectMapper();

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {

		var coletor = new Scanner(System.in);
		String entradaUsuario = coletor.nextLine();
		coletor.close();

		var manipulador = new ManipuladorEntrada();
		var linhas = manipulador.extrairLinhasDaEntrada(entradaUsuario);

		for(var linha : linhas) {

			List<OperacaoDTO> operacoes = MAPPER.readValue(linha, new TypeReference<List<OperacaoDTO>>() {});

			var valores = new ArmazemValoresDTO();
			for(var operacao : operacoes) {

				OperacaoCalculo operacaoCalculo = new FabricaDeOperacoes().obterOperacao(operacao.getTipo());

				operacaoCalculo.calcular(operacao, valores);

			}
			System.out.println(MAPPER.writeValueAsString(valores.getTaxas()));
		}
	}
}
