package com.venomapps.ua;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	AnvilDamageListener anvilDamageListener = new AnvilDamageListener();
	
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(anvilDamageListener, this);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "IA >> Author : Venom Apps");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "IA >> Enabled Succesfully!");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "IA >> Check out our website: https://venomapps.com");
    }
    
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "IA >> Author : Venom Apps");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "IA >> Disabled Succesfully!");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "IA >> Check out our website: https://venomapps.com");
    }
}