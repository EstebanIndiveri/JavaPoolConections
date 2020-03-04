/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poolconexiones;
import capaDatos.pool.PoolConectionsOracle;
import capaDatos.pool.PoolConexionesMySql;
import java.sql.*;

/**
 *
 * @author estel
 */
public class TestPollConections {
    
    public static void main(String[]args){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
            try{
                //Probamos el pool de MySQL:
                //y ejecutamos una consulta
                conn=PoolConexionesMySql.getConection();
                System.out.println("Utilizamos el pool de conexiones de MySQL");
                stmt=conn.prepareStatement("SELECT *FROM persona");
                rs=stmt.executeQuery();
                    while(rs.next()){
                        System.out.print(" "+rs.getInt(1));//idPersona
                        System.out.print(" "+rs.getString(2));//Nombre
                        System.out.println(" "+rs.getString(3));//Apellido
                    }
                //CERRAMOS LA CONEXION
                    conn.close();
            
                //Probamos el pool de ORACLE:
                //y ejecutamos una consula:
                //PODEMOS VOLVERA UTILIZAR LA CONEXIÓN ESTO GRACIAS AL POOL CREADO CON LIMITE DE 5 AL MISMO
                //TIEMPO:
                    conn=PoolConectionsOracle.getConection();
                        System.out.println("Utilizamos el pool de Conexiones de Oracle");
                        stmt=conn.prepareStatement("SELECT * FROM employees WHERE employee_id in(100,101,102)");
                        rs=stmt.executeQuery();
                    while(rs.next()){
                            System.out.print(" "+rs.getInt(1));//Empleado_id
                            System.out.print(" "+rs.getString(2));//Nombre
                            System.out.println(" "+rs.getString(3));//Apellido
                    }
                    conn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
    }
}
