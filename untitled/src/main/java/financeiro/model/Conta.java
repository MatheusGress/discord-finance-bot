package financeiro.model;

public class Conta {
    private UUID id;
    private String descricao;
    private BigDecimal valor;
    private LocalData diaVencimento;
    private boolean contaPaga;
    private boolean recorrente;

    private Conta(UUID id, String descricao, BigDecimal valor, LocalData diaVencimento, boolean contaPaga, boolean recorrente){
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.diaVencimento = diaVencimento;
        this.contaPaga = contaPaga;
        this.recorrente = recorrente;
    }

}
