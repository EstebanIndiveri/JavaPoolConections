 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDatos.pool;
import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author estel
 */
public class PoolConexionesMySql {
    public static DataSource getDataSource(){
        BasicDataSource ds=new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("admin");
        ds.setUrl("jdbc:mysql://localhost:3306/sga");
        //sga?useSSL=false"
        //Definimos el tamaño del pool de conexiones:
        ds.setInitialSize(5);//5 Conexiones iniciales;
        return ds;
    }
    public static Connection getConection()throws SQLException{
        return getDataSource().getConnection();
    }
}
