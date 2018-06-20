package com.example.c4q.deckofcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CardsActivity extends AppCompatActivity {
    private Button shuffleDeck;
    private Button drawCards;
    private EditText numOfCards;
    private TextView remainingCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
        setViews();
    }
    private void setViews() {
        shuffleDeck = findViewById(R.id.shuffle_button);
        drawCards = findViewById(R.id.draw_button);
        numOfCards = findViewById(R.id.how_many_cards);
        remainingCards = findViewById(R.id.cards_remaining);

    }
}
