package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sara on 06/06/2017.
 */
public class Player {

    private String name;

    private String username;

    private int hitPoints;

    private int magicPoints;

    //private List<Helmet> items = new ArrayList<Helmet>();

    private List<Hoard> hoards = new ArrayList<Hoard>();

    public Player() {
        hitPoints = 100;
        magicPoints = 3;
    }

    public Player(String name, String username) {
        this.name = name;
        this.username = username;
        hitPoints = 100;
        magicPoints = 3;
    }

    public void decreaseHitPoints(int damage) {
        hitPoints -= damage;
    }

    public int attack(boolean isBerserk) {
        int damage = new Random().nextInt(15) + 1;

        if (!isBerserk) {
            return damage;
        } else {
            return (damage) * 3;
        }
    }

    /*
    public List<Helmet> getItems() {
        return items;
    }

    public void addItem(Helmet item) {
        items.add(item);
    }*/

    public void addHoard(Hoard hoard) {
        hoards.add(hoard);
    }

    public void castMagicSpell() {
        magicPoints = magicPoints - 1;
        hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getMagicPoints() {
        return magicPoints;
    }

    public void setMagicPoints(int magicPoints) {
        this.magicPoints = magicPoints;
    }

    public List<Hoard> getHoards() {
        return hoards;
    }

    public void setHoards(List<Hoard> hoards) {
        this.hoards = hoards;
    }

    public int doAttack() {
        return new Random().nextInt(15);
    }

    public int goBerserk() {
        return doAttack() * 3;
    }

    public void subtractHitPoints(int points) {
        hitPoints -= points;
    }


    public String getDescription() {
        return "Hello " + name + ". I am your player. My name is " + username + ". \n"
                + "I have " + hitPoints + " Hit Points and " + magicPoints + " Magic Points. \n"
                + "I have " + hoards.size() + " hoards of gold, but I plan on getting more from the monsters I will encounter.";
    }
}
