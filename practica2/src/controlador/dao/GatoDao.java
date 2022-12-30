/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import modelo.Gato;

/**
 *
 * @author SONY VAIO
 */
public class GatoDao extends AdaptadorDao<Gato> {
    private Gato gato;
    public GatoDao(){
        super(Gato.class);
    }

    public Gato getGato() {
        if (gato == null){
            gato = new Gato();
        }
        return gato;
    }

    public void setGato(Gato gato) {
        this.gato = gato;
    }
    
    public boolean guardar() throws Exception {
        this.gato.setId(generarId());
        guardar(this.gato);
        return true;
    }

    public boolean modificar(Integer pos) throws Exception {
        modificar(this.gato, pos);
        return true;
    }
    public Integer generarId(){
        return listar().getSize()+1;
    }
}
