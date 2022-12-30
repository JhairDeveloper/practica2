/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Gato;

/**
 *
 * @author SONY VAIO
 */
public class ModeloTablaGato extends AbstractTableModel{

    private ListaEnlazada<Gato> lista = new ListaEnlazada<>();

    public ListaEnlazada<Gato> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Gato> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nro";
            case 1:
                return "Nombre";
            case 2:
                return "Raza";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Gato g = null;
        try {
            g = lista.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println("Problema en getAtValue " + e);
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (g != null) ? g.getNombre() : "NO DEFINIDO";
            case 2:
                return (g != null) ? g.getRaza() : "NO DEFINIDO";
            default:
                return null;
        }
     }
}
