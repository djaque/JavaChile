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
public class RegionComunaDto {
    private int idRegion;
    private int idComuna;
    private String nombreRegion;
    private String nombreComuna;

    public RegionComunaDto() {
    }

    public RegionComunaDto(int idRegion, int idCommuna, String nombreRegion, String nombreComuna) {
        this.idRegion = idRegion;
        this.idComuna = idCommuna;
        this.nombreRegion = nombreRegion;
        this.nombreComuna = nombreComuna;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public String getNombreComuna() {
        return nombreComuna;
    }

    public void setNombreComuna(String nombreComuna) {
        this.nombreComuna = nombreComuna;
    }
    
    
    
}
