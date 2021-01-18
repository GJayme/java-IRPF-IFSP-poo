package poo.lucas.domain.entities.gasto;

public abstract class GastoDedutivel {
    private String descricao;
    private Double valor;
    private String cnpj;

    public GastoDedutivel(){

    }

    public GastoDedutivel(String descricao, Double valor, String cnpj) {
        this.descricao = descricao;
        this.valor = valor;
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "GastoDedutivel{" +
                "descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
