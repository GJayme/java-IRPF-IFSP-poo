package poo.lucas.domain.entities.declaracao;

import poo.lucas.domain.entities.gasto.GastoDedutivel;
import poo.lucas.domain.entities.gasto.GastoEducacao;
import poo.lucas.domain.entities.gasto.GastoSaude;

import java.util.ArrayList;
import java.util.List;

public class DeclaracaoCompleta extends Declaracao {

    List<GastoDedutivel> dedutiveis = new ArrayList<>();

    public DeclaracaoCompleta(Double rendaTributavel, Double valorPago) {
        super(rendaTributavel, valorPago);
    }

    public void addGasto(GastoDedutivel g){
        verifyAndAddGastoDedutivel(g);
    }

    private void verifyAndAddGastoDedutivel(GastoDedutivel g) {
        double totalValorGastoSaude = 0.0;
        double totalValorGastoEducacao = 0.0;

        for (GastoDedutivel gasto : dedutiveis) {
            if (gasto instanceof GastoEducacao){
                if (totalValorGastoEducacao + gasto.getValor() <= GastoEducacao.deducaoMaxEducacao)
                totalValorGastoEducacao += gasto.getValor();
            } else {
                if (totalValorGastoSaude + gasto.getValor() <= GastoSaude.deducaoMaxSaude)
                    totalValorGastoSaude += gasto.getValor();
            }
        }

        if (g instanceof GastoEducacao){
            if (totalValorGastoEducacao + g.getValor() <= GastoEducacao.deducaoMaxEducacao){
                dedutiveis.add(g);
            }
        } else {
            if (totalValorGastoSaude + g.getValor() <= GastoSaude.deducaoMaxSaude){
                dedutiveis.add(g);
            }
        }
    }

    public void removeGasto(GastoDedutivel g){
        dedutiveis.remove(g);
    }

    @Override
    public double gastoDedutivel(){
        double valor = 0.0;

        for (GastoDedutivel gasto : dedutiveis) {
            valor += gasto.getValor();
        }
        return valor;
    }

    @Override
    public double valorImposto() {
        double alicota = getAlicota(getRendaTributavel());

        return getRendaTributavel() * alicota - gastoDedutivel() - getValorPago();
    }

    private double getAlicota(double renda) {
        double alicota = 0;

        if (renda < Declaracao.RENDA_MINIMA) {
            return alicota;
        }

        if (renda > Declaracao.RENDA_MINIMA && renda < 2826.66) {
            alicota = 0.075;

        } else if (renda > 2826.66 && renda < 3751.05) {
            alicota = 0.150;

        } else if (renda > 3751.05 && renda < 4664.68) {
            alicota = 0.225;

        } else {
            alicota = 0.275;
        }

        return alicota;
    }
}
