package servlet;

import com.google.gson.Gson;
import hibernate.AlunoAvaliacoes;
import hibernate.AlunoHasTurma;
import hibernate.AlunoHasTurmaHelper;
import hibernate.AlunoHasTurmaId;
import hibernate.AlunoHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
@WebServlet(name = "editNotas", urlPatterns = {"/editNotas"})
public class editNotas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                Scanner s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
                Gson g = new Gson();
                
                AlunoHasTurma notas = g.fromJson(s.next(), AlunoHasTurma.class);
                
                if(notas.getAps1() == null){
                    notas.setAps1(BigDecimal.ZERO);
                }
                if(notas.getAps2() == null){
                    notas.setAps2(BigDecimal.ZERO);
                }
                if(notas.getAv1() == null){
                    notas.setAv1(BigDecimal.ZERO);
                }
                if(notas.getAv2() == null){
                    notas.setAv2(BigDecimal.ZERO);
                }
                if(notas.getAv3() == null){
                    notas.setAv3(BigDecimal.ZERO);
                }                
                AlunoHasTurmaHelper alunoHasTurmaHelper = new AlunoHasTurmaHelper();
                alunoHasTurmaHelper.setNota(notas);
                
//                System.out.println(materiaEUser.getIsProf());

//                
//                if(materiaEUser.getIsProf() != true){
//                    AlunoHasTurma listMateriasId = alunoHasTurmaHelper.getAvaliacoes(materiaEUser.getTurmaMateriaIdmateria(), materiaEUser.getAlunoIdaluno());
//
//                    String json = g.toJson(listMateriasId);
//                    out.println(json);
//                }else {
//                    ArrayList<Integer> listIdAlunos = alunoHasTurmaHelper.getIdAlunos(materiaEUser.getTurmaMateriaIdmateria(), materiaEUser.getTurmaProfessorIdprofessor());
//                    
//                    ArrayList<AlunoAvaliacoes> alunos = new ArrayList<>();
//                    AlunoHelper helper = new AlunoHelper();
//                    AlunoHasTurmaHelper helperAvaliacoes = new AlunoHasTurmaHelper();
//                    
//                    for(int i=0; i < listIdAlunos.size() ; i++){
//                        AlunoAvaliacoes notas = new AlunoAvaliacoes();
//
//                        notas.setAluno(helper.getMatriculaById(listIdAlunos.get(i)));
//                        notas.setTurma(helperAvaliacoes.getAvaliacoes(materiaEUser.getTurmaMateriaIdmateria(), listIdAlunos.get(i)));
//                        alunos.add(i, notas);
//                    }
                    

//                    String json = g.toJson(alunos);
//                    out.println(json);                    
                    
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
