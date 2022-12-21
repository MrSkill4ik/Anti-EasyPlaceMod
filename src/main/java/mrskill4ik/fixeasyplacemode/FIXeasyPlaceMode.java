package mrskill4ik.fixeasyplacemode;

import jdk.tools.jlink.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

public final class FIXeasyPlaceMode extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
        Bukkit.getLogger().info("Load complete");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
