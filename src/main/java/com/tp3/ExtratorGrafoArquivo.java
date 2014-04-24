package com.tp3;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class ExtratorGrafoArquivo {

	public static Grafo extraiGrafoarquivo(File arquivo) {
		//TODO implementar a lógica para ler o arquivo e montar o grafo
		return mockCreateGrafo();
	}
	
	/**
	 * Método mock que apenas retorna uma estrutura pronta
	 */
	private static Grafo mockCreateGrafo() {
		Grafo grafo = new Grafo();
		Integer[] nodos = new Integer[] {1, 2, 3, 4, 5, 6, 7, 1};
		Integer[] nodosIniciais = new Integer[] {1};
		Integer[] nodosFinais = new Integer[] {7};
		LinkedHashSet<Integer> nodoGen = new LinkedHashSet<Integer>(Arrays.asList(nodos));
		grafo.setNodos(nodoGen);
		nodoGen = new LinkedHashSet<Integer>(Arrays.asList(nodosIniciais));
		grafo.setNodosIniciais(nodoGen);
		nodoGen = new LinkedHashSet<Integer>(Arrays.asList(nodosFinais));
		grafo.setNodosFinais(nodoGen);
		
		Arco[] arcos = {
			new Arco(1, 2), 
			new Arco(1, 3), 
			new Arco(2, 3), 
			new Arco(3, 4), 
			new Arco(4, 6), 
			new Arco(6, 5),
			new Arco(5, 4),
			new Arco(5, 7)
		};
				
		grafo.setArcos(new HashSet<Arco>(Arrays.asList(arcos)));
		return grafo;
	}
	
	private static Grafo mockCreateGrafo1() {
		Grafo grafo = new Grafo();
		Integer[] nodos = new Integer[] {0, 1, 2, 3, 4, 5, 6};
		Integer[] nodosIniciais = new Integer[] {1};
		Integer[] nodosFinais = new Integer[] {6};
		LinkedHashSet<Integer> nodoGen = new LinkedHashSet<Integer>(Arrays.asList(nodos));
		grafo.setNodos(nodoGen);
		nodoGen = new LinkedHashSet<Integer>(Arrays.asList(nodosIniciais));
		grafo.setNodosIniciais(nodoGen);
		nodoGen = new LinkedHashSet<Integer>(Arrays.asList(nodosFinais));
		grafo.setNodosFinais(nodoGen);
		
		Arco[] arcos = {
			new Arco(0, 1), 
			new Arco(0, 4), 
			new Arco(1, 2), 
			new Arco(1, 5), 
			new Arco(2, 3), 
			new Arco(3, 1),
			new Arco(4, 4),
			new Arco(4, 6),
			new Arco(5, 6)
		};
				
		grafo.setArcos(new HashSet<Arco>(Arrays.asList(arcos)));
		return grafo;
	}

}
