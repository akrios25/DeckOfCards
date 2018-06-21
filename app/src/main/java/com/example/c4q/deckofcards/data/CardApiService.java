package com.example.c4q.deckofcards.data;

import com.example.c4q.deckofcards.model.CardApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by c4q on 6/20/18.
 */

public interface CardApiService {
    String BASE_URL = "https://deckofcardsapi.com/api/deck/";

    @GET("{deck_id}/draw/?count")
    Call<CardApiResponse> getNewDeck(@Path("deck_id") String newDeck, @Query("count")int num_cards);

    @GET("new/shuffle/")
    Call<CardApiResponse> getShuffledDeck();
}
