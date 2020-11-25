package com.mayab.calidad.DAO;

public class Alumno {
	private int id;
	private String nombre;
	private int edad;
	private float promedio;
	private String email;
	
	public Alumno(int id, String nombre, int edad, float promedio, String email) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.promedio = promedio;
		this.email = email;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public float getPromedio() {
		return promedio;
	}
	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
