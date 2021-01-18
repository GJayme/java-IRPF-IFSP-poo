package poo.lucas.domain.entities.declaracao;

public class DeclaracaoSimplificada extends Declaracao{

    public DeclaracaoSimplificada(Double rendaTributavel, Double valorPago) {
        super(rendaTributavel, valorPago);
    }

    @Override
    public double valorImposto() {
        return 0;
    }


}
