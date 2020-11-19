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
public class AlunoHelper {
    SessionFactory sf = null;

    public AlunoHelper() {
        sf = HibernateUtil.getSessionFactory();
    }
    
    public ArrayList getAlunos() {
        ArrayList<Aluno> alunoList = null;
        Session session =  sf.openSession();
        try {
            Query q = session.createQuery("from Aluno as aluno");
            alunoList = (ArrayList<Aluno>) q.list();
        } catch( Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return alunoList;
    }
    
    public Aluno getAluno(String matricula) {
        ArrayList<Aluno> alunoList = null;
        Aluno aluno = null;
        Session session =  sf.openSession();
        try {
            Query q = session.createQuery("from Aluno as aluno where aluno.matricula=" + matricula);
            alunoList = (ArrayList<Aluno>) q.list();
            aluno = alunoList.get(0);
        } catch( Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return aluno;
    }
    
        public Aluno getMatriculaById(Integer id) {
        ArrayList<Aluno> matriculaAluno = null;
        Aluno matricula = null;
        Session session =  sf.openSession();
        try {
            Query q = session.createQuery("from Aluno as aluno where aluno.id=" + id);
            matriculaAluno = (ArrayList<Aluno>) q.list();
            matricula = matriculaAluno.get(0);
        } catch( Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return matricula;
    }
}
