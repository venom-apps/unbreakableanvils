package com.venomapps.ua;

import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class AnvilDamageListener implements Listener{

	public AnvilDamageListener() {}
	
    @EventHandler
    public void onAnvilDamage(final PlayerInteractEvent event) {
    	Player player = event.getPlayer();
    	final Block clickedBlock = player.getTargetBlock((Set<Material>)null, 5);
        if (clickedBlock.getType() == Material.DAMAGED_ANVIL || clickedBlock.getType() == Material.CHIPPED_ANVIL) {
        	BlockData blockData = clickedBlock.getBlockData();
        	Location blockLocation = clickedBlock.getLocation();
        	this.setBlock(player, blockData, blockLocation, clickedBlock, Material.ANVIL);
        }
    }
    
    public void setBlock(final Player player, BlockData data, final Location location, Block block, final Material newMaterial) {
        if (data instanceof Directional) {
            final BlockFace face = ((Directional)data).getFacing();
            location.getBlock().setType(newMaterial);
            block = player.getTargetBlock((Set<Material>)null, 5);
            data = block.getBlockData();
            ((Directional)data).setFacing(face);
            block.setBlockData(data);
        }
    }
}