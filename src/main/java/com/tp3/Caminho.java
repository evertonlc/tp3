package com.tp3;

import java.util.LinkedList;

public class Caminho implements Cloneable {
	private LinkedList<Integer> nodosLista;

	// Indica se o caminho ou não pode ser extendido, seja por encontrar um nodo final ou situação de loop
	private Boolean extensivel;

	public Caminho(LinkedList<Integer> nodosLista, Boolean extensivel) {
		super();
		this.extensivel = extensivel;
		this.nodosLista = nodosLista;
	}

	public Boolean isExtensivel() {
		return extensivel;
	}

	public void setExtensivel(Boolean extensivel) {
		this.extensivel = extensivel;
	}

	public LinkedList<Integer> getNodosLista() {
		return nodosLista;
	}

	public void setNodosLista(LinkedList<Integer> nodosLista) {
		this.nodosLista = nodosLista;
	}

	@Override
	public String toString() {
		return "Caminho " + nodosLista ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extensivel == null) ? 0 : extensivel.hashCode());
		result = prime * result + ((nodosLista == null) ? 0 : nodosLista.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caminho other = (Caminho) obj;
		if (extensivel == null) {
			if (other.extensivel != null)
				return false;
		} else if (!extensivel.equals(other.extensivel))
			return false;
		if (nodosLista == null) {
			if (other.nodosLista != null)
				return false;
		} else if (!nodosLista.equals(other.nodosLista))
			return false;
		return true;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		Caminho caminho = (Caminho)super.clone();
		caminho.setNodosLista((LinkedList<Integer>)nodosLista.clone());
		return caminho;
	}
}
