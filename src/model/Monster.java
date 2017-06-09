package model;

import model.Hoard;

/**
 * Created by sara on 07/06/2017.
 */
public abstract class Monster {
    int hitPoints;

    Hoard hoard;

    public int getHitPoints(){
        return hitPoints;
    }

    public Hoard getHoard() {
        return hoard;
    }

    public abstract String getName();

    public abstract int attackPlayer();

    public abstract int receiveAttack(int receivedAttack, boolean isBerserk);
}
