package me.namakius.ExtremeMobs;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

class BootItems {
    private static Material getBootMaterial() {
        ArrayList<Material> helmet = new ArrayList<>();
        helmet.add(Material.LEATHER_BOOTS);
        helmet.add(Material.IRON_BOOTS);
        helmet.add(Material.GOLD_BOOTS);
        helmet.add(Material.DIAMOND_BOOTS);

        Random random = new Random();
        return helmet.get(random.nextInt(helmet.size()));
    }

    private static Enchantment getBootEnchantment() {
        ArrayList<Enchantment> enchantment = new ArrayList<>();
        enchantment.add(Enchantment.DURABILITY);
        enchantment.add(Enchantment.PROTECTION_EXPLOSIONS);
        enchantment.add(Enchantment.PROTECTION_FIRE);
        enchantment.add(Enchantment.PROTECTION_PROJECTILE);
        enchantment.add(Enchantment.THORNS);
        enchantment.add(Enchantment.PROTECTION_FALL);

        Random random = new Random();
        return enchantment.get(random.nextInt(enchantment.size()));
    }

    private static ItemStack getZombieBoots() {
        Random random = new Random();
        ItemStack boots = new ItemStack(getBootMaterial(), 1);
        for (int i = 0; i < random.nextInt(3); i++) {
            try {
                boots.addEnchantment(getBootEnchantment(), random.nextInt(4) + 1);
            } catch (Exception e) {
                boots.addEnchantment(getBootEnchantment(), 1);
            }
        }
        return boots;
    }

    private static ItemStack getSkeletonBoots() {
        Random random = new Random();
        ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        boots.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
        for (int i = 0; i < random.nextInt(2); i++) {
            try {
                boots.addEnchantment(getBootEnchantment(), random.nextInt(4) + 1);
            } catch (Exception e) {
                boots.addEnchantment(getBootEnchantment(), 1);
            }
        }
        return boots;
    }

    static ItemStack getBoots(Zombie zombie) {
        return getZombieBoots();
    }

    static ItemStack getBoots(Skeleton skeleton) {
        return getSkeletonBoots();
    }
}
