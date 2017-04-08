/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(name = "NovaReclamacaoServlet", urlPatterns = {"/novo.html"})
public class NovaReclamacaoServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //de onde vem
        request.getRequestDispatcher("WEB-INF/nova-reclamacao.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String descricao = request.getParameter("descricao");
        int status = Integer.parseInt(request.getParameter("status"));
        
      Logger.getLogger(NovaReclamacaoServlet.class.getName()).log(Level.INFO, "POST: " +nome+" "+email+" "+descricao+" "+status);
       try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
             String url = "jdbc:derby://localhost:1527//lppo-2017-1";  
             Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
             System.out.println("Conexao aberta com sucesso");
             
             String sql = " INSERT INTO reclamacao (nome, email, descricao, status) VALUES('"
                     +nome+ "' , '"
                     +email+ "' , '"
                     +descricao+"', "
                     +status+")";
             Statement operacao = conexao.createStatement();
             operacao.executeUpdate(sql);
               
             

             
        } catch (Exception e) {
            Logger.getLogger(NovaReclamacaoServlet.class.getName()).log(Level.SEVERE, "Erro ao inserir o registro!" +e);
            
            
        }
            response.sendRedirect("lista.html");
      
       
    }

  
}
