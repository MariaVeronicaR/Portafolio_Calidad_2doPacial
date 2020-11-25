package com.mayab.calidad.dbunit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DAOoracle implements DAO{
	HashMap<Integer,Alumno> AlumnosBDD= new HashMap<Integer,Alumno>();

	@Override
	public void addAlumno(Alumno a) {
		Connection con=getConnection();
		PreparedStatement ps;
		AlumnosBDD.put(a.getId(), a);
		
		try {
			
			ps= con.prepareStatement("insert into alumno(id,nombre,edad,promedio,email) values(?,?,?,?,?)");
			
			ps.setInt(1,a.getId());
			ps.setString(2,a.getNombre());
			ps.setInt(3,a.getEdad());
			ps.setFloat(4,a.getPromedio());
			ps.setString(5,a.getEmail());
			
			int status=ps.executeUpdate();
			
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	@Override
	public void deleteAlumno(Alumno a) {
		AlumnosBDD.remove(a.getId());
		
		Connection con=getConnection();
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement("delete from alumno WHERE  id = ?");
			
			ps.setInt(1, a.getId());
			
			int status=ps.executeUpdate();
			
			
			
			con.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
		
	}

	@Override
	public void updatePromedio(Alumno a, float NuevoPromedio) {
		AlumnosBDD.get(a.getId()).setPromedio(NuevoPromedio);
		
		Connection con=getConnection();
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement("update alumno set promedio = ? WHERE  id = ?");
			
			ps.setFloat(1, a.getPromedio());
			ps.setInt(1, a.getId());
			
			int status=ps.executeUpdate();
			
			
			
			con.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
	}

	@Override
	public int getNumAlumnos() {
		// TODO Auto-generated method stub		
		Connection con=getConnection();
		PreparedStatement ps;
		int numAlumnos=0;
		
		try {
			ps = con.prepareStatement("select* from alumno");
			
			numAlumnos=ps.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
		
		return numAlumnos;
	}

	@Override
	public Alumno getAlumno(int id) {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		PreparedStatement ps;
		ResultSet r;
		Alumno alumno=null;
		
		try {
			ps = con.prepareStatement("select * from alumno WHERE id = ?");
			ps.setInt(1, id);
            r = ps.executeQuery();
			r.next();
			
			int a_id = r.getInt(1);
			String nombre = r.getString(2);
			int edad = r.getInt(3);
			Float promedio = r.getFloat(4);
			String email = r.getString(5);
			
			alumno = new Alumno(a_id, nombre, edad, promedio, email);
			
			r.close();
			ps.close();
			con.close();	
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
		
		return alumno;
	}

	@Override
	public Connection getConnection() {
		Connection con=null;  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbunit","dbunit");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
	}

}


