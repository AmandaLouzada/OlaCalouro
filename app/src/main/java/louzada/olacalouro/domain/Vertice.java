package louzada.olacalouro.domain;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by amanda on 29/02/16.
 */
public class Vertice {
        private Long id;
        private String nome;
        private Double lat;
        private Double lng;

    public Vertice(Long id, String nome, Double lat, Double lng) {
            this.id = id;
            this.nome = nome;
            this.lat = lat;
            this.lng = lng;
        }

        public Long getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public Double getLat() {
            return lat;
        }

        public Double getLng() {
            return lng;
        }

        public LatLng posicao(){
            LatLng posicao = new LatLng(lat,lng);
            return posicao;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((id == null) ? 0 : id.hashCode());
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
            Vertice outro = (Vertice) obj;
            if (id == null) {
                if (outro.id != null)
                    return false;
            } else if (!id.equals(outro.id))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return nome;
        }
}
