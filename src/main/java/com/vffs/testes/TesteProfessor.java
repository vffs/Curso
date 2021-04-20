
package com.vffs.testes;

import com.vffs.model.Professor;
import com.vffs.persistencia.ConnectionFactory;
import com.vffs.persistencia.ProfessorDao;
import java.sql.SQLException;


/**
 *
 * @author valeria
 */
public class TesteProfessor {
    public static void main(String[] args) throws SQLException {
        ProfessorDao pd = new ProfessorDao( ConnectionFactory.getInstance().getConnection());
        Professor p = new Professor("Mateus", 33);
        pd.createTable();
        pd.insert(p);
        
        
        
    }
}
