import java.sql.*;

public class db
{
	public void CREATE_TABLES(String Table)
	{
		String SQL = null;
		Connection db = null;
		Statement stmt = null;
		try {
			db = DriverManager.getConnection("jdbc:sqlite:database.db");
			stmt = db.createStatement();
			if(Table == "RESOURCES" || Table == "ALL") {
				SQL = "CREATE TABLE IF NOT EXISTS RESOURCES " +
					  "(ID INT PRIMARY KEY     NOT NULL," +
					  " CATEGORY       TEXT    NOT NULL, " + //NAME OF ATTRIBUTES COLUMN
					  " NAME           TEXT    NOT NULL, " + //ALL UNIQUE COLUMN VALUES
					  " MODIFIER       REAL    NOT NULL, " + //Multiplier or score weight
					  " GOALTYPE       TEXT, " + //<>=!
					  " GOALNUM        INT, " +  //At least 2 = GOALVAL
					  " GOALVAL        TEXT)";   //BLACK, BLUE, GREEN, RED
				stmt.executeUpdate(SQL);
				System.out.println("CREATE TABLE RESOURCES SUCCESSFUL.");
			}
			if(Table == "RESOURCE_CONCERNS" || Table == "ALL") {
				SQL = "CREATE TABLE IF NOT EXISTS RESOURCE_CONCERNS " +
					  "(ID INT PRIMARY KEY     NOT NULL," +
					  " NAME           TEXT    NOT NULL, " +
				      " RESOURCE_ID    TEXT    NOT NULL, " + //1,2,3,4
					  " MODIFIER       REAL    NOT NULL, " + 
					  " GOALTYPE       TEXT, " + 
				      " GOALNUM        INT, " +
					  " GOALVAL        TEXT)";
				stmt.executeUpdate(SQL);
				System.out.println("CREATE TABLE RESOURCE_CONCERNS SUCCESSFUL.");
			}
			if(Table == "DECISIONS" || Table == "ALL") {
				SQL = "CREATE TABLE IF NOT EXISTS DECISIONS " +
					  "(ID INT PRIMARY         KEY     NOT NULL, " +
					  " CHOICE                 TEXT    NOT NULL, " +
				      " RESOURCE_ID            TEXT    NOT NULL, " + //1,2,3,4
				      " RESOURCE_CONCERN_ID    TEXT    NOT NULL, " + //1,2,3,4
					  " MODIFIER               REAL    NOT NULL, " +
					  " GOALTYPE               TEXT, " +
				      " GOALNUM                INT, " +
					  " GOALVAL                TEXT)";
				stmt.executeUpdate(SQL);
				System.out.println("CREATE TABLE DECISIONS SUCCESSFUL.");
			}
			if (Table == "ASSETS" || Table == "ALL") {
				SQL = "CREATE TABLE IF NOT EXISTS ASSETS " +
					  "(ID INT PRIMARY         KEY     NOT NULL, " +
					  " DECISION_ID            INT     NOT NULL, " +
				      " RESOURCE_ID            TEXT    NOT NULL, " + //1,2,3,4
				      " RESOURCE_CONCERN_ID    TEXT    NOT NULL, " + //1,2,3,4
					  " MODIFIER               REAL    NOT NULL)";
				stmt.executeUpdate(SQL);
				System.out.println("CREATE TABLE ASSETS SUCCESSFUL.");
			}
			if (Table == "LIABILITIES" || Table == "ALL") {
				SQL = "CREATE TABLE IF NOT EXISTS LIABILITIES " +
					  "(ID INT PRIMARY         KEY     NOT NULL, " +
					  " DECISION_ID            INT     NOT NULL, " +
				      " RESOURCE_ID            TEXT    NOT NULL, " + //1,2,3,4
				      " RESOURCE_CONCERN_ID    TEXT    NOT NULL, " +//1,2,3,4
				      " MODIFIER               REAL    NOT NULL)";
				stmt.executeUpdate(SQL);
				System.out.println("CREATE TABLE LIABILITIES SUCCESSFUL.");
			}
			stmt.close();
			db.close();
		} catch (SQLException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			e.printStackTrace();
			System.exit(0);
		}
	}
	public void QUERY(String SQL)
	{
		Connection db = null;
		Statement stmt = null;
		try {
			db = DriverManager.getConnection("jdbc:sqlite:database.db");
			stmt = db.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main( String args[] )
	{
	    
	    try {
		    Class.forName("org.sqlite.JDBC");
				
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	e.printStackTrace();
	    	System.exit(0);
	    }
	}
}
