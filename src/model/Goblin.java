package model;

import java.util.Random;

/**
 * Created by sara on 07/06/2017.
 */
public class Goblin extends Monster {

    //Togliere variabile statica!
    private static int defeats = 0;

    public Goblin() {
        hitPoints = 10;
        hoard = new Hoard();
    }

    @Override
    public String getName() {
        return "Goblin";
    }

    @Override
    public int attackPlayer() {
        int damage = new Random().nextInt(5) + 1;
        return damage;
    }

    @Override
    public int receiveAttack(int receivedAttack, boolean isBerserk) {
        hitPoints -= receivedAttack;

        if (hitPoints <= 0) {
            defeats++;
        }

        int damage = new Random().nextInt(5) + 1;

        if (isBerserk) {
            damage = damage * 3;
        }

        return damage;
    }
}
