package poo.lucas.domain.entities.gasto;

public class GastoSaude extends GastoDedutivel{
    private String regConselho;
    public final static Double deducaoMaxSaude = 2000.00;

    public GastoSaude(){
    }

    public GastoSaude(String descricao, Double valor, String cnpj, String regConselho) {
        super(descricao, valor, cnpj);
        this.regConselho = regConselho;
    }

    public String getRegConselho() {
        return regConselho;
    }

    public void setRegConselho(String regConselho) {
        this.regConselho = regConselho;
    }

    @Override
    public String toString() {
        return "GastoSaude{" +
                "regConselho='" + regConselho + '\'' +
                '}';
    }
}
