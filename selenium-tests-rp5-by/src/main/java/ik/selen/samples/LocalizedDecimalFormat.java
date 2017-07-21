package ik.selen.samples;

import java.text.DecimalFormat;
import java.util.Locale;
import java.text.DecimalFormatSymbols;

/**
 * Helps to format currency values from test data set to get them being able
 * being comparable in assertions with app data. App data has localized
 * representation in app.
 * 
 * <P>
 * You can switch over serverLocale value when you're needed.
 * 
 * @author kanavalau
 *
 */
public class LocalizedDecimalFormat {

	/**
	 * Server locale that influence on way of displaying numbers and currency values
	 * on pages in application.
	 */
	private static final Locale serverLocale = Locale.GERMANY;	

	private static DecimalFormat format;

	/**
	 * Formats test currency values During formating operation server localization
	 * settings applied.
	 * 
	 * @param doubleValue
	 *            - String object that looks like Double object. For example 20.02
	 *            or 1100.
	 * @return String object that looks like currency value without currency sigh.
	 *         For example 20.02 -> 20,02 or 1100 -> 1.100,00 when Locale.GERMANY.
	 * 
	 */
	public static String format(String doubleValue) {

		Double value = Double.parseDouble(doubleValue);

		if (format == null) {
			format = (DecimalFormat) DecimalFormat.getCurrencyInstance(serverLocale);
			DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
			symbols.setCurrencySymbol("");
			format.setDecimalFormatSymbols(symbols);
		}

		return format.format(value).trim();
	}
	
	public static Locale getServerLocale() {
		return serverLocale;
	}
	
}
