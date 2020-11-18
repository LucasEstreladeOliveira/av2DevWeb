package hibernate;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author lucas
 */
public class AlunoHasTurmaIdHelper {
    SessionFactory sf = null;
    
    public AlunoHasTurmaIdHelper() {
        sf = HibernateUtil.getSessionFactory();
    }
    
    public ArrayList getAlunoHasTurmaId(int idAluno) {
        ArrayList<AlunoHasTurmaId> alunoHasTurmaIdList = null;
        Session session = sf.openSession();
        try {
            Query q = session.createQuery("from AlunoHasTurma as alunoHasTurma where alunoIdaluno=" + idAluno );
            alunoHasTurmaIdList = (ArrayList<AlunoHasTurmaId>) q.list();
        } catch( Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return alunoHasTurmaIdList;
    }      
}
