package financeiro.service;

import financeiro.model.TipoTransacao;
import financeiro.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FinanceiroService {
    private List<Transacao> transacoes = new ArrayList<>();

    public void registerTransaction(Transacao transacao){
        transacoes.add(transacao);
    }

    public List<Transacao> getTransactions(){
        return transacoes;
    }

    public BigDecimal calculateBalance(){
        BigDecimal saldo = BigDecimal.ZERO;
         for (Transacao transacao : transacoes) {
             if (transacao.getTipo() == TipoTransacao.RECEITA) {
                 saldo = saldo.add(transacao.getValor());
             } else if (transacao.getTipo() == TipoTransacao.DESPESA){
                 saldo = saldo.subtract(transacao.getValor());
             }
         }
         return saldo;
    }

    public BigDecimal calculateMonthlyExpenses(){
        BigDecimal total = BigDecimal.ZERO;
        LocalDate dataActual = LocalDate.now();

        for (Transacao transacao : transacoes){
            LocalDate dataTransaction = transacao.getData();
                if (transacao.getTipo() == TipoTransacao.DESPESA && dataTransaction.getMonthValue() == dataActual.getMonthValue() && dataTransaction.getYear() == dataActual.getYear()){
                total = total.add(transacao.getValor());
                }
        }
        return total;
    }

    public BigDecimal calculateCurrentInvoice(){
        BigDecimal faturaAtual = BigDecimal.ZERO;
        for (Transacao transacao : transacoes){
            if (transacao.getTipo() == TipoTransacao.DESPESA && transacao.isCartao()){
                faturaAtual = faturaAtual.add(transacao.getValor());
            }
        }
        return faturaAtual;
    }
}
