/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author lucas
 */
public class AlunoHasTurmaHelper {
    SessionFactory sf = null;
    
    public AlunoHasTurmaHelper() {
        sf = HibernateUtil.getSessionFactory();
    }
    
    public ArrayList getAlunoHasTurma(int idAlunoHasTurma) {
        ArrayList<AlunoHasTurma> alunoHasTurmaList = null;
        Session session = sf.openSession();
        try {
            Query q = session.createQuery("from AlunoHasTurma as alunoHasTurma where alunoHasTurmaId=" + idAlunoHasTurma );
            alunoHasTurmaList = (ArrayList<AlunoHasTurma>) q.list();
        } catch( Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return alunoHasTurmaList;
    }   
}
