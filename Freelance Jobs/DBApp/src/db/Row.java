package db;

import java.io.Serializable;
import java.util.Hashtable;

import exceptions.DBAppException;

public class Row implements Serializable{
	private Hashtable<String, Object> columns;
	
	public Row(Hashtable<String,Object> htblColNameValue, Hashtable<String,String> htblColNameType) throws DBAppException {
		this.columns = new Hashtable<String, Object>();
		
		for( String columnName: htblColNameType.keySet() ) {
			
			if( !htblColNameValue.containsKey(columnName)) {
				throw new DBAppException("Column "+columnName+" is missing.");
			}
			
			Object objColValue 	= htblColNameValue.get(columnName);
			String strColType 	= htblColNameType.get(columnName);
			
				try {
					columns.put(columnName, Class.forName(strColType).cast(objColValue));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	

	public Hashtable<String, Object> getColumns() {
		return columns;
	}

	public void setColumns(Hashtable<String, Object> columns) {
		this.columns = columns;
	}
}
