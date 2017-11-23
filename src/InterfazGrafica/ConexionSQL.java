
package InterfazGrafica;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class ConexionSQL {
    private static Connection conexion;

    public void ConexionBase(String root, String admin, String basedb){
    try {
        Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/"+ basedb,root,admin);
    }catch (SQLException e){
        System.out.println(e.getMessage());
    }catch (ClassNotFoundException e){
        System.out.println(e.getMessage());
    }
}    
    
    public  void CierreConexion (){
    try {
        if (conexion!=null) {
            conexion.close();
        }
    }catch (SQLException e){
        System.out.println(e.getMessage());
    }
}
    
    public   void CrearBase(String basedb){
   try {
        Statement miconexion= conexion.createStatement();
       miconexion.executeUpdate("CREATE DATABASE " + basedb);
   }catch (SQLException e){
       System.out.println(e.getMessage());
 }
}

    
    
public  void CrearTabla(String registro){
    try {
        Statement miconexion = conexion.createStatement();
        miconexion.executeUpdate("create table " + registro +
                "(nombre varchar(40), apellido varchar(40), localidad varchar(30), mail varchar(30), edad int, telefono int,Java varchar(2),DNI int(8),ID int AUTO_INCREMENT, primary key (ID))");
    }catch (SQLException e){
        System.out.println(e.getMessage());
    }
}




public   void IngresarDatosTabla (String registro,
String nombre,String apellido,String localidad,String mail, int edad, int telefono, String Java,int DNI){
    try {
        Statement miconexion = conexion.createStatement();
//        miconexion.executeUpdate("INSERT INTO " + Nombre_tabla + "VALUES(nombre, apellido, localidad, mail, edad, telefono, Java, DNI);");
        
        PreparedStatement pStmt = conexion.prepareStatement("Insert INTO registro " + "(nombre, apellido, localidad, mail, edad, telefono, Java, DNI)" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
pStmt.setString(1, nombre);
pStmt.setString(2, apellido);
pStmt.setString(3, localidad);
pStmt.setString(4, mail);
pStmt.setInt(5, edad);
pStmt.setInt(6, telefono);
pStmt.setString(7, Java);
pStmt.setInt(8, DNI);

pStmt.executeUpdate();
        
    }catch (SQLException e){
        System.out.println(e.getMessage());
    }
}

public   void EliminarRegistros (String registro){
    try {
        Statement miconexion = conexion.createStatement();
        miconexion.executeUpdate("DELETE FROM " + registro);
    }catch (SQLException e){
        System.out.println(e.getMessage());
    }
}

public  int Maximo (String registro){
    int max = 0;
    try {
        Statement miconexion = conexion.createStatement();
//       miconexion.executeUpdate("SELECT MAX(ID) FROM" + registro);
        
        ResultSet rs = miconexion.executeQuery("SELECT MAX(ID) FROM" + registro);
        while (rs.next()) {
               max= rs.getInt(9);
               System.out.println(rs.getInt(1));
        }
    }catch (SQLException e){
        System.out.println(e.getMessage());
    }
return max;
        }

    
}


