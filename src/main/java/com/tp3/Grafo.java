package com.tp3;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Grafo {

	private LinkedHashSet<Integer> nodos;

	private LinkedHashSet<Integer> nodosIniciais;

	private LinkedHashSet<Integer> nodosFinais;

	private HashSet<Arco> arcos;

	public LinkedHashSet<Integer> getNodos() {
		return nodos;
	}

	public void setNodos(LinkedHashSet<Integer> nodos) {
		this.nodos = nodos;
	}

	public LinkedHashSet<Integer> getNodosIniciais() {
		return nodosIniciais;
	}

	public void setNodosIniciais(LinkedHashSet<Integer> nodosIniciais) {
		this.nodosIniciais = nodosIniciais;
	}

	public LinkedHashSet<Integer> getNodosFinais() {
		return nodosFinais;
	}

	public void setNodosFinais(LinkedHashSet<Integer> nodosFinais) {
		this.nodosFinais = nodosFinais;
	}

	public HashSet<Arco> getArcos() {
		return arcos;
	}

	public void setArcos(HashSet<Arco> arcos) {
		this.arcos = arcos;
	}
}
