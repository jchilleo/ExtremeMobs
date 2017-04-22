package me.namakius.ExtremeMobs;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;

import com.projectkorra.projectkorra.ability.Ability;

class SkeletonMob {
    static void getExtremeSkeletonAttack(Arrow arrow, ExtremeMobs plugin) {
        if ((arrow.getShooter() instanceof Player) || (arrow.getShooter() instanceof Ability)) {
            return;
        }
        final Location location = arrow.getLocation();

        arrow.setCritical(true);
        arrow.setFireTicks(10);
        if ((arrow.getShooter() instanceof Skeleton)) {
            arrow.getWorld().strikeLightning(location);
            arrow.getWorld().createExplosion(location, 1.0F);
            arrow.getWorld().playSound(location, Sound.ENTITY_LIGHTNING_THUNDER, 10.0F, 10.0F);
            plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    arrow.getWorld().strikeLightning(location);
                    arrow.getWorld().createExplosion(location, 2.0F);
                    arrow.getWorld().playSound(location, Sound.ENTITY_LIGHTNING_THUNDER, 10.0F, 10.0F);
                }
            }, 3L);
            plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    arrow.getWorld().strikeLightning(location);
                    arrow.getWorld().createExplosion(location, 3.0F);
                    arrow.getWorld().playSound(location, Sound.ENTITY_LIGHTNING_THUNDER, 10.0F, 10.0F);
                }
            }, 10L);
        }
    }

    static void getExtremeSkeleton(Skeleton skeleton) {
        skeleton.getEquipment().setHelmet(HelmetItems.getHelmet(skeleton));
        skeleton.getEquipment().setHelmetDropChance(0.0F);
        skeleton.getEquipment().setChestplate(ChestplateItems.getChestplate(skeleton));
        skeleton.getEquipment().setChestplateDropChance(0.0F);
        skeleton.getEquipment().setLeggings(LeggingsItems.getLeggings(skeleton));
        skeleton.getEquipment().setLeggingsDropChance(0.0F);
        skeleton.getEquipment().setBoots(BootItems.getBoots(skeleton));
        skeleton.getEquipment().setBootsDropChance(0.0F);
    }
}
