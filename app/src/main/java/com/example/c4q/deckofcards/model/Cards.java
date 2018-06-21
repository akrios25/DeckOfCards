package com.example.c4q.deckofcards.model;

/**
 * Created by c4q on 6/20/18.
 */

public class Cards {
    private String image;
    private String value;
    private String suit;
    private String code;

    public Cards(String image, String value, String suit, String code) {
        this.image = image;
        this.value = value;
        this.suit = suit;
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public String getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public String getCode() {
        return code;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
