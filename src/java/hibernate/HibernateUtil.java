/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hsqldb.cmdline.SqlFile;
import org.hsqldb.cmdline.SqlToolError;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author lucas
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private Connection connection;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public void createDB() throws SQLException, IOException, SqlToolError{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/av2_dev_bd?user=root&password=admin&useTimezone=true&serverTimezone=UTC");
        System.out.print("\nCriando Banco de Dados...");
        
        SqlFile sf = new SqlFile(new File(".\\Create_DB.sql"));
        sf.setConnection(connection);
        sf.execute();
    }
    
    public void createTables() throws SQLException, IOException, SqlToolError{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/av2_dev_bd?user=root&password=admin&useTimezone=true&serverTimezone=UTC");
        System.out.print("\nCriando Tabelas...");
        
        SqlFile sf = new SqlFile(new File(".\\Create_Tables.sql"));
        sf.setConnection(connection);
        sf.execute();
    }
    
    public void createUsers() throws SQLException, IOException, SqlToolError{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/av2_dev_bd?user=root&password=admin&useTimezone=true&serverTimezone=UTC");
        System.out.print("\nCriando Usuários...");
        
        SqlFile sf = new SqlFile(new File(".\\Create_Users.sql"));
        sf.setConnection(connection);
        sf.execute();
    }
    
    public void insert() throws SQLException, IOException, SqlToolError{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/av2_dev_bd?user=root&password=admin&useTimezone=true&serverTimezone=UTC");
        System.out.print("\nInserindo Usuários...");
        
        SqlFile sf = new SqlFile(new File(".\\Insert.sql"));
        sf.setConnection(connection);
        sf.execute();
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
            
}
