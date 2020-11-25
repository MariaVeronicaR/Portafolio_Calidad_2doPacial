package com.mayab.calidad.dbunit;

import java.sql.Connection; 
public interface DAO {

	public void addAlumno(Alumno a);
	
	public void deleteAlumno(Alumno a);

	public void updatePromedio(Alumno a, float NuevoPromedio);

	public int getNumAlumnos();
	
	public Alumno getAlumno(int id);
	
	public Connection getConnection();

	
}
