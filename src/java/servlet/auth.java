package servlet;

import com.google.gson.Gson;
import hibernate.Aluno;
import hibernate.AlunoHelper;
import hibernate.Authorization;
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
@WebServlet(name = "auth", urlPatterns = {"/auth"})
public class auth extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Scanner s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
            Gson g = new Gson();

            AlunoHelper helperAluno = new AlunoHelper();
            Aluno aluno = g.fromJson(s.next(), Aluno.class);
            
            Authorization auth = new Authorization();
            auth.setAuth(false);
            
            ArrayList<Aluno> listaAluno = helperAluno.getAlunos();
            for(int i=0; i < listaAluno.size(); i++){
                if(listaAluno.get(i).getSenha().equals(aluno.getSenha()) && 
                    listaAluno.get(i).getMatricula().equals(aluno.getMatricula())){
                    auth.setMatricula(listaAluno.get(i).getMatricula());
                    auth.setNome(listaAluno.get(i).getNome());
                    auth.setAuth(true);
                    auth.setId(listaAluno.get(i).getIdaluno());
                    auth.setIsProf(false);

                    break;
                }
            };

            if(auth.getAuth() == false){
                Professor professor = new Professor();
                professor.setMatricula(aluno.getMatricula());
                professor.setSenha(aluno.getSenha());
                   
                ProfessorHelper helperProfessor = new ProfessorHelper();
                ArrayList<Professor> listaProfessor = helperProfessor.getProfessores();
                
                for(int i=0; i < listaProfessor.size(); i++){
                if(listaProfessor.get(i).getSenha().equals(professor.getSenha()) && 
                    listaProfessor.get(i).getMatricula().equals(professor.getMatricula())){
                    auth.setMatricula(listaProfessor.get(i).getMatricula());
                    auth.setNome(listaProfessor.get(i).getNome());
                    auth.setAuth(true);
                    auth.setIsProf(true);
                    auth.setId(listaProfessor.get(i).getIdprofessor());
                    break;
                }
                };
            }

            String json = g.toJson(auth);
                
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