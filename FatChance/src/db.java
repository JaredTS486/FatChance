import java.sql.*;

public class db
{
	public static void CREATE_TABLES(Connection db, String Table)
	{
		String SQL;
		Statement stmt = null;
		try {
			stmt = db.createStatement();
			If(Table == "RESOURCES" || Table == "ALL"); {
				SQL = "CREATE TABLE RESOURCES " +
					  "(ID INT PRIMARY KEY     NOT NULL," +
					  " CATEGORY       TEXT    NOT NULL, " + //NAME OF ATTRIBUTES COLUMN
					  " NAME           TEXT    NOT NULL, " + //ALL UNIQUE COLUMN VALUES
					  " MODIFIER       REAL    NOT NULL, " + //Multiplier or score weight
					  " GOALTYPE       TEXT, " + //<>=!
					  " GOALNUM        INT, " +  //At least 2 = GOALVAL
					  " GOALVAL        TEXT)";   //BLACK, BLUE, GREEN, RED
				stmt.executeUpdate(SQL);
			};
			SQL = "CREATE TABLE RESOURCE_CONCERNS " +
				  "(ID INT PRIMARY KEY     NOT NULL," +
				  " NAME           TEXT    NOT NULL, " +
			      " RESOURCE_ID    TEXT    NOT NULL, " + //1,2,3,4
				  " MODIFIER       REAL    NOT NULL, " + 
				  " GOALTYPE       TEXT, " + 
			      " GOALNUM        INT, " +
				  " GOALVAL        TEXT)";
			stmt.executeUpdate(SQL);
			stmt.close();
			db.close();
		} catch (SQLException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			e.printStackTrace();
			System.exit(0);
		}
	}
	private static void If(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public static void main( String args[] )
	{
	    Connection db = null;
	    try {
		    Class.forName("org.sqlite.JDBC");
			db = DriverManager.getConnection("jdbc:sqlite:test.db");
			CREATE_TABLES(db, "ALL");
				
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	e.printStackTrace();
	    	System.exit(0);
	    }
	    System.out.println("Table created successfully");
	}
}
