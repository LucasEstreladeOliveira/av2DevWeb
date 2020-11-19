/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author lucas
 */
public class AlunoHasTurmaHelper {
    SessionFactory sf = null;
    
    public AlunoHasTurmaHelper() {
        sf = HibernateUtil.getSessionFactory();
    }
    
    public AlunoHasTurma getAvaliacoes(int idMateria, int idAluno) {
        ArrayList<AlunoHasTurma> alunoHasTurmaList = new ArrayList<AlunoHasTurma>();
        AlunoHasTurma alunoHasTurma = null;
        Session session = sf.openSession();
        try {
            SQLQuery q = session.createSQLQuery("select AV1, APS_1, AV2, APS_2, AV3 from aluno_has_turma where aluno_idaluno=" + idAluno + " AND turma_materia_idmateria=" + idMateria );
            List<Object[]> obj = q.list();
            
		for (Object[] o : obj) {	   
                    Object[] aux = o;
                    
                    AlunoHasTurma al = new AlunoHasTurma();

                    al.setAv1((BigDecimal)aux[0]);
                    al.setAps1((BigDecimal)aux[1]);
                    al.setAv2((BigDecimal)aux[2]);
                    al.setAps2((BigDecimal)aux[3]);
                    al.setAv3((BigDecimal)aux[4]);
                    alunoHasTurmaList.add(al);
		}
                
            alunoHasTurma = alunoHasTurmaList.get(0);
        } catch( Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return alunoHasTurma;
    }   
    
    public ArrayList getIdAlunos(int idMateria, int idProfessor) {
        ArrayList<Integer> idAlunos = new ArrayList<Integer>();
        Session session = sf.openSession();
        try {
            SQLQuery q = session.createSQLQuery("select distinct aluno_idaluno from aluno_has_turma where turma_professor_idprofessor=" + idProfessor + " and turma_materia_idmateria=" + idMateria );
            idAlunos = (ArrayList<Integer>) q.list();
            
        } catch( Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return idAlunos;
    } 
    
    public void setNota(AlunoHasTurma aluno) {
        Transaction transaction = null;
        Session session = sf.openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(aluno);
            transaction.commit();
        } catch( Exception e) {
            System.out.println(e);
            if(transaction != null){
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }     
}
