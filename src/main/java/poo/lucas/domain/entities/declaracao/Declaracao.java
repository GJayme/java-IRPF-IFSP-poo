package poo.lucas.domain.entities.declaracao;

import java.util.Objects;

public abstract class Declaracao {
    private Double rendaTributavel;
    private Double valorPago;

    public Declaracao(Double rendaTributavel, Double valorPago) {
        this.rendaTributavel = rendaTributavel;
        this.valorPago = valorPago;
    }

    public double valorAPagar() {
        return valorImposto() - valorPago - gastoDedutivel() ;
    }

    public double gastoDedutivel() {
        return 0.0;
    }

    public abstract double valorImposto();

    public Double getRendaTributavel() {
        return rendaTributavel;
    }

    public void setRendaTributavel(Double rendaTributavel) {
        this.rendaTributavel = rendaTributavel;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    @Override
    public String toString() {
        return "Declaracao{" +
                "rendaTributavel=" + rendaTributavel +
                ", valorPago=" + valorPago +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Declaracao)) return false;
        Declaracao that = (Declaracao) o;
        return Objects.equals(rendaTributavel, that.rendaTributavel) && Objects.equals(valorPago, that.valorPago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rendaTributavel, valorPago);
    }
}
