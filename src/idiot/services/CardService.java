package idiot.services;

import idiot.Card;
import idiot.Deck;
import idiot.Hand;

import java.util.HashMap;
import java.util.concurrent.Callable;

public class CardService {

    private Deck draw;
    private Deck discard;

    private static HashMap<Integer, Callable<Boolean>> m = new HashMap<>();

    static{
        m.put(0, CardService::notSpecialCard);
        m.put(1, CardService::notSpecialCard);
        m.put(2, CardService::notSpecialCard);
        m.put(3, CardService::notSpecialCard);
        m.put(4, CardService::notSpecialCard);
        m.put(5, CardService::notSpecialCard);
        m.put(6, CardService::notSpecialCard);
        m.put(7, CardService::notSpecialCard);
        m.put(8, CardService::notSpecialCard);
        m.put(9, CardService::notSpecialCard);
        m.put(10, CardService::handleTenCard);
        m.put(11, CardService::notSpecialCard);
        m.put(12, CardService::notSpecialCard);
    }

    private static final CardService instance = new CardService();

    private CardService(){}

    public static CardService getInstance(Deck draw, Deck discard){
        instance.discard = discard;
        instance.draw = draw;
        return instance;
    }

    public Boolean handleCard(int c) throws Exception {
        return m.get(c) == null ? false : m.get(c).call();
    }

    public void discardAndReplace(Card c, Hand h){
        h.getAll().remove(c);
        h.getAll().add(this.draw.getCard());
        discard.discard(c);
    }

    private static boolean handleTenCard(){
        return true;
    }

    private static boolean notSpecialCard(){
        return true;
    }

}
