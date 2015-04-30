package com.cq.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonDateProcess implements JsonValueProcessor {
	private String datePattern = "yyyy-MM-dd";

	public JsonDateProcess() {
		super();
	}

	public JsonDateProcess(String format) {
		super();
		this.datePattern = format;
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
			if (value instanceof Date) {
				SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
				return sdf.format((Date) value);
			}
			return value == null ? "" : value.toString();
		} catch (Exception e) {
			return "";
		}
	}

	public String getDatePattern() {
		return datePattern;
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
}
