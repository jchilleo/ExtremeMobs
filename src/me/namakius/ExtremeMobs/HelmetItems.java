package me.namakius.ExtremeMobs;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

class HelmetItems {
    private static Material getHelmetMaterial() {
        ArrayList<Material> helmet = new ArrayList<Material>();
        helmet.add(Material.LEATHER_HELMET);
        helmet.add(Material.IRON_HELMET);
        helmet.add(Material.GOLD_HELMET);
        helmet.add(Material.DIAMOND_HELMET);

        Random random = new Random();
        return (Material) helmet.get(random.nextInt(helmet.size()));
    }

    private static Enchantment getHelmetEnchantment() {
        ArrayList<Enchantment> enchantment = new ArrayList<Enchantment>();
        enchantment.add(Enchantment.DURABILITY);
        enchantment.add(Enchantment.PROTECTION_EXPLOSIONS);
        enchantment.add(Enchantment.PROTECTION_FIRE);
        enchantment.add(Enchantment.PROTECTION_PROJECTILE);
        enchantment.add(Enchantment.THORNS);

        Random random = new Random();
        return (Enchantment) enchantment.get(random.nextInt(enchantment.size()));
    }

    private static ItemStack getZombieHelmet() {
        Random random = new Random();
        ItemStack helmet = new ItemStack(getHelmetMaterial(), 1);
        for (int i = 0; i < random.nextInt(3); i++) {
            try {
                helmet.addEnchantment(getHelmetEnchantment(), random.nextInt(4) + 1);
            } catch (Exception e) {
                helmet.addEnchantment(getHelmetEnchantment(), 1);
            }
        }
        return helmet;
    }

    private static ItemStack getSkeletonHelmet() {
        Random random = new Random();
        ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        helmet.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
        for (int i = 0; i < random.nextInt(3); i++) {
            try {
                helmet.addEnchantment(getHelmetEnchantment(), random.nextInt(4) + 1);
            } catch (Exception e) {
                helmet.addEnchantment(getHelmetEnchantment(), 1);
            }
        }
        return helmet;
    }


    static ItemStack getHelmet(Zombie zombie) {
        return getZombieHelmet();

    }

    static ItemStack getHelmet(Skeleton skeleton) {
        return getSkeletonHelmet();

    }

}
