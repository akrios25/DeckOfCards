package com.example.c4q.deckofcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c4q.deckofcards.data.CardApiService;
import com.example.c4q.deckofcards.model.CardApiResponse;
import com.example.c4q.deckofcards.model.Cards;
import com.example.c4q.deckofcards.presenter.CardsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CardsActivity extends AppCompatActivity {
    private Button shuffleDeck;
    private Button drawCards;
    private EditText numOfCards;
    private TextView remainingCards;
    private RecyclerView recyclerView;
    private String shuffle;
    private int remaining;
    private CardApiService cardApiService;

    List<Cards> cardHolder = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
        setViews();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));



        shuffleDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(cardApiService.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                CardApiService cardApiService = retrofit.create(CardApiService.class);
                Call<CardApiResponse> call = cardApiService.getShuffledDeck();
                call.enqueue(new Callback<CardApiResponse>() {
                    @Override
                    public void onResponse(Call<CardApiResponse> call, Response<CardApiResponse> response) {
                        shuffle = response.body().getDeck_id();
                        remaining = response.body().getRemaining();
                        remainingCards.setText(remaining + " Cards Remain");
                    }

                    @Override
                    public void onFailure(Call<CardApiResponse> call, Throwable t) {
                        Toast.makeText(CardsActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        drawCards.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                int cardsDrawn = Integer.parseInt(numOfCards.getText().toString());
                remainingCards.setText(remaining - cardsDrawn + " Cards Remain");
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(cardApiService.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                int numOfCardsSelected = Integer.parseInt(numOfCards.getText().toString());
                if (numOfCardsSelected < 1) {
                    numOfCards.setError("not a sufficient number of cards");
                } else if (numOfCardsSelected > remaining) {
                    numOfCards.setError("there's not enough cards to draw");
                } else {
                    cardApiService = retrofit.create(CardApiService.class);
                    Call<CardApiResponse> call = cardApiService.getNewDeck(shuffle, numOfCardsSelected);
                    call.enqueue(new Callback<CardApiResponse>() {
                        @Override
                        public void onResponse(Call<CardApiResponse> call, Response<CardApiResponse> response) {
                            List<Cards> newCards = response.body().getCards();
                            cardHolder.addAll(newCards);
                            cardAdapter(cardHolder);



                        }

                        @Override
                        public void onFailure(Call<CardApiResponse> call, Throwable t) {
                            Toast.makeText(CardsActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    public void cardAdapter(List<Cards> cardList) {
        CardsAdapter adapter = new CardsAdapter(cardList);
        recyclerView.setAdapter(adapter);
    }

    private void setViews() {
        shuffleDeck = findViewById(R.id.shuffle_button);
        drawCards = findViewById(R.id.draw_button);
        numOfCards = findViewById(R.id.how_many_cards);
        remainingCards = findViewById(R.id.cards_remaining);

    }


}
