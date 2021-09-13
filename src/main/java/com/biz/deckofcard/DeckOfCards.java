package com.biz.deckofcard;

import java.util.Random;

public class DeckOfCards {

    MyQueue<Player> playerQueue;
    int[][] cardsArray;
    public static void main(String[] args) {

        DeckOfCards extended = new DeckOfCards();
        extended.start();
        extended.dequeuePlayers();
    }


    void start() {
        playerQueue = new MyQueue<>();
        cardsArray = new int[4][13];
        for(int i = 0; i < 4; i++) {
            addPlayers();
        }
    }


    void addPlayers() {
        Player player = new Player();
        for (int i = 0; i < 9; i++) {
            allotCard(player);
        }
        player.enqueueCards();
        playerQueue.enqueue(player);	    }


    void allotCard(Player player) {
        Random random = new Random();
        int suit = random.nextInt(4);
        int rank = random.nextInt(13);
        if(cardsArray[suit][rank] == 0) {
            player.addCard(suit, rank);
            cardsArray[suit][rank] = 1;
        }
        else {
            allotCard(player);
        }
    }


    void dequeuePlayers() {
        for(int i = 0; i < 4; i++) {
            Player player = playerQueue.dequeue();
            System.out.println("Player " + (i+1) + "'s cards:");
            printPlayerCards(player);
            System.out.println();
        }
    }


    void printPlayerCards(Player player) {
        for (int i = 0; i < 9; i++) {
            Card card = player.getCard();
            System.out.print(card.getSuit() + " " + card.getRank() + "\t");
        }
        System.out.println();
    }
}
