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
public class ProfessorHelper {
    SessionFactory sf = null;
    
    public ProfessorHelper() {
        sf = HibernateUtil.getSessionFactory();
    }
    
    public ArrayList getProfessores() {
        ArrayList<Professor> professorList = null;
        Session session = sf.openSession();
        try {
            Query q = session.createQuery("from Professor as professor");
            professorList = (ArrayList<Professor>) q.list();
        } catch( Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return professorList;
    }
    
        public Professor getProfessor(String matricula) {
        ArrayList<Professor> professorList = null;
        Professor professor = null;
        Session session =  sf.openSession();
        try {
            Query q = session.createQuery("from Professor as professor where professor.matricula=" + matricula);
            professorList = (ArrayList<Professor>) q.list();
            professor = professorList.get(0);
        } catch( Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return professor;
    }
}
