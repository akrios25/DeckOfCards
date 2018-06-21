package com.example.c4q.deckofcards.model;

import java.util.List;

/**
 * Created by c4q on 6/20/18.
 */

public class CardApiResponse {
    private boolean success;
    private String deck_id;
    private boolean shuffled;
    private int remaining;
    private List<Cards> cards;

    public CardApiResponse(boolean success, String deck_id, boolean shuffled, int remaining, List<Cards> cards) {
        this.success = success;
        this.deck_id = deck_id;
        this.shuffled = shuffled;
        this.remaining = remaining;
        this.cards = cards;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public boolean isShuffled() {
        return shuffled;
    }

    public int getRemaining() {
        return remaining;
    }

    public List<Cards> getCards() {
        return cards;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }

    public void setShuffled(boolean shuffled) {
        this.shuffled = shuffled;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public void setCards(List<Cards> cards) {
        this.cards = cards;
    }
}
