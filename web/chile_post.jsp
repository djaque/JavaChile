<%-- 
    Document   : chile_post
    Created on : 22-ago-2019, 13:46:18
    Author     : dany
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Parametros enviados!</h1>
        <ul>
            <li>ID de region: ${requestScope.regionId}</li>
            <li>Nombre region ${requestScope.region.name}</li>
            
            <li>ID de comuna: ${requestScope.comunaId}</li>
            <li>Nombre comuna: ${requestScope.comuna.name}</li>
            
            <!--
                Al usar requestScope accedo a todas las variables 
                que se encuentran en el objeto request
                en este caso tengo 4 variable
                - regionId que es un String
                - communaId que es un String
                
                - region que es un objeto RegionDto
                    como RegionDto tiene un campo name lo puedo acceder directamente
                    
                - communa que es un objeto ComunaDto
                    como ComunaDto tiene un campo name lo puedo acceder directamente
                    
            -->
        </ul>
        <a href='ChileController'>Volver</a>
        <!-- Al presionar el link volver ejecuta el metodo GET del servlet -->
    </body>
</html>
