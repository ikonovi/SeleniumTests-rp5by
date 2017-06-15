package ik.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.ThreadLocalRandom;

public class Test1 {

	public static void main(String[] args) {
		
		int loop = 0;
		while (loop <= 10) {
			loop += 1;
			int number = ThreadLocalRandom.current().nextInt(1,10);
			System.out.printf("#%s: %s \n", loop, number);			
		}
		
		//assertThat("Numbers is not equal", 2, is(1));	
		
		
	}

}
