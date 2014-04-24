package com.tp3;

public class Arco {

	private Integer inicioArco;
	private Integer fimArco;
	
	public Arco(Integer inicioArco, Integer fimArco) {
		super();
		this.inicioArco = inicioArco;
		this.fimArco = fimArco;
	}
	public Integer getInicioArco() {
		return inicioArco;
	}
	public void setInicioArco(Integer inicioArco) {
		this.inicioArco = inicioArco;
	}
	public Integer getFimArco() {
		return fimArco;
	}
	public void setFimArco(Integer fimArco) {
		this.fimArco = fimArco;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fimArco == null) ? 0 : fimArco.hashCode());
		result = prime * result + ((inicioArco == null) ? 0 : inicioArco.hashCode());
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
		Arco other = (Arco) obj;
		if (fimArco == null) {
			if (other.fimArco != null)
				return false;
		} else if (!fimArco.equals(other.fimArco))
			return false;
		if (inicioArco == null) {
			if (other.inicioArco != null)
				return false;
		} else if (!inicioArco.equals(other.inicioArco))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "[" + inicioArco + "," + fimArco + "]";
	}
	
	
	
	
}
