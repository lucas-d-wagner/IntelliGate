package br.com.unisenaisc.intelligate.common.util;

import java.math.BigDecimal;

public class SystemProperties {

	public static final String JWT_PRIVATE_KEY = "JWTPrivateKey";
	public static final String JWT_TOKEN_EXPIRATION_TIME_MINUTES = "JWTTokenExpirationTimeMinutes";
	public static final String LOTACAO_MAXIMA_CARROS = "LotacaoMaximaCarros";
	public static final String LOTACAO_MAXIMA_MOTOS = "LotacaoMaximaMotos";
	
	public static Long getJwtTokenExpirationTimeMinutes() {
		return Long.getLong(JWT_TOKEN_EXPIRATION_TIME_MINUTES, 60);
	}
	
	public static String getJWTPrivateKey() {
		String jwtPrivateKey = System.getProperty(JWT_PRIVATE_KEY, "batman-batman-batman");
		validateRequiredPropertyValue(jwtPrivateKey, JWT_PRIVATE_KEY);
		return jwtPrivateKey;
	}
	
	public static BigDecimal getLotacaoMaximaCarros() {
		String lotacaoMaxima = System.getProperty(LOTACAO_MAXIMA_CARROS, "56");
		return new BigDecimal(lotacaoMaxima);
	}
	
	public static BigDecimal getLotacaoMaximaMotos() {
		String lotacaoMaxima = System.getProperty(LOTACAO_MAXIMA_MOTOS, "124");
		return new BigDecimal(lotacaoMaxima);
	}
	
	private static void validateRequiredPropertyValue(String value, String propertyName) {
		if(value == null || value.isBlank()) {
			throw new RuntimeException("System Property " +  propertyName + " not found");
		}
	}

}
