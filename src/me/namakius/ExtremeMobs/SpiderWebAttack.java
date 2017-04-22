package me.namakius.ExtremeMobs;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

class SpiderWebAttack {
    static void spiderAttack(Player player) {
        Location playerPos = player.getLocation();

        int r = 1;
        Random random = new Random();
        for (int x = r * -1; x <= r; x++) {
            for (int y = r * -1; y <= r; y++) {
                for (int z = r * -1; z <= r; z++) {
                    Block block = playerPos.getWorld().getBlockAt(playerPos.getBlockX() + x, playerPos.getBlockY() + y, playerPos.getBlockZ() + z);
                    if ((block.getType() == Material.AIR) && (random.nextInt(13) == 1)) {
                        block.setType(Material.WEB);
                    }
                }
            }
        }
    }
}
