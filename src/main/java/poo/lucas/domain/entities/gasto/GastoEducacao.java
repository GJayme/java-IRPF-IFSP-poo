package poo.lucas.domain.entities.gasto;

public class GastoEducacao extends GastoDedutivel{
    private String nomeInstituicao;
    public static Double deducaoMaxEducacao = 1500.00;

    public GastoEducacao(String descricao, Double valor, String cnpj, String nomeInstituicao) {
        super(descricao, valor, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }
}
