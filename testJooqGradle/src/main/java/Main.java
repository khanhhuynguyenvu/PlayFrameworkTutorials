import jooq.EnumConnection;
import org.jooq.DSLContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DSLContext create =  EnumConnection.INSTANCE.getContext();
    }
}
