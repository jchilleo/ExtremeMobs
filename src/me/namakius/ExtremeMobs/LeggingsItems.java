package me.namakius.ExtremeMobs;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

class LeggingsItems {
    private static Material getLeggingsMaterial() {
        ArrayList<Material> leggings = new ArrayList<Material>();
        leggings.add(Material.LEATHER_LEGGINGS);
        leggings.add(Material.IRON_LEGGINGS);
        leggings.add(Material.GOLD_LEGGINGS);
        leggings.add(Material.DIAMOND_LEGGINGS);

        Random random = new Random();
        return (Material) leggings.get(random.nextInt(leggings.size()));
    }

    private static Enchantment getLegginsEnchantment() {
        ArrayList<Enchantment> enchantment = new ArrayList<Enchantment>();
        enchantment.add(Enchantment.DURABILITY);
        enchantment.add(Enchantment.PROTECTION_EXPLOSIONS);
        enchantment.add(Enchantment.PROTECTION_FIRE);
        enchantment.add(Enchantment.PROTECTION_PROJECTILE);
        enchantment.add(Enchantment.THORNS);

        Random random = new Random();
        return (Enchantment) enchantment.get(random.nextInt(enchantment.size()));
    }

    private static ItemStack getZombieLeggings() {
        Random random = new Random();
        ItemStack legging = new ItemStack(getLeggingsMaterial(), 1);
        for (int i = 0; i < random.nextInt(3); i++) {
            try {
                legging.addEnchantment(getLegginsEnchantment(), random.nextInt(4) + 1);
            } catch (Exception e) {
                legging.addEnchantment(getLegginsEnchantment(), 1);
            }
        }
        return legging;
    }

    private static ItemStack getSkeletonLeggings() {
        Random random = new Random();
        ItemStack legging = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        legging.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
        for (int i = 0; i < random.nextInt(2); i++) {
            try {
                legging.addEnchantment(getLegginsEnchantment(), random.nextInt(4) + 1);
            } catch (Exception e) {
                legging.addEnchantment(getLegginsEnchantment(), 1);
            }
        }
        return legging;
    }

    static ItemStack getLeggings(Zombie zombie) {
        return getZombieLeggings();
    }

    static ItemStack getLeggings(Skeleton skeleton) {
        return getSkeletonLeggings();
    }
}

