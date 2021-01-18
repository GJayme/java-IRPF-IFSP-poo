package poo.lucas.domain.entities.declaracao;

import poo.lucas.domain.entities.gasto.GastoDedutivel;
import poo.lucas.domain.entities.gasto.GastoEducacao;
import poo.lucas.domain.entities.gasto.GastoSaude;

import java.util.ArrayList;
import java.util.List;

public class DeclaracaoCompleta extends Declaracao{

    List<GastoDedutivel> dedutiveis = new ArrayList<>();

    public DeclaracaoCompleta(Double rendaTributavel, Double valorPago) {
        super(rendaTributavel, valorPago);
    }

    public void addGasto(GastoDedutivel g){

        boolean isGastoEducacao = g instanceof GastoEducacao;

        if (isGastoEducacao){
            if (g.getValor() <= GastoEducacao.deducaoMaxEducacao){
                //TODO fazer verificacao do total de valor de educacao que foi add na lista dedutivel, se o valor total for menor que 1500, add na lista
                dedutiveis.add(g);
            }
        } else {
            //TODO fazer verificacao do total de valor de saude que foi add na lista dedutivel, se o valor total for menor que 2000, add na lista
            if (g.getValor() <= GastoSaude.deducaoMaxSaude){
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
