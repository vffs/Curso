
package exception;

import java.sql.SQLException;

/**
 *
 * @author valeria
 */
public class SqlException extends RuntimeException{
    
    protected SQLException sqlException;
    
    public SqlException(SQLException exception){
        this.sqlException = exception;
    }
    
    public String getMensagem() {
       return this.sqlException.toString();
    }
}
