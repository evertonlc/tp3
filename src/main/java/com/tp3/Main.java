package com.tp3;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Main {

	/**
	 * 
	 * @param args
	 * Espera que arg[0] seja o nome do arquivo
	 * Espera que arg[1] seja outro arquivo com caminhos de teste para avaliar quais obrigações são satisfeitas pelo mesmo
	 */
	public static void main(String[] args) throws IOException {
            
            if(args.length == 0) {
                System.out.println("Não foi passado nenhum parâmetro de entrada");
            } else{
                Grafo grafo = ExtratorGrafoArquivo.extraiGrafoArquivo(new File(args[0]));
		List<Caminho> caminhos = GeraObrigacoesTeste.geraObrigacaoCaminhosPrimarios(grafo);
                System.out.println("Caminhos primários de teste: " + caminhos);
            }
	}
}
