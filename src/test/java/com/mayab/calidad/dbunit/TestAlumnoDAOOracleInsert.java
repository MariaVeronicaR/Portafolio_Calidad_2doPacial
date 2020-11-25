package com.mayab.calidad.dbunit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import com.mayab.calidad.dbunit.Alumno;
import com.mayab.calidad.dbunit.DAOoracle;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import java.io.File;
import java.io.InputStream;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;

public class TestAlumnoDAOOracleInsert extends DBTestCase{

	
	public TestAlumnoDAOOracleInsert(String name) {
		super(name);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "oracle.jdbc.driver.OracleDriver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:oracle:thin:@localhost:1521:xe");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "dbunit");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "dbunit");
	}
	@Before
	public void setUp() throws Exception{
		super.setUp();
		IDatabaseConnection con = getConnection();
		try {
			DatabaseOperation.CLEAN_INSERT.execute(con, getDataSet());
		}finally {
			con.close();
		}
	}

	
	@Test
	public void Add() {
		//Ejercicio
		Alumno a= new Alumno(1, "Veronica", 21, 93.4f, "mvrm10@gmail.com");
		DAOoracle dao=new DAOoracle();
		dao.addAlumno(a);
		//Verify
		try{
			IDataSet databaseDataSet = getConnection().createDataSet();
			ITable actualTable = databaseDataSet.getTable("alumno");
			//Leemos los datos del archivo esperado
			IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/resources/insert_result.xml"));
			ITable expectedTable = expectedDataSet.getTable("alumno");
			// Assert actual database table match expected table
			Assertion.assertEquals(expectedTable, actualTable);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void remove() {
		//Ejercicio
		Alumno a= new Alumno(1, "Veronica", 21, 93.4f, "mvrm10@gmail.com");
		DAOoracle dao=new DAOoracle();
		dao.addAlumno(a);
		//Verify
		try{
			IDataSet databaseDataSet = getConnection().createDataSet();
			ITable actualTable = databaseDataSet.getTable("alumno");
			//Leemos los datos del archivo esperado
			IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/resources/delete.xml"));
			ITable expectedTable = expectedDataSet.getTable("alumno");
			// Assert actual database table match expected table
			Assertion.assertEquals(expectedTable, actualTable);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void update() {
		//Ejercicio
		Alumno a= new Alumno(1, "Veronica", 21, 93.4f, "mvrm10@gmail.com");
		DAOoracle dao=new DAOoracle();
		
		//Verify
       IDatabaseConnection con;
		
		try {
			
			con = getConnection();
			
			int registros = con.getRowCount("alumno");
			dao.addAlumno(a);
			assertEquals(registros + 1, con.getRowCount("alumno"));
			
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new File("src/resources/alumno_init.xml"));
	}

}
