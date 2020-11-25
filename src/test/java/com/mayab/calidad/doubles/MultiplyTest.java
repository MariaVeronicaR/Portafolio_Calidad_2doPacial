package com.mayab.calidad.doubles;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class MultiplyTest {

	@Parameters
	public static Iterable data() {
		return Arrays.asList(new Object[][] {
			{4,2,2},{6,3,2},{5,5,1},{10,5,2}
		});
	}

	private int multiplierOne;
	private int expected;
	private int multiplierTwo;
	
	public MultiplyTest(int expected, int multiplierOne, int multiplierTwo) {
		
		this.multiplierOne=multiplierOne;
		this.expected=expected;
		this.multiplierTwo=multiplierTwo;
	}
	
	@Test
	public void givenTwoNumbersShoulBeMultiplyResult() {
		Assert.assertEquals(expected, multiplierOne*multiplierTwo);
	}

}
