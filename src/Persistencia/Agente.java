package Persistencia;
//AARON
import java.sql.*;


//AARON
public class Agente {
	//Creamos una variable de conexion estatica ya que vamos a utilizar el patron singleton
	private static Connection conexion = null;
	private static PreparedStatement ps;
	private static ResultSet rs;
    private String url;
    private String driver;
    private String usuario;
    private String password;
    
    //Constructor
    public Agente() {
    	 String url = "jdbc:mysql://servidorpecespi.hopto.org:3306/restaurante";
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
    
    //Metodos para la interaccion con la base de datos.
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
    
    //Método para insertar registros en la base de dato.
    public static void insertar(String comando) {
    	if(conexion == null) {
    		try {
    			getConnection();
    			ps = conexion.prepareStatement(comando);
    			int res = ps.executeUpdate();
    			if(res>0) {
    				System.out.println("Valores guardados en la base de datos");
    			}else System.out.println("Error al guardar valores en la base de datos");
    			conexion.close();
    		}catch(Exception e) {
    			System.err.print(e);
    		}
    	}
    }
    
    //Método para realizar consultas en la base de datos.
    public static String consultar(String comando) {
    	String resultado="0";
    	if(conexion == null) {
    		try {
    			getConnection();
    			ps = conexion.prepareStatement(comando);
    			rs = ps.executeQuery();
				while(rs.next()) {
					ResultSetMetaData rsmd = rs.getMetaData();
					for(int i=1; i<= rsmd.getColumnCount();i++) {
						if(i>1) {
							System.out.print(" | ");
						}
						int type = rsmd.getColumnType(i);
						if(type==Types.VARCHAR || type == Types.CHAR) {
							resultado = rs.getString(i);
							System.out.print(resultado);
						}else {
							resultado = Long.toString(rs.getLong(i));
							System.out.print(resultado);
						}
					}
					System.out.println();
				}
    		}catch(Exception e) {
    			System.err.print(e);
    		}
    	}
    	return resultado;
    }
    
    //Método para modificar las tablas.
    public static void modificar(String comando) {
    	if(conexion == null) {
    		try {
    			getConnection();
    			ps = conexion.prepareStatement(comando);
    			int res = ps.executeUpdate();
    			if(res>0) {
    				System.out.println("Valores modificados en la base de datos");
    			}else System.out.println("Error al modificar valores en la base de datos");
    			conexion.close();
    		}catch(Exception e) {
    			System.err.print(e);
    		}
    	}
    }
    
    public static void eliminar(String comando) {
    	if(conexion == null) {
    		try {
    			getConnection();
    			ps = conexion.prepareStatement(comando);
    			int res = ps.executeUpdate();
    			if(res>0) {
    				System.out.println("Valores eliminados de la base de datos");
    			}else System.out.println("Error al eliminar valores de la base de datos");
    			conexion.close();
    		}catch(Exception e) {
    			System.err.print(e);
    		}
    	}
    }
}