package com.cq.util;

import java.text.DecimalFormat;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonDoubleProcess implements JsonValueProcessor {
	private String doublePattern = "###0.00";

	public JsonDoubleProcess() {
		super();
	}

	public JsonDoubleProcess(String format) {
		super();
		this.doublePattern = format;
	}

	@Override
	public Object processArrayValue(Object value, JsonConfig cfg) {
		return process(value);

	}

	@Override
	public Object processObjectValue(String key, Object value, JsonConfig arg2) {
		return process(value);

	}

	private Object process(Object value) {
		try {
			if (value instanceof Double) {
				DecimalFormat decimalFormat = new DecimalFormat(doublePattern);
				return decimalFormat.format((Double) value);
			}
			return value == null ? "" : value.toString();
		} catch (Exception e) {
			return "";
		}
	}

	public String getDatePattern() {
		return doublePattern;
	}

	public void setDatePattern(String datePattern) {
		this.doublePattern = datePattern;
	}
}
