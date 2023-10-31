package configuration;

import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class Singleton {

	private static final String PATCHCONF = "./ressource/configuration/conf.properties";
	private static final Properties props = new Properties();
	private static Connection connection;
	
	private Singleton() {
		try {
			FileInputStream file = new FileInputStream(PATCHCONF);
			props.load(file);
			
			Class.forName(props.getProperty("jdbc.driver.class"));
			props.setProperty("user", props.getProperty("jdbc.user"));
			props.setProperty("password", props.getProperty("jdbc.password"));
			
			connection = DriverManager.getConnection(props.getProperty("jdbc.url"),props);
		}
		catch (HeadlessException | IOException | SQLException | ClassNotFoundException e) {
			System.out.println("relationWithDB connection : " + e.getMessage());
		}
	}
	
	private static Connection getConnection () {
		return connection;
	}
	
	public static Connection getInstanceDB() {
		if (getConnection() == null) {
			new Singleton();
			System.out.println("relationWithDB infos : Connection etablie");
		}
		else {
			System.out.println("relationWith infos : Connection already existing");
		}
		return getConnection();
	}
	
	public static void closenstanceDB() {
		try {
			Singleton.getConnection().close();
			System.out.println("relationWithDB infos : Connection Terminates");
		}
		catch(SQLException sqle) {
			System.out.println("RelationWithDB erreur :" + sqle.getMessage() + " [SQL error code : " + sqle.getSQLState() + " ]");
		}
	}
	
	public static void testecon (Connection conn) {
		try {
		String sql = "select * from medicament;";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			System.out.println("resultat : " + result.getInt("idmed") + "_" + result.getString("nommed"));
		}
		conn.close();
		
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}
			
		}
}

