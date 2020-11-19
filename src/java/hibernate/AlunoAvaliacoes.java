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
public class AlunoAvaliacoes {
    Aluno aluno;
    AlunoHasTurma turma;

    public AlunoAvaliacoes() { }
    public AlunoAvaliacoes(Aluno aluno, AlunoHasTurma turma) {
        this.aluno = aluno;
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public AlunoHasTurma getTurma() {
        return turma;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setTurma(AlunoHasTurma turma) {
        this.turma = turma;
    }
    
    
}
