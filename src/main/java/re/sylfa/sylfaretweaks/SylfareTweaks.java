package re.sylfa.sylfaretweaks;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import re.sylfa.sylfaretweaks.gameplay.RabbitsCarrotCropsListener;

public class SylfareTweaks extends JavaPlugin{

    public static final Component prefix = Component.text("[SylfareTweaks] ", NamedTextColor.GOLD);
    public static final PluginManager pm = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        log(Component.text("Enabled!"));
        pm.registerEvents(new RabbitsCarrotCropsListener(), this);
    }

    public static void log(Component message) {
        Bukkit.getConsoleSender().sendMessage(prefix.append(message));
    }
}