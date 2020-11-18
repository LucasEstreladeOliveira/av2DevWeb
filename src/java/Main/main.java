/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import hibernate.Aluno;
import hibernate.AlunoHelper;
import java.util.List;

/**
 *
 * @author lucas
 */
public class main {
    
    public static void main(String[] args) {
    
        System.out.println("======");
        AlunoHelper helper = new AlunoHelper();
        List<Aluno> listaAlunos = helper.getAlunos();
        System.out.println(listaAlunos);
        listaAlunos.forEach((al) -> {
            System.out.println(al.getNome());
        });                   
    }
}

