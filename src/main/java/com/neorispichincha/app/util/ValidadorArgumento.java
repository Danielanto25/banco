
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
		if (valor.length() < longitud) {
			throw new ExcepcionArgumento(mensaje);
		}
	}

	public static <T> void validarNoVacio(List<T> lista, String mensaje) {
		if (lista.isEmpty()) {
			throw new ExcepcionArgumento(mensaje);
		}
	}

	public static void validarPositivo(Double valor, String mensaje) {
		if (valor <= 0) {
			throw new ExcepcionArgumento(mensaje);
		}
	}

	public static void validarIgual(Double valor, Double valorEsperado, String mensaje) {
		if (!valor.equals(valorEsperado)) {
			throw new ExcepcionArgumento(mensaje);
		}
	}

	public static void validarLongitudMinima(Object valor, int longitudMinima, String mensaje) {
		if (valor.toString().length() < longitudMinima) {
			throw new ExcepcionArgumento(mensaje);
		}
	}

	public static void validarLongitudMaxima(Object valor, int longitudMaxima, String mensaje) {
		if (valor.toString().length() > longitudMaxima) {
			throw new ExcepcionArgumento(mensaje);
		}
	}

	public static void validarMenor(LocalDateTime fechaInicial, LocalDateTime fechaFinal, String mensaje) {
		if (fechaInicial.toLocalDate().isAfter(fechaFinal.toLocalDate())) {
			throw new ExcepcionArgumento(mensaje);
		}
	}

	public static void validarMenor(Long numeroInicial, Long numeroFinal, String mensaje) {
		if (numeroInicial > numeroFinal) {
			throw new ExcepcionArgumento(mensaje);
		}
	}

	public static void validarMes(int mes, String mensaje) {
		if (!(mes > 0 && mes < 13)) {
			throw new ExcepcionArgumento(mensaje);
		}
	}

	public static <E extends Enum<E>> E validarValido(String valor, Class<E> enumAObtener, String mensaje) {
		E enumObtenido = null;
		if (null != valor) {
			Optional<E> resultadoOpcional = Arrays.stream(enumAObtener.getEnumConstants())
					.filter(resultado -> resultado.toString().equals(valor)).findFirst();

			if (resultadoOpcional.isPresent()) {
				enumObtenido = resultadoOpcional.get();
			} else {
				throw new ExcepcionArgumento(mensaje);
			}
		}
		return enumObtenido;
	}

	public static void validarNumerico(String valor, String mensaje) {
		try {
			Long.parseLong(valor);
		} catch (NumberFormatException numberFormatException) {
			throw new ExcepcionArgumento(mensaje);
		}
	}
}