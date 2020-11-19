package hibernate;

import java.util.ArrayList;
import org.hibernate.SQLQuery;
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
    
    public ArrayList getIdTurmaAluno(int idAluno) {
        ArrayList<Integer> idMaterias = null;
        Session session = sf.openSession();
        try {
            SQLQuery q = session.createSQLQuery("select turma_materia_idmateria from aluno_has_turma where aluno_idaluno=" + idAluno );
            idMaterias = (ArrayList<Integer>) q.list();
        } catch( Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return idMaterias;
    }   
    
    public ArrayList getIdTurmaProfessor(int idProfessor) {
        ArrayList<Integer> idMaterias = null;
        Session session = sf.openSession();
        try {
            SQLQuery q = session.createSQLQuery("select distinct turma_materia_idmateria from aluno_has_turma where turma_professor_idprofessor=" + idProfessor );
            idMaterias = (ArrayList<Integer>) q.list();
        } catch( Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return idMaterias;
    }      
}
