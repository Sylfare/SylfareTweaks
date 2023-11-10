package re.sylfa.sylfaretweaks.gameplay;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Rabbit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class RabbitsCarrotCropsListener implements Listener {

    private Random random = new Random();

    @EventHandler
    public void onRabbitEatingCarrotCrop(EntityChangeBlockEvent event) {
        if (event.getEntityType() != EntityType.RABBIT || event.getBlock().getType() != Material.CARROTS)
            return;
        Rabbit rabbit = (Rabbit) event.getEntity();

        // if the rabbit is not adult, make it grow up
        if (!rabbit.isAdult()) {
            rabbit.setAge((int) Math.ceil(rabbit.getAge() * 0.95));
            event.getEntity().getWorld().spawnParticle(Particle.VILLAGER_HAPPY, event.getEntity().getLocation(), 5);
        }
        // if the rabbit can be in love mode, try to make it in love
        if (rabbit.canBreed() && random.nextDouble() < .5) {
            rabbit.setLoveModeTicks(600);
            rabbit.setBreedCause(null);
        }
    }
}