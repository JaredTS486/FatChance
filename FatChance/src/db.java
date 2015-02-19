import java.sql.*;

public class db
{
  public static void main( String args[] )
  {
    Connection db = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      db = DriverManager.getConnection("jdbc:sqlite:test.db");
      System.out.println("Opened database successfully");

      stmt = db.createStatement();
      String SQL = "DROP TABLE COMPANY";
      stmt.executeUpdate(SQL);
      SQL = "CREATE TABLE COMPANY " +
            "(ID INT PRIMARY KEY     NOT NULL," +
            " NAME           TEXT    NOT NULL, " + 
            " AGE            INT     NOT NULL, " + 
            " ADDRESS        CHAR(50), " + 
            " SALARY         REAL)"; 
      stmt.executeUpdate(SQL);
      stmt.close();
      db.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table created successfully");
  }
}
