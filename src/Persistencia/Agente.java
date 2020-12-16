package Persistencia;

import java.sql.*;
import java.util.*;

//AARON
public class Agente {
	//Creamos una variable de conexion estatica ya que vamos a utilizar el patron singleton.
	private static Connection conexion = null;
	private static PreparedStatement ps;
	private static ResultSet rs;
    private String url;
    private String driver;
    private String usuario;
    private String password;
    
    //Constructor
    private Agente() {
    	 String url = "jdbc:mysql://servidorpecespi.hopto.org:3306/nation";
    	 String driver = "com.mysql.cj.jdbc.Driver";
    	 String usuario = "isoft2";
    	 String password = "isoft2c01";
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url,usuario,password);
			System.out.println("Conexión con la base de datos realizada con exito");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    }
    
    //Metodos para la interaccion con la base de datos:
    
    //Método para iniciar la conexion con la base de datos
    public static Connection getConnection(){
    	if (conexion == null) {
    		new Agente();
    	}
    	return conexion;
    }
    
    //Método para cerrar la conexion con la base de datos
    public static void closeConnection() throws SQLException {
    	if(conexion != null) {
    		conexion.close();
    	}
    }
    
    //Método para insertar registros en la base de dato.
	public static void insertar(String comando) {
		try {
			getConnection();
			ps = conexion.prepareStatement(comando);
			int res = ps.executeUpdate();
			if (res > 0) {
				System.out.println("Valores guardados");
			} else
				System.out.println("Error al guardar valores");
			conexion.close();
		} catch (Exception e) {
			System.err.print(e);
		}
	}
    
    //Método para mostrar datos
	public static void mostrar(String comando) {
		try {
			getConnection();
			ps = conexion.prepareStatement(comando);
			rs = ps.executeQuery();
			while (rs.next()) {
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					if (i > 1) {
						System.out.print(" | ");
					}
					int type = rsmd.getColumnType(i);
					if (type == Types.VARCHAR || type == Types.CHAR) {
						System.out.print(rs.getString(i));
					} else {
						System.out.print(Long.toString(rs.getLong(i)));
					}
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.err.print(e);
		}
	}
    
    //Método para obtener varios elementos de una tabla.
	public static ArrayList<ArrayList<String>> getMany(String comando) {
    	ArrayList<ArrayList<String>> lista= new ArrayList<ArrayList<String>>();
		try {
			getConnection();
			ps = conexion.prepareStatement(comando);
			rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList<String> elemento= new ArrayList<String>();
				ResultSetMetaData rsmd = rs.getMetaData();
				for(int i=1; i<= rsmd.getColumnCount();i++) {
					int type = rsmd.getColumnType(i);
					if(type==Types.VARCHAR || type == Types.CHAR) {
						elemento.add(rs.getString(i));
					}else{
						elemento.add(Long.toString(rs.getLong(i)));
					}
				}
				lista.add(elemento);
			}
		}catch(Exception e) {
			System.err.print(e);
		}
    	return lista;
    }
	
	//Metodo para obtener un unico elemento de una tabla
    public static String get(String comando) {
    	String resultado="0";
		try {
			getConnection();
			ps = conexion.prepareStatement(comando);
			rs = ps.executeQuery();
			while(rs.next()) {
				ResultSetMetaData rsmd = rs.getMetaData();
				for(int i=1; i<= rsmd.getColumnCount();i++) {
					int type = rsmd.getColumnType(i);
					if(type==Types.VARCHAR || type == Types.CHAR) {
						resultado = rs.getString(i);
					}else {
						resultado = Long.toString(rs.getLong(i));
					}
				}
			}
		}catch(Exception e) {
			System.err.print(e);
		}
    	return resultado;
    }
    
    //Método para modificar las tablas.
	public static void modificar(String comando) {
		try {
			getConnection();
			ps = conexion.prepareStatement(comando);
			int res = ps.executeUpdate();
			if (res > 0) {
				System.out.println("Valores modificados en la base de datos");
			} else
				System.out.println("Error al modificar valores en la base de datos");
			conexion.close();
		} catch (Exception e) {
			System.err.print(e);
		}
	}
    
	//Método para eliminar elementos de la base de datos
	public static void eliminar(String comando) {
		try {
			getConnection();
			ps = conexion.prepareStatement(comando);
			int res = ps.executeUpdate();
			if (res > 0) {
				System.out.println("Valores eliminados de la base de datos");
			} else
				System.out.println("Error al eliminar valores de la base de datos");
			conexion.close();
		} catch (Exception e) {
			System.err.print(e);
		}
	}
}