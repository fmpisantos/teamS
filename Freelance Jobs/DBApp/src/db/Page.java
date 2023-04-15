package db;

import java.util.Vector;

public class Page {
	private Vector<Row> vectorRows;
	
	public Page(int maximumRowsCountinTablePage) {
		this.setVectorRows(new Vector<Row>(maximumRowsCountinTablePage));
	}

	public Vector<Row> getVectorRows() {
		return vectorRows;
	}

	public void setVectorRows(Vector<Row> vectorRows) {
		this.vectorRows = vectorRows;
	}
}
