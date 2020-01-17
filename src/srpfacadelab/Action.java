public class Action{

    public void useItem(Item item) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = gameEngine.getEnemiesNear(this);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

    public boolean pickUpItem(Item item, RpgPlayer player, Inventory inventory, IGameEngine gameEngine) {
        int weight = inventory.calculateInventoryWeight();
        if (weight + item.getWeight() > player.getCarryingCapacity)
            return false;

        if (item.isUnique() && inventory.checkIfItemExistsInInventory(item))
            return false;

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            player.health += item.getHeal();

            if (player.health > maxHealth)
                player.health = maxHealth;

            if (item.getHeal() > 500) {
                gameEngine.playSpecialEffect("green_swirly");
            }

            return true;
        }

        if (item.isRare())
            gameEngine.playSpecialEffect("cool_swirly_particles");

        if (item.isRare() && item.isUnique())
            gameEngine.playSpecialEffect("blue_swirly");

        inventory.add(item);

        player.armor = inventory.calculateStats(player.armor);

        return true;
    }

    public void takeDamage(int damage, RpgPlayer player, IGameEngine engine, Inventory inventory) {
        if (damage < player.armour) {
            engine.playSpecialEffect("parry");
        }

        int damageToDeal = damage - player.armour;
        if (inventory.calculateInventoryWeight() < player.getCarryingCapacity() ){
            player.health -= .75 * damageToDeal;
        }
        else {
            player.health -= damageToDeal;
        }

        engine.playSpecialEffect("lots_of_gore");
    }
}