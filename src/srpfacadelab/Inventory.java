
public class Inventory {

    private List<Item> inventory;

    public Inventory() {
        inventory = new ArrayList<Item>();
    }
    private void calculateStats(int armor) {
        for (Item i: inventory) {
            armour += i.getArmour();
        }
        return armor;
    }

    private boolean checkIfItemExistsInInventory(Item item) {
        for (Item i: inventory) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }

    private int calculateInventoryWeight() {
        int sum=0;
        for (Item i: inventory) {
            sum += i.getWeight();
        }
        return sum;
    }

    private int add(Item i) {
        inventory.add(i);
    }
}