// System imports

import java.util.Random;
import java.util.Scanner;

public class shop {
    public void shopMethod() {

        // System
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        // Player variables
        int day = stats.getDay();
        int health = stats.getHealth();
        int startMoney = stats.getstartMoney();

        // Inventory variables
        int specialAmount = stats.getSpecialAmount();
        int enhancementLimbs = stats.getEnhancementLimbs();

        // Quest shop/inventory variables
        int networkModule = 0; // Storyline variable
        int bruteForcer = 0;
        int tazer = 0;

        // Shop price variables
        int enhancementLimbShopValue = 150;
        int specialAttackValue = 300;
        int scopeUpgrade1Value = 1000;
        int specialUpgradeValue = 2000;
        int eyeZoomUpgrade2Value = 4000;
        int slowMotionUpgrade3Value = 10000;

        // Rare inventory variables
        int scopeUpgrade = stats.getScopeUpgrade();
        int specialUpgrade = 2000;
        int eyeZoomUpgrade = 4000;
        int slowMotionUpgrade = 10000;

        // Rare inventory upgrade values
        // Advanced scope
        int scopeBase = 5;
        int scopeBaseMax = 5;
        int scopeMinSpecial = 3;
        int scopeMaxSpecial = 3;
        // Special Upgrade
        int upgradeMinSpecial = 3;
        int upgradeMaxSpecial = 3;

        // Weapon variables
        int baseGunMinDamage = stats.getBaseGunMinDamage();
        int baseGunMaxDamage = stats.getBaseGunMaxDamage();
        int specialMinDamage = stats.getSpecialMinDamage();
        int specialMaxDamage = stats.getSpecialMaxDamage();

        // Continue to shop or go home to replenish yourself
        System.out.println("You arrive at the shop..");

        // Shop system
        boolean inshop = true;
        while (inshop) {
            System.out.println("   __    _              ()       __                  \n" +
                    "  /  )  //   _/_        /\\      /  )  /              \n" +
                    " /--<  //  o /   __.   (  X    /     /_  o   _   __. \n" +
                    "/___/_</_ <_<__ /  |_   \\/ \\  (__/  / /_<_  /_)_/  |_\n" +
                    "                  (|                       /      (| \n" +
                    "                                          '          ");
            System.out.println("Welcome to the shop. What can I help you with today?\n");
            System.out.println("Type: [exit] to leave the shop.\n");
            System.out.println("Cash: " + "[" + startMoney + "$]\n");
            System.out.println("0. Quest item: Network Module\n");
            System.out.println("1. Enhancement limb: " + enhancementLimbShopValue + "$" + "\n2. Special Refill: " + specialAttackValue + "$" + "\n3. Advanced Scope: " + scopeUpgrade1Value + "$" + "\n4. Special Attack Upgrade: " + specialUpgradeValue + "$" + "\n5. Iris Zoom: " + eyeZoomUpgrade2Value + "$" + "\n6. Iris Slow-motion: " + slowMotionUpgrade3Value + "$");

            // Global menu string
            String shopinput = scanner.nextLine();

            // Exit shop
            if (shopinput.equals("exit")) {
                stats.setStartMoney(startMoney);
                break;
            }

            // Quest item (network module)
            if (shopinput.equals("0")) {
                if (networkModule == 0) {
                    networkModule++;
                    stats.setNetworkModule(networkModule);
                    System.out.println("----------------------------------------");
                    System.out.println("You have acquired: " + networkModule + " Network Module!");
                    System.out.println("----------------------------------------");


                } else {
                    System.out.println("----------------------------------------");
                    System.out.println("You already have a Network Module!");
                    System.out.println("----------------------------------------");
                }
            }

            // Enhancement limb
            if (shopinput.equals("1")) {


                // If you have enough cash and have not reached maximum inventory value
                if (startMoney >= enhancementLimbShopValue) {

                    if (enhancementLimbs < 4) {

                        startMoney -= enhancementLimbShopValue;
                        enhancementLimbs++;
                        stats.setStartMoney(startMoney);
                        stats.setEnhancementLimbs(enhancementLimbs);
                        System.out.println("----------------------------------------");
                        System.out.println("Receipt:\nYou bought an enhancement limb for: " + enhancementLimbShopValue + "$ " + "\nYou now have: " + enhancementLimbs + "\nCash after purchase: " + startMoney + "$");
                        System.out.println("----------------------------------------");
                    }

                    // If maximum in inventory is reached
                    else if (enhancementLimbs > 3) {
                        System.out.println("-------------------------------------------------");
                        System.out.println("You have the maximum number of enhancement limbs!" + "\nCurrently: " + enhancementLimbs);
                        System.out.println("-------------------------------------------------");
                    }

                    // If you do not have enough cash for the item
                } else if (startMoney < enhancementLimbShopValue) {
                    System.out.println("----------------------------------------");
                    System.out.println("You do not have enough cash!\nCurrent cash: " + startMoney + "$\n" + "Enhancement limb price: " + enhancementLimbShopValue + "$");
                    System.out.println("----------------------------------------");
                }

            } else {
                System.out.println("--------------");
                System.out.println("Invalid input!");
                System.out.println("--------------");
            }


            // Special Refill
            if (shopinput.equals("2")) {

                // If you have enough cash and have not reached maximum inventory value
                if (startMoney >= specialAttackValue) {

                    if (specialAmount < 2) {
                        startMoney -= specialAttackValue;
                        specialAmount++;
                        stats.setStartMoney(startMoney);
                        stats.setSpecialAmount(specialAmount);
                        System.out.println("----------------------------------------");
                        System.out.println("Receipt:\nYou bought a special refill: " + specialAttackValue + "$ " + "\nYou now have: " + specialAmount + "\nCash after purchase: " + startMoney + "$");
                        System.out.println("----------------------------------------");

                    }

                    // If maximum in inventory is reached
                    else if (specialAmount > 1) {
                        System.out.println("-------------------------------------------------");
                        System.out.println("You have the maximum amount of special refills!" + "\nCurrently: " + specialAmount);
                        System.out.println("-------------------------------------------------");
                    }

                    // If you do not have enough cash for the item
                } else if (startMoney < specialAttackValue) {
                    System.out.println("----------------------------------------");
                    System.out.println("You do not have enough cash!\nCurrent cash: " + startMoney + "$\n" + "Special refill price: " + specialAttackValue + "$");
                    System.out.println("----------------------------------------");
                }
            }


            // Advanced Scope
            if (shopinput.equals("3")) {

                // If you have enough cash and have not reached maximum inventory value
                if (startMoney >= scopeUpgrade1Value) {

                    if (scopeUpgrade < 1) {
                        startMoney -= scopeUpgrade1Value;

                        scopeUpgrade++;
                        baseGunMinDamage += scopeBase;
                        baseGunMaxDamage += scopeBaseMax;
                        specialMinDamage += scopeMinSpecial;
                        specialMaxDamage += scopeMaxSpecial;

                        stats.setStartMoney(startMoney);
                        stats.setScopeUpgrade(scopeUpgrade);
                        stats.setBaseGunMinDamage(baseGunMinDamage);
                        stats.setBaseGunMaxDamage(baseGunMaxDamage);
                        stats.setSpecialMinDamage(specialMinDamage);
                        stats.setSpecialMaxDamage(specialMaxDamage);

                        System.out.println("----------------------------------------");
                        System.out.println("Receipt:\nYou bought a Advanced Scope: " + scopeUpgrade1Value + "$ " + "\nYou have: " + scopeUpgrade + "\nCash after purchase: " + startMoney + "$");
                        System.out.println("\nYour damage is now: " + "[" + baseGunMinDamage + " - " + baseGunMaxDamage + "]" + "\nYour special attack is: " + "[" + specialMinDamage + " - " + specialMaxDamage + "]");
                        System.out.println("----------------------------------------");

                    }

                    // If maximum in inventory is reached
                    else if (scopeUpgrade > 1) {
                        System.out.println("-------------------------------------------------");
                        System.out.println("You already have a Advanced Scope!" + "\nCurrently: " + scopeUpgrade);
                        System.out.println("-------------------------------------------------");
                    }

                    // If you do not have enough cash for the item
                } else if (startMoney < scopeUpgrade1Value) {
                    System.out.println("----------------------------------------");
                    System.out.println("You do not have enough cash!\nCurrent cash: " + startMoney + "$\n" + "Advanced Scope price: " + scopeUpgrade1Value + "$");
                    System.out.println("----------------------------------------");
                }
            }


            // Special Upgrade
            if (shopinput.equals("4")) {

                // If you have enough cash and have not reached maximum inventory value
                if (startMoney >= specialUpgradeValue) {

                    if (specialUpgrade < 1) {
                        startMoney -= specialUpgradeValue;

                        specialUpgrade++;
                        specialMinDamage += upgradeMinSpecial;
                        specialMaxDamage += upgradeMaxSpecial;

                        stats.setStartMoney(startMoney);
                        stats.setSpecialUpgrade(specialUpgrade);
                        stats.setSpecialMinDamage(specialMinDamage);
                        stats.setSpecialMaxDamage(specialMaxDamage);

                        System.out.println("----------------------------------------");
                        System.out.println("Receipt:\nYou bought a Special Attack Upgrade: " + specialUpgradeValue + "$ " + "\nYou have: " + specialUpgrade + "\nCash after purchase: " + startMoney + "$");
                        System.out.println("\nYour special attack is now: " + "[" + specialMinDamage + " - " + specialMaxDamage + "]");
                        System.out.println("----------------------------------------");

                    }

                    // If maximum in inventory is reached
                    else if (specialUpgrade > 1) {
                        System.out.println("-------------------------------------------------");
                        System.out.println("You already have a Special Attack Upgrade!" + "\nCurrently: " + specialUpgrade);
                        System.out.println("-------------------------------------------------");
                    }

                    // If you do not have enough cash for the item
                } else if (startMoney < specialUpgradeValue) {
                    System.out.println("----------------------------------------");
                    System.out.println("You do not have enough cash!\nCurrent cash: " + startMoney + "$\n" + "Special Attack Upgrade price: " + specialUpgradeValue + "$");
                    System.out.println("----------------------------------------");
                }
            }
        }

        // If shop is exited the shop, it breaks to this class
        home gohome = new home();
        gohome.homeMethod();

    }
}

