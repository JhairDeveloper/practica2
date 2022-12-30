/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Casa;

/**
 *
 * @author SONY VAIO
 */
public class ModeloTablaCasa extends AbstractTableModel{
    private ListaEnlazada<Casa> lista = new ListaEnlazada<>();

    public ListaEnlazada<Casa> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Casa> lista) {
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
                return "Direccion";

            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Casa c = null;
        try {
            c = lista.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println("Error en getValueAt" + e);
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (c != null) ? c.getNombre() : "NO DEFINIDO";
            case 2:
                return (c != null) ? c.getUbicacion() : "NO DEFINIDO";
            default:
                return null;
        }
    }
}
