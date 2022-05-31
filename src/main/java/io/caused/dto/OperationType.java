package io.caused.dto;

public enum OperationType {

	BUY("buy"), SELL("sell");
	
	private String nome;
	
	OperationType(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}
