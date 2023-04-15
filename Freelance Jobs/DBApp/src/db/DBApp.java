package db;

import java.util.Hashtable;
import java.util.Iterator;
import java.io.*;

import exceptions.DBAppException;

public class DBApp {

	//these consts should go into a config file
	public static final Integer MaximumRowsCountinTablePage = 200;
	
	public DBApp() {
	}
	
	public void init( ) {
		
	} // this does whatever initialization you would like 
	// or leave it empty if there is no code you want to 
	// execute at application startup 
	
	// following method creates one table only 
	// strClusteringKeyColumn is the name of the column that will be the primary 
	// key and the clustering column as well. The data type of that column will 
	// be passed in htblColNameType 
	// htblColNameValue will have the column name as key and the data 
	// type as value 
	// htblColNameMin and htblColNameMax for passing minimum and maximum values 
	// for data in the column. Key is the name of the column
	public void createTable(String strTableName, String strClusteringKeyColumn, Hashtable<String,String> htblColNameType, 
			Hashtable<String,String> htblColNameMin, Hashtable<String,String> htblColNameMax ) throws DBAppException {
			String tablePath = "data/"+strTableName+"/"+strTableName+".ser";
			File file = new File(tablePath);
			if (file.exists()) {
			    throw new DBAppException("Table already exists");
			} else {
			    Table tbl = new Table(htblColNameType);
			    try {
		    		 file.getParentFile().mkdirs();
			         FileOutputStream fileOut = new FileOutputStream(file);
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(tbl);
			         out.close();
			         fileOut.close();
			         System.out.println("Serialized table data is saved in "+tablePath);
			      } catch (IOException i) {
			         i.printStackTrace();
			      }
			}
	}
	
	// following method creates an octree 
	// depending on the count of column names passed. 
	// If three column names are passed, create an octree. 
	// If only one or two column names is passed, throw an Exception. 
	public void createIndex(String strTableName, String[] strarrColName) throws DBAppException{
		
	}
	
	// following method inserts one row only. 
	// htblColNameValue must include a value for the primary key 
	public void insertIntoTable(String strTableName, Hashtable<String,Object> htblColNameValue) throws DBAppException{
		String tablePath = "data/"+strTableName+"/"+strTableName+".ser";
		File file = new File(tablePath);
		if (!file.exists()) {
		    throw new DBAppException("Table provided doesn not exist");
		} else {
			Table tbl = null;
		    try {
		    	FileInputStream fileIn = new FileInputStream(file);
		        ObjectInputStream in = new ObjectInputStream(fileIn);
		        tbl  = (Table) in.readObject();
		        in.close();
		        fileIn.close();
		      } catch (IOException i) {
		    	  i.printStackTrace();
		      } catch (ClassNotFoundException e) {
		    	  e.printStackTrace();
		      }
		    System.out.println("Table counter:"+tbl.getiPage_Counter());
		    
		}
	}
	
	// following method updates one row only 
	// htblColNameValue holds the key and new value 
	// htblColNameValue will not include clustering key as column name 
	// strClusteringKeyValue is the value to look for to find the row to update. 
	public void updateTable(String strTableName, String strClusteringKeyValue, Hashtable<String,Object> htblColNameValue ) throws DBAppException{
		
	}
	
	// following method could be used to delete one or more rows. 
	// htblColNameValue holds the key and value. This will be used in search 
	// to identify which rows/tuples to delete. 
	// htblColNameValue entries are ANDED together 
	public void deleteFromTable(String strTableName, Hashtable<String,Object> htblColNameValue) throws DBAppException {
		
	}
	
	public Iterator selectFromTable(SQLTerm[] arrSQLTerms, String[] strarrOperators) throws DBAppException {
		return null;
	}
	
}