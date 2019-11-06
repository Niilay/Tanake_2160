import java.util.Random;
import java.util.Scanner;

class casino {
    public void games() {

        // System
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        // Player cash
        int startMoney = stats.getstartMoney();

        // Unicode UTF-8 characters
        String unicodeMessageMoneyDrop = "\uD83D\uDCB0";
        String unicodeMessageSuperRoll = "\uD83D\uDDF2";

        // Bet values
        int bet1 = 50;
        int bet2 = 100;
        int bet3 = 250;
        int bet4 = 500;
        int bet5 = 1000;

        // Art
        System.out.println("   __                     \n" +
                "  /  )                    \n" +
                " /     __.  _   o ____  __\n" +
                "(__/  (_/|_/_)_<_/ / <_(_)");

        // Casino loop (main game-loop)
        boolean running = true;
        while (running) {

            System.out.println("\nRules:\nYou get a random number between 1 - 20. House gets a random number between 10 - 20.\nWinner has the highest number.\nYou can win [2x - 5x] your bet. If you win and your roll is 20, you acquire a Super Roll x10!\n");
            System.out.println("Cash: [" + startMoney + "$]\n");
            System.out.println("Choose your bet!");
            System.out.println("\n1. 50$ | 2. 100$ | 3. 250$ | 4. 500$ | 5. 1000$\n");
            System.out.println("type [exit] to go home.\n");

            // A bound is set for the random numbers. House roll between 10-20 and player roll between 1 - 20
            int houseRoll = rand.nextInt(11) + 10;
            int userRoll = rand.nextInt(20) + 1;

            // Input for each round of play
            String input = scanner.nextLine();

            // Exit to home class
            if (input.equals("exit")) {
                home gohome = new home();
                gohome.homeMethod();
            }

            // Bet 50$
            if (input.equals("1")) {

                // Random numbers are generated for the house and player/user
                rand.nextInt(houseRoll);
                rand.nextInt(userRoll);

                // A random number is set for win in between (150) + 100. Which in this context means 100 to 250$
                int win = rand.nextInt(150) + 100;

                // If you have enough startMoney, subtract bet x from startMoney
                if (startMoney >= bet1) {
                    startMoney -= bet1;
                    stats.setStartMoney(startMoney);

                    // (Game-loop). While you do not roll the same as the house, this loop will run
                    while (userRoll != houseRoll) {

                        // If the player rolls lower than the house
                        if (userRoll < houseRoll) {
                            System.out.println("------------------------------------------------");
                            System.out.println("Your roll was lower than the house and you lose!");
                            System.out.println("------------------------------------------------");
                            System.out.println("\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");
                            break;

                        // If the player rolls higher than the house and wins!
                        } else if (userRoll > houseRoll) {
                            startMoney += win;
                            stats.setStartMoney(startMoney);
                            System.out.println("Your roll was higher than the house and you win!");
                            System.out.println("------------------------------------------------");
                            System.out.println(unicodeMessageMoneyDrop + " You won! [" + win + "$]");
                            System.out.println("------------------------------------------------");
                            System.out.println("\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");

                            // Super-roll x10. If the player rolls 20
                            if (userRoll > 19) {
                                int superRollwin = rand.nextInt(350) + 150;
                                startMoney += superRollwin;
                                stats.setStartMoney(startMoney);
                                System.out.println("------------------------------------------------");
                                System.out.println("You've unlocked a Super Roll x10!");
                                System.out.println("------------------------------------------------");
                                System.out.println("\nPress [enter] to spin!");
                                scanner.nextLine();
                                System.out.println("------------------------------------------------");
                                System.out.println(unicodeMessageSuperRoll + " Congratulations! The Super roll hit: [" + (superRollwin/bet1) + "x]");
                                System.out.println(unicodeMessageMoneyDrop + " You've won: [" + superRollwin + "$]");
                                System.out.println("------------------------------------------------");
                        }
                            break;

                        // If the user rolls the same as the house nothing happens and it breaks back to the while loop
                        } else if (userRoll == houseRoll) {

                            System.out.println("You rolled the same as the house\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");
                            break;

                        // System failure check. Just for fun and debugging
                        } else {
                            System.out.println("----------------------------------------------------------");
                            System.out.println("System fail!");
                            System.out.println("----------------------------------------------------------");
                        }
                    }

                // If you do not have enough cash to bet the String input amount
                } else if (startMoney < bet1) {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("You do not have enough cash! You have: " + "[" + startMoney + "$]");
                    System.out.println("----------------------------------------------------------");

                // Invalid command from String input
                } else {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Invalid command");
                    System.out.println("----------------------------------------------------------");
                }
            }

            // Bet 100$
            if (input.equals("2")) {
                rand.nextInt(houseRoll);
                rand.nextInt(userRoll);
                int win = rand.nextInt(300) + 200;

                if (startMoney >= bet2) {
                    startMoney -= bet2;
                    stats.setStartMoney(startMoney);

                    while (userRoll != houseRoll) {

                        if (userRoll < houseRoll) {
                            System.out.println("------------------------------------------------");
                            System.out.println("Your roll was lower than the house and you lose!");
                            System.out.println("------------------------------------------------");
                            System.out.println("\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");
                            break;

                        } else if (userRoll > houseRoll) {

                            startMoney += win;
                            stats.setStartMoney(startMoney);
                            System.out.println("Your roll was higher than the house and you win!");
                            System.out.println("------------------------------------------------");
                            System.out.println(unicodeMessageMoneyDrop + " You won! [" + win + "$]");
                            System.out.println("------------------------------------------------");
                            System.out.println("\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");

                            // Super-roll x10. If the player rolls 20
                            if (userRoll > 19) {
                                int superRollwin = rand.nextInt(700) + 300;
                                startMoney += superRollwin;
                                stats.setStartMoney(startMoney);
                                System.out.println("------------------------------------------------");
                                System.out.println("You've unlocked a Super Roll x10!");
                                System.out.println("------------------------------------------------");
                                System.out.println("\nPress [enter] to spin!");
                                scanner.nextLine();
                                System.out.println("------------------------------------------------");
                                System.out.println(unicodeMessageSuperRoll + " Congratulations! The Super roll hit: [" + (superRollwin/bet2) + "x]");
                                System.out.println(unicodeMessageMoneyDrop + " You've won: [" + superRollwin + "$]");
                                System.out.println("------------------------------------------------");
                            }
                            break;

                            // If the user rolls the same as the house nothing happens and it breaks back to the while loop
                        } else if (userRoll == houseRoll) {

                            System.out.println("You rolled the same as the house\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");
                            break;

                        } else {
                            System.out.println("----------------------------------------------------------");
                            System.out.println("System fail!");
                            System.out.println("----------------------------------------------------------");
                        }
                    }


                } else if (startMoney < bet2) {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("You do not have enough cash! You have: " + "[" + startMoney + "$]");
                    System.out.println("----------------------------------------------------------");

                } else {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Invalid command");
                    System.out.println("----------------------------------------------------------");
                }
            }

            // Bet 250$
            if (input.equals("3")) {
                rand.nextInt(houseRoll);
                rand.nextInt(userRoll);
                int win = rand.nextInt(750) + 500;

                if (startMoney >= bet3) {
                    startMoney -= bet3;
                    stats.setStartMoney(startMoney);

                    while (userRoll != houseRoll) {

                        if (userRoll < houseRoll) {
                            System.out.println("------------------------------------------------");
                            System.out.println("Your roll was lower than the house and you lose!");
                            System.out.println("------------------------------------------------");
                            System.out.println("\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");
                            break;

                        } else if (userRoll > houseRoll) {

                            startMoney += win;
                            stats.setStartMoney(startMoney);
                            System.out.println("Your roll was higher than the house and you win!");
                            System.out.println("------------------------------------------------");
                            System.out.println(unicodeMessageMoneyDrop + " You won! [" + win + "$]");
                            System.out.println("------------------------------------------------");
                            System.out.println("\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");

                            // Super-roll x10. If the player rolls 20
                            if (userRoll > 19) {
                                int superRollwin = rand.nextInt(1500) + 1000;
                                startMoney += superRollwin;
                                stats.setStartMoney(startMoney);
                                System.out.println("------------------------------------------------");
                                System.out.println("You've unlocked a Super Roll x10!");
                                System.out.println("------------------------------------------------");
                                System.out.println("\nPress [enter] to spin!");
                                scanner.nextLine();
                                System.out.println("------------------------------------------------");
                                System.out.println(unicodeMessageSuperRoll + " Congratulations! The Super roll hit: [" + (superRollwin/bet3) + "x]");
                                System.out.println(unicodeMessageMoneyDrop + " You've won: [" + superRollwin + "$]");
                                System.out.println("------------------------------------------------");
                            }
                            break;

                        } else if (userRoll == houseRoll) {

                            System.out.println("You rolled the same as the house\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");
                            break;


                        } else {
                            System.out.println("----------------------------------------------------------");
                            System.out.println("System fail!");
                            System.out.println("----------------------------------------------------------");
                        }
                    }

                } else if (startMoney < bet3) {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("You do not have enough cash! You have: " + "[" + startMoney + "$]");
                    System.out.println("----------------------------------------------------------");

                } else {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Invalid command");
                    System.out.println("----------------------------------------------------------");
                }
            }

            // Bet 500$
            if (input.equals("4")) {
                rand.nextInt(houseRoll);
                rand.nextInt(userRoll);
                int win = rand.nextInt(1500) + 1000;

                if (startMoney >= bet4) {
                    startMoney -= bet4;
                    stats.setStartMoney(startMoney);

                    while (userRoll != houseRoll) {

                        if (userRoll < houseRoll) {
                            System.out.println("------------------------------------------------");
                            System.out.println("Your roll was lower than the house and you lose!");
                            System.out.println("------------------------------------------------");
                            System.out.println("\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");
                            break;

                        } else if (userRoll > houseRoll) {

                            startMoney += win;
                            stats.setStartMoney(startMoney);
                            System.out.println("Your roll was higher than the house and you win!");
                            System.out.println("------------------------------------------------");
                            System.out.println(unicodeMessageMoneyDrop + " You won! [" + win + "$]");
                            System.out.println("------------------------------------------------");
                            System.out.println("\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");

                            // Super-roll x10. If the player rolls 20
                            if (userRoll > 19) {
                                int superRollwin = rand.nextInt(3000) + 2000;
                                startMoney += superRollwin;
                                stats.setStartMoney(startMoney);
                                System.out.println("------------------------------------------------");
                                System.out.println("You've unlocked a Super Roll x10!");
                                System.out.println("------------------------------------------------");
                                System.out.println("\nPress [enter] to spin!");
                                scanner.nextLine();
                                System.out.println("------------------------------------------------");
                                System.out.println(unicodeMessageSuperRoll + " Congratulations! The Super roll hit: [" + (superRollwin/bet4) + "x]");
                                System.out.println(unicodeMessageMoneyDrop + " You've won: [" + superRollwin + "$]");
                                System.out.println("------------------------------------------------");
                            }
                            break;

                        } else if (userRoll == houseRoll) {

                            System.out.println("You rolled the same as the house\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");
                            break;


                        } else {
                            System.out.println("----------------------------------------------------------");
                            System.out.println("System fail!");
                            System.out.println("----------------------------------------------------------");
                        }
                    }

                } else if (startMoney < bet4) {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("You do not have enough cash! You have: " + "[" + startMoney + "$]");
                    System.out.println("----------------------------------------------------------");

                } else {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Invalid command");
                    System.out.println("----------------------------------------------------------");
                }
            }

            // Bet 1000$
            if (input.equals("5")) {
                rand.nextInt(houseRoll);
                rand.nextInt(userRoll);
                int win = rand.nextInt(3000) + 2000;

                if (startMoney >= bet5) {
                    startMoney -= bet5;
                    stats.setStartMoney(startMoney);

                    while (userRoll != houseRoll) {

                        if (userRoll < houseRoll) {
                            System.out.println("------------------------------------------------");
                            System.out.println("Your roll was lower than the house and you lose!");
                            System.out.println("------------------------------------------------");
                            System.out.println("\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");
                            break;

                        } else if (userRoll > houseRoll) {

                            startMoney += win;
                            stats.setStartMoney(startMoney);
                            System.out.println("Your roll was higher than the house and you win!");
                            System.out.println("------------------------------------------------");
                            System.out.println(unicodeMessageMoneyDrop + " You won! [" + win + "$]");
                            System.out.println("------------------------------------------------");
                            System.out.println("\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");


                            // Super-roll x10. If the player rolls 20
                            if (userRoll > 19) {
                                int superRollwin = rand.nextInt(6000) + 4000;
                                startMoney += superRollwin;
                                stats.setStartMoney(startMoney);
                                System.out.println("------------------------------------------------");
                                System.out.println("You've unlocked a Super Roll x10!");
                                System.out.println("------------------------------------------------");
                                System.out.println("\nPress [enter] to spin!");
                                scanner.nextLine();
                                System.out.println("------------------------------------------------");
                                System.out.println(unicodeMessageSuperRoll + " Congratulations! The Super roll hit: [" + (superRollwin/bet5) + "x]");
                                System.out.println(unicodeMessageMoneyDrop + " You've won: [" + superRollwin + "$]");
                                System.out.println("------------------------------------------------");
                            }
                            break;

                        } else if (userRoll == houseRoll) {
                            System.out.println("You rolled the same as the house\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");
                            break;

                        } else {
                            System.out.println("----------------------------------------------------------");
                            System.out.println("System fail!");
                            System.out.println("----------------------------------------------------------");
                        }
                    }

                } else if (startMoney < bet5) {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("You do not have enough cash! You have: " + "[" + startMoney + "$]");
                    System.out.println("----------------------------------------------------------");

                } else {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Invalid command");
                    System.out.println("----------------------------------------------------------");
                }
            }
        }
    }
}
