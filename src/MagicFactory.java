public class MagicFactory {

    public static MagicItem getMagicItem(String itemName, double damageValue, String itemType){
        if (itemType.equals("Staff")) {
            return new Staff(itemName, damageValue);            
        } else if (itemType.equals("Wand")){
            return new Wand(itemName, damageValue);
        } else if (itemType.equals("Gauntlet")){
            return new Gauntlet(itemName, damageValue);
        } else return null;
    }
}
