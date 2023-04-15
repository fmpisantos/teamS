package db;

import java.util.Hashtable;

import exceptions.DBAppException;

public class Main {

	public static void main(String[] args) {
		
		String strTableName = "Student";
		
		DBApp dbApp = new DBApp();
		
		Hashtable<String,String> htblColNameType = new Hashtable<String,String>();
		
		htblColNameType.put("id", "java.lang.Integer");
		htblColNameType.put("name", "java.lang.String");
		htblColNameType.put("gpa", "java.lang.Double");
		
		Hashtable<String,Object> htblColNameValue = new Hashtable<String,Object>(); 
		htblColNameValue.put("id", new Integer( 2343432 )); 
		htblColNameValue.put("name", new String("Ahmed Noor" ) ); 
		htblColNameValue.put("gpa", new Double( 0.95 ) ); 
		
		
		try {
			dbApp.createTable( strTableName, "id", htblColNameType, null, null );
			dbApp.insertIntoTable( strTableName , htblColNameValue );
		} catch (DBAppException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
