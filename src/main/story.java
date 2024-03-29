import java.util.Scanner;

public class story {
    public void storyLine () {

        // System
        Scanner scanner = new Scanner(System.in);

        // Integers (mostly for game restart)
        int health = stats.getHealth();
        int day = stats.getDay();
        int escapeAmount = stats.getEscapeAmount();
        int networkModule = stats.getNetworkModule();
        int startMoney = stats.getstartMoney();
        int xP = stats.getXP();
        int baseGunMinDamage = stats.getBaseGunMinDamage();
        int baseGunMaxDamage = stats.getBaseGunMaxDamage();
        int specialMinDamage = stats.getSpecialMinDamage();
        int specialMaxDamage = stats.getSpecialMaxDamage();
        int specialAmount = stats.getSpecialAmount();
        int enhancementLimbs = stats.getEnhancementLimbs();

        // Game restart. This happens if you die while fighting an enemy or boss. (The enemyAttack class will exit to here, when int health < 1 and the player are terminated in that class)
        if (health < 1) {
            startMoney = 250;
            stats.setStartMoney(startMoney);
            health = 120;
            stats.setHealth(health);
            day = 1;
            stats.setDay(day);
            xP = 0;
            stats.setXP(xP);
            networkModule = 0;
            stats.setNetworkModule(networkModule);
            baseGunMinDamage = 10;
            stats.setBaseGunMinDamage(baseGunMinDamage);
            baseGunMaxDamage = 30;
            stats.setBaseGunMaxDamage(baseGunMaxDamage);
            specialMinDamage = 30;
            stats.setSpecialMinDamage(specialMinDamage);
            specialMaxDamage = 70;
            stats.setSpecialMaxDamage(specialMaxDamage);
            specialAmount = 1;
            stats.setSpecialAmount(specialAmount);
            enhancementLimbs = 2;
            stats.setEnhancementLimbs(enhancementLimbs);
            escapeAmount = 1;
            stats.setEscapeAmount(escapeAmount);
        }

        // Storyline - Switch statements with 'day' as variable. This integer value is set when 'sleep' is the String input from home class
        switch (day) {

            // Day 1
            case 1:

                // This is the first day
                System.out.println("\nTanake Virtual instance initiated...");
                System.out.println("\nPress [Enter] to transfer to Agent");
                scanner.nextLine();

                // [Prologue]
                System.out.println("Transfer complete. [Casper] has been assigned as your virtual assistant.\nHe will guide you along the way and bring you valuable intel." +
                        "\n----------------------------------------\nPress enter to initiate wake-up sequence\n----------------------------------------");

                scanner.nextLine();
                System.out.println("Casper:\noi, oyh...?\nGood morning sir. I see you are awake.. The weather outside seems chilly" +
                        "\nand the reporter on the news talks about an incoming storm," +
                        "\nbut everything is in order for today's events..");

                scanner.nextLine();
                System.out.println("Casper:\nThe wind oozes in through the cracks in what seems to be the whole building complex." +
                        "\nIt were meant to be fixed ages ago..");

                scanner.nextLine();
                System.out.println("Casper:\nEver since the power outages, something has been a bit off with" +
                        "\nmy network connection..");

                scanner.nextLine();
                System.out.println("Casper:\n---------------------------------------------------------------------------\n" +
                        "Do you think you can fetch me a new network module at the shop by tomorrow?" +
                        "\n---------------------------------------------------------------------------\n");
                System.out.println("\t1. Yes\n\t2. No\t[Uses 1 escape try. You have: " + escapeAmount + "]");

                boolean acceptQuest = true;
                while (acceptQuest) {
                String input = scanner.nextLine();

                    if (input.equals("1")) {
                        System.out.println("You take a taxi to the shop..");
                        scanner.nextLine();
                        System.out.println("The city is looking a bit vail compared to how it used to be..");
                        scanner.nextLine();
                        System.out.println("That's what greed does to people I guess..");
                        scanner.nextLine();
                        System.out.println("---------------------------------");
                        System.out.println("You hear someone scream for help!");
                        System.out.println("---------------------------------");
                        scanner.nextLine();

                        // Common enemy attack (class)
                        enemyAttack attack = new enemyAttack();
                        attack.enemy();

                    } else if (input.equals("2")) {
                        System.out.println("\nYou choose to stay home..\n");

                        // Go to home (class)
                        home gohome = new home();
                        gohome.homeMethod();

                    } else {
                        System.out.println("----------------------------------------------------------");
                        System.out.println("Invalid input!");
                        System.out.println("----------------------------------------------------------");
                    }
                }
                break;


                // Day 2
            case 2:

                // [Chapter 01/01] If you have acquired a Network Module for Casper.
                if (networkModule == 1) {
                    scanner.nextLine();
                    System.out.println("System reconnected! Press [enter] to wake up.");
                    scanner.nextLine();
                    System.out.println("\nCasper:\nGood morning sir! Thank you for fetching me that Network Module.\nPress [Enter] to fix me now.");
                    scanner.nextLine();
                    networkModule--;
                    System.out.println("----------------------------------------");
                    System.out.println("You fixed Casper with a Network module!" + "\nYou now have: " + networkModule + " Network modules");
                    System.out.println("----------------------------------------");
                    scanner.nextLine();
                    System.out.println("Casper:\nThank you! So much better.. This will help me to collect information for you along the way..");
                    scanner.nextLine();
                    System.out.println("Casper:\nI've heard that Celestia AI is having a fundraiser tonight..");
                    scanner.nextLine();
                    System.out.println("Casper:\nThere might be people of interest in attendance..");
                    scanner.nextLine();
                    System.out.println("Casper:\nDo you wish to go?\n1. yes\t2. no");
                    scanner.nextLine();
                }

                // [Chapter 01/02] If you did not acquire a Network Module for Casper.
                else if (networkModule != 1) {
                    scanner.nextLine();
                    System.out.println("System reconnected! Press [enter] to wake up.");
                    scanner.nextLine();
                    System.out.println("\nCasper:\nGood morning sir! Too bad you didn't get me that network module. Could have been useful to find better intel..");
                    scanner.nextLine();
                    System.out.println("\nCasper:\nI could definitely use an upgrade..");
                    scanner.nextLine();
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Do you want to go downtown to search after people of interest?");
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("\t1. Yes\n\t2. No\t[Uses 1 escape try. You have: " + escapeAmount + "]");

                    boolean acceptQuest02 = true;
                    while (acceptQuest02) {
                        String input = scanner.nextLine();

                        if (input.equals("1")) {
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("                   A boss has been spotted!                   ");
                            System.out.println("--------------------------------------------------------------");

                            // boss attack (class)
                            bossAttack attack = new bossAttack();
                            attack.boss();

                        } else if (input.equals("2")) {
                            escapeAmount--;
                            System.out.println("\nYou choose to stay home..\n");

                            // Go to home (class)
                            home gohome = new home();
                            gohome.homeMethod();

                        } else {
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Invalid input!");
                            System.out.println("----------------------------------------------------------");
                        }
                    }
                }
                break;

            // Day 3
            case 3:
                System.out.println("This day happens if day = 3\n");
                break;

            // Day 4
            case 4:
                System.out.println("This day happens if day = 4\n");
                break;

            // Day 5
            case 5:
                System.out.println("This day happens if day = 5\n");
                break;

            // Day 6
            case 6:
                System.out.println("This day happens if day = 6\n");
                break;

            // Day 7
            case 7:
                System.out.println("This day happens if day = 7\n");
                break;

            // Day 8
            case 8:
                System.out.println("This day happens if day = 8\n");
                break;

            // Day 9
            case 9:
                System.out.println("This day happens if day = 9\n");
                break;

            // Day 10
            case 10:
                System.out.println("This day happens if day = 10\n");
                break;
        }
    }
}
