/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DEEPIN
 */
public class ModeloTablaNumero extends AbstractTableModel {

    private ListaEnlazada<Float> lista = new ListaEnlazada<>();

    public ListaEnlazada<Float> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Float> lista) {
        this.lista = lista;
    }



    @Override
    public int getColumnCount() {
        return 2;
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
                return "Valor";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Float n = null;
        try {
            n = lista.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println("Error ren getValueAt");
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return n;
            default:
                return null;
        }
    }

}
