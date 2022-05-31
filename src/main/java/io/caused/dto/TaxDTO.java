package io.caused.dto;

import java.math.BigDecimal;

public class TaxDTO {

	private BigDecimal tax;

	public TaxDTO(BigDecimal tax) {
		this.tax = tax;
	}
	
	public BigDecimal getTax() {
		return tax.setScale(2);
	}
}
