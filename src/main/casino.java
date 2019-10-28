import java.util.Random;
import java.util.Scanner;

class casino {
    public void games() {
        // System imports

        // System
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int startMoney = stats.getstartMoney();

        String unicodeMessageMoneyDrop = "\uD83D\uDCB0";

        int bet1 = 50;
        int bet2 = 100;
        int bet3 = 250;
        int bet4 = 500;
        int bet5 = 1000;

        System.out.println("   __                     \n" +
                "  /  )                    \n" +
                " /     __.  _   o ____  __\n" +
                "(__/  (_/|_/_)_<_/ / <_(_)");

        boolean running = true;
        while (running) {

            System.out.println("\nRules:\nYou get a random number between 1 - 100. House gets a random number between 50 - 100.\nWinner has the highest number.\nYou can win [2x - 5x] your bet. If your number is 95 or higher you get a Super Roll 30x\n");
            System.out.println("Cash: [" + startMoney + "$]\n");
            System.out.println("Choose your bet!");
            System.out.println("\n1. 50$ | 2. 100$ | 3. 250$ | 4. 500$ | 5. 1000$\n");
            System.out.println("type [exit] to go home.\n");

            int houseRoll = rand.nextInt(50) + 50;
            int userRoll = rand.nextInt(99) + 1;
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                home gohome = new home();
                gohome.homeMethod();
            }

            // Bet 50$
            if (input.equals("1")) {
                rand.nextInt(houseRoll);
                rand.nextInt(userRoll);
                int win = rand.nextInt(150) + 100;

                if (startMoney >= bet1) {
                    startMoney -= bet1;
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
                            break;

                        } else if (userRoll > 94) {

                            int superRollwin = rand.nextInt(1500) + 500;
                            startMoney += superRollwin;
                            stats.setStartMoney(startMoney);
                            System.out.println("------------------------------------------------");
                            System.out.println("You unlocked a Super Roll x30!");
                            System.out.println("------------------------------------------------");
                            System.out.println("\nClick to roll!");
                            scanner.nextLine();
                            System.out.println("\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");
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


                } else if (startMoney < bet1) {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("You do not have enough cash! You have: " + "[" + startMoney + "$]");
                    System.out.println("----------------------------------------------------------");

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
                            break;


                        } else if (userRoll > 94) {
                            rand.nextInt(houseRoll);
                            rand.nextInt(userRoll);
                            int superRollwin = rand.nextInt(1500) + 500;
                            startMoney += superRollwin;
                            stats.setStartMoney(startMoney);
                            System.out.println("------------------------------------------------");
                            System.out.println("You unlocked a Super Roll x30!");
                            System.out.println("------------------------------------------------");
                            System.out.println("\nClick to roll!");
                            scanner.nextLine();
                            System.out.println("\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");
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
                            break;


                        } else if (userRoll > 94) {
                            rand.nextInt(houseRoll);
                            rand.nextInt(userRoll);
                            int superRollwin = rand.nextInt(1500) + 500;
                            startMoney += superRollwin;
                            stats.setStartMoney(startMoney);
                            System.out.println("------------------------------------------------");
                            System.out.println("You unlocked a Super Roll x30!");
                            System.out.println("------------------------------------------------");
                            System.out.println("\nClick to roll!");
                            scanner.nextLine();
                            System.out.println("\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");
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
                            break;


                        } else if (userRoll > 94) {
                            rand.nextInt(houseRoll);
                            rand.nextInt(userRoll);
                            int superRollwin = rand.nextInt(1500) + 500;
                            startMoney += superRollwin;
                            stats.setStartMoney(startMoney);
                            System.out.println("------------------------------------------------");
                            System.out.println("You unlocked a Super Roll x30!");
                            System.out.println("------------------------------------------------");
                            System.out.println("\nClick to roll!");
                            scanner.nextLine();
                            System.out.println("\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");
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
                            break;


                        } else if (userRoll > 94) {
                            rand.nextInt(houseRoll);
                            rand.nextInt(userRoll);
                            int superRollwin = rand.nextInt(1500) + 500;
                            startMoney += superRollwin;
                            stats.setStartMoney(startMoney);
                            System.out.println("------------------------------------------------");
                            System.out.println("You unlocked a Super Roll x30!");
                            System.out.println("------------------------------------------------");
                            System.out.println("\nClick to roll!");
                            scanner.nextLine();
                            System.out.println("\nYou rolled: " + userRoll + "\nHouse rolled: " + houseRoll + "\n\nYou now have: [" + startMoney + "$]");
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
