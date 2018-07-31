package com.example.c4q.deckofcards.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.c4q.deckofcards.R;
import com.example.c4q.deckofcards.model.Cards;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by c4q on 6/20/18.
 */

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardViewHolder>{
    List<Cards> cardsList;
    Cards cards;


    public CardsAdapter(List<Cards> cardsList){
        this.cardsList = cardsList;
    }

    @NonNull
    @Override
    public CardsAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardsAdapter.CardViewHolder holder, int position) {
        cards = cardsList.get(position);
        holder.onBind(cards);

    }

    @Override
    public int getItemCount() {
        return cardsList.size();
    }
    public void addCards(List<Cards> cards){
        cardsList.addAll(cards);
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView cardImageView;
        Cards cards;

        public CardViewHolder(final View itemview){
            super(itemview);
            cardImageView = itemview.findViewById(R.id.card_image);
            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),cards.getValue() + " of " + cards.getSuit()  , Toast.LENGTH_SHORT).show();
                }
            });
        }
        public void onBind(Cards cards){
            this.cards = cards;
            Picasso.with(itemView.getContext())
                    .load(cards.getImage())
                    .into(cardImageView);

        }



    }
}
