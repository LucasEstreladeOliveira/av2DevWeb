/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import hibernate.Aluno;
import hibernate.AlunoAvaliacoes;
import hibernate.AlunoHasTurma;
import hibernate.AlunoHasTurmaHelper;
import hibernate.AlunoHasTurmaId;
import hibernate.AlunoHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
    @WebServlet(name = "avaliacoes", urlPatterns = {"/avaliacoes"})
    public class avaliacoes extends HttpServlet {
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                Scanner s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
                Gson g = new Gson();
                
                AlunoHasTurmaId materiaEUser = g.fromJson(s.next(), AlunoHasTurmaId.class);

                AlunoHasTurmaHelper alunoHasTurmaHelper = new AlunoHasTurmaHelper();
                
                if(materiaEUser.getIsProf() != true){
                    AlunoHasTurma listMateriasId = alunoHasTurmaHelper.getAvaliacoes(materiaEUser.getTurmaMateriaIdmateria(), materiaEUser.getAlunoIdaluno());

                    String json = g.toJson(listMateriasId);
                    out.println(json);
                }else {
                    ArrayList<Integer> listIdAlunos = alunoHasTurmaHelper.getIdAlunos(materiaEUser.getTurmaMateriaIdmateria(), materiaEUser.getTurmaProfessorIdprofessor());
                    
                    ArrayList<AlunoAvaliacoes> alunos = new ArrayList<>();
                    AlunoHelper helper = new AlunoHelper();
                    AlunoHasTurmaHelper helperAvaliacoes = new AlunoHasTurmaHelper();
                    
                    for(int i=0; i < listIdAlunos.size() ; i++){
                        AlunoAvaliacoes notas = new AlunoAvaliacoes();

                        notas.setAluno(helper.getMatriculaById(listIdAlunos.get(i)));
                        notas.setTurma(helperAvaliacoes.getAvaliacoes(materiaEUser.getTurmaMateriaIdmateria(), listIdAlunos.get(i)));
                        alunos.add(i, notas);
                    }
                    

                    String json = g.toJson(alunos);
                    out.println(json);                    
                    
                }
        }
    
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
