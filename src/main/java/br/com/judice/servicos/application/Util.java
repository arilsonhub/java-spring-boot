package br.com.judice.servicos.application;

public class Util {

	public static String extractDigitsFromString(String str) {

		if (str == null)
			return str;

		return str.replaceAll("\\D+", "");
	}
}