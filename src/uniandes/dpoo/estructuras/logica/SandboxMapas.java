package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>();
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
    	List<String> nuevaL = new ArrayList<>(mapaCadenas.values());
        nuevaL.sort(null);
		return nuevaL;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
    	List<String> nuevaL = new ArrayList<>(mapaCadenas.keySet());
    	Collections.sort(nuevaL,Collections.reverseOrder());
		return nuevaL;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
    	List<String> nuevaL = getValoresComoLista();
        if (nuevaL.size() > 0) {
    		return nuevaL.get(0);
        }
        return null;
    }
    

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	List<String> nuevaL = getValoresComoLista();
        if (nuevaL.size() > 0) {
    		return nuevaL.get(nuevaL.size()-1);
        }
        return null;
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	Collection<String> llaves =  mapaCadenas.keySet();
    	Collection<String> llavesMay =  new ArrayList<>();
    	for (String llave : llaves) {
    		llavesMay.add(llave.toUpperCase());
    	}
    	return llavesMay;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    	Map<String,Integer> hashCantidad = new HashMap<String,Integer>();
    	for (String valores : mapaCadenas.values()) {
    		if (hashCantidad.containsKey(valores)){
    			hashCantidad.put(valores, hashCantidad.get(valores)+1);
    		}
    		
    		else {
    			hashCantidad.put(valores, 1);
    		}
    	}
    	
    	return hashCantidad.size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	String invertida = new String();
    	for (int i = cadena.length(); i > 0; i--) {
    		invertida=invertida.concat(cadena.substring(i-1, i));
    	}
    	mapaCadenas.put(invertida, cadena);
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	mapaCadenas.remove(llave);

    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	String invertida = new String();
    	for (int i = valor.length(); i > 0; i--) {
    		invertida=invertida.concat(valor.substring(i-1, i));
    	}
    	mapaCadenas.remove(invertida);
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	Map<String,String> nuevoHash = new HashMap<>();     
    	for (Object hijoObjeto : objetos) {
    		String invertida = new String();
    		String nueva = hijoObjeto.toString();
    		
    		for (int i=nueva.length();i>0;i--) {
    			invertida=invertida.concat(nueva.substring(i-1, i));
        	}
    		nuevoHash.put(invertida, nueva);
    	}
    	mapaCadenas = nuevoHash;

    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )

    {
    	Map<String,String> nuevoHash = new HashMap<>();     
    	for (Map.Entry<String, String> entry : mapaCadenas.entrySet()) {
			String llaveMin = entry.getKey();
			String llaveMax = llaveMin.toUpperCase();
			nuevoHash.put(llaveMax, mapaCadenas.get(llaveMin));			
		}
    	mapaCadenas = nuevoHash;
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
    	List<String> nuevaL = new ArrayList<>(mapaCadenas.values());
        for (int i = 0; i < otroArreglo.length; i++) {
			if (!nuevaL.contains(otroArreglo[i])) {
				return false;
			}
		}
        return true;
    }

}
