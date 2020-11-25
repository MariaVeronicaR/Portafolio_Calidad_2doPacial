package com.mayab.calidad.doubles;

import java.util.HashMap;

public class fakeDAO implements DAO{
	HashMap<Integer,Alumno> AlumnosBDD= new HashMap<Integer,Alumno>();

	@Override
	public void addAlumno(Alumno a) {
		AlumnosBDD.put(a.getId(), a);		
	}

	@Override
	public void deleteAlumno(Alumno a) {
		AlumnosBDD.remove(a.getId());		
	}

	@Override
	public void updatePromedio(Alumno a, float NuevoPromedio) {
		AlumnosBDD.get(a.getId()).setPromedio(NuevoPromedio);
	}

	@Override
	public int getNumAlumnos() {
		// TODO Auto-generated method stub
		return AlumnosBDD.size();
	}

	@Override
	public Alumno getAlumno(int id) {
		// TODO Auto-generated method stub
		return AlumnosBDD.get(id);
	}

}


