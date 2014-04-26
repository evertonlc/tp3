/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tp3;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author everton
 */
public class CaminhoGrafoTestCase {
   
    @Test
    public void testGrafo1() throws IOException, URISyntaxException {
        
        Grafo grafo = ExtratorGrafoArquivo.extraiGrafoArquivo(new File(getClass().getResource("/Grafo1.txt").toURI()));
        List<Caminho> caminhos = GeraObrigacoesTeste.geraObrigacaoCaminhosPrimarios(grafo);
        assertEquals(5, caminhos.size());
        assertEquals("[Caminho [4, 6, 5, 4], Caminho [5, 4, 6, 5], Caminho [6, 5, 4, 6], Caminho [1, 3, 4, 6, 5, 7], Caminho [1, 2, 3, 4, 6, 5, 7]]", caminhos.toString());
    }
    
    @Test
    public void testGrafo2() throws IOException, URISyntaxException {
        Grafo grafo = ExtratorGrafoArquivo.extraiGrafoArquivo(new File(getClass().getResource("/Grafo2.txt").toURI()));
        List<Caminho> caminhos = GeraObrigacoesTeste.geraObrigacaoCaminhosPrimarios(grafo);
        assertEquals(8, caminhos.size());
        assertEquals("[Caminho [4, 4], Caminho [0, 4, 6], Caminho [0, 1, 5, 6], Caminho [1, 2, 3, 1], Caminho [2, 3, 1, 2], Caminho [3, 1, 2, 3], Caminho [0, 1, 2, 3], Caminho [2, 3, 1, 5, 6]]", caminhos.toString());
    }
}
