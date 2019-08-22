/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.djaque.model.dao;

import cl.djaque.beans.ComunaDto;
import cl.djaque.beans.RegionDto;
import cl.djaque.model.db.MysqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dany
 */
public class MySqlComunaDao  {

    final String SELECTALL = "SELECT * FROM comuna";
    final String SELECTBYREGION = "SELECT * FROM comuna WHERE idregion = ?";
    final String SELECTBYID = "SELECT * FROM comuna WHERE id = ?";
    
    /**
     * Obtiene todas las comunas sin filtro
     * @return List<ComunaDto>
     */
    public List<ComunaDto> getAll() {
        List<ComunaDto> lu = new ArrayList<>();
        Connection conn = null;
        Statement ps = null;
        try {
            conn = MysqlConnection.open();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(this.SELECTALL);
            while (rs.next()) {
                ComunaDto u = new ComunaDto();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setIdRegion(rs.getInt("idregion"));
                
                lu.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL" + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error Closing" + ex.getMessage());
            }
        }
        return lu;
    }
    
    /**
     * Obtiene un listado de comunas de una region
     * @param region id de la region 
     * @return List<ComunaDto>
     */
    public List<ComunaDto> getByRegion(int region) {
        List<ComunaDto> lu = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = MysqlConnection.open();
            ps = conn.prepareStatement(this.SELECTBYREGION);
            ps.setInt(1, region);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ComunaDto u = new ComunaDto();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setIdRegion(rs.getInt("idregion"));
                
                lu.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL" + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error Closing" + ex.getMessage());
            }
        }
        return lu;
    }

    /**
     * Obtiene una comuna por ID de comuna
     * @param id id de la comuna a buscar
     * @return ComunaDto
     */
    public ComunaDto get(int id) {
        ComunaDto comunaDto = null;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = MysqlConnection.open();
            ps = conn.prepareStatement(this.SELECTBYID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                comunaDto = new ComunaDto();
                comunaDto.setId(rs.getInt("id"));
                comunaDto.setName(rs.getString("name"));
                comunaDto.setIdRegion(rs.getInt("idregion"));
               }
        } catch (SQLException ex) {
            System.out.println("Error SQL" + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error Closing" + ex.getMessage());
            }
        }
        return comunaDto;
    }
   

}
