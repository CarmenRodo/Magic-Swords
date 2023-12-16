
import java.util.ArrayList;

public class WizardSchool {
    private static WizardSchool instance;
    ArrayList<Wizard> roster = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();
    EasyMode easyMode = new EasyMode();
    NormalMode normalMode = new NormalMode();
    HardMode hardMode = new HardMode();

    private WizardSchool() {}
    public static WizardSchool getInstance(){
        if(instance == null){
            instance = new WizardSchool();
        }
        return instance;
    }
    public void fillRoster(){

        Wizard wizard = new Wizard("Not-Gandalf", MagicFactory.getMagicItem("Staff of Oak", 12, "Staff"), PhysicalFactory.getPhysicalItem("Cane of Eld", 7, "Cane") ) {
        };
        Wizard wizard1 = new Wizard("Great Gaziibo", MagicFactory.getMagicItem("Wand of Willow", 10, "Wand"), PhysicalFactory.getPhysicalItem("Sword of House Fortest", 11, "Sword")) {
        };
        Wizard wizard2 = new Wizard("Charlie Murph", MagicFactory.getMagicItem("Gauntlet of Ice", 12, "Gauntlet"), PhysicalFactory.getPhysicalItem("Cane of Concern", 8, "Cane")) {
        };

        roster.add(wizard);
        roster.add(wizard1);
        roster.add(wizard2);
        enemies.add( new TrainingDummy("Dumbo", 200));

        Enemy trainingDummy = enemies.get(0);
        double healthPoints = trainingDummy.getHealth();

        double wizardDamage = wizard.getPrimaryWeapon().getDamageValue();

        healthPoints = healthPoints - ( wizardDamage / easyMode.getDifficultyScaling());

        //System.out.println("Dumbo has: " +healthPoints + " hit-points left!");


        //System.out.println(wizard.getName() + " " + wizard.getPrimaryWeapon().getItemName() + " " + wizard.getSecondaryWeapon().getItemName());
    }

    public void addToRoster(String name, String magicItemName, String magicType, String physItemName, String physType){
        Wizard userWizard = new Wizard(name,MagicFactory.getMagicItem(magicItemName, 15, magicType), PhysicalFactory.getPhysicalItem(physItemName, 12, physType)) {};
        roster.add(userWizard);
    }

    public Wizard getFromRoster(String checkName){
        Wizard searchTarget;

        for (Wizard item : roster) {
            if(item.getName().equals(checkName)){
                searchTarget = item;
                return searchTarget;
            }
        }
        return null;
    }

    /*public String displayFromRoster(String target){
        Wizard search = getFromRoster(target);

        return toString("%s ");
    }*/

    public Enemy setUpTrainingDummy(){
        return new TrainingDummy("Dumbo", 200);
    }
}
