package poo.lucas.domain.entities.declaracao;

public class DeclaracaoSimplificada extends Declaracao{

    public DeclaracaoSimplificada(){
    }

    public DeclaracaoSimplificada(Double rendaTributavel, Double valorPago) {
        super(rendaTributavel, valorPago);
    }

    @Override
    public double valorImposto() {
        if (getRendaTributavel() < Declaracao.RENDA_MINIMA) {
            return 0;
        }

        return getRendaTributavel() * 0.20 - getValorPago();
    }
}
