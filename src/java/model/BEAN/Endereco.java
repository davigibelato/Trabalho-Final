package model.BEAN;

public class Endereco {
    private int idEndereco;  // Corrigido para evitar caracteres especiais
    private static int idEnderecoAtual;  // Corrigido para evitar caracteres especiais
    private String estado;
    private String cidade;
    private int cep;
    private String rua;
    private int numeroCasa;
    private String complemento;
    private int usuario;

    public Endereco() {
    }

    public Endereco(int idEndereco, String estado, String cidade, int cep, String rua, int numeroCasa, String complemento, int usuario) {
        this.idEndereco = idEndereco;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.complemento = complemento;
        this.usuario = usuario;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public static int getIdEnderecoAtual() {
        return idEnderecoAtual;
    }

    public static void setIdEnderecoAtual(int idEnderecoAtual) {
        Endereco.idEnderecoAtual = idEnderecoAtual;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
}
