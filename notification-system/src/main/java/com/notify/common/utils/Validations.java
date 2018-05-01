package com.notify.common.utils;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

public class Validations {

	/**
	 * 
	 * If argument is null, throws {@link IllegalArgumentException}
	 * 
	 * @param value
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static String notBlank(String value, String argName) throws IllegalArgumentException {
		return Optional.ofNullable(value).filter(StringUtils::isNotBlank).orElseThrow(() -> new IllegalArgumentException(argName + " must not be null or blank"));
	}
	
	/**
	 * If argument is null, throws {@link IllegalArgumentException}
	 * 
	 * @param value
	 * @param argName
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static <T> T notNull(T value, String argName) throws IllegalArgumentException {
		return Optional.ofNullable(value).orElseThrow(() -> new IllegalArgumentException(argName + " must not be null"));
	}
}
