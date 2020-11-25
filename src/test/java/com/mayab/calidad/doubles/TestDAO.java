package com.mayab.calidad.doubles;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mayab.calidad.doubles.Alumno;
import com.mayab.calidad.doubles.fakeDAO;

import static org.hamcrest.Matchers.*;


public class TestDAO {
	
	private Alumno alumno;
	private Alumno alumno2;

	private fakeDAO DAO;
	
	
	@Before
	public void beforetest() {
		DAO= new fakeDAO();
		alumno= new Alumno(1,"Milangela",21,93.4f,"mvrm10@gamil.com");
		alumno2= new Alumno(2,"Milangela",21,93.4f,"mvrm10@gamil.com");
		DAO.addAlumno(alumno);
	}
	@Test
	public void testadd() {
		int numeroAntes=DAO.getNumAlumnos();
		DAO.addAlumno(alumno2);
		int numeroDespues=DAO.getNumAlumnos();
		
		assertThat(numeroDespues,is(numeroAntes+1));

	}
	@Test
	public void testremove() {
		int numeroAntes=DAO.getNumAlumnos();
		
		DAO.deleteAlumno(alumno);
		int numeroDespues=DAO.getNumAlumnos();
		
		assertThat(numeroDespues,is(numeroAntes-1));

	}
	@Test
	public void testUpdatePromedio() {
		
		DAO.updatePromedio(alumno,95.0f);
		
		assertThat(alumno.getPromedio(),is(95.0f));

	}
	@Test
	public void tesGetNumAlumnos() {
		DAO.addAlumno(alumno2);
	
		assertThat(DAO.getNumAlumnos(),is(2));

	}
	@Test
	public void tesGetAlumnos() {

		assertThat(DAO.getAlumno(1),is(alumno));

	}
}
