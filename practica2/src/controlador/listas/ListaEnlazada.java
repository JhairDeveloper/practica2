/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.listas;

import controlador.listas.excepciones.AtributoException;
import controlador.listas.excepciones.ListaNullException;
import controlador.listas.excepciones.PosicionNoEncontradaException;
import controlador.utiles.Utilidades;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DEEPIN
 */
@XmlRootElement
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private Integer size;
    public static Integer ASCENDENTE = 1;
    public static Integer DESCENDENTE = 2;
    public long ascendenteShell;
    public long descendenteShell;

    public ListaEnlazada() {
        cabecera = null;
        size = 0;
        ascendenteShell = (long) 0.00;
        descendenteShell = (long) 0.00;
    }

    public ListaEnlazada busquedaLinealBinaria(String campo, String dato) throws Exception {
        ListaEnlazada<E> resultado = new ListaEnlazada<>();
        long finEjecucion = (long) 0.00;
        long inicioEjecucion = System.nanoTime();
        if (size > 0) {
            E[] arreglo = toArray();
            Class<E> clazz = (Class<E>) cabecera.getDato().getClass();
            boolean isObject = Utilidades.isObject(clazz);
            Integer inicio = 0;
            Integer fin = arreglo.length - 1;
            Integer posicion = 0;
            Float numeroBuscado = null;
            Field field = null;
            Object valor = null;
            if (campo != null) {
                field = Utilidades.obtenerAtributo(clazz, campo);
                if (field == null) {
                    System.out.println("problemm");
                    throw new AtributoException();
                }
                field.setAccessible(true);
            } else {
                numeroBuscado = (float) Float.parseFloat(dato);
                System.out.println(numeroBuscado);
            }
            while (inicio <= fin) {
                posicion = (inicio + fin) / 2;
                if (isObject) {

                    valor = field.get(arreglo[posicion]);
                    if (valor.equals(dato)) {
                        resultado.insertar(arreglo[posicion]);
                        finEjecucion = System.nanoTime();
                        System.out.println("Tiempo de ejecicion en busqueda binaria " + (finEjecucion - inicioEjecucion));
                        return resultado;
                    } else if ((arreglo[posicion]).toString().compareTo(dato) < 0) {
                        inicio = posicion + 1;
                    } else {
                        fin = posicion - 1;
                    }
                } else {
                    System.out.println("arreglo " + arreglo[posicion]);
                    if (((Number)arreglo[posicion]).floatValue() == numeroBuscado) {
                        System.out.println("Dentro de igual");
                        finEjecucion = System.nanoTime();
                        resultado.insertar(arreglo[posicion]);
                        System.out.println("Tiempo de ejecicion en busqueda binaria " + (finEjecucion - inicioEjecucion));
                        return resultado;
                    } else if (((Number)arreglo[posicion]).floatValue() < numeroBuscado) {
                        System.out.println("numeroArreglo < numeroBuscado");
                        inicio = posicion + 1;
                    } else {
                        System.out.println("else");
                        fin = posicion - 1;
                    }
                }
            }
        }
        finEjecucion = System.nanoTime();
        System.out.println("Tiempo de ejecicion en busqueda binaria " + (finEjecucion - inicioEjecucion));
        return resultado;
    }

    public ListaEnlazada busquedaSecuencial(String campo, String dato) throws Exception {
        Object a;
        long inicioEjecucion = System.nanoTime();
        ListaEnlazada<E> resultado = new ListaEnlazada<>();
        if (size > 0) {
            E[] arreglo = toArray();
            Class<E> clazz = (Class<E>) cabecera.getDato().getClass();
            boolean isObject = Utilidades.isObject(clazz);
            if (isObject) {
                Field field = Utilidades.obtenerAtributo(clazz, campo); // Agregar el parametro atributo, y completar el metodo obtener atributo
                if (field == null) {
                    throw new AtributoException();
                }
                field.setAccessible(true);
                int i = 0;
                boolean band = false;
                while (i < arreglo.length) {
                    a = field.get(arreglo[i]);
                    if (a.equals(dato)) {
                        resultado.insertar(arreglo[i]);
                        band = true;
                    }
                    i++;
                }
                if (band == false) {
                    JOptionPane.showMessageDialog(null, "El dato no se encuentra en el arreglo");
                }
            } else {
                int i = 0;
                boolean band = false;
                while (i < arreglo.length) {
                    Float x = (float) arreglo[i];
                    Float y = Float.parseFloat(dato);
                    if (Objects.equals(x, y)) {
                        resultado.insertar(arreglo[i]);
                        band = true;
                    }
                    i++;
                }
                if (band == false) {
                    JOptionPane.showMessageDialog(null, "El dato no se encuentra en el arreglo");
                }

            }

        }
        long finEjecucion = System.nanoTime();
        System.out.println("Tiempo de ejecicion en busqueda secuencial " + (finEjecucion - inicioEjecucion));

        return resultado;
    }

    public ListaEnlazada<E> ordenamientoQuickSort(String atributo, Integer tipoOrdenacion) throws Exception {
        Class<E> clazz = null;
        E[] arreglo = toArray();
        long inicioEjecucion = System.nanoTime();
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            if (isObject) {
                ordenarQuickNoPrimitivo(arreglo, atributo, clazz, 0, arreglo.length - 1, tipoOrdenacion);
            } else {
                ordenarQuickPrimitivo(arreglo, 0, arreglo.length - 1, tipoOrdenacion);
            }
        }
        long finEjecucion = System.nanoTime();
        System.out.println("Timpo de ejecucion del algoritmo shell es: " + (finEjecucion - inicioEjecucion));
        return this;
    }

    public void ordenarQuickNoPrimitivo(E[] arreglo, String atributo, Class clazz, Integer posicionInicial, Integer posicionFinal, Integer tipoOrdenacion)
            throws Exception {
        Field field = null;
        field = Utilidades.obtenerAtributo(clazz, atributo); // Agregar el parametro atributo, y completar el metodo obtener atributo
        if (field == null) {
            throw new AtributoException();
        }
        field.setAccessible(true);
        int i, j;
        E auxiliar, pivote;
        i = posicionInicial;
        j = posicionFinal;
        pivote = arreglo[posicionInicial + posicionFinal / 2];
        Boolean bandera = true;
        do {
            bandera = false;
            Integer[] indices = intercambioQuickSort(i, j, arreglo, field, pivote, tipoOrdenacion);
            i = (int) indices[0];
            j = (int) indices[1];
            if (i <= j) {
                auxiliar = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = auxiliar;
                i++;
                j--;
                bandera = true;
            }
        } while (i <= j && bandera == true);

        if (posicionInicial < j) {
            ordenarQuickNoPrimitivo(arreglo, atributo, clazz, posicionInicial, j, tipoOrdenacion);
        }
        if (i < posicionFinal) {
            if (tipoOrdenacion == DESCENDENTE) {
                ordenarQuickNoPrimitivo(arreglo, atributo, clazz, i - 1, posicionFinal, tipoOrdenacion);
            } else {
                ordenarQuickNoPrimitivo(arreglo, atributo, clazz, i - 1, posicionFinal, tipoOrdenacion);
            }
        }
        if (arreglo != null) {
            toList(arreglo);
        }

    }

    public E[] ordenarQuickPrimitivo(E[] arreglo, Integer posicionInicial, Integer posicionFinal, Integer tipoOrdenacion)
            throws Exception {
        if (posicionInicial >= posicionFinal) {
            toList(arreglo);
            return arreglo;
        }
        int i, j, pivote;
        E auxiliar;
        i = posicionInicial;
        j = posicionFinal;
        if (posicionInicial != posicionFinal) {
            pivote = posicionInicial;
            while (posicionInicial != posicionFinal) {
                if (tipoOrdenacion == ASCENDENTE) {
                    while (((Number) arreglo[posicionFinal]).doubleValue() >= ((Number) arreglo[pivote]).doubleValue()
                            && posicionInicial < posicionFinal) {
                        posicionFinal--;
                        while (((Number) arreglo[posicionInicial]).doubleValue() < ((Number) arreglo[pivote]).doubleValue()
                                && posicionInicial < posicionFinal) {
                            posicionInicial++;
                        }
                    }
                } else {
                    while (((Number) arreglo[posicionFinal]).doubleValue() <= ((Number) arreglo[pivote]).doubleValue()
                            && posicionInicial < posicionFinal) {
                        posicionFinal--;
                        while (((Number) arreglo[posicionInicial]).doubleValue() > ((Number) arreglo[pivote]).doubleValue()
                                && posicionInicial < posicionFinal) {
                            posicionInicial++;
                        }
                    }
                }
                if (posicionInicial != posicionFinal ) {
                    auxiliar = arreglo[posicionFinal];
                    arreglo[posicionFinal] = arreglo[posicionInicial];
                    arreglo[posicionInicial] = auxiliar;
                }
                if (posicionInicial == posicionFinal) {
                    ordenarQuickPrimitivo(arreglo, i, posicionInicial - 1, tipoOrdenacion);
                    ordenarQuickPrimitivo(arreglo, posicionInicial + 1, j, tipoOrdenacion);
                }
            }
        } else {
            toList(arreglo);
            return arreglo;
        }
        toList(arreglo);
        return arreglo;

    }

    public Integer[] intercambioQuickSort(int i, int j, E[] arreglo, Field field, E pivote, Integer tipoOrdenacion) throws Exception {
        Class clazz = pivote.getClass();
        Integer[] indices = new Integer[2];
        Object a = null, b = null, piv;
        a = arreglo[i];
        b = arreglo[j];
        if (field != null) {
            a = field.get(a);
            b = field.get(b);
            pivote = (E) field.get(pivote);
        }

        if (Utilidades.isNumber(clazz)) {
            if (tipoOrdenacion == DESCENDENTE) {
                System.out.println("tipo de ordenacion : " + tipoOrdenacion);
                while (((Number) arreglo[i]).doubleValue() < ((Number) pivote).doubleValue()) {
                    i++;
                    if (field != null) {
                        a = field.get((Object) arreglo[i]);
                    } else {
                        a = arreglo[i];
                    }
                }
                while (((Number) arreglo[j]).doubleValue() > ((Number) pivote).doubleValue()) {
                    j--;
                    if (field != null) {
                        b = field.get((Object) arreglo[j]);
                    } else {
                        b = arreglo[j];
                    }
                }
            } else {
                while (((Number) arreglo[i]).doubleValue() < ((Number) pivote).doubleValue()) {
                    i++;
                    if (field != null) {
                        a = field.get((Object) arreglo[i]);
                    } else {
                        a = arreglo[i];
                        System.out.println("a  " + a.toString() + " i " + i);

                    }
                }
                while (((Number) arreglo[j]).doubleValue() > ((Number) pivote).doubleValue()) {
                    j--;
                    if (field != null) {
                        b = field.get((Object) arreglo[j]);
                    } else {
                        b = arreglo[j];
                        System.out.println("b  " + a.toString() + " j " + j);
                    }
                }
            }
        }
        if (Utilidades.isString(clazz) || field != null) {
            if (tipoOrdenacion == DESCENDENTE) {
                while (a.toString().toLowerCase().compareTo(pivote.toString().toLowerCase()) > 0) {
                    i++;
                    if (field != null) {
                        a = field.get((Object) arreglo[i]);
                    } else {
                        a = arreglo[i];
                    }
                }
                while (b.toString().toLowerCase().compareTo(pivote.toString().toLowerCase()) < 0) {
                    j--;
                    if (field != null) {
                        b = field.get((Object) arreglo[j]);
                    } else {
                        b = arreglo[j];
                    }
                }
            } else {
                while (a.toString().toLowerCase().compareTo(pivote.toString().toLowerCase()) < 0) {
                    i++;
                    if (field != null) {
                        a = field.get((Object) arreglo[i]);
                    } else {
                        a = arreglo[i];
                    }
                }
                while (b.toString().toLowerCase().compareTo(pivote.toString().toLowerCase()) > 0) {
                    j--;
                    if (field != null) {
                        b = field.get((Object) arreglo[j]);
                    } else {
                        b = arreglo[j];
                    }
                }
            }
        }
        indices[0] = i;
        indices[1] = j;
        return indices;
    }

    public ListaEnlazada<E> ordenamientoShell(String atributo, Integer tipoOrdenamiento) throws Exception {
        Class<E> clazz = null;
        long inicioEjecucion = System.nanoTime();
        E[] arreglo = toArray();
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            if (isObject) {
                ordenarShellNoPrimitivo(arreglo, atributo, clazz, tipoOrdenamiento);
            } else {
                ordenarShellPrimitivo(arreglo, tipoOrdenamiento);
            }
        }
        long finEjecucion = System.nanoTime();
        if (ascendenteShell == 0.00) {
            ascendenteShell = finEjecucion - inicioEjecucion;
        } else {
            descendenteShell = finEjecucion - inicioEjecucion;
        }
        System.out.println("Tiempo de ejecicion en shell " + (finEjecucion - inicioEjecucion));
        return this;
    }

    public void ordenarShellNoPrimitivo(E[] arreglo, String atributo, Class clazz, Integer tipoOrdenamiento) throws Exception {
        Object a, b;
        Field field = Utilidades.obtenerAtributo(clazz, atributo); // Agregar el parametro atributo, y completar el metodo obtener atributo
        if (field == null) {
            throw new AtributoException();
        }

        field.setAccessible(true);
        for (int salto = arreglo.length / 2; salto > 0; salto /= 2) {
            for (int i = salto; i < arreglo.length; i++) {
                int j = i;
                E aux1 = arreglo[j];
                E aux2 = arreglo[j - salto];
                a = field.get(aux1);
                b = field.get(aux2);
                while (j >= salto && !(a.equals(b))) {
                    a = field.get(aux1);
                    b = field.get(aux2);
                    intercambioShell(j, salto, arreglo, a, b, tipoOrdenamiento);
                    j -= salto;
                }
            }
        }
        if (arreglo != null) {
            toList(arreglo);
        }
    }

    public void intercambioShell(int j, int salto, E[] arreglo, Object auxJ, Object auxJ1, Integer tipoOrdenacion) {
        Class clazz = auxJ.getClass();
//        System.out.println(clazz.getName());
        if (Utilidades.isNumber(clazz)) {
            if (tipoOrdenacion == ASCENDENTE) {
                if (((Number) auxJ).doubleValue() < ((Number) auxJ1).doubleValue()) {
                    E temp = arreglo[j];
                    arreglo[j] = arreglo[j - salto];
                    arreglo[j - salto] = (E) temp;
                }
            } else {
                if (((Number) auxJ).doubleValue() > ((Number) auxJ1).doubleValue()) {
                    E temp = arreglo[j];
                    arreglo[j] = arreglo[j - salto];
                    arreglo[j - salto] = (E) temp;
                }
            }
        }
        if (Utilidades.isString(clazz)) {
            if (tipoOrdenacion == ASCENDENTE) {
                if (auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase()) < 0) {
                    E temp = arreglo[j];
                    arreglo[j] = arreglo[j - salto];
                    arreglo[j - salto] = (E) temp;
                }
            } else {
                if (auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase()) > 0) {
                    E temp = arreglo[j];
                    arreglo[j] = arreglo[j - salto];
                    arreglo[j - salto] = (E) temp;
                }
            }

        }
    }

    public void ordenarShellPrimitivo(E[] arreglo, Integer tipoOrdenacion) {
        for (int salto = arreglo.length / 2; salto > 0; salto /= 2) {
            for (int i = salto; i < arreglo.length; i++) {
                int j = i;
                E a = arreglo[j];
                E b = arreglo[j - salto];
                while (j >= salto && !(a.equals(b))) {
                    a = arreglo[j];
                    b = arreglo[j - salto];
                    intercambioShell(j, salto, arreglo, a, b, tipoOrdenacion);
                    j -= salto;
                }
            }
        }
        if (arreglo != null) {
            toList(arreglo);
        }
    }

    // mediante listas ordenarlo
    //ordenar mediante arrays
    public E[] toArray() {
        //Class<E> clazz = null;
        E[] matriz = null;
        if (this.size > 0) {
            matriz = (E[]) Array.newInstance(cabecera.getDato().getClass(), this.size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.size; i++) {
                matriz[i] = aux.getDato();
                aux = aux.getSiguiente();
            }
        }
        return matriz;
    }

    public ListaEnlazada<E> toList(E[] matriz) {
        this.vaciar();
        for (int i = 0; i < matriz.length; i++) {
            this.insertar(matriz[i]);
        }
        return this;
    }

    public void vaciar() {
        this.cabecera = null;
        this.size = 0;
    }

    public ListaEnlazada<E> burbuja(String atributo, Integer tipoOrdenacion) throws Exception {
        Class<E> clazz = null;
        E[] matriz = toArray();
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            for (int i = matriz.length; i > 1; i--) {
                for (int j = 0; j < i - 1; j++) {
                    if (isObject) {
                        intercambioObjeto(j, matriz, clazz, tipoOrdenacion, atributo);
                    } else {
                        intercambioDato(j, matriz, clazz, tipoOrdenacion);
                    }
                }
            }

        }
        if (matriz != null) {
            toList(matriz);
        }
        return this;
    }

    public void intercambio(int j, E[] matriz, Object auxJ, Object auxJ1, Integer tipoOrdenacion) {
        Class clazz = auxJ.getClass();
        E a = matriz[j];
        E b = matriz[j + 1];
//        System.out.println(clazz.getName());
        if (Utilidades.isNumber(clazz)) {
            if (tipoOrdenacion == DESCENDENTE) {
                if (((Number) auxJ).doubleValue() < ((Number) auxJ1).doubleValue()) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            } else {
                if (((Number) auxJ).doubleValue() > ((Number) auxJ1).doubleValue()) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            }
        }
        if (Utilidades.isString(clazz)) {
            if (tipoOrdenacion == DESCENDENTE) {
                if (auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase()) < 0) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            } else {
                if (auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase()) > 0) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            }

        }
    }

    private void intercambioDato(int j, E[] matriz, Class clazz, Integer tipoOrdenacion) {
        E auxJ = matriz[j];
        E auxJ1 = matriz[j + 1];
        intercambio(j, matriz, auxJ, auxJ1, tipoOrdenacion);

    }

    private void intercambioObjeto(int j, E[] matriz, Class clazz, Integer tipoOrdenacion, String atributo) throws Exception {
        E auxJ = matriz[j];
        E auxJ1 = matriz[j + 1];
        Field field = Utilidades.obtenerAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        }
        field.setAccessible(true);
        Object a = field.get(auxJ);
        Object b = field.get(auxJ1);
