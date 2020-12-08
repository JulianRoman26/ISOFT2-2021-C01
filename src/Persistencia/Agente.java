package Persistencia;

import java.sql.*;

//AARON
public class Agente {
	//Creamos una variable de conexion estatica ya que vamos a utilizar el patron singleton
	private static Connection conexion = null;
    private String url;
    private String driver;
    private String usuario;
    private String password;
    
    //Constructor
    private Agente() {
    	String url = "jdbc:mysql://servidorpecespi.hopto.org:3306/restaurante";
    	 String driver = "com.mysql.jdbc.Driver";
    	 String usuario = "isoft2";
    	 String password = "isoft2c01";
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url,usuario,password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    }
    
    //Metodos para abrir y cerrar la conexión:
    public static Connection getConnection(){
    	if (conexion == null) {
    		new Agente();
    	}
    	return conexion;
    }
    
    public static void closeConnection() throws SQLException {
    	if(conexion != null) {
    		conexion.close();
    	}
    }

}