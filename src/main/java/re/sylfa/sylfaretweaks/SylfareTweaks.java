package re.sylfa.sylfaretweaks;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class SylfareTweaks extends JavaPlugin{

    public static final Component prefix = Component.text("[SylfareTweaks] ", NamedTextColor.GOLD);

    @Override
    public void onEnable() {
        log(Component.text("Enabled!"));
    }

    public void log(Component message) {
        Bukkit.getConsoleSender().sendMessage(prefix.append(message));
    }
}