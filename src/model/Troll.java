package model;

import java.util.Random;

/**
 * Created by sara on 08/06/2017.
 */
public class Troll extends Monster {
    @Override
    public String getName() {
        return "Troll";
    }

    @Override
    public int attackPlayer() {
        return new Random().nextInt(10) + 1;
    }

    @Override
    public int receiveAttack(int receivedAttack, boolean isBerserk) {
        //TODO
        return 0;
    }
}
