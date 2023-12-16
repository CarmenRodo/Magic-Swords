
public abstract class Wizard {

    private String name;
    private MagicItem primaryWeapon;
    private PhysicalItem secondaryWeapon;
    // private Trinket personalCurio;

    public Wizard(String name, MagicItem primaryWeapon, PhysicalItem secondaryWeapon) {
        setName(name);
        this.primaryWeapon = primaryWeapon;
        this.secondaryWeapon = secondaryWeapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MagicItem getPrimaryWeapon() {
        return primaryWeapon;
    }

    public void setPrimaryWeapon(MagicItem primaryWeapon) {
        this.primaryWeapon = primaryWeapon;
    }

    public PhysicalItem getSecondaryWeapon() {
        return secondaryWeapon;
    }

    public void setSecondaryWeapon(PhysicalItem secondaryWeapon) {
        this.secondaryWeapon = secondaryWeapon;
    }
}
