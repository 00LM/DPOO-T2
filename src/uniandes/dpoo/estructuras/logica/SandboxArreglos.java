package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros(){
    	int[] nuevoArregloEnteros = new int[this.arregloEnteros.length];
    	for(int i = 0; i<this.arregloEnteros.length; i++) {
    		nuevoArregloEnteros[i] = this.arregloEnteros[i];
    	}
    	return nuevoArregloEnteros;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	String[] nuevoArregloCadenas = new String[this.arregloCadenas.length];
    	for(int i = 0; i<this.arregloCadenas.length; i++) {
    		nuevoArregloCadenas[i] = this.arregloCadenas[i];
    	}
    	return nuevoArregloCadenas;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return this.arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return this.arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {

    	int[] nuevoArregloEnteros = new int[this.arregloEnteros.length + 1];
    	for(int i = 0; i<this.arregloEnteros.length; i++) {
    		nuevoArregloEnteros[i] = this.arregloEnteros[i];
    	}
    	nuevoArregloEnteros[this.arregloEnteros.length] = entero;
    	this.arregloEnteros = nuevoArregloEnteros;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	String[] nuevoArregloCadena = new String[this.arregloCadenas.length + 1];
    	for(int i = 0; i<this.arregloCadenas.length; i++) {
    		nuevoArregloCadena[i] = this.arregloCadenas[i];
    	}
    	nuevoArregloCadena[this.arregloCadenas.length] = cadena;
    	this.arregloCadenas = nuevoArregloCadena;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int vecesValor = 0;
    	for(int i = 0; i<this.arregloEnteros.length; i++) {
    		if (this.arregloEnteros[i] == valor) {
    			vecesValor ++;
    		}
    	}
    	int[] nuevoArregloEnteros = new int[this.arregloEnteros.length - vecesValor];
    	for(int i = 0; i<this.arregloEnteros.length; i++)
    		if (this.arregloEnteros[i] != valor) {
    			nuevoArregloEnteros[i] = arregloEnteros[i];
    			i--;
    		}
    	this.arregloEnteros = nuevoArregloEnteros;

    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int vecesValor = 0;
    	for(int i = 0; i<this.arregloCadenas.length; i++) {
    		if (this.arregloCadenas[i] == cadena) {
    			vecesValor ++;
    		}
    	}
    	String[] nuevoArregloCadenas = new String[this.arregloCadenas.length - vecesValor];
    	for(int i = 0; i<this.arregloCadenas.length; i++)
    		if (this.arregloCadenas[i] != cadena) {
    			nuevoArregloCadenas[i] = arregloCadenas[i];
    		}
    	this.arregloCadenas = nuevoArregloCadenas;

    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero(int entero, int posicion) {
    	if (posicion > arregloEnteros.length) {
    		posicion = arregloEnteros.length;
    	}
    	else if (posicion < arregloEnteros.length) {
    		posicion = 0;
    	}
    	
        int[] nuevoArregloEnteros = new int[this.arregloEnteros.length + 1];
        int shift = 0; 

        for (int i = 0; i < nuevoArregloEnteros.length; i++) {
            if (i == posicion) {
                nuevoArregloEnteros[i] = entero;
                shift = 1;
            } 
            else {
                nuevoArregloEnteros[i] = this.arregloEnteros[i - shift];
            }
        }

        this.arregloEnteros = nuevoArregloEnteros;
    }


    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	int[] nuevoArregloEnteros = new int[this.arregloEnteros.length - 1];
        int shift = 0; 

        for (int i = 0; i < nuevoArregloEnteros.length; i++) {
            if (i == posicion) {
                shift = 1; 
            }
            nuevoArregloEnteros[i] = this.arregloEnteros[i + shift];
        }

        this.arregloEnteros = nuevoArregloEnteros;
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int[] nuevoAE = new int[valores.length];
    	for (int i = 0; i < nuevoAE.length; i++) {
    		nuevoAE[i] = (int) valores[i];
    	}
    	this.arregloEnteros = nuevoAE;

    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	String[] nuevoAC = new String[objetos.length];
        for (int i = 0; i < objetos.length; i++) {
        	nuevoAC[i] = objetos[i].toString();
        }
        this.arregloCadenas = nuevoAC;
    }


    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	int[] nuevoAE = new int[this.arregloEnteros.length];
    	for(int i = 0; i < this.arregloEnteros.length; i++) {
    		if (this.arregloEnteros[i] < 0) {
    			nuevoAE[i] = arregloEnteros[i]*-1;  
    		}
    		else if (this.arregloEnteros[i] >= 0) {
    			nuevoAE[i] = arregloEnteros[i];  
    		}
    	}
    	this.arregloEnteros = nuevoAE;

    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	for (int i = 1; i < this.arregloEnteros.length; i++) {
            int prev = i - 1;
            int elemento = this.arregloEnteros[i];
            while (prev >= 0 && elemento < this.arregloEnteros[prev]) {
                this.arregloEnteros[prev + 1] = this.arregloEnteros[prev];
                prev--;
            }
            this.arregloEnteros[prev + 1] = elemento;
        }

    }


    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	for (int i = 1; i < this.arregloCadenas.length; i++) {
            int prev = i - 1;
            String elemento = this.arregloCadenas[i];
            while (prev >= 0 && elemento.compareTo(arregloCadenas[prev]) < 0) {
                this.arregloCadenas[prev + 1] = this.arregloCadenas[prev];
                prev--;
            }
            this.arregloCadenas[prev + 1] = elemento;
        }

    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
        int contador = 0;
        for (int i = 0; i < this.arregloEnteros.length; i++) {
        	if (this.arregloEnteros[i] == valor) {
        		contador++;
        	}
        }
        return contador;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int contador = 0;
        for (int i = 0; i < this.arregloCadenas.length; i++) {
        	if (this.arregloCadenas[i].toLowerCase().equals(cadena)) {
        		contador++;
        	}
        }
        return contador;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {	boolean encontrado = false;
    	int contador = 0;
    	for (int i = 0; i < this.arregloEnteros.length; i++) {
			if (this.arregloEnteros[i] == valor) {
				contador++;
				encontrado = true;
			}
    	}
    	if (encontrado) {
			int k = 0;
			int[] nuevoAE = new int[contador];
			for (int j = 0; j < arregloEnteros.length; j++) {
				if (arregloEnteros[j] == valor) {
					nuevoAE[k] = j;
					k++;
				}
			}
	        return nuevoAE;
    	}
    	int[] nuevoAE = new int[0];
    	return nuevoAE;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {	int[] retorno = new int[0];
    	if (arregloEnteros.length != 0) {
	    	int minimo = 99999;
	    	int maximo = -99999;
	    	for (int i = 0; i < arregloEnteros.length; i++) {
				if (arregloEnteros[i] > maximo) {
					maximo = arregloEnteros[i];
				}
				else if (arregloEnteros[i] < minimo) {
					minimo = arregloEnteros[i];
				}
			}
	    	
	    	retorno = new int[2];
	    	retorno[0] = minimo;
	    	retorno[1] = maximo;
	    			
    }
    return retorno;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer, Integer> MapitaUWU = new HashMap<>();
        for (int i = 0; i < this.arregloEnteros.length; i++) {
            if (MapitaUWU.containsKey(this.arregloEnteros[i])) {
                int valor = MapitaUWU.get(this.arregloEnteros[i]);
                MapitaUWU.put(this.arregloEnteros[i], valor + 1);
            } 
            else {
            	MapitaUWU.put(this.arregloEnteros[i], 1);
            }
        }
        return MapitaUWU;
    }
    

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	int contador = 0;
        HashMap<Integer, Integer> MapitaUWU = calcularHistograma();

        Iterator<HashMap.Entry<Integer, Integer>> iterador = MapitaUWU.entrySet().iterator();
        while (iterador.hasNext()) {
            HashMap.Entry<Integer, Integer> pareja = iterador.next();
            if (pareja.getValue() > 1) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	if (this.arregloEnteros.length != otroArreglo.length) {
    		return false;
    	}
    	for (int i = 0; i < otroArreglo.length; i++) {
			if (this.arregloEnteros[i] != otroArreglo[i]) {
				return false;
			}
		}
    	return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	if (arregloEnteros.length != otroArreglo.length) {
            return false; 
        }
    	
    	HashMap<Integer, Integer> MapitaUWU1 = new HashMap<>();
    	HashMap<Integer, Integer> MapitaUWU2 = new HashMap<>();
        for (int num : arregloEnteros) {
        	if (!MapitaUWU1.containsKey(num)) {
        		MapitaUWU1.put(num, 1);
        	}
        	int numactual = MapitaUWU1.get(num);
        	MapitaUWU1.put(num, numactual + 1);
        }
        for (int num : otroArreglo) {
        	if (!MapitaUWU2.containsKey(num)) {
        		MapitaUWU2.put(num, 1);
        	}
        	int numactual = MapitaUWU2.get(num);
        	MapitaUWU2.put(num, numactual + 1);
        }

        return MapitaUWU1.equals(MapitaUWU2);
    }
    

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	int[] nuevaLista = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            nuevaLista[i] = minimo + (int) (Math.random() * (maximo - minimo + 1));
        }
        this.arregloEnteros = nuevaLista;
    }

}
