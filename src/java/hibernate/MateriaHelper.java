package hibernate;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**
 *
 * @author lucas
 */
public class MateriaHelper {
    SessionFactory sf = null;
    
    public MateriaHelper() {
        sf = HibernateUtil.getSessionFactory();
    }
    
    public Materia getMateria(int idMateria) {
        ArrayList<Materia> materiaList = null;
        Materia materia = null;
        Session session = sf.openSession();
        try {
            Query q = session.createQuery("from Materia as materia where idmateria=" + idMateria );
            materiaList = (ArrayList<Materia>) q.list();
            materia = materiaList.get(0);
        } catch( Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return materia;
    }   
}
