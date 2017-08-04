package ik.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;

import com.sun.jna.platform.win32.OaIdl.CURRENCY;

@SuppressWarnings("unused")
public class Test1 {		
	
	static Number number = Long.parseLong("1");

	public static void main(String[] args) throws ParseException {
		
		/*
		 * int loop = 0; while (loop <= 10) { loop += 1; int number =
		 * ThreadLocalRandom.current().nextInt(1,10); System.out.printf("#%s: %s \n",
		 * loop, number); }
		 */
		// assertThat("Numbers is not equal", 2, is(1));

		//System.out.println("4,003.00".replaceAll(",00$|\\.00$|,|\\.", ""));
		/*
		LocalDate date = LocalDate.of(2017, 7, 1);
		System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(date);
		*/
		
		
	}

}

