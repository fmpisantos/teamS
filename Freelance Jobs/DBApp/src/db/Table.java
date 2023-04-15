package db;

import java.util.Hashtable;
import java.io.Serializable;

public class Table implements Serializable{
	private int iPage_Counter;
	private Hashtable<String,String> htblColNameType;
	
	public Table(Hashtable<String,String> htblColNameType) {
		this.iPage_Counter = 0;
		this.setHtblColNameType(htblColNameType);
	}
	
	public int getiPage_Counter() {
		return iPage_Counter;
	}

	public void setiPage_Counter(int iPage_Counter) {
		this.iPage_Counter = iPage_Counter;
	}

	public Hashtable<String,String> getHtblColNameType() {
		return htblColNameType;
	}

	public void setHtblColNameType(Hashtable<String,String> htblColNameType) {
		this.htblColNameType = htblColNameType;
	}
}
