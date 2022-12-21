package mrskill4ik.fixeasyplacemode;

import mrskill4ik.fixeasyplacemode.Objects.DataInfo;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Material.AIR;

public class Events implements Listener {

    private static DataInfo TestBlock;
    private static final List<Integer> ListRepeats = new ArrayList<>();
    private @Nullable Plugin plugin = Bukkit.getPluginManager().getPlugin("FIXeasyPlaceMode");


    @EventHandler
    public void Place(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        int x = player.getTargetBlock(null, 8).getX();
        int y = player.getTargetBlock(null, 8).getY();
        int z = player.getTargetBlock(null, 8).getZ();
        if (TestBlock.getX() == x && TestBlock.getY() == y && TestBlock.getZ() == z && TestBlock.getBlockClick() == AIR) {
            if (player.hasMetadata("Repeats")) {
                int Index = player.getMetadata("Repeats").get(0).asInt();
                if (Index >= 30) {
                    player.removeMetadata("Repeats", plugin);

                    player.kick(Component.newline().content("Превышено время ожидания [0846]"));
                } else {
                    player.setMetadata("Repeats", new FixedMetadataValue(plugin, Index + 1));
                }
            } else {
                player.setMetadata("Repeats", new FixedMetadataValue(plugin, 1));
            }
            event.setCancelled(true);
        }

    }

    @EventHandler(priority = EventPriority.HIGH)
    public void Click(PlayerInteractEvent event) {
        if (event.getAction().isRightClick()) {
            if (event.getClickedBlock() == null) return;
            TestBlock = new DataInfo(
                    event.getClickedBlock().getLocation().getBlockX(),
                    event.getClickedBlock().getLocation().getBlockY(),
                    event.getClickedBlock().getLocation().getBlockZ(),
                    event.getClickedBlock().getType()
            );
        }
    }

}
