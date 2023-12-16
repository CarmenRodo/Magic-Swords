import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserInput ui = new UserInput();
        String name;
        String magicChoice;
        String physChoice;

        String magicItemName = null;
        String magicItemType = null;

        String physItemName = null;
        String physItemType = null;

        EasyMode easyMode = new EasyMode();
        NormalMode normalMode = new NormalMode();
        HardMode hardMode = new HardMode();


        Scanner scanner = new Scanner(System.in);

        // only main and wizardschool should have printlines
        WizardSchool wizardSchool = WizardSchool.getInstance();
        wizardSchool.fillRoster();

        System.out.println("Welcome to the Enchanted Realm!\nYou find yourself in a mystical world filled with magic and danger.");
        System.out.println("Before embarking on your quest, I need to know your name.");

        do {
            System.out.print("Please enter your name: ");
            name = scanner.nextLine();
        }while(ui.checkName(name) == 1);

        System.out.printf("Thank you, %s.\nNow, we need to sort out which items you'll be using while on the premises.\n" +
        "You might have noticed already that the western wall is missing,\n" +
        "and it is for that reason why we've shifted away from allowing just anyone to bring in magical items.\n" +
        "You'll have to be assigned some items, at least until you've cleared your junior exams.\n\nPlease choose " +
        "from the following magical items:\n1) Ramshackle Staff\n2) Maple Wand\n3) Gauntlet of Destruction, Doom and the Cringe.", name);

        do{
            System.out.print("\n *****\nYour choice: ");
            magicChoice = scanner.nextLine();
        }while(ui.checkChoice(magicChoice) == 0);

        if (magicChoice.equals("1")) {
            magicItemName = "Ramshackle Staff";
            magicItemType = "Staff";
        } else if (magicChoice.equals("2")) {
            magicItemName = "Maple Wand";
            magicItemType = "Wand";
        } else if (magicChoice.equals("3")) {
            magicItemName = "Gauntlet of Destruction, Doom and the Cringe";
            magicItemType = "Gauntlet";
        }

        System.out.printf("Now %s, please pick a physical item for self defense. With all the magic running around, \nit's no small wonder some things can take a magical " +
                "punch or seven. A physical weapon might be just what you need,\nto crack a soul crystal or a person's skull. I know I'm tempted to do so on occasion.\n\n" +
                "Please choose from the following:\n1) Sturdy Sword\n2) Solid Cane", name);

        do{
            System.out.print("\n ****** \nYour Choice: ");
            physChoice = scanner.nextLine();
        }while(ui.checkChoice(physChoice) == 0 || ui.checkChoice(physChoice) == 3);

        if (physChoice.equals("1")) {
            physItemName = "Sturdy Sword";
            physItemType = "Sword";
        } else if (physChoice.equals("2")) {
            physItemName = "Solid Cane";
            physItemType = "Cane";
        }

        wizardSchool.addToRoster(name, magicItemName, magicItemType, physItemName, physItemType);

        System.out.println("\nNow... to see your full card, please see below:\n ");
        Wizard userWizard = wizardSchool.getFromRoster(name);

        System.out.printf("Name: %s\nMagic Weapon: %s\nPhysical Weapon: %s ", userWizard.getName(), userWizard.getPrimaryWeapon().getItemName(), userWizard.getSecondaryWeapon().getItemName() );

        System.out.println("\n\nConsidering the fact that we're missing a wall, it would probably be best to " +
                "see your current prowess BEFORE letting you past the main hall.\n" +
                "I'll place a training dummy out for you, to attack as you see fit.\n" +
                "First and foremost, please choose a difficulty for the dummy:\n1) Easy\n2) Normal\n3) Hard");

        String dummyChoice;
        do{
            System.out.print("\n*****\nYour Choice: ");
            dummyChoice = scanner.nextLine();
        }while(dummyChoice == null);


        double userMagicDamage = 0.0;
        double userPhysicalDamage = 0.0;
        if (dummyChoice.equals("1")) {
            userMagicDamage = userWizard.getPrimaryWeapon().getDamageValue() / easyMode.getDifficultyScaling();
            userPhysicalDamage = userWizard.getSecondaryWeapon().getDamageValue() / easyMode.getDifficultyScaling();
        } else if (dummyChoice.equals("2")) {
            userMagicDamage = userWizard.getPrimaryWeapon().getDamageValue() / normalMode.getDifficultyScaling();
            userPhysicalDamage = userWizard.getSecondaryWeapon().getDamageValue() / normalMode.getDifficultyScaling();
        } else if (dummyChoice.equals("3")) {
            userMagicDamage = userWizard.getPrimaryWeapon().getDamageValue() / hardMode.getDifficultyScaling();
            userPhysicalDamage = userWizard.getSecondaryWeapon().getDamageValue() / hardMode.getDifficultyScaling();
        }

        double dummyHealth = wizardSchool.setUpTrainingDummy().getHealth();
        String dummyName = wizardSchool.setUpTrainingDummy().getName();

        String playerChoice;

        do {
            System.out.printf( "%s has %.2f health health remaining.", dummyName , dummyHealth);

            do{
                System.out.print("\n ****** \n\"Attack with Magic(1) or Melee(2)?");
                playerChoice = scanner.nextLine();
            }while(ui.checkChoice(playerChoice) == 0 || ui.checkChoice(playerChoice) == 3);

            if(playerChoice.equals("1")){
                dummyHealth = dummyHealth - userMagicDamage;
            }
            else if(playerChoice.equals("2")){
                dummyHealth = dummyHealth - userPhysicalDamage;
            }

        }while (dummyHealth > 0);


        System.out.printf("Amazing %s!\nIf I didn't know better, I'd say you're prone towards violent tendencies!\n" +
                "You'll fit right in, mark my words. Unfortunately, given the company budget we'll have to call this " +
                "little adventure right here- ", name);



    }
}