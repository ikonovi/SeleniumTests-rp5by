package ik.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import com.sun.jna.platform.win32.OaIdl.CURRENCY;

import ik.selen.samples.LocalizedDecimalFormat;

public class Test1 {

	public static void main(String[] args) throws ParseException {
		/*
		 * int loop = 0; while (loop <= 10) { loop += 1; int number =
		 * ThreadLocalRandom.current().nextInt(1,10); System.out.printf("#%s: %s \n",
		 * loop, number); }
		 */
		// assertThat("Numbers is not equal", 2, is(1));

		System.out.println("4,003.00".replaceAll(",00$|\\.00$|,|\\.", ""));
		
	}

}

