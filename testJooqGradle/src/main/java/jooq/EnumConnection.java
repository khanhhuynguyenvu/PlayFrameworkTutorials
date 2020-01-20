package jooq;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public enum  EnumConnection {
    INSTANCE;
    public DSLContext getContext(){
        try {
            Connection conn = getConnection(DBInfo.INSTANCE.url, DBInfo.INSTANCE.user, DBInfo.INSTANCE.password);
            return DSL.using(conn, SQLDialect.MYSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
