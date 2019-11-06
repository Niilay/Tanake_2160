// System imports

import java.util.Random;
import java.util.Scanner;

public class home {
    public void homeMethod() {

        // System
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        int day = stats.getDay();

        int maxHealth = stats.getMaxHealth();
        int health = stats.getHealth();
        int xP = stats.getXP();
        int startMoney = stats.getstartMoney();
        int homeHP = 100;

        // Weapon variables.
        int baseGunMinDamage = stats.getBaseGunMinDamage();
        int baseGunMaxDamage = stats.getBaseGunMaxDamage();
        int specialMinDamage = stats.getSpecialMinDamage();
        int specialMaxDamage = stats.getSpecialMaxDamage();

        // Inventory variables.
        int specialAmount = stats.getSpecialAmount();
        int enhancementLimbs = stats.getEnhancementLimbs();
        int escapeAmount = stats.getEscapeAmount();

        // Leveling system
        int maxHealthAdd = 35;
        String[] levels = {"Bitch", "Trainee", "Rookie", "Supervisor", "Pro", "Killer Machine", "Infamous", "Legendary", "Badass", "Badass MOFO"};
        Integer[] xPs = {250, 750, 1500, 3000, 5000, 8000, 12000, 18000, 24000, 36000};

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

        // UTF-8 characters
        String unicodeMessageHP = "\uD83D\uDC96";
        String unicodeMessageMaxDamage = "\uD83D\uDD2B";
        String unicodeMessageSpecialAttack = "\uD83D\uDDF2";
        String unicodeMessageMoneyDrop = "\uD83D\uDCB0";
        String unicodeSleep = "\uD83D\uDCA4";
        String unicodeEnhance = "\uD83D\uDD74";
        String unicodeRun = "\uD83C\uDFC3";
        String unicodeRare = "\uD83D\uDC8D";
        String unicodeSunrise = "\uD83C\uDF04";
        String unicodeXp = "\uD83D\uDCDA";


        // In the comfort of your home ( main loop ) - This is a "hub" for everything the player can do in the game
        boolean home = true;
        while (home) {

            // City is sleeping ASCII art
            System.out.println("                      .|.       ,       +\n" +
                    "             *        |.|      ((             *\n" +
                    "                  *   |.|       `      ____\n" +
                    "         +      __    |.|   *   ___   |.  .|   ___\n" +
                    "     __      .-'  '-._|.|      |...|  |.  .| _|. .|\n" +
                    "    | .|  _.|. |.  .||   '-__  | . |  |.  .||  . .|\n" +
                    "    |. | |.   .|.  .||  .  - | |. .|  |.  .||  . .|\n" +
                    "    | .|-'     ' ..          '-' . '--' .. ''   . |\n" +
                    "''''''''''''''''''''''''''''''''''''''''''''''''''''''''");

            System.out.println("\nYou are home.");
            System.out.println("\n-------\ttype 'stats' when at home, for viewing stats." +
                    "\n-------\ttype 'casino' when at home, to go to the casino.\n-------\ttype 'fight' when at home, to go and fight crime.\n-------\ttype 'shop' when at home, to go to the shop.\n\n-------\ttype 'sleep' to proceed to the next day\n");

            // Home menu
            String homeinput = scanner.nextLine();

            if (homeinput.equals("stats")) {
                System.out.println("\nStats:");
                System.out.println("---------------------------");
                System.out.println(unicodeXp + " Experience: " + xP + " xP\n" + unicodeMessageMoneyDrop + " Cash: " + startMoney + "$" + "\n" + unicodeMessageHP + " Health: " + health + "\n" + unicodeMessageMaxDamage + " Damage: " + "[" + baseGunMinDamage + " - " + baseGunMaxDamage + "]" + "\n" + unicodeMessageSpecialAttack + " Special damage: " + "[" + specialMinDamage + " - " + specialMaxDamage + "]" + "\n" + unicodeEnhance + " Enhancement limbs: " + enhancementLimbs + "\n" + unicodeRun + " Escapes: " + escapeAmount + "\n" + unicodeRare + " Rare items: ");
                System.out.println("---------------------------\n");

                if (exoskeleton == 1) {
                    System.out.println("You have: " + exoskeleton + " exoskeleton giving you +" + exoskeletonBase + " max damage " + "and +" + exoskeletonSpecial + " max special damage");
                }

            } else if (homeinput.equals("casino")) {
                System.out.println("\nYou go to the casino..");
                casino gocasino = new casino();
                gocasino.games();

            } else if (homeinput.equals("fight")) {

                // Common enemy attack (class)
                enemyAttack attack = new enemyAttack();
                attack.enemy();

            } else if (homeinput.equals("shop")) {

                // Shop (class)
                shop goshop = new shop();
                goshop.shopMethod();

            } else if (homeinput.equals("iamrich")) {
                startMoney += 99750;
                stats.setStartMoney(startMoney);

            } else if (homeinput.equals("iamstrong")) {
                baseGunMaxDamage += 10000;
                health += 10000;
                stats.setHealth(health);
                stats.setBaseGunMaxDamage(baseGunMaxDamage);

            } else if (homeinput.equals("sleep")) {

                day++;
                stats.setDay(day);
                health += homeHP;
                stats.setHealth(health);
                System.out.println("--------------\n" + unicodeSunrise + "\tDay: " + day + "\n--------------" + "\nIt's a new day\nYou health has been replenished by: " + homeHP + " and is now: " + health + " HP");

                // Leveling system ( Gets values from String and Integer arrays )
                if(xP < xPs[0]) {
                    System.out.println("\nYour xP is: " + xP);
                    System.out.println("You have reached a rank of: " + levels[0]);
                    maxHealth += maxHealthAdd;
                }
                else if(xP < xPs[1]) {
                    System.out.println("\nYour xP is: " + xP);
                    System.out.println("You have reached a rank of: " + levels[1]);
                    maxHealth += maxHealthAdd;
                }
                else if(xP < xPs[2]) {
                    System.out.println("\nYour xP is: " + xP);
                    System.out.println("You have reached a rank of: " + levels[2]);
                    maxHealth += maxHealthAdd;
                }
                else if(xP < xPs[3]) {
                    System.out.println("\nYour xP is: " + xP);
                    System.out.println("You have reached a rank of: " + levels[3]);
                    maxHealth += maxHealthAdd;
                }
                else if(xP < xPs[4]) {
                    System.out.println("\nYour xP is: " + xP);
                    System.out.println("You have reached a rank of: " + levels[4]);
                    maxHealth += maxHealthAdd;
                }
                else if(xP < xPs[5]) {
                    System.out.println("\nYour xP is: " + xP);
                    System.out.println("You have reached a rank of: " + levels[5]);
                    maxHealth += maxHealthAdd;
                }
                else if(xP < xPs[6]) {
                    System.out.println("\nYour xP is: " + xP);
                    System.out.println("You have reached a rank of: " + levels[6]);
                    maxHealth += maxHealthAdd;
                }
                else if(xP < xPs[7]) {
                    System.out.println("\nYour xP is: " + xP);
                    System.out.println("You have reached a rank of: " + levels[7]);
                    maxHealth += maxHealthAdd;
                }
                else if(xP < xPs[8]) {
                    System.out.println("\nYour xP is: " + xP);
                    System.out.println("You have reached a rank of: " + levels[8]);
                    maxHealth += maxHealthAdd;
                }
                else if(xP < xPs[9]) {
                    System.out.println("\nYour xP is: " + xP);
                    System.out.println("You have reached a rank of: " + levels[9]);
                    maxHealth += maxHealthAdd;
                }

                stats.setMaxHealth(maxHealth);

                    story goToStory = new story();
                    goToStory.storyLine();

            } else {
                System.out.println("----------------------------------------------------------");
                System.out.println("Invalid input!");
                System.out.println("----------------------------------------------------------");
            }
        }
    }
}
