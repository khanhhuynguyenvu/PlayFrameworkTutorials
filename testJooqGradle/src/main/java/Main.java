import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;
import static org.jooq.generated.Tables.STUDENT;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = getConnection("jdbc:mysql://localhost:3306", "root", "MaiPhuong121")) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            //CREATE
            create.insertInto(STUDENT,STUDENT.FIRST_NAME,STUDENT.LAST_NAME)
                    .values("Won","Chung")
                    .execute();
            //UPDATE
            create.update(STUDENT)
                    .set(STUDENT.FIRST_NAME,"New Name")
                    .where(STUDENT.ID.eq(6))
                    .execute();
            //DELETE
            create.delete(STUDENT)
                    .where(STUDENT.ID.eq(5))
                    .execute();
            //READ
            Result<Record> result = create.select().from(STUDENT).fetch();
            for (Record r : result) {
                Integer id = r.getValue(STUDENT.ID);
                String firstName = r.getValue(STUDENT.FIRST_NAME);
                String lastName = r.getValue(STUDENT.LAST_NAME);
                System.out.println("ID: " + id + " First name: " + firstName + " Last name: " + lastName);
            }
        } catch (SQLException sqlException) {
            //TODO
        }
        System.out.println("Done");
    }
}
