package io.caused.input;

public class ManipuladorEntrada {

	public String[] extrairLinhasDaEntrada(String entradaUsuario) {

		var textoFormatado = entradaUsuario.replace("]", "]%%");
		return textoFormatado.split("%%");
	}
}
