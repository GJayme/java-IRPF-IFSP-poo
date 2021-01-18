package poo.lucas.domain.entities.gasto;

public class GastoEducacao extends GastoDedutivel{
    private String nomeInstituicao;
    public final static Double deducaoMaxEducacao = 1500.00;

    public GastoEducacao(){
    }

    public GastoEducacao(String descricao, Double valor, String cnpj, String nomeInstituicao) {
        super(descricao, valor, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    @Override
    public String toString() {
        return "GastoEducacao{" +
                "nomeInstituicao='" + nomeInstituicao + '\'' +
                '}';
    }
}
