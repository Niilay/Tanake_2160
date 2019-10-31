// System imports

import java.util.Random;
import java.util.Scanner;

public class bossAttack {
    public void boss() {

        // System
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        // Boss variables.
        String[] bosses = {"Big Bertha", "Arthur (???)", "Alien nightmare goo", "Robots"};

        // Boss action variables.
        String[] actions = {"needs to be stopped before everyone is killed!", "should be killed as fast as possible!", "will try to rip your flesh out!", "needs to be stopped before you are a sack of blood!", "should be killed with fire!"};

        // Environment
        int day = stats.getDay();

        // Player variables.
        int health = stats.getHealth();
        int xP = stats.getXP();

        // Weapon variables.
        int baseGunMaxDamage = stats.getBaseGunMaxDamage();
        int baseGunMinDamage = stats.getBaseGunMinDamage();
        int specialMinDamage = stats.getSpecialMinDamage();
        int specialMaxDamage = stats.getSpecialMaxDamage();

        // Bosses.
        int maxBossHealth = 300;
        int maxBossAttack = 50;
        int maxXpBoss = 500;

        int startMoney = stats.getstartMoney();
        int moneyDropBoss = 1000;
        int moneyDropChance = 80; // Percentage %
        int enhanceDrop = 30; // Percentage %
        int escapeChance = 50; // Percentage %
        int escapeAmount = stats.getEscapeAmount();

        // Inventory variables.
        int specialAmount = stats.getSpecialAmount();
        int enhancementLimbs = stats.getEnhancementLimbs();
        int healthEnhanceAmount = 35;

        // Rare items
        int exoskeleton = 0;
        int laserHat = 0;
        int ionGun = 0;
        int nanoSuit = 0;

        // baseGunMaxDamage
        int exoskeletonBase = 10;
        int laserHatBase = 20;
        int ionGunBase = 20;
        int nanoSuitBase = 30;

        // specialMaxDamage
        int exoskeletonSpecial = 5;
        int laserHatSpecial = 15;
        int ionGunSpecial = 15;
        int nanoSuitSpecial = 30;

        // Rare items - drop chance (from bosses).
        int exoskeletonChance = 25; // Percentage %
        int laserHatChance = 20; // Percentage %
        int ionGunChance = 15; // Percentage %
        int nanoSuitChance = 10; // Percentage %

        // Extremely rare items
        String[] extremelyRareItems = {""};
        int extremelyRareItemBaseAttack = 50;
        int extremelyRareItemSpecialAttack = 25;

        // Unicode UTF-8 symbols
        String unicodeMessageHP = "\uD83D\uDC96";
        String unicodeMessageMaxDamage = "\uD83D\uDD2B";
        String unicodeMessageCommonAttack = "\uD83D\uDD25";
        String unicodeMessageSpecialAttack = "\uD83D\uDDF2";
        String unicodeMessageMoneyDrop = "\uD83D\uDCB0";
        String unicodeMessageItemDrop = "\uD83C\uDF82";
        String unicodeSleep = "\uD83D\uDCA4";
        String unicodeEnhance = "\uD83D\uDD74";
        String unicodeRun = "\uD83C\uDFC3";
        String unicodeRare = "\uD83D\uDC8D";
        String unicodeEnemyDead = "\uD83D\uDC80";
        String unicodeXp = "\uD83D\uDCDA";

        boolean enemyFight = true;
        while (enemyFight) {

            System.out.println("Do you wish to go and fight crime?");
            System.out.println("\n1. Yes. Let's do it!\t2. No. I rather go home.");
            String input = scanner.nextLine();

            // Menu for attack options ( Common attack starts here )...................................................................................................................................................................................................................................
            if (input.equals("1")) {

                // Common enemy attack
                int enemyHealth = rand.nextInt(maxBossHealth);
                String enemy = bosses[rand.nextInt(bosses.length)];
                String enemyAction = actions[rand.nextInt(actions.length)];

                System.out.println("\n--------------------------------------------------------------");
                System.out.println(enemy + " stopped you and " + enemyAction);
                System.out.println("--------------------------------------------------------------");

                // While the enemy has > 0 health, this while loop is active.
                while (enemyHealth > 0) {

                    System.out.println("\n\t------------------------------------------------------");
                    System.out.println("\t" + unicodeMessageHP + " Your HP: " + health + "\n\t" + unicodeMessageMaxDamage + " Your max damage: " + baseGunMaxDamage + "\n\t" + unicodeMessageSpecialAttack + " Your special damage: " + "[" + specialMinDamage + " - " + specialMaxDamage + "]");
                    System.out.println("\t------------------------------------------------------");
                    System.out.println("\n\t------------------------------------------------------");
                    System.out.println("\t" + unicodeMessageHP + " " + enemy + "'s HP: " + enemyHealth);
                    System.out.println("\t" + unicodeMessageMaxDamage + " " + enemy + "'s max damage: " + maxBossAttack);
                    System.out.println("\t------------------------------------------------------");
                    System.out.println("\n\n\tWhat is your choice?");
                    System.out.println("\n\t1. Attack" + "\n\t2. Special Attack" + "\t[Left: " + specialAmount + "]" + "\n\t3. Outsmart them and run away" + "\t[Left: " + escapeAmount + "]" + "\n\t4. Use enhancement limb" + "\t[Left: " + enhancementLimbs + "]\n");

                    // Fight! (common enemy) with choices: 1, 2, 3 or 4. ( (input.equals is a String function).
                    String fightinput = scanner.nextLine();

                    // Normal attack......................................................................................................................................................
                    // Range = (max - min)
                    // Formula is rand.nextInt((max - min) + 1) + min
                    if (fightinput.equals("1")) {
                        int damageGiven = rand.nextInt((baseGunMaxDamage - baseGunMinDamage) + 1) + baseGunMinDamage;
                        int damageTaken = rand.nextInt(maxBossAttack);

                        enemyHealth -= damageGiven;
                        health -= damageTaken;
                        stats.setHealth(health);

                        System.out.println("----------------------------------------------------------");
                        System.out.println(unicodeMessageCommonAttack + " You hit the " + enemy + " for " + damageGiven + " HP!");
                        System.out.println(unicodeMessageCommonAttack + " The " + enemy + " hit you for " + damageTaken + " HP!");
                        System.out.println("----------------------------------------------------------");

                        if (damageGiven < 1) {
                            System.out.println("\t\t\nYou missed the enemy!\n");
                        }

                        // If you die.
                        if (health < 1) {
                            System.out.println("\n" +
                                    "   ___  ___  ___  _   _  _  _  _   _   ___  ___  __  ||\n" +
                                    "  |_ _|| __|| o \\| \\_/ || || \\| | / \\ |_ _|| __||  \\ L|\n" +
                                    "   | | | _| |   /| \\_/ || || \\\\ || o | | | | _| | o )  \n" +
                                    "   |_| |___||_|\\\\|_| |_||_||_|\\_||_n_| |_| |___||__/ ()\n");

                            System.out.println("\t\t    Press [Enter] to start new game");
                            scanner.nextLine();
                            story goToStory = new story();
                            goToStory.storyLine();

                            // If the enemy dies.
                        } else if (enemyHealth < 1) {

                            // One new escape for each enemy defeated. Save them up or use them.
                            escapeAmount++;

                            System.out.println("\nYou have defeated the " + enemy);

                            // XP gained
                            int xCommon = rand.nextInt(maxXpBoss);
                            xP += xCommon;
                            stats.setXP(xP);
                            System.out.println("----------------------------------------------------------");
                            System.out.println(unicodeXp + " xP gained: " + "[" + xCommon + "xP]" + " Your xP is now: " + "[" + xP + "xP]");
                            System.out.println("----------------------------------------------------------");

                            // Money drop chance
                            if (rand.nextInt(100) < moneyDropChance) {
                                startMoney += moneyDropBoss;
                                stats.setStartMoney(startMoney);
                                System.out.println("----------------------------------------------------------");
                                System.out.println(unicodeMessageMoneyDrop + " The " + enemy + " dropped " + "[" + moneyDropBoss + "$]");
                                System.out.println("You now have: " + "[" + startMoney + "$]");
                                System.out.println("----------------------------------------------------------");
                            }

                            // Special refill drop chance
                            if (rand.nextInt(100) < enhanceDrop) {
                                specialAmount++;
                                stats.setSpecialAmount(specialAmount);
                                System.out.println("-----------------------------");
                                System.out.println(unicodeMessageItemDrop + " A Special refill dropped" + "\nYou now have: " + specialAmount);
                                System.out.println("-----------------------------");
                            }

                            // Rare items
                            // Exoskeleton drop chance (common enemy).
                            if (rand.nextInt(100) < exoskeletonChance) {
                                exoskeleton++;
                                baseGunMinDamage += exoskeletonBase;
                                baseGunMaxDamage += exoskeletonBase;
                                specialMinDamage += exoskeletonSpecial;
                                specialMaxDamage += exoskeletonSpecial;

                                stats.setBaseGunMinDamage(baseGunMinDamage);
                                stats.setBaseGunMaxDamage(baseGunMaxDamage);
                                stats.setSpecialMinDamage(specialMinDamage);
                                stats.setSpecialMaxDamage(specialMaxDamage);

                                System.out.println("----------------------------------------------------------");
                                System.out.println(unicodeRare + " A rare item dropped! An exoskeleton!\nYour damage is now: " + "[" + baseGunMinDamage + " - " + baseGunMaxDamage + "]" + "\nYour special attack is: " + "[" + specialMinDamage + " - " + specialMaxDamage + "]");
                                System.out.println("----------------------------------------------------------");
                            }
                        }

                        // Special attack......................................................................................................................................................
                    } else if (fightinput.equals("2")) {
                        int damageGiven = rand.nextInt((specialMaxDamage - specialMinDamage) + 1) + specialMinDamage;
                        int damageTaken = rand.nextInt(maxBossAttack);

                        if (specialAmount > 0) {

                            specialAmount--;
                            enemyHealth -= damageGiven;
                            health -= damageTaken;
                            stats.setHealth(health);

                            if (damageGiven < 1) {
                                System.out.println("\t\t\nYou missed the enemy!\n");
                            }

                            System.out.println("----------------------------------------------------------");
                            System.out.println(unicodeMessageSpecialAttack + " You have used a special attack, dealing " + damageGiven + " damage!!");
                            System.out.println(unicodeMessageCommonAttack + " The " + enemy + " hit you for " + damageTaken + " HP!");
                            System.out.println("----------------------------------------------------------");
                        }

                        // If you die.
                        // If you die.
                        if (health < 1) {
                            System.out.println("\n" +
                                    "   ___  ___  ___  _   _  _  _  _   _   ___  ___  __  ||\n" +
                                    "  |_ _|| __|| o \\| \\_/ || || \\| | / \\ |_ _|| __||  \\ L|\n" +
                                    "   | | | _| |   /| \\_/ || || \\\\ || o | | | | _| | o )  \n" +
                                    "   |_| |___||_|\\\\|_| |_||_||_|\\_||_n_| |_| |___||__/ ()\n");

                            System.out.println("\t\t    Press [Enter] to start new game");
                            scanner.nextLine();
                            story goToStory = new story();
                            goToStory.storyLine();


                            // If the enemy dies.
                        } else if (enemyHealth < 1) {
                            System.out.println("\nYou have defeated the " + enemy);

                            // One new escape for each enemy defeated. Save them up or use them.
                            escapeAmount++;
                            stats.setEscapeAmount(escapeAmount);

                            // XP gained
                            int xCommon = rand.nextInt(maxXpBoss);
                            xP += xCommon;
                            stats.setXP(xP);
                            System.out.println("----------------------------------------------------------");
                            System.out.println(unicodeXp + " xP gained: " + "[" + xCommon + "xP]" + " Your xP is now: " + "[" + xP + "xP]");
                            System.out.println("----------------------------------------------------------");

                            // Money drop drop chance.
                            if (rand.nextInt(100) < moneyDropChance) {
                                startMoney += moneyDropBoss;
                                stats.setStartMoney(startMoney);
                                System.out.println("----------------------------------------------------------");
                                System.out.println(unicodeMessageMoneyDrop + " The " + enemy + " dropped " + "[" + moneyDropBoss + "$]");
                                System.out.println("You now have: " + "[" + startMoney + "$]");
                                System.out.println("----------------------------------------------------------");
                            }

                            // Special refill drop chance.
                            if (rand.nextInt(100) < enhanceDrop) {
                                specialAmount++;
                                System.out.println("-----------------------------");
                                System.out.println(unicodeMessageItemDrop + " A Special refill dropped!" + "\nYou now have: " + specialAmount);
                                System.out.println("-----------------------------");
                            }

                            // Rare items
                            // Exoskeleton drop chance (common enemy).
                            if (rand.nextInt(100) < exoskeletonChance) {
                                exoskeleton++;
                                baseGunMinDamage += exoskeletonBase;
                                baseGunMaxDamage += exoskeletonBase;
                                specialMinDamage += exoskeletonSpecial;
                                specialMaxDamage += exoskeletonSpecial;

                                stats.setBaseGunMinDamage(baseGunMinDamage);
                                stats.setBaseGunMaxDamage(baseGunMaxDamage);
                                stats.setSpecialMinDamage(specialMinDamage);
                                stats.setSpecialMaxDamage(specialMaxDamage);

                                System.out.println("----------------------------------------------------------");
                                System.out.println(unicodeRare + " A rare item dropped! An exoskeleton!\nYour damage is now: " + "[" + baseGunMinDamage + " - " + baseGunMaxDamage + "]" + "\nYour special attack is: " + "[" + specialMinDamage + " - " + specialMaxDamage + "]");
                                System.out.println("----------------------------------------------------------");
                            }
                        }

                        // If you choose to run away.......................................................................................................................................................
                    } else if (fightinput.equals("3")) {

                        // If you have more than one escape left
                        if (escapeAmount > 0) {

                            // One less escape try for each use. Set to global stats.
                            escapeAmount--;
                            stats.setEscapeAmount(escapeAmount);

                            if (rand.nextInt(100) < escapeChance) {
                                System.out.println("---------------------------------------------------------------");
                                System.out.println(unicodeRun + " You successfully ran away from the " + enemy);
                                System.out.println("---------------------------------------------------------------");
                                break;

                            } else {
                                System.out.println("---------------------------------------------------------------");
                                System.out.println(unicodeRun + " You could not run away from the " + enemy);
                                System.out.println("---------------------------------------------------------------");
                            }

                        } else {
                            System.out.println("---------------------------------------------------------------");
                            System.out.println("The " + enemy + " has you trapped.\nYou have: " + escapeAmount + " escape tries left.");
                            System.out.println("---------------------------------------------------------------");
                        }

                        // If you use an enhancement limb.......................................................................................................................................................
                    } else if (fightinput.equals("4")) {
                        if (enhancementLimbs > 0) {
                            health += healthEnhanceAmount;
                            enhancementLimbs--;
                            stats.setEnhancementLimbs(enhancementLimbs);
                            System.out.println("----------------------------------------------------------");
                            System.out.println("You have used an Enhancement Limb, healing you " + healthEnhanceAmount + " HP");
                            System.out.println("----------------------------------------------------------");

                        } else {
                            System.out.println("----------------------------------------------------------");
                            System.out.println("You have no enhancement limbs left.");
                            System.out.println("----------------------------------------------------------");
                        }

                    } else {
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Invalid input!");
                        System.out.println("-----------------------------------------------------------");
                    }
                }

                // If you do not choose to fight you skip a day.

            } else if (input.equals("2")) {
                System.out.println("----------------------------------------------------------");
                System.out.println("You go back home.");
                System.out.println("----------------------------------------------------------\n");
                home gohome = new home();
                gohome.homeMethod();


            } else {
                System.out.println("----------------------------------------------------------");
                System.out.println("Invalid input!");
                System.out.println("----------------------------------------------------------");
                continue;
            }
        }
    }
}