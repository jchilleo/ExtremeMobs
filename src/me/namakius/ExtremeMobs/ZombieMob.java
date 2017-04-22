package me.namakius.ExtremeMobs;

import org.bukkit.entity.Zombie;

class ZombieMob
{
  static void getExtremeZombie(Zombie zombie)
  {
    zombie.getEquipment().setItemInMainHand(SwordItems.getSword(zombie));
    zombie.getEquipment().setItemInMainHandDropChance(0.0F);
    
    zombie.getEquipment().setHelmet(HelmetItems.getHelmet(zombie));
    zombie.getEquipment().setHelmetDropChance(0.0F);
    zombie.getEquipment().setChestplate(ChestplateItems.getChestplate(zombie));
    zombie.getEquipment().setChestplateDropChance(0.0F);
    zombie.getEquipment().setLeggings(LeggingsItems.getLeggings(zombie));
    zombie.getEquipment().setLeggingsDropChance(0.0F);
    zombie.getEquipment().setBoots(BootItems.getBoots(zombie));
    zombie.getEquipment().setBootsDropChance(0.0F);
  }


}
