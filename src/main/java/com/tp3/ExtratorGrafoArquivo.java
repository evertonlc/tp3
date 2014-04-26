package com.tp3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

public class ExtratorGrafoArquivo {

        /**
         * Dado um arquivo no formato fornecido, retorna um grafo com os dados no mesmo
         * Linha 1 - Nome do grafo
         * Linha 2 - Nodos do grafo - N = 1, 2, 3, 4, 5, 6, 7
         * Linha 3 - Nodos iniciais - Ni = 1
         * Linha 4 - Nodos Finais   - Nf = 5
         * Linha 5 - Definição de arco - E =
         * 1,2
         * 1,3
         * 2,3
         * 3,4
         * 4,6
         * 6,5
         * 5,4
         * 5,7
         *  Não reconhece arquivos com comentários
         * @param arquivo
         * @return
         * @throws IOException 
         * 
         */
	public static Grafo extraiGrafoArquivo(File arquivo) throws IOException{    
            List<String> lista = FileUtils.readLines(arquivo);
            Grafo grafo = new Grafo();
            LinkedHashSet<Integer> nodos = null;
            LinkedHashSet<Integer> nodosIniciais = null;
            LinkedHashSet<Integer> nodosFinais = null;
            
            String nodosStr = lista.get(1);
            String nodosIniciaisStr = lista.get(2);
            String nodosFinaisStr = lista.get(3);
            String arcosStr = lista.get(4);
            
            String[] valoresStringParametrosArquivo = retornaStringsParametrosArquivo(nodosStr, nodosIniciaisStr, nodosFinaisStr, arcosStr);

            try {
                nodos = divideLista(valoresStringParametrosArquivo[0]);
                nodosIniciais = divideLista(valoresStringParametrosArquivo[1]);
                nodosFinais = divideLista(valoresStringParametrosArquivo[2]);   
            } catch (NumberFormatException e) {
                throw new NumberFormatException("String de parametro com valor incorreto");
            }
          
            grafo.setNodos(nodos);
            grafo.setNodosIniciais(nodosIniciais);
            grafo.setNodosFinais(nodosFinais);
            grafo.setArcos(retornaArcosParametrosArquivo(lista.subList(5, lista.size())));
                
            return grafo;
	}
	
        /**
         * Recebe uma String separada por vírgula e devolve uma lista de inteiros
         * @param lista
         * @return 
         */
        private static LinkedHashSet<Integer> divideLista(String lista) {
            String[] listaSeparada = StringUtils.split(lista, ',');
            
            LinkedHashSet<Integer> retornoLista = new LinkedHashSet<Integer>(listaSeparada.length);
            for (int i = 0; i < listaSeparada.length; i++) {
                listaSeparada[i] = StringUtils.trim(listaSeparada[i]);
                retornoLista.add(Integer.parseInt(listaSeparada[i]));
            }
            return retornoLista;
        }
        /**
         * Recebe as linhas referentes à configuração do grafo e retorna um array 
         * de string com os valores dos [0]nodos, [1]nodosIniciais e [2]nodosFinais
         * @param nodos
         * @param nodosIniciais
         * @param nodosFinais
         * @param arcos
         * @return 
         */
        private static String[] retornaStringsParametrosArquivo(String nodos, String nodosIniciais, String nodosFinais, String arcos) {
            String[][] temp = new String[4][2];
            temp[0] = StringUtils.split(nodos, '=');
            temp[1] = StringUtils.split(nodosIniciais, '=');
            temp[2] = StringUtils.split(nodosFinais, '=');
            temp[3] = StringUtils.split(arcos,'=');
            if(!(temp[0][0].startsWith("N") && temp[1][0].startsWith("Ni") && temp[2][0].startsWith("Nf") && temp[3][0].startsWith("E"))) {
                throw new IllegalArgumentException("Arquivo com formato inválido");
            }
            String[] retorno = new String[3];
            retorno[0] = temp[0][1];
            retorno[1] = temp[1][1];
            retorno[2] = temp[2][1];
            return retorno;
        }
        
        /**
         * Recebe um conjunto de linhas e retorna o conjunto de arcos para elas
         * @param linhas
         * @return 
         */
        private static HashSet<Arco> retornaArcosParametrosArquivo(List<String> linhas) {
            HashSet<Arco> arcos = null;
            if(linhas != null && !linhas.isEmpty()) {
                arcos = new HashSet<Arco>();
                for(String linha : linhas) {
                    LinkedHashSet<Integer> arco = divideLista(linha);
                    LinkedList<Integer> arco1 = new LinkedList<Integer>(arco);
                    arcos.add(new Arco(arco1.getFirst(), arco1.getLast()));
                }
            } else {
                throw new IllegalArgumentException("Arcos não fornecidos");
            }
            return arcos;
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
