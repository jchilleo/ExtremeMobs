package me.namakius.ExtremeMobs;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

class ChestplateItems {
    private static Material getChestplateMaterial() {
        ArrayList<Material> chestplate = new ArrayList<>();
        chestplate.add(Material.LEATHER_CHESTPLATE);
        chestplate.add(Material.IRON_CHESTPLATE);
        chestplate.add(Material.GOLD_CHESTPLATE);
        chestplate.add(Material.DIAMOND_CHESTPLATE);

        Random random = new Random();
        return chestplate.get(random.nextInt(chestplate.size()));
    }

    private static Enchantment getChestplateEnchantment() {
        ArrayList<Enchantment> enchantment = new ArrayList<Enchantment>();
        enchantment.add(Enchantment.DURABILITY);
        enchantment.add(Enchantment.PROTECTION_EXPLOSIONS);
        enchantment.add(Enchantment.PROTECTION_FIRE);
        enchantment.add(Enchantment.PROTECTION_PROJECTILE);
        enchantment.add(Enchantment.THORNS);

        Random random = new Random();
        return (Enchantment) enchantment.get(random.nextInt(enchantment.size()));
    }

    private static ItemStack getZombieChestplate() {
        Random random = new Random();
        ItemStack chestplate = new ItemStack(getChestplateMaterial(), 1);
        for (int i = 0; i < random.nextInt(3); i++) {
            try {
                chestplate.addEnchantment(getChestplateEnchantment(), random.nextInt(4) + 1);
            } catch (Exception e) {
                chestplate.addEnchantment(getChestplateEnchantment(), 1);
            }
        }
        return chestplate;
    }

    private static ItemStack getSkeletonChestplate() {
        Random random = new Random();
        ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        chestplate.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
        for (int i = 0; i < random.nextInt(2); i++) {
            try {
                chestplate.addEnchantment(getChestplateEnchantment(), random.nextInt(4) + 1);
            } catch (Exception e) {
                chestplate.addEnchantment(getChestplateEnchantment(), 1);
            }
        }
        return chestplate;
    }

    static ItemStack getChestplate(Zombie zombie) {
        return getZombieChestplate();
    }

    static ItemStack getChestplate(Skeleton skeleton) {
        return getSkeletonChestplate();
    }
}
