package exemplo2;

import java.time.LocalDate;

public class ValidatorUtil {
	
	public static void validarCPF(String value) {
		if (value == null) {
			return;
		}
		
		int i, j, n1;
		value = value.toString().replace(".", "").replace("-", "");
		if (value.equals("") || value.length() != 11
				|| value.equals("11111111111") || value.equals("22222222222")
				|| value.equals("33333333333") || value.equals("44444444444")
				|| value.equals("55555555555") || value.equals("66666666666")
				|| value.equals("77777777777") || value.equals("88888888888")
				|| value.equals("99999999999") || value.equals("00000000000")) {
			//TODO Implementar o lancamento da excecao
		} else {
			for (j = 0; j <= 1; j++) {
				n1 = 0;
				for (i = 0; i <= 8 + j; i++)
					n1 = n1 + Integer.parseInt(value.substring(i, i + 1))
							* (11 + j - i - 1);
				n1 = 11 - (n1 - (n1 / 11) * 11);
				if (n1 == 10 || n1 == 11)
					n1 = 0;
				if (n1 != Integer.parseInt(value.substring(9 + j, 9 + j + 1))) {
					//TODO Implementar o lancamento da excecao
				}
			}
		}
	}
	
	public static void validarNascimento(LocalDate value) {
		if (value == null) {
			return;
		}

		LocalDate plus18Years = value.plusYears(18);
		if (plus18Years.isAfter(LocalDate.now())) {
			//TODO Implementar o lancamento da excecao
		}
	}

	public static void validarNome(String value) {
		// TODO Implementar o método
	}

}
