package louzada.olacalouro;

import java.util.List;

import louzada.olacalouro.domain.Aresta;
import louzada.olacalouro.domain.Vertice;

/**
 * Created by amanda on 29/02/16.
 */
public class Grafo {
        private final List<Vertice> vertices;
        private final List<Aresta> arestas;

        public Grafo(List<Vertice> vertices, List<Aresta> arestas) {
            this.vertices = vertices;
            this.arestas = arestas;
        }

        public List<Vertice> getVertices() {
            return vertices;
        }

        public List<Aresta> getArestas() {
            return arestas;
        }

}
