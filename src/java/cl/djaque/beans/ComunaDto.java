/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.djaque.beans;

/**
 *
 * @author dany
 */
public class ComunaDto {
    private int id;
    private int idRegion;
    private String name;

    public ComunaDto() {
    }

    public ComunaDto(int id, int idRegion, String name) {
        this.id = id;
        this.idRegion = idRegion;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
