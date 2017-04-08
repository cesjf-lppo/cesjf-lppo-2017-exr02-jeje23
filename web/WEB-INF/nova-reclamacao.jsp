<%-- 
    Document   : nova-reclamacao
    Created on : 13/03/2017, 22:45:47
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Reclamcao</title>
    </head>
    <body>
        <h1>Reclamacao</h1>
        <form method="post">
            <label> Nome:
                <input type="text" name="nome" />
            </label></tr>
            <label> Email:
                <input type="text" name="email"  />
            </label></tr>
             <label> Descrição:
                <input type="text" name="descricao"  />
            </label>
            <label>
                Status: <select name="status" >
                    <option></option>
                    <option value="0">Aberto</option>
                    <option value="1">Confirmado</option>
                    <option value="2">Recusado</option>
                    <option value="3">Em execução</option>
                    <option value="4">Resolvido</option>
                </select><br><br>
                <input type="submit"/>
           
            </label>
            
        </form>
    </body>
</html>
