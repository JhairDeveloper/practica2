/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica2;

import controlador.dao.AdaptadorDao;
import controlador.dao.CasaDao;
import controlador.dao.GatoDao;
import controlador.listas.ListaEnlazada;
import modelo.Casa;
import modelo.Gato;

/**
 *
 * @author SONY VAIO
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
//        ListaEnlazada<Float> lista = new ListaEnlazada<>();
//        lista.insertar(Float.parseFloat("6"));
//        lista.insertar(Float.parseFloat("5"));
//        lista.insertar(Float.parseFloat("7"));
//        lista.insertar(Float.parseFloat("4"));
//        lista.insertar(Float.parseFloat("1"));
//        lista.insertar(Float.parseFloat("3"));
//        ListaEnlazada<String> lista = new ListaEnlazada<>();
//        lista.insertar("dalton");
//        lista.insertar("jhair");
//        lista.insertar("alyce");
//        lista.insertar("lopez");
//        lista.insertar("velez");
//        lista.insertar("chenoa");
//        lista.imprimir();
//        System.out.println("Lista ordenada");
//        lista.ordenamientoQuickSort(null, ListaEnlazada.ASCENDENTE);
//        lista.imprimir();
        
        ListaEnlazada<Gato> casaP = new GatoDao().listar();
        casaP.imprimir();
        casaP.ordenamientoShell("nombre", ListaEnlazada.ASCENDENTE);
        casaP.imprimir();
        
        
        GatoDao<Gato> aC = new AdaptadorDao<>(Casa.class);
        
        try{
            Casa d = new Casa();
            d.setNombre("Ana's house");
            d.setPrecio(Double.parseDouble("40"));
            d.setTamanio(20.00);
            d.setUbicacion("Malacatos");
            d.setNumPisos(1);
            d.setColor("Naranja");
            aC.guardar(d);
//            Casa b = new Casa();
//            b.setNombre("Ana's house");
//            b.setNumPisos(1);
//            b.setColor("Blue");
//            aC.guardar(b);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
