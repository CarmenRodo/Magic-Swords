
public abstract class MagicItem {

    private String itemName;
    private double DamageValue;


    public MagicItem(String itemName, double damageValue) {
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
        return DamageValue;
    }

    public void setDamageValue(double damageValue) {
        DamageValue = damageValue;
    }

}
