/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.djaque.model;

import cl.djaque.beans.ComunaDto;
import cl.djaque.beans.RegionDto;
import cl.djaque.model.dao.MySqlComunaDao;
import cl.djaque.model.dao.MySqlRegionDao;
import java.util.List;

/**
 *
 * @author dany
 */
public class DaoManager {
    
    private final MySqlRegionDao regionDao = new MySqlRegionDao();
    private final MySqlComunaDao comunaDao = new MySqlComunaDao();
    
    public List<RegionDto> getRegiones(){
        return regionDao.getAll();
    }
    
    public RegionDto getRegion(int id) {
        return regionDao.get(id);
    }
    
    public List<ComunaDto> getComunas(int region){
        return comunaDao.getByRegion(region);
    }
    
    public ComunaDto getComuna(int id) {
        return comunaDao.get(id);
    }
}
