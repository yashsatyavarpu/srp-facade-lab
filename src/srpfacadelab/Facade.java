public class Facade {
    private RpgPlayer player;
    private Action action;
    private Inventory inventory;
    private IGameEngine engine;

    public Facade(RpgPlayer player, Action action, Inventory inventory, IGameEngine engine){
        this.player = player;
        this.action = action;
        this.inventory = inventory;
        this.engine = engine;
    }
    public void calculateStats(int armor) {
        this.inventory.calculateStats(armor);
    }
    public boolean checkifItemExistsInInventory(Item item){
        return this.inventory.checkIfItemExistsInInventory(item);
    }
    public int calculateInventoryWeight(){
        return this.inventory.calculateInventoryWeight();
    }
    public void useItem(Item item){
        this.action.useItem(item);
    }
    public boolean pickUpItem(Item item, RpgPlayer player, Inventory inventory, IGameEngine engine){
        return this.action.pickUpItem(item, player, inventory, engine);
    }
    public void takeDamage(int damage, RpgPlayer player, IGameEngine engine, Inventory inventory){
        this.action.takeDamage(damage, player, engine, inventory);
    }

}