//        System.out.println(field);
        intercambio(j, matriz, a, b, tipoOrdenacion);
        //intercambio(j, matriz, auxJ, auxJ1, tipoOrdenacion);

    }
    //implent burble method

    public Boolean estaVacia() {
        return cabecera == null;
    }

    public void insertar(E dato) {
        NodoLista<E> nodo = new NodoLista<>(dato, null);
        if (estaVacia()) {
            this.cabecera = nodo;

        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
        size++;

    }

    public void insertarCabecera(E dato) {

        if (estaVacia()) {
            insertar(dato);
        } else {
            NodoLista<E> nodo = new NodoLista<>(dato, null);
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
            size++;
        }
    }

    public void insertarPosicion(E dato, Integer pos) throws PosicionNoEncontradaException {
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            if (pos == (size - 1)) {
                insertar(dato);
            } else if (pos == 0) {
                insertarCabecera(dato);
            } else {
                NodoLista<E> nodo = new NodoLista(dato, null);
                NodoLista<E> aux = cabecera;
                for (int i = 0; i < (pos - 1); i++) {
                    aux = aux.getSiguiente();
                }
                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nodo);
                nodo.setSiguiente(siguiente);
                size++;
            }

        } else {
            throw new PosicionNoEncontradaException();
        }
    }

    public void imprimir() {
        System.out.println("----------------------LISTA ENLAZADA----------------------");
        NodoLista<E> aux = cabecera;
        while (aux != null) {
            System.out.print(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();

        }
        System.out.println("\n----------------------------------------------------------");
    }

    public E obtener(Integer pos) throws ListaNullException, PosicionNoEncontradaException {

        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }
            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaNullException();
        }
        //return dato;

    }

    public void modificar(E dato, Integer pos) throws PosicionNoEncontradaException {
        if (!estaVacia()) {
            insertar(dato);

        } else if (pos >= 0 && pos < size) {
            if (pos == 0) {
                cabecera.setDato(dato);
            } else {
                NodoLista<E> aux = cabecera;
                for (int i = 0; i < pos; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setDato(dato);
            }

        } else {
            throw new PosicionNoEncontradaException();
        }

    }

    public E eliminar(Integer pos) throws ListaNullException, PosicionNoEncontradaException {

        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    size--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    size--;
                }
            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaNullException();
        }
    }

    public ListaEnlazada<E> order_seleccion(String atributo, Integer tipoOrdenacion) throws Exception {
        Class<E> clazz = null;
        E[] array = toArray();
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            //comienza algoritmo seleccion
            Integer i, j, k = 0;
            Integer n = array.length;
            E t = null;
            for (i = 0; i < n - 1; i++) { //Verificar si esta bien
                k = i;
                t = array[i];
                for (j = i + 1; j < n; j++) {
                    E auxj1 = array[j];
                    Object[] aux = null;
                    if (isObject) {
                        aux = evaluarCambioObjeto(t, auxj1, j, tipoOrdenacion, clazz, atributo);
                    } else {
                        aux = evaluarCambioDato(t, auxj1, j, tipoOrdenacion);

                    }

                    if (aux[0] != null) {
                        t = (E) aux[0];
                        k = (Integer) aux[1];
                    }

                }
                array[k] = array[i];
                array[i] = t;
            }
        }

        if (array != null) {
            toList(array);
        }
        return this;
    }

    private Object[] evaluarCambioDato(E auxj, E auxj1, Integer j, Integer tipoOrdenacion) {
        return evaluarCambio(auxj, auxj1, auxj1, j, tipoOrdenacion);
    }

    private Object[] evaluarCambioObjeto(E auxj, E auxj1, Integer j, Integer tipoOrdenacion, Class clazz, String atributo) throws Exception {
        Field field = Utilidades.obtenerAtributo(clazz, atributo); // Agregar el parametro atributo, y completar el metodo obtener atributo
        if (field == null) {
            throw new AtributoException();
        }
        field.setAccessible(true);
        Object a = field.get(auxj);
        Object b = field.get(auxj1);
        return evaluarCambio(a, b, auxj1, j, tipoOrdenacion);
    }

    private Object[] evaluarCambio(Object auxj, Object auxj1, E dato, Integer j, Integer tipoOrdenacion) {
        Object[] aux = new Object[2];
        Class clazz = auxj.getClass();
        if (Utilidades.isNumber(clazz)) {
            if (tipoOrdenacion == DESCENDENTE) {
                if (((Number) auxj).doubleValue() < ((Number) auxj1).doubleValue()) {
                    aux[0] = dato;
                    aux[1] = j;
                }
            } else {
                if (((Number) auxj).doubleValue() > ((Number) auxj1).doubleValue()) {
                    aux[0] = dato;
                    aux[1] = j;
                }
            }

        }

        if (Utilidades.isString(clazz)) {
            if (tipoOrdenacion == DESCENDENTE) {
                if (((String) auxj).compareToIgnoreCase((String) auxj1) < 0) {
                    aux[0] = dato;
                    aux[1] = j;
                }
            } else {
                if (((String) auxj).compareToIgnoreCase((String) auxj1) > 0) {
                    aux[0] = dato;
                    aux[1] = j;
                }
            }

        }
        if (Utilidades.isCharacter(clazz)) {
            if (tipoOrdenacion == DESCENDENTE) {
                if (((Character) auxj).toString().compareToIgnoreCase(((Character) auxj1).toString()) < 0) {
                    aux[0] = dato;
                    aux[1] = j;
                }
            } else {
                if (((Character) auxj).toString().compareToIgnoreCase(((Character) auxj1).toString()) > 0) {
                    aux[0] = dato;
                    aux[1] = j;
                }
            }
        }
        if (Utilidades.isString(clazz)) {
            if (tipoOrdenacion == DESCENDENTE) {
                if (auxj.toString().toLowerCase().compareTo(auxj1.toString().toLowerCase()) < 0) {
                    aux[0] = dato;
                    aux[1] = j;
                }
            } else {
                if (auxj.toString().toLowerCase().compareTo(auxj1.toString().toLowerCase()) > 0) {
                    aux[0] = dato;
                    aux[1] = j;
                }
            }
        }
        return aux;
    }

    //BUSQUEDA
    public ListaEnlazada<E> buscar(String atributo, Object dato) throws Exception {
        Class<E> clazz = null;
        ListaEnlazada<E> result = new ListaEnlazada<>();
        if (size > 0) {
            //opcional pueden ordenar
            E[] array = toArray();
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);

            for (int i = 0; i < array.length; i++) { //Verificar si esta bien
                if (isObject) {
                    //cuando es objeto
                    Boolean band = evaluarBusquedaObjeto(array[i], dato, clazz, atributo);
                    if (band) {
                        result.insertar(array[i]);
                    }
                } else {
                    //cuando son datos primitivos
                    Boolean band = buscarPosicion(array[i], dato);
                    if (band) {
                        result.insertar(array[i]);
                    }
                }
            }
        }
        return result;
    }

    private Boolean buscarPosicion(Object datoMatriz, Object busqueda) {
        //TODO 
        //FALTA IMPLEMENTAR MAS FATOS --- ENUMS
        if (Utilidades.isNumber(busqueda.getClass())) {
            if (((Number) datoMatriz).doubleValue() == ((Number) busqueda).doubleValue()) {
                return true;
            }
        } else if (Utilidades.isString(busqueda.getClass())) {
            if (datoMatriz.toString().toLowerCase().startsWith(busqueda.toString().toLowerCase())
                    || datoMatriz.toString().toLowerCase().endsWith(busqueda.toString().toLowerCase())
                    || datoMatriz.toString().toLowerCase().equalsIgnoreCase(busqueda.toString().toLowerCase())
                    || datoMatriz.toString().toLowerCase().contains(busqueda.toString().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private Boolean evaluarBusquedaObjeto(E aux, Object dato, Class clazz, String atributo) throws Exception {
        Field field = Utilidades.obtenerAtributo(clazz, atributo); // Agregar el parametro atributo, y completar el metodo obtener atributo
        if (field == null) {
            throw new AtributoException();
        }
        field.setAccessible(true);
        Object a = field.get(aux);
        return buscarPosicion(a, dato);
    }

    //Getter and Setter
    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getSize() {
//        this.size = tamanio();
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
