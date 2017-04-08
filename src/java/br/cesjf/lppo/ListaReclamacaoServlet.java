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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ListaReclamacaoServlet", urlPatterns = {"/lista.html"})
public class ListaReclamacaoServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Reclamacao> reclamacoes = new ArrayList<>();
        
        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527//lppo-2017-1", "usuario", "senha");
             
             Statement operacao = conexao.createStatement();
             ResultSet resultado = operacao.executeQuery("SELECT * FROM reclamacao");
                while(resultado.next()){
                    Reclamacao reclamacaoAtual = new Reclamacao();
                    reclamacaoAtual.setId(resultado.getLong("id"));
                    reclamacaoAtual.setNome(resultado.getString("nome"));
                    reclamacaoAtual.setEmail(resultado.getString("email"));
                    reclamacaoAtual.setDescricao(resultado.getString("descricao"));
                    reclamacaoAtual.setStatus(resultado.getInt("status"));
                    
                    reclamacoes.add(reclamacaoAtual);
                    
                            
                }
             
             
             
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaReclamacaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaReclamacaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("reclamacoes", reclamacoes);
        request.getRequestDispatcher("WEB-INF/lista-reclamacao.jsp").forward(request, response);
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
   

}
