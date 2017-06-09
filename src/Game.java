import model.*;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by sara on 07/06/2017.
 */

public class Game {

    private static final int MAX_MONSTERS = 10;

    private int defeatedMonsters = 0;

    private Player player;

    private boolean hasDefeatedDragon;

    private Shop shop;

    public Game() {

    }

    public void startPlaying() {


        printLine("What's your name?");
        String name = readLine();

        printLine("Choose a username");
        String username = readLine();

        player = new Player(name, username);
        startFighting();
    }

    private void shop(Shop shop) {
        printLine("Cosa vuoi comprare? (H elmo S spada)");
        String answer = readLine();

        if (answer.equalsIgnoreCase("H")) {
            Helmet helmet = (Helmet) shop.buyItem(Item.ITEM_TYPE.HELMET);
        }
    }

    private void startFighting() {
        while (defeatedMonsters <= MAX_MONSTERS && player.getHitPoints() > 0 && !hasDefeatedDragon) {

            Random r = new Random();
            int nextMonsterInt = r.nextInt(10) + 1;
            Monster monster = null;

            switch (nextMonsterInt) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    monster = new Goblin();
                    break;
                /*default:
                    monster = new Monster() {
                        @Override
                        public String getName() {
                            return null;
                        }

                        @Override
                        public int attackPlayer() {
                            return 0;
                        }

                        @Override
                        public int receiveAttack(int receivedAttack, boolean isBerserk) {
                            return 0;
                        }
                    };*/

                /*
                case 6:
                case 7:
                case 8:
                    monster = new Troll();
                    break;
                case 9:
                case 10:
                    monster = new Dragon();
                    break;*/
            }

            //TODO start
            monster = new Goblin();
            //TODO end

            printLine("Your enemy is a " + monster.getName() + ". It's your turn.");
            boolean playerTurn = true;
            boolean isEscaped = false;

            while (player.getHitPoints() > 0 && monster.getHitPoints() > 0 && !isEscaped) {
                //Combattimento
                if (playerTurn) {

                    printLine("What's your next move?");
                    printLine("(B)uy a helmet"
                            + "\n(R)un away" +
                            "\n (A)ttack - You attack the monster causing a random number of hit points damage (between 1 and 15)." +
                            "\n (B)erserk - You attack the monster while ignoring their own defense, causing triple damages (1 to 15) to the monster, but causing double damage to be done by the Monster to the Player." +
                            "\n (M)agic - You cast a Magic Heal Spell. This reduces the number of Magic Points by one. The Magic Heal Spell resets your Hit Points to 100. However, the monster has a free receiveAttack.");


                    String chosenOption = readLine();
                    if (chosenOption.equalsIgnoreCase("R")) {
                        //Run away
                        isEscaped = true;
                        printLine("You ran away.");
                    } else if (chosenOption.equalsIgnoreCase("A")) {
                        //Attack
                        int damage = player.attack(false);
                        int knockback = monster.receiveAttack(damage, false);
                        player.decreaseHitPoints(knockback);
                        printLine("You attacked the " + monster.getName() +
                                "\n Damage: " + damage + "\n"
                                + "\n Knockback: " + knockback);
                        playerTurn = false;
                    } else if (chosenOption.equalsIgnoreCase("B")) {
                        //Berserk
                        int damage = player.attack(true);
                        int knockback = monster.receiveAttack(damage, true);
                        player.decreaseHitPoints(knockback);
                        printLine("You went berserk on a " + monster.getName() +
                                "\n Damage: " + damage +
                                "\n Knockback: " + knockback);
                        playerTurn = false;
                    } else if (chosenOption.equalsIgnoreCase("M")) {
                        //Magic
                        int restoredPoints = 100 - player.getHitPoints();
                        player.castMagicSpell();
                        printLine("You restored " + restoredPoints + " hit points!");
                        playerTurn = false;
                    } else {
                        printLine("Invalid option.");
                    }
                } else {
                    //Attacco normale
                    int collateralDamage = monster.attackPlayer();
                    player.decreaseHitPoints(collateralDamage);
                    printLine("The " + monster.getName() + " attacked you\n" +
                            "Damage: " + collateralDamage +
                            "\n Your hits points left: " + player.getHitPoints());
                    playerTurn = true;
                }

                if (isEscaped) {
                    int damage = monster.attackPlayer();
                    printLine("You skipped turn. The " + monster.getName() + " attacked you and inflicted " + damage + " points damage");
                    player.decreaseHitPoints(damage);
                    //isEscaped = false;
                }

                //qui
                isEscaped = false;
            }

            //monster (dragon?) /player deceased
            if (monster.getHitPoints() <= 0) {
                defeatedMonsters++;
                printLine("The " + monster.getName() + " is dead. Great!");
                Hoard monsterHoard = monster.getHoard();
                player.addHoard(monsterHoard);

                if (monster.getName().equalsIgnoreCase("Dragon")) {
                    hasDefeatedDragon = true;
                }
            }
        }

        if (player.getHitPoints() <= 0) {
            printLine("You are dead. Better luck next time.");
        } else {
            printLine("You won! Congratulations.");
            if (hasDefeatedDragon) {
                printStats();
            }
        }
    }

    private void printStats() {
        printLine("Hit points: " + player.getHitPoints()
                + "\n Magic points: " + player.getMagicPoints()
                + "\n Hoard: " + player.getHoards().size());
    }

    private void printLine(String text) {
        System.out.println(text);
    }

    private String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


}
