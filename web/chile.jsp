<%-- 
    Document   : requerimiento
    Created on : 18-ago-2019, 22:30:05
    Author     : dany
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingresar requerimiento</h1>
        
        <form action="ChileController" method="get">
            <table>
                <tr>
                    <td>Región</td>
                    <td>
                        <select name="regionId" onchange="this.form.submit()">
                            <option value="0">Seleccionar</option>
                            <c:forEach items="${requestScope.regiones}" var="item"> 
                                <option value="${item.id}" ${requestScope.regionId==item.id?"selected":""} >
                                    ${item.name}
                                </option>
                            </c:forEach>
                        </select>
                        
 
                    </td>
                </tr>
                <tr>
                    <td>Comuna</td>
                    <td>
                        <select name="comunaId">
                            <option value="0">Seleccionar</option>
                            <c:forEach items="${requestScope.comunas}" var="item"> 
                                <option value="${item.id}" ${requestScope.comunaId==item.id?"selected":""} >${item.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                
                
            </table>
            <!--
                Para cambiar de methodo usar Javascript
                En el metodo onclick del input
                - Cambia el metodo a post
                    this.form.method='POST'
                - Envia el formulario
                    this.form.submit()
            -->
            <input type="button" value="Enviar" onclick="this.form.method='POST';this.form.submit()">
        </form>
        
    </body>
</html>
