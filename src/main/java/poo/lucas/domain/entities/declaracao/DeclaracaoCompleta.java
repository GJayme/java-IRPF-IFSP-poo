package poo.lucas.domain.entities.declaracao;

import poo.lucas.domain.entities.gasto.GastoDedutivel;

import java.util.ArrayList;
import java.util.List;

public class DeclaracaoCompleta extends Declaracao{

    List<GastoDedutivel> dedutiveis = new ArrayList<>();

    public DeclaracaoCompleta(Double rendaTributavel, Double valorPago) {
        super(rendaTributavel, valorPago);
    }

    public void addGasto(GastoDedutivel g){
        return;
    }

    public void removeGasto(GastoDedutivel g){
        return;
    }

    @Override
    public double gastoDedutivel(){
        return 0.0;
    }

    @Override
    public double valorImposto() {
        return 0;
    }
}
