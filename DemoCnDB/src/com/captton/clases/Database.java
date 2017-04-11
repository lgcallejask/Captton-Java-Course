package com.captton.clases;

/*
 * 1 - Importar el paquete necesario - import java.sql.*;
 * 2 - Registrar el driver JDBC – Class.forName("com.mysql.jdbc.Driver");
 * 3 - Abrir la conexion - DriverManager.getConnection(DB_URL,USER,PASS);
 * 4 - Ejecutar una query – stmt.executeQuery(sql);
 * 5 - Extraer resultados – ResultSet rs; rs.next();
 * 6 - Limpiar conexiones – rs.close(); stmt.close(); conn.close();
 */
import java.sql.*;
import java.util.ArrayList;

public class Database 
{
	private static final String URL = "jdbc:mysql://localhost:3306/Ejemplo";
	private static final String USER = "root"; 
	private static final String PASS = "1234"; 

	private static Connection conectar()
	{
		Connection cn = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(URL, USER, PASS);
		}
		catch (ClassNotFoundException e) 
		{		
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return cn;		
	}

	public static ArrayList<Alumno> listarAlumnos()
	{
		ArrayList<Alumno> listaAlu = new ArrayList<Alumno>();

		Connection cn = conectar();
		Statement stmt = null;
		ResultSet rs = null;

		try 
		{
			stmt = cn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Alumno");
			while(rs.next())
			{
				Alumno alu = new Alumno(rs.getLong("id"), 
						rs.getString("nombre"),
						rs.getString("apellido"), 
						rs.getInt("edad"),
						rs.getString("dni"),
						rs.getLong("idLocalidad"));
				listaAlu.add(alu);
			}
		}
		catch (SQLException e) 
		{		
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				rs.close();
				stmt.close();
				cn.close();
			}
			catch (SQLException e) {			
				e.printStackTrace();
			}
		}				
		return listaAlu;		
	}

	public static void insertarAlumno(Alumno alu)
	{
		Connection cn = conectar();
		PreparedStatement prstmt = null;

		try {
			prstmt = cn.prepareStatement("INSERT INTO Alumno "
					+ "(nombre,apellido,edad,dni,idLocalidad) "
					+ "VALUES (?,?,?,?,?)");
			prstmt.setString(1, alu.getNombre());
			prstmt.setString(2,alu.getApellido());
			prstmt.setInt(3, alu.getEdad());
			prstmt.setString(4, alu.getDni());
			prstmt.setLong(5,alu.getIdLocalidad());
			prstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			try {
				prstmt.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void borrarAlumno(long id)
	{
		Connection cn = conectar();
		PreparedStatement prstmt = null;
		
		try {
			prstmt = cn.prepareStatement("DELETE FROM Alumno where id = ?");
			prstmt.setLong(1, id);
			prstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			try {
				prstmt.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static ArrayList<Localidad> listarLocalidad()
	{
		ArrayList<Localidad> listaAlu = new ArrayList<Localidad>();

		Connection cn = conectar();
		Statement stmt = null;
		ResultSet rs = null;

		try 
		{
			stmt = cn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Localidad");
			while(rs.next())
			{
				Localidad alu = new Localidad
						(rs.getLong("id"), 
						rs.getString("nombre"),
						rs.getString("ciudad"), 						
						rs.getString("pais"),
						rs.getLong("cp"));
				listaAlu.add(alu);
			}
		}
		catch (SQLException e) 
		{		
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				rs.close();
				stmt.close();
				cn.close();
			}
			catch (SQLException e) {			
				e.printStackTrace();
			}
		}				
		return listaAlu;		
	}

}
