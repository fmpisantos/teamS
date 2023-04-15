package db;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

import exceptions.DBAppException;

public class Page implements Serializable{
	//this const should go into a config file
	public static final Integer MaximumRowsCountinTablePage = 200;
	
	private Vector<Row> vectorRows;
	
	public Page() {
		this.setVectorRows(new Vector<Row>(MaximumRowsCountinTablePage));
	}

	public Vector<Row> getVectorRows() {
		return this.vectorRows;
	}

	public void setVectorRows(Vector<Row> vectorRows) {
		this.vectorRows = vectorRows;
	}
	
	public boolean canAddRow() {
		return ( vectorRows.size() < vectorRows.capacity() );
	}
	
	public void addRow(Hashtable<String,Object> htblColNameValue, Hashtable<String,String> htblColNameType) {
		try {
			Row newRow = new Row(htblColNameValue, htblColNameType);
			vectorRows.add(newRow);
		} catch (DBAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
