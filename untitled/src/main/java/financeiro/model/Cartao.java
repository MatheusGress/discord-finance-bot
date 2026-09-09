package financeiro.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Cartao {
    private UUID id;
    private String nome;
    private BigDecimal limite;
    private LocalData diaFechamento;
    private LocalData diaVencimento;

    private Cartao(UUID id, String nome, BigDecimal limite, LocalData diaFechamento, LocalData diavencimento){
        this.id = id;
        this.nome = nome;
        this.limite = limite;
        this.diaFechamento = diaFechamento;
        this.diaVencimento = diavencimento;
    }
}
