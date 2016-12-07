package com.example.mark.cecs453_blackjack;

/**
 * Created by Kelvin on 11/18/2016.
 */

public class Card {
    private String name;
    private int value;
    private String suit;
    private String image;

    public Card(String n, int v, String s, String i) {
        name = n;
        value = v;
        suit = s;
        image = i;
    }

    public void setName(String n) {
        name = n;
    }

    public void setValue(int v) {
        value = v;
    }

    public void setSuit(String s) {
        suit = s;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public void setImage(String i) {
        image = i;
    }

    public String getImage() {
        return image;
    }
}
