package me.namakius.ExtremeMobs;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class ExtremeMobsListener
        implements Listener {
    ExtremeMobs extremeMob;

    ExtremeMobsListener(ExtremeMobs plugin) {
        this.extremeMob = plugin;
    }

    @EventHandler
    public void entityExplodeEvents(EntityExplodeEvent event) {
        if ((event.getEntity() instanceof Creeper)) {
            float explosionPower = 6.0F;
            event.getEntity().getWorld().createExplosion(event.getLocation(), explosionPower);
        }
    }

    @EventHandler
    public void mobSpawnEvents(CreatureSpawnEvent event) {
        if ((event.getEntity() instanceof Zombie)) {
            Zombie zombie = (Zombie) event.getEntity();
            ZombieMob.getExtremeZombie(zombie);
        } else if ((event.getEntity() instanceof Skeleton)) {
            Skeleton skeleton = (Skeleton) event.getEntity();
            SkeletonMob.getExtremeSkeleton(skeleton);
        }
    }

    @EventHandler
    public void entityDeathEvents(EntityDeathEvent event) {
        if (((event.getEntity() instanceof Skeleton)) &&
                ((event.getEntity().getKiller() instanceof Player))) {
            Player player = event.getEntity().getKiller();
            player.setHealth(20.0D);
        }
    }

    @EventHandler
    public void entityDamageByEntityEvents(EntityDamageByEntityEvent event) {
        if ((event.getDamager() instanceof Projectile)) {
            Projectile projectile = (Projectile) event.getDamager();
            if ((projectile instanceof Arrow)) {
                Arrow arrow = (Arrow) projectile;
                SkeletonMob.getExtremeSkeletonAttack(arrow, this.extremeMob);
            }
        }
        if ((event.getEntity() instanceof Spider)) {
            if ((event.getDamager() instanceof Player)) {
                Player player = (Player) event.getDamager();
                SpiderWebAttack.spiderAttack(player);
            }
        } else if (((event.getEntity() instanceof Player)) &&
                ((event.getDamager() instanceof Spider))) {
            Player player = (Player) event.getEntity();
            SpiderWebAttack.spiderAttack(player);
        }
    }
}
