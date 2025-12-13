package re.sylfa.sylfaretweaks;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;
import re.sylfa.sylfaretweaks.tweaks.paintingStonecutter.PaintingStonecutter;

public class SylfareTweaks extends JavaPlugin {

    private static final String NAMESPACE = "sylfaretweaks";
    private static SylfareTweaks instance;

    public static SylfareTweaks getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
        new PaintingStonecutter().onLoad();
    }

    @NonNull
    public static NamespacedKey getNamespacedKey(@NonNull String registry, @NonNull String id) {
        return new NamespacedKey(NAMESPACE, registry + "_" + id);
    }
}
