/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.djaque.model.dao;

import cl.djaque.beans.RegionComunaDto;
import cl.djaque.beans.RegionDto;
import cl.djaque.model.db.MysqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.catalina.realm.NullRealm;

/**
 *
 * @author dany
 */
public class MySqlRegionDao {

    final String SELECTALL = "SELECT * FROM region";
    final String SELECTBYID = "SELECT * FROM region WHERE id = ?";

    final String SELECTREGIONCOMUNA = ""
            + "SELECT "
            + "	r.id as regionId, "
            + " r.name as regionName, "
            + " c.id as comunaId, "
            + " c.name as comunaName "
            + "FROM chile.region r, chile.comuna c "
            + "WHERE r.id = c.idregion ";
       
    final String SELECTREGIONCOMUNABYREGION = ""
            + "SELECT "
            + "	r.id as regionId, "
            + " r.name as regionName, "
            + " c.id as comunaId, "
            + " c.name as comunaName "
            + "FROM chile.region r, chile.comuna c "
            + "WHERE r.id = c.idregion AND r.id = ?";
            
    
    /**
     * Obtiene todos las regiones
     *
     * @return List<RegionDto>
     */
    public List<RegionDto> getAll() {
        List<RegionDto> lu = new ArrayList<>();
        Connection conn = null;
        Statement ps = null;
        try {
            conn = MysqlConnection.open();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(this.SELECTALL);
            while (rs.next()) {
                RegionDto u = new RegionDto();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));

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
     * Obtiene una region por el ID
     *
     * @param region id de la region
     * @return RegionDto
     */
    public RegionDto get(int region) {
        RegionDto r = null;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = MysqlConnection.open();
            ps = conn.prepareStatement(this.SELECTBYID);
            ps.setInt(1, region);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                r = new RegionDto();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
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
        return r;
    }

    public List<RegionComunaDto> getAllRegionCommuna() {
        List<RegionComunaDto> lrc = new ArrayList<>();
        Connection conn = null;
        Statement ps = null;
        try {
            conn = MysqlConnection.open();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(this.SELECTREGIONCOMUNA);
            while (rs.next()) {
                RegionComunaDto rc = new RegionComunaDto();
                rc.setIdRegion(rs.getInt("regionId"));
                rc.setIdComuna(rs.getInt("comunaId"));
                rc.setNombreComuna(rs.getString("comunaName"));
                rc.setNombreRegion(rs.getString("regionName"));
                lrc.add(rc);
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
        return lrc;
    }
    
    public List<RegionComunaDto> getRegionCommuna(int idRegion) {
        List<RegionComunaDto> lrc = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = MysqlConnection.open();
            ps = conn.prepareStatement(this.SELECTREGIONCOMUNABYREGION);
            ps.setInt(1, idRegion);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RegionComunaDto rc = new RegionComunaDto();
                rc.setIdRegion(rs.getInt("regionId"));
                rc.setIdComuna(rs.getInt("comunaId"));
                rc.setNombreComuna(rs.getString("comunaName"));
                rc.setNombreRegion(rs.getString("regionName"));
                lrc.add(rc);
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
        return lrc;
    }
}
