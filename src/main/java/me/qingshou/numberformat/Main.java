package me.qingshou.numberformat;

import me.qingshou.lib.BasePlugin;
import me.qingshou.lib.anntation.Outsource;
import me.qingshou.numberformat.util.PAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
public class Main extends BasePlugin {
    public static JavaPlugin instance;

    @Outsource
    public void init() {
        instance = this;
        need_version = "1.1.4";
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            (new PAPI()).register();
            getLogger().info("Find PlaceholderAPI");
        }
    }

    public void onDisable() {
    }
}
