package com.tp3;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class GeraObrigacoesTeste {
	
	/**
	 * 
	 * @param grafo
	 */
	public static void geraObrigacaoNodos(Grafo grafo) {
		/*
		 * TODO 
		 * O conjunto de teste T satisfaz o critério
		 * de cobertura de nodos em um grafo G se somente se para
		 * cada nodo n sintaticamente alcançável syntactically em N,
		 * existe algum caminho p em caminhos(T) tal que p visita n.
		 */
	}
	
	/**
	 * 
	 * @param grafo
	 */
	public static void geraObrigacaoArcos(Grafo grafo) {
		/*
		 * TODO 
		 * TR contém cada caminho de tamanho máximo 1, inclusive, alcançável em G.
		 */
	}

	/**
	 * 
	 * @param grafo
	 * @return
	 */
	public static List<Caminho> geraObrigacaoCaminhosPrimarios(Grafo grafo) {
		List<Caminho> caminhosEstensiveis = new ArrayList<Caminho>();
		List<Caminho> caminhosNaoExtensiveis = new ArrayList<Caminho>();

		//Adiciona os nodos como caminho 0 (nodos)
		for (Integer nodo : grafo.getNodos()) {
			LinkedList caminho = new LinkedList<Integer>();
			caminho.add(nodo);
			caminhosEstensiveis.add(new Caminho(caminho, !grafo.getNodosFinais().contains(nodo)));
		}

		//Agora começa a gerar os caminhos simples
		while (!caminhosEstensiveis.isEmpty()) {
			Caminho caminho = caminhosEstensiveis.get(0);
			if(caminho.isExtensivel()) {
				List<Arco> arcos = buscaArcosOrigemNodo(caminho.getNodosLista().getLast(), grafo);
				for (Arco arco : arcos) {
					caminhosEstensiveis.add(estendeCaminho(caminho, arco, grafo.getNodosFinais()));
				}
			} else {
				caminhosNaoExtensiveis.add(caminho);
			}
			caminhosEstensiveis.remove(0);
		}

		return retornaCaminhosPrimarios(caminhosNaoExtensiveis);
	}
	
	/**
	 * 
	 * @param caminho
	 * @param arco
	 * @param nodosFinais
	 * @return
	 */
	public static Caminho estendeCaminho(Caminho caminho, Arco arco, LinkedHashSet<Integer> nodosFinais) {
		Caminho novoCaminho = null;
		try {
			novoCaminho = (Caminho)caminho.clone();
			Boolean inserir = Boolean.TRUE;
			//Testa se o nodo para onde estamos tenantado estender já está no caminho
			if(novoCaminho.getNodosLista().contains(arco.getFimArco())) {
				//Se está, já sabemos que o caminho não é estensível
				novoCaminho.setExtensivel(Boolean.FALSE);
				//Se o nodo não o primeiro, signigica um loop interno, logo, não deve inserir na lista de caminhos
				if(!novoCaminho.getNodosLista().getFirst().equals(arco.getFimArco())) {
					inserir = Boolean.FALSE;
				}
			}
			
			if(inserir) {
				//Se é um caminho que leva a um final de arco, não pode ser removido
				if(nodosFinais.contains(arco.getFimArco())) {
					novoCaminho.setExtensivel(Boolean.FALSE);
				}
				novoCaminho.getNodosLista().add(arco.getFimArco());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoCaminho;
	}
	
	/**
	 * 
	 * @param caminhos
	 * @return
	 */
	public static List<Caminho> retornaCaminhosPrimarios(List<Caminho> caminhos) {
		
		List<Caminho> caminhosLocal = new ArrayList<Caminho>();
		
		for (Caminho caminho : caminhos) {
			Boolean encontrou = Boolean.FALSE;
			int i = 0;
			while(!encontrou && i < caminhos.size()) {
				if(!caminho.equals(caminhos.get(i))) {
					encontrou = isSubCaminho(caminho, caminhos.get(i));
					if(encontrou) {
						caminhosLocal.add(caminho);
					}
				}
				i++;
			}
		}
		caminhosLocal = (List<Caminho>)CollectionUtils.subtract(caminhos, caminhosLocal);
		return caminhosLocal;
	}
	
	/**
	 * Busca os arcos do grafo cuja origem é o nodo
	 * @param nodo Inteiro para ser pesquisado
	 * @param grafo Grafo que contém as informações dos arcos
	 * @return
	 */
	public static List<Arco> buscaArcosOrigemNodo(Integer nodo, Grafo grafo) {
		List<Arco> arcosOrigemNodo = new ArrayList<Arco>();
		for (Arco arco : grafo.getArcos()) {
			if(arco.getInicioArco().equals(nodo)) {
				arcosOrigemNodo.add(arco);
			}
		}
		return arcosOrigemNodo;
	}
	
	/**
	 * Verifica se dentre os caminhos existe algum que possa ser apliado
	 * @param caminhos
	 * @return
	 */
	public static Boolean temCaminhosExtensiveis(List<Caminho> caminhos) {
		for (Caminho caminho : caminhos) {
			if(caminho.isExtensivel()) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
	
	/**
	 * Verifica se o caminho da origem é subcaminho do destino
	 * @param origem
	 * @param destino
	 */
	public static Boolean isSubCaminho(Caminho origem, Caminho destino) {
		Boolean isSubCaminho = Boolean.FALSE;
		Boolean encerraLoopExterno = Boolean.FALSE;
		
		int i = 0;
		int j = 0;
		
		int bateu = 0;
		
		while (i < destino.getNodosLista().size() && !encerraLoopExterno) {
			int iTemp = i;
			while (j < origem.getNodosLista().size() && iTemp < destino.getNodosLista().size()) {
				if(origem.getNodosLista().get(j).equals(destino.getNodosLista().get(iTemp))) {
					iTemp++;
					bateu++;
					j++;
				} else {
					if(bateu > 0) {
						encerraLoopExterno = Boolean.TRUE;
					}
					break;					
				}
			}
			i++;
		}
		
		if(origem.getNodosLista().size() == bateu) {
			isSubCaminho = Boolean.TRUE;
		}
		
		return isSubCaminho;
	}
}
