package financeiro.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Transacao {
    private UUID id;
    private BigDecimal valor;
    private TipoTransacao tipo;
    private Categoria categoria;
    private String descricao;
    private LocalDate data;
    private Cartao cartao;


    public Transacao(UUID id, BigDecimal valor, TipoTransacao tipo, Categoria categoria, String descricao, LocalDate data, Cartao cartao){
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
        this.descricao = descricao;
        this.data = data;
        this.cartao = cartao;
    }

    public TipoTransacao getTipo(){
        return tipo;
    }

    public BigDecimal getValor(){
        return valor;
    }

    public LocalDate getData(){
        return data;
    }

    public Cartao getCartao(){
        return cartao;
    }

    public boolean isCartao(){
        return cartao != null;
    }


}
