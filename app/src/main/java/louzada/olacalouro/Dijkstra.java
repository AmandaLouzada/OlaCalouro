package louzada.olacalouro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import louzada.olacalouro.domain.Aresta;
import louzada.olacalouro.domain.Vertice;

/**
 * Created by amanda on 29/02/16.
 */
public class Dijkstra {
    private final List<Vertice> nos;
    private final List<Aresta> arestas;
    private Set<Vertice> nosSettled;
    private Set<Vertice> nosNaoSettled;
    private Map<Vertice, Vertice> antecessores;
    private Map<Vertice, Double> distancia;

    public Dijkstra(Grafo grafo) {
        this.nos = new ArrayList<Vertice>(grafo.getVertices());
        this.arestas = new ArrayList<Aresta>(grafo.getArestas());
    }

    public void execute(Vertice origem) {
        nosSettled = new HashSet<Vertice>();
        nosNaoSettled = new HashSet<Vertice>();
        distancia = new HashMap<Vertice, Double>();
        antecessores = new HashMap<Vertice, Vertice>();
        distancia.put(origem, 0.0);
        nosNaoSettled.add(origem);
        while (nosNaoSettled.size() > 0) {
            Vertice node = getMinimum(nosNaoSettled);
            nosSettled.add(node);
            nosNaoSettled.remove(node);
            findMinimalDistancias(node);
        }
    }

    private void findMinimalDistancias(Vertice node) {
        List<Vertice> adjacentNodes = getNeighbors(node);
        for (Vertice target : adjacentNodes) {
            if (getTestarDistanciaCurta(target) > getTestarDistanciaCurta(node)
                    + getDistancia(node, target)) {
                distancia.put(target, getTestarDistanciaCurta(node)
                        + getDistancia(node, target));
                antecessores.put(target, node);
                nosNaoSettled.add(target);
            }
        }

    }

    private Double getDistancia(Vertice node, Vertice target) {
        for (Aresta aresta : arestas) {
            if (aresta.getOrigem().equals(node)
                    && aresta.getDestino().equals(target)) {
                return aresta.getPeso();
            }
        }
        throw new RuntimeException("Não deveria acontecer");
    }

    private List<Vertice> getNeighbors(Vertice node) {
        List<Vertice> neighbors = new ArrayList<Vertice>();
        for (Aresta aresta : arestas) {
            if (aresta.getOrigem().equals(node)
                    && !isSettled(aresta.getDestino())) {
                neighbors.add(aresta.getDestino());
            }
        }
        return neighbors;
    }

    private Vertice getMinimum(Set<Vertice> vertices) {
        Vertice minimum = null;
        for (Vertice vertice : vertices) {
            if (minimum == null) {
                minimum = vertice;
            } else {
                if (getTestarDistanciaCurta(vertice) < getTestarDistanciaCurta(minimum)) {
                    minimum = vertice;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Vertice vertice) {
        return nosSettled.contains(vertice);
    }

    private Double getTestarDistanciaCurta(Vertice destino) {
        Double d = distancia.get(destino);
        if (d == null) {
            return Double.MAX_VALUE;
        } else {
            return d;
        }
    }


    public LinkedList<Vertice> getPath(Vertice target) {
        LinkedList<Vertice> path = new LinkedList<Vertice>();
        Vertice step = target;
        // verifica se exite path
        if (antecessores.get(step) == null) {
            return null;
        }
        path.add(step);
        while (antecessores.get(step) != null) {
            step = antecessores.get(step);
            path.add(step);
        }
        // Colocar na ordem correta
        Collections.reverse(path);
        return path;
    }

}