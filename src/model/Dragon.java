package com.company;

import java.util.Random;

/**
 * Created by Giorgio on 08/06/2017.
 */



public class Dragon extends Monster{

    private static int defeats = 0;

    @Override
    public int receiveAttack(int damage, boolean isBerserk) {

        hitPoints-=damage;
        int knockback = new Random().nextInt(20)+1;

        if (hitPoints<=0){
            defeats++;
        }

        if (isBerserk){
            knockback= knockback*3;
        }

        return knockback;
    }

    @Override
    public int attackPlayer() {
        return new Random().nextInt(20)+1;
    }

    @Override
    public String getName() {
        return "Dragon";
    }

    public Dragon(){
        super();
        hitPoints = 100;
    }
}
