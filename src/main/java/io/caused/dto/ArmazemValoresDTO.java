package io.caused.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ArmazemValoresDTO {

	private Integer quantidadeAcoesAtuais;
	private BigDecimal mediaPonderadaAtual;
	private Double prejuizo;
	private List<TaxDTO> taxas;
	
	public ArmazemValoresDTO() {
		this.quantidadeAcoesAtuais = 0;
		this.mediaPonderadaAtual = BigDecimal.ZERO;
		this.prejuizo = 0.0;
		this.taxas = new ArrayList<TaxDTO>();
	}

	public Integer getQuantidadeAcoesAtuais() {
		return quantidadeAcoesAtuais;
	}

	public void setQuantidadeAcoesAtuais(Integer quantidadeAcoesAtuais) {
		this.quantidadeAcoesAtuais = quantidadeAcoesAtuais;
	}

	public BigDecimal getMediaPonderadaAtual() {
		return mediaPonderadaAtual;
	}

	public void setMediaPonderadaAtual(BigDecimal mediaPonderadaAtual) {
		this.mediaPonderadaAtual = mediaPonderadaAtual;
	}

	public Double getPrejuizo() {
		return prejuizo;
	}

	public void setPrejuizo(Double prejuizo) {
		this.prejuizo = prejuizo;
	}

	public List<TaxDTO> getTaxas() {
		return taxas;
	}

	public void setTaxas(List<TaxDTO> taxas) {
		this.taxas = taxas;
	}
	
	
}
