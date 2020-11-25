package com.mayab.calidad.doubles;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mayab.calidad.doubles.Calculadora;

public class TestCalculadora2 {
	static Calculadora miCalculadora;
	
	@BeforeClass
	public static void setup() {
		System.out.println("Before test --->");
	miCalculadora  = new Calculadora();
	}
	
	@Test
	public void SumaPositivostest() {
		float sumando1 = 4;
		float sumando2= 4;
		float expectedResult=8;
		float resultado = -1;
	
		//end setup
		
		System.out.println("Ultimo resultado = " + miCalculadora.getUltimaResultado());
		resultado = miCalculadora.suma(sumando1, sumando2);
		//end exercise
		assertEquals(expectedResult,resultado,0); //verify
	}
	
	@Test
	public void RestaPositivosTest()
	{
		float operador1 = 30;
		float operador2= 50;
		float expectedResult=-20;
		float resultado = -1;
		System.out.println("Ultimo resultado = " + miCalculadora.getUltimaResultado());
		resultado = miCalculadora.resta(operador1, operador2);
		
		assertThat(resultado,is(expectedResult)); //verify
		
	}
	
	@Test
	public void Divisionentre0Test()
	{
		float operador1 = 9;
		float operador2= 0;
		float expectedResult=Float.POSITIVE_INFINITY;
		float resultado = -1;
		System.out.println("Ultimo resultado = " + miCalculadora.getUltimaResultado());
		resultado = miCalculadora.division(operador1, operador2);
		
		assertThat(resultado,is(expectedResult)); //verify
		
	}
	
	@Test
	public void Division0entre0Test()
	{
		float operador1 = 0;
		float operador2= 0;
		float expectedResult=Float.NaN;
		float resultado = -1;
		System.out.println("Ultimo resultado = " + miCalculadora.getUltimaResultado());
		resultado = miCalculadora.division(operador1, operador2);
		
		assertThat(resultado,is(expectedResult)); //verify
		
	}
	
	@After
	public void despues()
	{
		System.out.println(">>> Despues de la prueba");
	}
	@AfterClass
	public static void fin()
	{
		System.out.println(">>>Ya termine");
	}

}
