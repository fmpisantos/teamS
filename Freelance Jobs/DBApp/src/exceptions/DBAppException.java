package exceptions;

public class DBAppException extends Exception{
	private static final long serialVersionUID = 1L;

	public DBAppException(String errorMessage){
        super(errorMessage);
    }
}