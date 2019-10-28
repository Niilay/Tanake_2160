// System imports

import java.util.Scanner;

public class tanake {
    public static void main(String[] args) {

        // System
        Scanner scanner = new Scanner(System.in);

        // Unicode UTF-8 symbols
        String unicodeMessageHP = "\uD83D\uDC96";

        System.out.println("  ______                            __                  ___    ___   _____   ____ \n" +
                " /_  __/  ____ _   ____   ____ _   / /__  ___          |__ \\  <  /  / ___/  / __ \\\n" +
                "  / /    / __ `/  / __ \\ / __ `/  / //_/ / _ \\         __/ /  / /  / __ \\  / / / /\n" +
                " / /    / /_/ /  / / / // /_/ /  / ,<   /  __/        / __/  / /  / /_/ / / /_/ / \n" +
                "/_/     \\__,_/  /_/ /_/ \\__,_/  /_/|_|  \\___/        /____/ /_/   \\____/  \\____/  \n" +
                "                                                                                  ");
        System.out.println("Cyberpunk Micro-RPG developed with " + unicodeMessageHP + "\nby Nicklas Pedersen\n");
        System.out.println("Introduction:" +
                "\nThe year is 2160. You are a rogue, freelance detective for hire in the virtual" +
                "\ncity of Tanake. A corporate network filled with greed, hostility and crime. " +
                "\nA large portion of people has been divided into several violent clans who fight for control. " +
                "\nThe largest corporations in the city is slowly beginning to take control of everything." +
                "\nLately there’s been a huge disturbance in public peace and regular power outages" +
                "\nhas been causing players to loss their progress. Your job is to investigate" +
                "\nthese disturbances and try and maintain peace in the online city " +
                "\nand do your best to save it from mysterious, maybe even cataclysmic events.");

        story goToStory = new story();
        goToStory.storyLine();

        }
    }




