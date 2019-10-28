// System imports

import java.util.Random;
import java.util.Scanner;

public class enemyAttack {
    public void enemy() {

        // System
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        // Enemy variables.
        String[] enemies = {"Ice Dragon Tribe gangster", "Sanguine Vulture gangster", "Reapers gangster", "Fire Tigers gangster", "Wolves gangster", "Monkey Clan gangster", "Men Of The Night gangster", "Violet Snake Gang gangster", "Cobalt Rat Riders gangster", "Gold Coyotes gangster", "Grey Elephant Squad gangster", };

        // Enemy action variables.
        String[] actions = {"beating up homeless people!", "selling drugs!", "stealing from citizens!", "breaking into an apartment!", "pushing citizens around!", "being too drunk and harassing people!", "smoking Violet in public!", "being cruel to a dog!", "being high and nude in public!", "setting fire to random birds!", "blotting himself in public!", "robbing a liqueur store!", "drug dealing to kids!", "using counterfeited dollars at Blits & Chips!"};

        int day = stats.getDay();

        int xP = stats.getXP();
        int maxXpCommon = 50;

            // Player variables.
        int health = stats.getHealth();

        // Weapon variables.
        int baseGunMinDamage = stats.getBaseGunMinDamage();
        int baseGunMaxDamage = stats.getBaseGunMaxDamage();
        int specialMinDamage = stats.getSpecialMinDamage();
        int specialMaxDamage = stats.getSpecialMaxDamage();

        int maxCommonAttack = 24;

        int startMoney = stats.getstartMoney();
        int moneyDropCommon = rand.nextInt(250) + 50;
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
        int exoskeletonBase = 5;
        int exoskeletonBaseMax = 5;
        int laserHatBase = 20;
        int ionGunBase = 20;
        int nanoSuitBase = 30;

        // specialMaxDamage
        int exoskeletonSpecial = 5;
        int laserHatSpecial = 15;
        int ionGunSpecial = 15;
        int nanoSuitSpecial = 30;

        // Rare items - drop chance (from common enemies).
        int exoskeletonChanceCommon = 5; // Percentage %
        int laserHatChanceCommon = 2; // Percentage %
        int ionGunChanceCommon = 2; // Percentage %
        int nanoSuitChanceCommon = 1; // Percentage %

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
                int enemyHealth = rand.nextInt(100) + 20;
                String enemy = enemies[rand.nextInt(enemies.length)];
                String enemy2 = actions[rand.nextInt(actions.length)];

                System.out.println("\n--------------------------------------------------------------");
                System.out.println("A " + enemy + " is seen " + enemy2);
                System.out.println("--------------------------------------------------------------");

                // While the enemy has > 0 health, this while loop is active.
                while (enemyHealth > 0) {

                    System.out.println("\n\t------------------------------------------------------");
                    System.out.println("\t" + unicodeMessageHP + " Your HP: " + health + "\n\t" + unicodeMessageMaxDamage + " Your damage: " + "["+ baseGunMinDamage + " - " + baseGunMaxDamage + "]" + "\n\t" + unicodeMessageSpecialAttack + " Your special damage: " + "[" + specialMinDamage + " - " + specialMaxDamage + "]");
                    System.out.println("\t------------------------------------------------------");
                    System.out.println("\n\t------------------------------------------------------");
                    System.out.println("\t" + unicodeMessageHP + " " + enemy + "'s HP: " + enemyHealth);
                    System.out.println("\t" + unicodeMessageMaxDamage + " " + enemy + "'s max damage: " + maxCommonAttack);
                    System.out.println("\t------------------------------------------------------");
                    System.out.println("\n\tWhat is your choice?");
                    System.out.println("\n\t1. Attack" + "\n\t2. Special Attack" + "\t[Left: " + specialAmount + "]" + "\n\t3. Outsmart them and run away" + "\t[Left: " + escapeAmount + "]" + "\n\t4. Use enhancement limb" + "\t[Left: " + enhancementLimbs + "]\n");

                    // Fight! (common enemy) with choices: 1, 2, 3 or 4. ( (input.equals is a String function).
                    String fightinput = scanner.nextLine();

                    // Normal attack......................................................................................................................................................
                    // Range = (max - min)
                    // Formula is rand.nextInt((max - min) + 1) + min
                    if (fightinput.equals("1")) {
                        int damageGiven = rand.nextInt((baseGunMaxDamage - baseGunMinDamage) + 1) + baseGunMinDamage;
                        int damageTaken = rand.nextInt(maxCommonAttack);

                        enemyHealth -= damageGiven;
                        health -= damageTaken;
                        stats.setHealth(health);

                        System.out.println("----------------------------------------------------------");
                        System.out.println(unicodeMessageCommonAttack + " You hit the " + enemy + " for " + damageGiven + " HP!");
                        System.out.println(unicodeMessageCommonAttack + " The " + enemy + " hit you for " + damageTaken + " HP!");
                        System.out.println("----------------------------------------------------------");

                        if (damageGiven < baseGunMinDamage) {
                            System.out.println("\t\t\nYou missed the enemy!\n");
                        }

                        // If you die.
                        if (health < 1) {
                            System.out.println("\t\t\nYou are terminated!");
                            break;

                            // If the enemy dies.
                        } else if (enemyHealth < 1) {

                            // One new escape for each enemy defeated. Save them up or use them.
                            escapeAmount++;

                            System.out.println("----------------------------------------------------------");
                            System.out.println(unicodeEnemyDead + " You have defeated the " + enemy + "!");
                            System.out.println("----------------------------------------------------------");

                            // XP gained
                            int xCommon = rand.nextInt(maxXpCommon);
                            xP += xCommon;
                            stats.setXP(xP);
                            System.out.println("----------------------------------------------------------");
                            System.out.println(unicodeXp + " xP gained: " + "[" + xCommon + "xP]" + " Your xP is now: " + "[" + xP + "xP]");
                            System.out.println("----------------------------------------------------------");

                            // Money drop chance
                            if (rand.nextInt(100) < moneyDropChance) {
                                startMoney += moneyDropCommon;
                                stats.setStartMoney(startMoney);
                                System.out.println("----------------------------------------------------------");
                                System.out.println(unicodeMessageMoneyDrop + " The " + enemy + " dropped " + "[" + moneyDropCommon + "$]");
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
                            if (rand.nextInt(100) < exoskeletonChanceCommon) {
                                exoskeleton++;
                                baseGunMinDamage += exoskeletonBase;
                                baseGunMaxDamage += exoskeletonBaseMax;
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
                        int damageTaken = rand.nextInt(maxCommonAttack);

                        if (specialAmount > 0) {

                            specialAmount--;
                            enemyHealth -= damageGiven;
                            health -= damageTaken;
                            stats.setHealth(health);

                            if (damageGiven < 0) {
                                System.out.println("\t\t\nYou missed the enemy!\n");
                            }

                            System.out.println("----------------------------------------------------------");
                            System.out.println(unicodeMessageSpecialAttack + " You have used a special attack, dealing " + damageGiven + " damage!!");
                            System.out.println(unicodeMessageCommonAttack + " The " + enemy + " hit you for " + damageTaken + " HP!");
                            System.out.println("----------------------------------------------------------");
                        }

                        // If you die.
                        if (health < 1) {
                            System.out.println("\t\t\nYou are terminated!");


                            // If the enemy dies.
                        } else if (enemyHealth < 1) {
                            System.out.println("----------------------------------------------------------");
                            System.out.println(unicodeEnemyDead + " You have defeated the " + enemy + "!");
                            System.out.println("----------------------------------------------------------");

                            // One new escape for each enemy defeated. Save them up or use them.
                            escapeAmount++;
                            stats.setEscapeAmount(escapeAmount);

                            // XP gained
                            int xCommon = rand.nextInt(maxXpCommon);
                            xP += xCommon;
                            stats.setXP(xP);
                            System.out.println("----------------------------------------------------------");
                            System.out.println(unicodeXp + " xP gained: " + "[" + xCommon + "xP]" + " Your xP is now: " + "[" + xP + "xP]");
                            System.out.println("----------------------------------------------------------");


                            // Money drop drop chance.
                            if (rand.nextInt(100) < moneyDropChance) {
                                startMoney += moneyDropCommon;
                                stats.setStartMoney(startMoney);
                                System.out.println("----------------------------------------------------------");
                                System.out.println(unicodeMessageMoneyDrop + " The " + enemy + " dropped " + "[" + moneyDropCommon + "$]");
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
                            if (rand.nextInt(100) < exoskeletonChanceCommon) {
                                exoskeleton++;
                                baseGunMinDamage += exoskeletonBase;
                                baseGunMaxDamage += exoskeletonBaseMax;
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
                                System.out.println(unicodeRun + " You successfully ran away from the " + enemy + "!");
                                System.out.println("---------------------------------------------------------------");
                                break;

                            } else {
                                System.out.println("---------------------------------------------------------------");
                                System.out.println(unicodeRun + " You could not run away from the " + enemy + "!");
                                System.out.println("---------------------------------------------------------------");
                            }

                        } else {
                            System.out.println("---------------------------------------------------------------");
                            System.out.println("The " + enemy + " has you trapped!\nYou have: " + escapeAmount + " escape tries left.");
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
                System.out.println("You go back home..");
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