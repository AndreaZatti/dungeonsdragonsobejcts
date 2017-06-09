package model;

import java.util.Random;

/**
 * Created by sara on 07/06/2017.
 */
public class Hoard {
    private int goldPieces;

    public Hoard() {
        Random r = new Random();
        goldPieces = r.nextInt(100) + 1;
    }

    public int getGoldPieces() {
        return goldPieces;
    }

    public void setGoldPieces(int goldPieces) {
        this.goldPieces = goldPieces;
    }
}
