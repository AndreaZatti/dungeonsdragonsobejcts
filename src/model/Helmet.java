package model;

/**
 * Created by sara on 08/06/2017.
 */
public class Helmet extends Item implements ItemDefenseInterface {

    private int defensePoints;

    private int hitPoints;

    public Helmet() {
        itemType = ITEM_TYPE.HELMET;
        name = "Helmet";
        price = 70;
        defensePoints = 10;
        hitPoints = 30;
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
    public int getAdditionalDefensePoints() {
        return defensePoints;
    }

    @Override
    public int getAdditonalHitPoints() {

        return hitPoints;
    }
}
