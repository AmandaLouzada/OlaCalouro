package louzada.olacalouro.domain;

/**
 * Created by amanda on 29/02/16.
 */
public class Aresta {
        private final Long id;
        private final Vertice origem;
        private final Vertice destino;
        private final Double peso;

        public Aresta(Long id, Vertice origem, Vertice destino, Double peso) {
            this.id = id;
            this.origem = origem;
            this.destino = destino;
            this.peso = peso;
        }

        public Long getId() {
            return id;
        }
        public Vertice getDestino() {
            return destino;
        }

        public Vertice getOrigem() {
            return origem;
        }
        public Double getPeso() {
            return peso;
        }

        @Override
        public String toString() {
            return origem + " " + destino;
        }

}
