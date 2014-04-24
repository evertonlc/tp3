package com.tp3;

import java.util.List;


public class Main {

	/**
	 * 
	 * @param args
	 * Espera que arg[0] seja o nome do arquivo
	 * Espera que arg[1] seja outro arquivo com caminhos de teste para avaliar quais obrigações são satisfeitas pelo mesmo
	 */
	public static void main(String[] args) {
		Grafo grafo = ExtratorGrafoArquivo.extraiGrafoarquivo(null);

		List<Caminho> caminhos = GeraObrigacoesTeste.geraObrigacaoCaminhosPrimarios(grafo);
		
	}
}
