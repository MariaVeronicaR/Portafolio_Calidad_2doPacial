package com.mayab.calidad.doubles;

public interface DAO {

	public void addAlumno(Alumno a);
	
	public void deleteAlumno(Alumno a);

	public void updatePromedio(Alumno a, float NuevoPromedio);

	public int getNumAlumnos();
	
	public Alumno getAlumno(int id);

	
}
