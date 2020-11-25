package com.mayab.calidad.dbunit;

public class App {

	public static void main(String[] args) {
		Alumno a= new Alumno(1, "Veronica", 21, 93.4f, "mvrm10@gmail.com");
		
		DAOoracle oracle = new DAOoracle();
		
		oracle.addAlumno(a);


	}

}
