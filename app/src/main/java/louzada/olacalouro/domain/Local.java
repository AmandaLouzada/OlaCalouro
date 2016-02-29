package louzada.olacalouro.domain;

/**
 * Created by amanda on 22/02/16.
 */
public class Local {
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String DESCRICAO = "descricao";
    public static final String TELEFONE = "telefone";
    public static final String CATEGORIA = "categoria";

    private Long id;
    private String nome;
    private String descricao;
    private String telefone;
    private Integer categoria;


    public Local(Long id, String nome, String descricao, String telefone, Integer categoria){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.telefone = telefone;
        this.categoria = categoria;
    }

    public Local(){
        this.id = null;
        this.nome = null;
        this.descricao = null;
        this.telefone = null;
        this.categoria = null;
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

    public void  setTelefone(String telefone) {
        telefone = this.telefone;
    }

    public String  getTelefone() {
        return telefone;
    }

    public void  setCategoria(Integer categoria) {
        categoria = this.categoria;
    }

    public Integer  getCategoria() {
        return categoria;
    }

}
