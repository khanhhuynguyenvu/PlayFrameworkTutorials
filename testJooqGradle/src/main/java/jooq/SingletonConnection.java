package jooq;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class SingletonConnection {
    private static SingletonConnection instance;
    private static DSLContext context = setContext();
    private SingletonConnection() {
    }
    public static synchronized SingletonConnection getInstance(){
        if(instance==null){
            synchronized (SingletonConnection.class){
                if(instance == null){
                    instance = new SingletonConnection();
                }
            }
        }
        return instance;
    }
    public static DSLContext setContext(){
        try {
            Connection conn = getConnection("jdbc:mysql://localhost:3306", "root", "MaiPhuong121");
            return DSL.using(conn, SQLDialect.MYSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public DSLContext getContext(){
        return context;
    }
}
