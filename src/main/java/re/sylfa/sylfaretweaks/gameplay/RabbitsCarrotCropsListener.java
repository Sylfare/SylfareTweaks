package re.sylfa.sylfaretweaks.gameplay;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Rabbit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class RabbitsCarrotCropsListener implements Listener{

    @EventHandler
    public void onRabbitEatingCarrotCrop(EntityChangeBlockEvent event){
        if(event.getEntityType() != EntityType.RABBIT || event.getBlock().getType() != Material.CARROTS) return;
        Rabbit rabbit = (Rabbit) event.getEntity();
        if(!rabbit.isAdult()) {
            rabbit.setAge((int) Math.ceil(rabbit.getAge() * 0.95));
            event.getEntity().getWorld().spawnParticle(Particle.VILLAGER_HAPPY, event.getEntity().getLocation(), 5);
        }
    }
    
}