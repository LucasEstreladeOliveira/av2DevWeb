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
    
    Boolean auth;
    String matricula;
    String nome;


    public boolean getAuth() {
        return auth;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
}
