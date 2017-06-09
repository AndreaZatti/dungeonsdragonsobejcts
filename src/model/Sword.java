package model;

import java.util.Random;

/**
 * Created by sara on 08/06/2017.
 */
public class Sword extends Item implements ItemAttackInterface {

    private int attackPoints;

    public Sword() {
        itemType = ITEM_TYPE.SWORD;
        name = "Sword";
        price = 80;
        attackPoints = 7;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAdditionalAttackPoints() {
        return attackPoints;
    }
}
