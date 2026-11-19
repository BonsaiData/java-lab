import java.math.BigDecimal; //classe mais importante para sistemas financeiros
import java.math.RoundingMode; // classe que simplifica regras matemáticas para arredondar e manipular casas decimais

public class Account {
    private BigDecimal balance;

    public Account(BigDecimal initBalance) {
        if (initBalance.signum() < 0) {    // Usando o signum para conseguir identificar números positivos, negativos e o zero. Também aceita números quebrados, e não rejeita a não ser que seja negativo.
            throw new IllegalArgumentException("Illegal negative balance");
        }
        this.balance = initBalance.setScale(4, RoundingMode.UNNECESSARY); // Adicionado para que haja exatamente 4 casas decimais à direita da vírgula (Se autocompleta com zeros até atingir a escala declarada (4)). Meramente usado para cálculos precisos, entretanto, quando devolvido ao cliente usando um ledger, o ideal é retornar duas casas decimais para um valor legível à moeda escolhida
        // Caso exceda a escala (4), o UNNECESSARY lança ArithmeticException, onde o construtor é interrompido e a conta não é criada.
    }
}