package louzada.olacalouro.domain;

/**
 * Created by amanda on 29/02/16.
 */
public class Local {
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String DESCRICAO = "descricao";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String TIPO = "tipo";

    private Long id;
    private String nome;
    private String descricao;
    private Double lat;
    private Double lng;
    private Integer tipo;

    public Local(Long id, String nome, Double lat, Double lng, String descricao, Integer tipo){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.lat = lat;
        this.lng = lng;
        this.tipo = tipo;
    }

    public Local(){
        this.id = null;
        this.nome = null;
        this.descricao = null;
        this.lat = null;
        this.lng = null;
        this.tipo = null;
    }

    @Override
    public String toString() {
        return nome;
    }
    public void  setId(long id) {
        id = this.id;
    }

    public long  getId() {
        return id;
    }

    public void  setNome(String nome) {
        nome = this.nome;
    }

    public String  getNome() {
        return nome;
    }

    public void  setDescricao(String descricao) {
        descricao = this.descricao;
    }

    public String  getDescricao() {
        return descricao;
    }

    public void  setLat(Double lat) {
        lat = this.lat;
    }

    public Double  getLat() {
        return lat;
    }

    public void  setLng(Double lng) {
        lng = this.lng;
    }

    public Double  getLng() {
        return lng;
    }

    public void  setTipo(Integer tipo) {
        tipo = this.tipo;
    }

    public Integer  getTipo() {
        return tipo;
    }

}
