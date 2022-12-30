/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Auto;

/**
 *
 * @author SONY VAIO
 */
public class ModeloTablaAuto extends AbstractTableModel{
    private ListaEnlazada<Auto> lista = new ListaEnlazada<>();

    public ListaEnlazada<Auto> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Auto> lista) {
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
                return "Marca";
            case 2:
                return "Modelo";

            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Auto a = null;
        try {
            a = lista.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println("Error en getValueAt" + e);
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (a != null) ? a.getMarca(): "NO DEFINIDO";
            case 2:
                return (a != null) ? a.getModelo(): "NO DEFINIDO";
            default:
                return null;
        }
    }
}
