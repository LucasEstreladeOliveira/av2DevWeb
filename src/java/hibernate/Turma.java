package hibernate;
// Generated 16/11/2020 23:09:46 by Hibernate Tools 4.3.1



/**
 * Turma generated by hbm2java
 */
public class Turma  implements java.io.Serializable {


     private TurmaId id;
     private String codigoTurma;

    public Turma() {
    }

    public Turma(TurmaId id, String codigoTurma) {
       this.id = id;
       this.codigoTurma = codigoTurma;
    }
   
    public TurmaId getId() {
        return this.id;
    }
    
    public void setId(TurmaId id) {
        this.id = id;
    }
    public String getCodigoTurma() {
        return this.codigoTurma;
    }
    
    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }




}


