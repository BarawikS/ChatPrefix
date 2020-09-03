package ru.gorodilov.chatprefix.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.gorodilov.chatprefix.ChatPrefix;

import java.util.Arrays;

public class ChangePrefix implements CommandExecutor {
    private ChatPrefix pl;
    public ChangePrefix(ChatPrefix chatPrefix) {
        this.pl = chatPrefix;
    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String l, String[] arg) {
        if (s instanceof Player) {
            Player p = (Player) s;
            if (!pl.getPerm().playerHas(p,"chatprefix.prefix") ) {
                p.sendMessage(pl.pc+"У вас недостаточно прав!");
            } else {
                if (arg.length == 0) {
                    p.sendMessage(pl.pc + "Для смены префикса используйте:");
                    p.sendMessage(pl.color + "/prefix <prefix> (макс.длина префикса - 1 слово)" + (p.isOp() ? " §c(chatprefix.prefix) + §c(chatprefix.prefix.other)" : ""));
                    p.sendMessage(pl.color + "Для очистки префикса на стандартный используйте:");
                    p.sendMessage(pl.color + "/prefix clear" + (p.isOp() ? " §c(chatprefix.prefix) + §c(chatprefix.prefix.other)" : ""));
                }else if(arg.length == 1) {
                    if (arg[0].equals("clear")) {
                        pl.getChat().setPlayerPrefix(null, p, "");
                        p.sendMessage(pl.pc + "Теперь Ваш префикс - " + pl.getChat().getPlayerPrefix(p).replaceAll("&", "\u00a7")+ "\u00a7f" + p.getName());
                    } else {
                        pl.getChat().setPlayerPrefix(null ,p,"&8[&f"+arg[0]+"&8]&f ");
                        p.sendMessage(pl.pc + "Теперь Ваш префикс - " + pl.getChat().getPlayerPrefix(p).replaceAll("&", "\u00a7")+ "\u00a7f" + p.getName());
                    }
                } else if(arg.length == 2){
                    if (!pl.getPerm().playerHas(p,"chatprefix.prefix.other") ) {
                        p.sendMessage(pl.pc+"У вас недостаточно прав для смены префиксов других игроков!");
                    } else {
                            if(!(pl.getServer().getPlayer(arg[0]) != null)) {
                                p.sendMessage(pl.pc + "Невозможно изменить префикс оффлайн игроку!");
                            } else {
                                Player player = Bukkit.getPlayer(arg[0]);
                                if (arg[1].equals("clear")) {
                                    pl.getChat().setPlayerPrefix(null, player, "");
                                    p.sendMessage(pl.pc + "Префикс игрока " + player.getName() + " теперь - " + pl.getChat().getPlayerPrefix(player).replaceAll("&", "\u00a7") + "\u00a7f" + player.getName());
                                    //player.sendMessage(pl.pc + "Теперь Ваш префикс - " + pl.getChat().getPlayerPrefix(player).replaceAll("&", "\u00a7"));
                                } else {
                                    pl.getChat().setPlayerPrefix(null, player, "&8[&f" + arg[1] + "&8]&f ");
                                    p.sendMessage(pl.pc + "Префикс игрока " + player.getName() + " теперь - " + pl.getChat().getPlayerPrefix(player).replaceAll("&", "\u00a7")+ "\u00a7f" + player.getName());
                                    //player.sendMessage(pl.pc + "Теперь Ваш префикс - " + pl.getChat().getPlayerPrefix(player).replaceAll("&", "\u00a7"));
                                }
                            }
                    }
                }
            }
        } else {
            if(!(pl.getServer().getPlayer(arg[0]) != null)) {
                s.sendMessage(pl.pc + "Невозможно изменить префикс оффлайн игроку!");
            } else {
                Player player = Bukkit.getPlayer(arg[0]);
                if (arg[1].equals("clear")) {
                    pl.getChat().setPlayerPrefix(null, player, "");
                    s.sendMessage(pl.pc + "Префикс игрока " + player.getName() + " теперь - " + pl.getChat().getPlayerPrefix(player).replaceAll("&", "\u00a7") + "\u00a7f" + player.getName());
                    //player.sendMessage(pl.pc + "Теперь Ваш префикс - " + pl.getChat().getPlayerPrefix(player).replaceAll("&", "\u00a7"));
                } else {
                    pl.getChat().setPlayerPrefix(null, player, "&8[&f" + arg[1] + "&8]&f ");
                    s.sendMessage(pl.pc + "Префикс игрока " + player.getName() + " теперь - " + pl.getChat().getPlayerPrefix(player).replaceAll("&", "\u00a7")+ "\u00a7f" + player.getName());
                    //player.sendMessage(pl.pc + "Теперь Ваш префикс - " + pl.getChat().getPlayerPrefix(player).replaceAll("&", "\u00a7"));
                }
            }
        }

        return true;
    }
}
