/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import modelo.Auto;

/**
 *
 * @author SONY VAIO
 */
public class AutoDao extends AdaptadorDao<Auto>{
    
    private Auto auto;
    
    public AutoDao(){
        super(Auto.class);
    }

    public Auto getAuto() {
        if(auto == null){
            auto = new Auto();
        }
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }
    
    public boolean guardar() throws Exception {
        this.auto.setId(generarId());
        guardar(this.auto);
        return true;
    }

    public boolean modificar(Integer pos) throws Exception {
        modificar(this.auto, pos);
        return true;
    }
    
    private Integer generarId(){
        return listar().getSize()+1;
    }
}
