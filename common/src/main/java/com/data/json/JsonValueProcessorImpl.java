package com.data.json;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  12:29 PM
 * @description:
 */
public class JsonValueProcessorImpl implements JsonValueProcessor {

    private String format = "yyyy-MM-dd HH:mm:ss";

    /**
     * .
     *
     * @param strFormat .
     */
    public JsonValueProcessorImpl(final String strFormat) {
        this.format = strFormat;
    }

    /**
     * @param value      .
     * @param jsonConfig .
     * @return .
     */
    public final Object processArrayValue(final Object value,
                                          final JsonConfig jsonConfig) {
        String[] obj = null;
        if (value instanceof Date[]) {
            final SimpleDateFormat simForate = new SimpleDateFormat(format,
                    Locale.CHINESE);
            final Date[] dates = (Date[]) value;
            obj = new String[dates.length];
            for (int i = 0; i < dates.length; i++) {
                obj[i] = simForate.format(dates[i]);
            }
        }
        return obj;
    }

    /**
     *
     */
    public Object processObjectValue(final String key, final Object value,
                                     final JsonConfig jsonConfig) {
        if (value instanceof Date) {
            String str = new SimpleDateFormat(format).format((Date) value);
            return str;
        }
        if (value != null) {
            return value.toString();
        } else {
            return null;
        }

    }

    /**
     * .
     *
     * @return .
     */
    public final String getFormat() {
        return format;
    }

    /**
     * .
     *
     * @param strFormat .
     */
    public final void setFormat(final String strFormat) {
        this.format = strFormat;
    }
}
