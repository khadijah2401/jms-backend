package main.java.com.example.jms.model;

import java.util.List;

public class CoinResponse {
    private List<Double> coins;

    public CoinResponse(List<Double> coins) {
        this.coins = coins;
    }

    public List<Double> getCoins() {
        return coins;
    }

    public void setCoins(List<Double> coins) {
        this.coins = coins;
    }
}
