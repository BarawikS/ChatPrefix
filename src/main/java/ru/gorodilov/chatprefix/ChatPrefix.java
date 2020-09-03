package ru.gorodilov.chatprefix;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import ru.gorodilov.chatprefix.commands.ChangeColorName;
import ru.gorodilov.chatprefix.commands.ChangePrefix;
import ru.gorodilov.chatprefix.commands.ReloadCommand;

import java.io.File;

public class ChatPrefix extends JavaPlugin {
    private static Chat chat = null;
    private static Permission perm = null;
    public static File config = new File("plugins/ChatPrefix", "config.yml");

    public void loadConf() {
        if(!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }
    }

    public void onEnable() {
        getCommand("prefix").setExecutor(new ChangePrefix(this));
        getCommand("color").setExecutor(new ChangeColorName(this));
        getCommand("cpreload").setExecutor(new ReloadCommand(this));
        loadConf();
        setupChat();
        setupPerm();
        getLogger().info("ChatPrefix is enabled! by Gorodlilov.ru");
    }
    public void onDisable() {
        getLogger().info("ChatPrefix is disabled! by Gorodlilov.ru");
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }
    private boolean setupPerm() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perm = rsp.getProvider();
        return perm != null;
    }
    public static Chat getChat() {
        return chat;
    }
    public static Permission getPerm() {
        return perm;
    }
    public String prefix = getConfig().getString("prefix").replaceAll("&","\u00a7");
    public String color = getConfig().getString("colors-message").replaceAll("&","\u00a7");
    public String pc = prefix + " " + color;
}
