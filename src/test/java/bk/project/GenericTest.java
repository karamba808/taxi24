package bk.project;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;

import java.sql.DriverManager;

public class GenericTest {
    public static void executeOperation(Operation op) throws Exception{
        System.out.println("After is running");
        DriverManager.registerDriver(
                new org.postgresql.Driver());
        DriverManagerDestination driver =
                new DriverManagerDestination(
                        "jdbc:postgresql://localhost:5432/bk",
                        "postgres","root");
        DbSetup ds = new DbSetup(driver, op);
        ds.launch();
    }
}
