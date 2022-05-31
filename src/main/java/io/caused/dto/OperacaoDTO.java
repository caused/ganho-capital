package io.caused.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OperacaoDTO {

	@JsonProperty("operation")
	private String tipo;
	
	@JsonProperty("unit-cost")
	private BigDecimal custoUnitario;
	
	@JsonProperty("quantity")
	private Integer quantidade;
	
	public OperacaoDTO() {
		
	}

	public OperacaoDTO(String tipo, BigDecimal custoUnitario, Integer quantidade) {
		this.tipo = tipo;
		this.custoUnitario = custoUnitario;
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getCustoUnitario() {
		return custoUnitario;
	}

	public void setCustoUnitario(BigDecimal custoUnitario) {
		this.custoUnitario = custoUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	

}
