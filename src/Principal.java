import java.math.BigDecimal;
import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        System.out.println("""
                
                --- Welcome to BestShop.com ---
                
                Digite o limite do seu cartão:""");
        BigDecimal limite = leitura.nextBigDecimal();
        CreditCard cartao = new CreditCard(limite);

        int sair = 1;
        while (sair != 0) {
            System.out.println("Informe o nome do produto:");
            String descricao = leitura.next();

            System.out.println("Informe o valor da compra:");
            BigDecimal valor = leitura.nextBigDecimal();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada!");
            } else {
                System.out.println("Saldo insuficiente para realizar a compra deste produto");
            }
            cartao.imprimeSaldo();
            mostraMenu();
            sair = leitura.nextInt();

            if (sair == 0) {
                System.out.println("""
                        
                        *************************
                        Extrato das suas compras:
                        -------------------------""");
                Collections.sort(cartao.getCompras());
                for (Compra c: cartao.getCompras()) {
                    System.out.println(c);
                }
                System.out.println("-------------------------");
                cartao.imprimeSaldo();
                System.out.println("""
                        
                        Obrigado pela prefência!
                        -------------------------""");

            }
        }
    }

    static void mostraMenu(){
        System.out.println("\nDigite: [ 1 - continuar ] ou [ 0 - sair ]");
    }
}
