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
		htblColNameValue.put("id", new Integer( 23434324 )); 
		htblColNameValue.put("name", new String("Ahmed Noorhhh TEST hihihi" ) ); 
		htblColNameValue.put("gpa", new Double( 0.86 ) ); 
		
		
		try {
			//dbApp.createTable( strTableName, "id", htblColNameType, null, null );
			dbApp.insertIntoTable( strTableName , htblColNameValue );
			dbApp.readTable(strTableName);
		} catch (DBAppException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
