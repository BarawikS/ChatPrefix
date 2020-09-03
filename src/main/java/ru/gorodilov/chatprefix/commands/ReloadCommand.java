package ru.gorodilov.chatprefix.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.gorodilov.chatprefix.ChatPrefix;

public class ReloadCommand implements CommandExecutor {

    private ChatPrefix pl;
    public ReloadCommand(ChatPrefix chatPrefix) {
        this.pl = chatPrefix;
    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String lab, String[] arg) {
        if (s instanceof Player) {
            Player p = (Player) s;
            if (!pl.getPerm().playerHas(p, "chatprefix.reload")) {
                p.sendMessage(pl.pc + "У вас недостаточно прав!");
            } else {
                pl.reloadConfig();
                p.sendMessage(pl.pc + "Конфиг перезагружен!");
            }
        } else {
            pl.reloadConfig();
            s.sendMessage(pl.pc + "Конфиг перезагружен!");
        }
        return true;
    }
}
