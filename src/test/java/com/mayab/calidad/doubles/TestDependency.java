package com.mayab.calidad.doubles;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;
import static org.hamcrest.Matchers.*;


public class TestDependency {
	
	private Dependency dependency;
	
	@Before
	public void setupMocks() {
		dependency = mock(Dependency.class);
	}
	

	@Test
	public void test() {
		when(dependency.getClassName()).thenReturn("Minombre");
		assertThat(dependency.getClassName(),is("Minombre"));
		//assertNull(dependency.getClassName());
		assertNull(dependency.getClassNameUpperCase());
		assertNull(dependency.getSubdependencyClassName());

	}
	
	@Test
	public void otrotest() {
		when(dependency.getClassName()).thenReturn("otronombre");
		assertThat(dependency.getClassName(),is("otronombre"));


	}
	@Test(expected=IllegalArgumentException.class)
	public void testexception() {
		when(dependency.getClassName()).thenThrow(IllegalArgumentException.class);
		dependency.getClassName();
	}
	@Test
	public void testaddtwo() {
		when(dependency.addTwo(anyInt())).thenReturn(5);
		assertThat(dependency.addTwo(1),is(5));
		assertThat(dependency.addTwo(27),is(5));
		//assertThat(dependency.addTwo(27),is(0));


	}
	@Test
	public void testAnswer() {
		when(dependency.addTwo(anyInt())).thenAnswer(new Answer<Integer>() {
			public Integer answer(InvocationOnMock invocation) throws Throwable{
				int arg=(Integer) invocation.getArguments()[0];
				return arg +20;
			}
		});
		assertThat(dependency.addTwo(10),is(30));

	}	
	@Test
	public void testMultiply() {
		when(dependency.multiply(anyInt(),anyInt())).thenAnswer(new Answer<Integer>() {
			public Integer answer(InvocationOnMock invocation) throws Throwable{
				int arg=(Integer) invocation.getArguments()[0];
				int arg2=(Integer) invocation.getArguments()[1];

				return arg * arg2;
			}
		});
		assertThat(dependency.multiply(10,10),is(100));

	}	

}
