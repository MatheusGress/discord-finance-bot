package financeiro.model;

public class Transacao {
    private UUID id;
    private BigDecimal valor;
    private TipoTransacao tipo;
    private Categoria categoria;
    private String descricao;
    private LocalDate data;

    public Transacao(UUID id, BigDecimal valor, TipoTransacao tipo, Categoria categoria, String descricao, LocalDate data){
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
        this.descricao = descricao;
        this.data = data;
    }
}
