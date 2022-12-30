/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import modelo.Casa;

/**
 *
 * @author SONY VAIO
 */
public class CasaDao extends AdaptadorDao<Casa>{
 
    private Casa casa;
    
    public CasaDao(){
        super(Casa.class);
    }

    public Casa getCasa() {
        if(casa == null){
            casa = new Casa();
        }
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }
    
    public boolean guardar() throws Exception {
        this.casa.setId(generarId());
        guardar(this.casa);
        return true;
    }

    public boolean modificar(Integer pos) throws Exception {
        modificar(this.casa, pos);
        return true;
    }
    
    
    private Integer generarId(){
        return listar().getSize()+1;
    }
}
