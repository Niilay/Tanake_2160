public class stats {

    // Environment
    private static int day = 1;


    // Functions
    public static int getDay() {
        return day;
    }

    public static void setDay(int day) {
        stats.day = day;
    }


    // Player.
    private static int health = 120;
    private static int startMoney = 250;
    private static int xP = 0;


    // Functions
    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        stats.health = health;
    }


    public static int getstartMoney() { return startMoney; }

    public static void setStartMoney(int startMoney) { stats.startMoney = startMoney; }


    public static int getXP() {
        return xP;
    }

    public static void setXP(int xP) {
        stats.xP = xP;
    }


    // Player weapon variables.
    private static int baseGunMinDamage = 10;
    private static int baseGunMaxDamage = 30;
    private static int specialMinDamage = 30;
    private static int specialMaxDamage = 70;


    // Functions
    public static int getBaseGunMinDamage() {
        return baseGunMinDamage;
    }

    public static void setBaseGunMinDamage(int baseGunMinDamage) { stats.baseGunMinDamage = baseGunMinDamage; }


    public static int getBaseGunMaxDamage() { return baseGunMaxDamage; }

    public static void setBaseGunMaxDamage(int baseGunMaxDamage) { stats.baseGunMaxDamage = baseGunMaxDamage; }


    public static int getSpecialMinDamage() { return specialMinDamage; }

    public static void setSpecialMinDamage(int specialMinDamage) { stats.specialMinDamage = specialMinDamage; }


    public static int getSpecialMaxDamage() {
        return specialMaxDamage;
    }

    public static void setSpecialMaxDamage(int specialMaxDamage) {
        stats.specialMaxDamage = specialMaxDamage;
    }


    // Player inventory
    private static int specialAmount = 1;
    private static int enhancementLimbs = 2;
    private static int escapeAmount = 1;


    // Functions
    public static int getSpecialAmount() {
        return specialAmount;
    }

    public static void setSpecialAmount(int specialAmount) {
        stats.specialAmount = specialAmount;
    }


    public static int getEnhancementLimbs() {
        return enhancementLimbs;
    }

    public static void setEnhancementLimbs(int enhancementLimbs) {
        stats.enhancementLimbs = enhancementLimbs;
    }


    public static int getEscapeAmount() {
        return escapeAmount;
    }

    public static void setEscapeAmount(int escapeAmount) {
        stats.escapeAmount = escapeAmount;
    }


    // Quest shop/inventory variables.
    private static int networkModule = 0; // Storyline variable
    private static int bruteForcer = 0;
    private static int tazer = 0;

    // Functions
    public static int getNetworkModule() {
        return networkModule;
    }

    public static void setNetworkModule(int networkModule) {
        stats.networkModule = networkModule;
    }
}