package me.namakius.ExtremeMobs;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

class SwordItems {
    private static Material getSwordMaterial() {
        ArrayList<Material> weapon = new ArrayList<Material>();

        weapon.add(Material.WOOD_SWORD);

        weapon.add(Material.IRON_SWORD);

        weapon.add(Material.GOLD_SWORD);

        weapon.add(Material.DIAMOND_SWORD);

        Random random = new Random();
        return (Material) weapon.get(random.nextInt(weapon.size()));
    }

    private static Enchantment getSwordEnchantment() {
        ArrayList<Enchantment> enchantment = new ArrayList<Enchantment>();
        enchantment.add(Enchantment.DAMAGE_ALL);
        enchantment.add(Enchantment.DURABILITY);
        enchantment.add(Enchantment.FIRE_ASPECT);
        enchantment.add(Enchantment.KNOCKBACK);

        Random random = new Random();
        return (Enchantment) enchantment.get(random.nextInt(enchantment.size()));
    }

    private static ItemStack getZombieSword() {
        Random random = new Random();
        ItemStack weapon = new ItemStack(getSwordMaterial());
        for (int i = 0; i < random.nextInt(3); i++) {
            try {
                weapon.addEnchantment(getSwordEnchantment(), random.nextInt(4) + 1);
            } catch (Exception e) {
                weapon.addEnchantment(getSwordEnchantment(), 1);
            }
        }
        return weapon;
    }

    static ItemStack getSword(Zombie zombie) {
        return getZombieSword();
    }
}
