package cl.djaque.controllers;

import cl.djaque.beans.ComunaDto;
import cl.djaque.beans.RegionComunaDto;
import cl.djaque.beans.RegionDto;
import cl.djaque.model.DaoManager;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dany
 */
public class ChileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // DaoManager es un servicio que entrega los elementos usando los otros dao
        DaoManager dm = new DaoManager();

        // Obtiene la lista que no necesitan filtro
        List<RegionDto> regiones = dm.getRegiones();

        // Envia la lista al request para el formulario
        request.setAttribute("regiones", regiones);

        // Obtiene los datos si se enviaron
        String regionId = request.getParameter("regionId");

        // Persiste los valores que se enviaron para preseleccionar
        request.setAttribute("regionId", regionId);

        // Verifico q regionId existe
        if (regionId != null) {
            // Solo si existe regionId busco las comunas
            int id = Integer.parseInt(regionId);
            List<ComunaDto> comunas = dm.getComunas(id);
            request.setAttribute("comunas", comunas);
        }

        // Obtengo otros campos solo para persistencia
        String comunaId = request.getParameter("comunaId");

        // Los envio al formulario de vuelta
        request.setAttribute("comunaId", comunaId);

        // Todas las regiones con comunas
        List<RegionComunaDto> lrc = dm.getAllRegionComuna();
        request.setAttribute("regionescomunas", lrc);
        
        
        // Ejecuta el jsp
        request.getRequestDispatcher("chile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // DaoManager es un servicio que entrega los elementos usando los otros dao
        DaoManager dm = new DaoManager();

        // Obtiene los datos si se enviaron
        String regionId = request.getParameter("regionId");
        String comunaId = request.getParameter("comunaId");

        // Reenvia los parametros para el siguiente JSP
        request.setAttribute("regionId", regionId);
        request.setAttribute("comunaId", comunaId);

        if (regionId != null) {
            // Si recibo el regionId busco el objeto en la BD
            int id = Integer.parseInt(regionId);
            RegionDto regionDto = dm.getRegion(id);

            // Lo envio al request para usarlo en el JSP
            request.setAttribute("region", regionDto);
        }

        if (comunaId != null) {
            // Si recibo un comunaId lo busco en la BD
            int id = Integer.parseInt(comunaId);
            ComunaDto comunaDto = dm.getComuna(id);
            // Lo envio al request para usarlo en el JSP
            request.setAttribute("comuna", comunaDto);
        }

        // Ejecuta el jsp
        request.getRequestDispatcher("chile_post.jsp").forward(request, response);
    }

}
