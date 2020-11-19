/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import hibernate.Aluno;
import hibernate.AlunoHasTurmaIdHelper;
import hibernate.AlunoHelper;
import hibernate.Authorization;
import hibernate.Materia;
import hibernate.MateriaHelper;
import hibernate.Professor;
import hibernate.ProfessorHelper;
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
@WebServlet(name = "materias", urlPatterns = {"/materias"})
public class materias extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Scanner s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
            Gson g = new Gson();
            
            Authorization user = g.fromJson(s.next(), Authorization.class);
            ArrayList<Integer> listMateriasId = null;

            if(user.getIsProf() == false ){
                AlunoHelper helperAluno = new AlunoHelper();
                Aluno al = helperAluno.getAluno(user.getMatricula());
    
                AlunoHasTurmaIdHelper alunoHasTurmaIdHelper = new AlunoHasTurmaIdHelper();
                listMateriasId = alunoHasTurmaIdHelper.getIdTurmaAluno(al.getIdaluno());
                          
            } else {
                ProfessorHelper helperProfessor = new ProfessorHelper();
                Professor prof = helperProfessor.getProfessor(user.getMatricula());
                
                AlunoHasTurmaIdHelper professorHasTurmaIdHelper = new AlunoHasTurmaIdHelper();
                listMateriasId = professorHasTurmaIdHelper.getIdTurmaAluno(prof.getIdprofessor());
            }
            
            MateriaHelper materiaHelper = new MateriaHelper();
            ArrayList<Materia> materias = new ArrayList<>();
            Integer idMateria;
            for(int i=0 ; i < listMateriasId.size(); i++) {
                idMateria = listMateriasId.get(i);
                materias.add(materiaHelper.getMateria(idMateria));
            }
            String json = g.toJson(materias);
            out.println(json);
            
            
            
    
            
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
    