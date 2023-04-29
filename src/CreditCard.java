import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private BigDecimal limite;
    private BigDecimal saldo;
    private List<Compra> compras;

    public CreditCard(BigDecimal limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    public boolean lancaCompra(Compra compra) {
        var temSaldo = this.saldo.compareTo(compra.getValor());
        if (temSaldo >= 0) {
            this.saldo = this.saldo.subtract(compra.getValor());
            this.compras.add(compra);
            return true;
        }
        return false;
    }

    public void imprimeSaldo(){
        System.out.println("Saldo disponível no cartão: [ EUR " + this.getSaldo() + " ]");
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }
}
