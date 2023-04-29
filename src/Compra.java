import java.math.BigDecimal;

public class Compra implements Comparable<Compra> {
    private String descricao;
    private BigDecimal valor;

    public Compra(String descricao, BigDecimal valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Compra: Produto = " + descricao + ", EUR " + valor;
    }

    @Override
    public int compareTo(Compra outraCompra) {
        return this.valor.compareTo(outraCompra.valor);
    }
}
