package re.sylfa.sylfaretweaks.tweaks.paintingStonecutter;

import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import org.bukkit.Art;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.StonecuttingRecipe;
import re.sylfa.sylfaretweaks.SylfareTweaks;
import re.sylfa.sylfaretweaks.tweaks.Tweak;

public class PaintingStonecutter implements Tweak {
    private static final String REGISTRY_KEY = "painting_stonecutter";
    private static final Registry<Art> REGISTRY = RegistryAccess.registryAccess().getRegistry(RegistryKey.PAINTING_VARIANT);

    @Override
    public void enable() {
        REGISTRY.stream()
            .map(this::getPaintingRecipe)
            .forEach(Bukkit::addRecipe);
    }

    @Override
    public void disable() {

    }

    private Recipe getPaintingRecipe(Art painting) {
        ItemStack item = new ItemStack(Material.PAINTING);
        item.setData(DataComponentTypes.PAINTING_VARIANT, painting);
        NamespacedKey key = REGISTRY.getKey(painting);
        String formatedKey = String.join(".", key.getNamespace(), key.getKey());
        return new StonecuttingRecipe(SylfareTweaks.getNamespacedKey(REGISTRY_KEY, formatedKey), item, Material.PAINTING);
    }
}
