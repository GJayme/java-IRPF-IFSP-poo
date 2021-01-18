package poo.lucas.domain.entities.gasto;

public class GastoSaude extends GastoDedutivel{
    private String regConselho;
    public static Double deducaoMaxSaude = 2000.00;

    public GastoSaude(String descricao, Double valor, String cnpj, String regConselho) {
        super(descricao, valor, cnpj);
        this.regConselho = regConselho;
    }
}
