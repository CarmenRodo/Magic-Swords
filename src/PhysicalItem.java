
public abstract class PhysicalItem {

    private String itemName;
    private double damageValue;


    public PhysicalItem(String itemName, double damageValue) {
        setItemName(itemName);
        setDamageValue(damageValue);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getDamageValue() {
        return damageValue;
    }

    public void setDamageValue(double damageValue) {
        this.damageValue = damageValue;
    }
}
