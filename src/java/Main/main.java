/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import hibernate.Aluno;
import hibernate.AlunoHelper;
import hibernate.HibernateUtil;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.List;
import org.hsqldb.cmdline.SqlToolError;

/**
 *
 * @author lucas
 */
public class main {
    
    public static void main(String[] args) throws SqlToolError, SQLException, IOException {
        HibernateUtil util = new HibernateUtil();
        util.createDB();
        util.createTables();
        util.createUsers();
        util.insert();
        
        System.out.println("======");
        AlunoHelper helper = new AlunoHelper();
        List<Aluno> listaAlunos = helper.getAlunos();
        listaAlunos.forEach((al) -> {
            System.out.println(al.getNome());
        });                   
    }
}

