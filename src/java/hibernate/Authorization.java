/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

/**
 *
 * @author lucas
 */
public class Authorization {
    
    private Boolean auth;
    private Integer id;
    private String matricula;
    private String nome;
    private Boolean isProf;


    public Boolean getAuth() {
        return auth;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }
    
    public Integer getId() {
        return id;
    }

    public Boolean getIsProf() {
        return isProf;
    }
    
    public void setAuth(Boolean auth) {
        this.auth = auth;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIsProf(Boolean isProf) {
        this.isProf = isProf;
    }
    
    
}
