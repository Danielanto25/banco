
package com.neorispichincha.app.util;

import com.neorispichincha.app.excepcion.ExcepcionArgumento;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ValidadorArgumento {

	private ValidadorArgumento() {
	}

	public static void validarObligatorio(Object valor, String mensaje) {

		if (valor == null || valor.toString().trim().isEmpty()) {
			throw new ExcepcionArgumento(mensaje);
		}
	}

	public static void validarLongitud(String valor, int longitud, String mensaje) {
		if (valor.length() > longitud) {
			throw new ExcepcionArgumento(mensaje);
		}
	}

	public static <T> void validarNoVacio(List<T> lista, String mensaje) {
		if (lista.isEmpty()) {
			throw new ExcepcionArgumento(mensaje);
		}
	}
}