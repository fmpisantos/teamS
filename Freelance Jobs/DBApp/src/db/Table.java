package db;

import java.util.Hashtable;
import java.util.LinkedList;

import exceptions.DBAppException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Table implements Serializable{
	private static final long serialVersionUID = 1L;
	private int iPage_Counter;
	String strClusteringKeyColumn;
	private Hashtable<String,String> htblColNameType;
	private LinkedList<String> pagesList;
	
	public Table(Hashtable<String,String> htblColNameType, String strClusteringKeyColumn) {
		this.iPage_Counter = 0;
		this.setHtblColNameType(htblColNameType);
		this.pagesList = new LinkedList<>();
		this.strClusteringKeyColumn = strClusteringKeyColumn;
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
	
	public LinkedList<String> getPagesList() {
		return this.pagesList;
	}
	
	public void setPagesList(LinkedList<String> pagesList) {
		this.pagesList = pagesList;
	}
	
	public void insert(String strTableName, Hashtable<String,Object> htblColNameValue) throws DBAppException {
		Page page = getWritablePage(strTableName);
		page.addRow(htblColNameValue, this.htblColNameType);
		writePage(strTableName, page);
		writeTable(strTableName);
	}
	
	public void update(String strTableName, String strClusteringKeyValue, Hashtable<String,Object> htblColNameValue) throws DBAppException {
		for(String pagePath: pagesList) {
			File file = new File(pagePath);
			if (!file.exists()) {
			    throw new DBAppException("Page path provided does not exist");
			} else {
				Page page = null;
			    try {
			    	FileInputStream fileIn = new FileInputStream(file);
			        ObjectInputStream in = new ObjectInputStream(fileIn);
			        page  = (Page) in.readObject();
			        in.close();
			        fileIn.close();
			      } catch (IOException i) {
			    	  i.printStackTrace();
			      } catch (ClassNotFoundException e) {
			    	  e.printStackTrace();
			      }
			    
			    for(Row r: page.getVectorRows() ) {
			    }
			}
		}
	}
	
	public void readLastPage() throws DBAppException {
		String pagePath = pagesList.getLast();
		File file = new File(pagePath);
		if (!file.exists()) {
		    throw new DBAppException("Page path provided does not exist");
		} else {
			Page page = null;
		    try {
		    	FileInputStream fileIn = new FileInputStream(file);
		        ObjectInputStream in = new ObjectInputStream(fileIn);
		        page  = (Page) in.readObject();
		        in.close();
		        fileIn.close();
		      } catch (IOException i) {
		    	  i.printStackTrace();
		      } catch (ClassNotFoundException e) {
		    	  e.printStackTrace();
		      }
		    
		    for(Row r: page.getVectorRows() ) {
		    	for(String s: r.getColumns().keySet()) {		    		
		    		System.out.println(r.getColumns().get(s).toString());
		    	}
		    }
		}
	}
	
	private Page newPage(String strTableName) {
		Page page = new Page();
		iPage_Counter++;
		String pagePath = "data/"+strTableName+"/"+strTableName+"_Page_"+iPage_Counter+".ser";
		pagesList.add(pagePath);
		return page;
	}
	
	private void writePage(String strTableName, Page page) throws DBAppException {
		String pagePath = "data/"+strTableName+"/"+strTableName+"_Page_"+iPage_Counter+".ser";
		File file = new File(pagePath);
	    try {
	         FileOutputStream fileOut = new FileOutputStream(file);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(page);
	         out.close();
	         fileOut.close();
	         System.out.println("Serialized page data is saved in "+pagePath);
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	private void writeTable(String strTableName) throws DBAppException {
		String tablePath = "data/"+strTableName+"/"+strTableName+".ser";
		File file = new File(tablePath);
	    try {
	         FileOutputStream fileOut = new FileOutputStream(file);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(this);
	         out.close();
	         fileOut.close();
	         System.out.println("Serialized page data is saved in "+tablePath);
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	private Page getWritablePage(String strTableName) throws DBAppException {
		if( pagesList.isEmpty() ) {
			return newPage(strTableName);
		}
		
		String pagePath = pagesList.getLast();
		File file = new File(pagePath);
		if (!file.exists()) {
		    throw new DBAppException("Page provided does not exist");
		} else {
			Page page = null;
		    try {
		    	FileInputStream fileIn = new FileInputStream(file);
		        ObjectInputStream in = new ObjectInputStream(fileIn);
		        page  = (Page) in.readObject();
		        in.close();
		        fileIn.close();
		        
		        if( page.canAddRow()) {
		        	System.out.println("reutrn existing page");
		        	return page;
		        }
		        else
		        	return newPage(strTableName);
		        
		      } catch (IOException i) {
		    	  i.printStackTrace();
		      } catch (ClassNotFoundException e) {
		    	  e.printStackTrace();
		      }
		}
		return null;
	}
}
