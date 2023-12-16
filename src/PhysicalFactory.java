
public class PhysicalFactory {

    public static PhysicalItem getPhysicalItem(String itemName, double damageValue, String itemType){
        if (itemType.equals("Sword")) {
            return new Sword(itemName, damageValue);
        } else if (itemType.equals("Cane")) {
            return new Cane(itemName, damageValue);
        } else {
            return null;
        }
    }
}
