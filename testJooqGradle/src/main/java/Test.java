import jooq.SingletonConnection;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import static org.jooq.generated.Tables.STUDENT;

public class Test {
    private static DSLContext create  = SingletonConnection.getInstance().getContext();

    public static void main(String[] args) {
//        CREATE
            create.insertInto(STUDENT,STUDENT.FIRST_NAME,STUDENT.LAST_NAME)
                    .values("Won","Chang")
                    .execute();
//        UPDATE
//            create.update(STUDENT)
//                    .set(STUDENT.FIRST_NAME,"New Name")
//                    .where(STUDENT.ID.eq(6))
//                    .execute();
//        DELETE
//            create.delete(STUDENT)
//                    .where(STUDENT.ID.greaterOrEqual(0))
//                    .execute();
//        READ
            Result<Record> result = create.select().from(STUDENT).fetch();
            for (Record r : result) {
                Integer id = r.getValue(STUDENT.ID);
                String firstName = r.getValue(STUDENT.FIRST_NAME);
                String lastName = r.getValue(STUDENT.LAST_NAME);
                System.out.println("ID: " + id + " First name: " + firstName + " Last name: " + lastName);
            }
    }
}
