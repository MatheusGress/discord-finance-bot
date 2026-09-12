package finance.service;

import finance.model.Card;
import finance.model.Transaction;

import javax.naming.BinaryRefAddr;
import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CardService {
    private List<Card> cards = new ArrayList<>();

    public void registerCard(Card card){
        cards.add(card);
    }

    public List<Card> getCards(){
        return cards;
    }

    public BigDecimal calculateUsedLimit(Card card, List<Transaction> transactions) {
        BigDecimal usedLimit = BigDecimal.ZERO;

        for (Transaction transaction : transactions) {
            if (transaction.getCard().getId().equals(card.getId())){
                usedLimit = usedLimit.add(transaction.getAmount());
            }
        }

        return usedLimit;
    }

    public BigDecimal calculateAvailableLimit(Card card, List<Transaction> transactions) {
        BigDecimal usedLimit = calculateUsedLimit(card, transactions);

        return card.getLimit().subtract(usedLimit);
    }

    public Card getCardById(UUID id){

        for (Card card : cards){
            if (id.equals(card.getId())){
                return card;
            }
        }
        return null;
    }
}
