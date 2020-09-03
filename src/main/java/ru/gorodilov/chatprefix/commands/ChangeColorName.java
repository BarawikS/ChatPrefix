package ru.gorodilov.chatprefix.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.gorodilov.chatprefix.ChatPrefix;

import java.util.Arrays;

public class ChangeColorName implements CommandExecutor {
    private ChatPrefix pl;
    public ChangeColorName(ChatPrefix chatPrefix) {
        this.pl = chatPrefix;
    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String lab, String[] arg) {
        if (s instanceof Player) {
            Player p = (Player) s;
            if (!pl.getPerm().playerHas(p,"chatprefix.color") ) {
                p.sendMessage(pl.pc+"У вас недостаточно прав!");
            } else {
                if (arg.length == 0) {
                    p.sendMessage(pl.pc + "Для смены цвета ника используйте:");
                    p.sendMessage(pl.color + "/color <color>" + (p.isOp() ? " §c(chatprefix.color) + §c(chatprefix.color.other)" : ""));
                    p.sendMessage(pl.color + "Для очистки цвета ника на стандартный используйте:");
                    p.sendMessage(pl.color + "/color clear" + (p.isOp() ? " §c(chatprefix.color) + §c(chatprefix.color.other)" : ""));
                } else if (arg.length == 1) {
                        switch (arg[0]) {
                            case "0":
                                pl.getChat().setPlayerSuffix(null, p, "&0");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(p).replaceAll("&", "\u00a7") + p.getName());
                                break;
                            case "1":
                                pl.getChat().setPlayerSuffix(null, p, "&1");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(p).replaceAll("&", "\u00a7") + p.getName());
                                break;
                            case "2":
                                pl.getChat().setPlayerSuffix(null, p, "&2");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(p).replaceAll("&", "\u00a7") + p.getName());
                                break;
                            case "3":
                                pl.getChat().setPlayerSuffix(null, p, "&3");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(p).replaceAll("&", "\u00a7") + p.getName());
                                break;
                            case "4":
                                pl.getChat().setPlayerSuffix(null, p, "&4");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(p).replaceAll("&", "\u00a7") + p.getName());
                                break;
                            case "5":
                                pl.getChat().setPlayerSuffix(null, p, "&5");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(p).replaceAll("&", "\u00a7") + p.getName());
                                break;
                            case "6":
                                pl.getChat().setPlayerSuffix(null, p, "&6");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(p).replaceAll("&", "\u00a7") + p.getName());
                                break;
                            case "7":
                                pl.getChat().setPlayerSuffix(null, p, "&7");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(p).replaceAll("&", "\u00a7") + p.getName());
                                break;
                            case "8":
                                pl.getChat().setPlayerSuffix(null, p, "&8");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(p).replaceAll("&", "\u00a7") + p.getName());
                                break;
                            case "9":
                                pl.getChat().setPlayerSuffix(null, p, "&9");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(p).replaceAll("&", "\u00a7") + p.getName());
                                break;
                            case "a":
                                pl.getChat().setPlayerSuffix(null, p, "&a");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(p).replaceAll("&", "\u00a7") + p.getName());
                                break;
                            case "b":
                                pl.getChat().setPlayerSuffix(null, p, "&b");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(p).replaceAll("&", "\u00a7") + p.getName());
                                break;
                            case "c":
                                pl.getChat().setPlayerSuffix(null, p, "&c");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(p).replaceAll("&", "\u00a7") + p.getName());
                                break;
                            case "d":
                                pl.getChat().setPlayerSuffix(null, p, "&d");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(p).replaceAll("&", "\u00a7") + p.getName());
                                break;
                            case "e":
                                pl.getChat().setPlayerSuffix(null, p, "&e");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(p).replaceAll("&", "\u00a7") + p.getName());
                                break;
                            case "f":
                                pl.getChat().setPlayerSuffix(null, p, "&f");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(p).replaceAll("&", "\u00a7") + p.getName());
                                break;
                            case "clear":
                                pl.getChat().setPlayerSuffix(null, p, "");
                                p.sendMessage(pl.pc + "Теперь цвет Вашего ника - стандартный");
                                break;
                            default:
                                p.sendMessage(pl.pc + "Используйте /color для подробной информации");
                                break;
                        }
                    } else if(arg.length == 2) {
                    if (!pl.getPerm().playerHas(p, "chatprefix.color.other")) {
                        p.sendMessage(pl.pc + "У вас недостаточно прав для смены цвета ника других игроков!");
                    } else {
                        if (!(pl.getServer().getPlayer(arg[0]) != null)) {
                            p.sendMessage(pl.pc + "Невозможно изменить цвет ника оффлайн игроку!");
                        } else {
                            if (arg[1].length() > 1) {
                                p.sendMessage(pl.pc + "Максимальная длина цветого кода - 1 символ!");
                            } else {
                                Player player = pl.getServer().getPlayer(arg[0]);
                                pl.getChat().setPlayerSuffix(null, player, "&"+arg[1]);
                                //player.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(player).replaceAll("&", "\u00a7") + " " + player.getName());
                                p.sendMessage(pl.pc + "Теперь у игрока " + player.getName() + " цвет ника - " + pl.getChat().getPlayerSuffix(player).replaceAll("&", "\u00a7")  + player.getName());
                            }
                        }
            } } }
        } else {
            if (!(pl.getServer().getPlayer(arg[0]) != null)) {
                s.sendMessage(pl.pc + "Невозможно изменить цвет ника оффлайн игроку!");
            } else {
                if (arg[1].length() > 1) {
                    s.sendMessage(pl.pc + "Максимальная длина цветого кода - 1 символ!");
                } else {
                    Player player = pl.getServer().getPlayer(arg[0]);
                    pl.getChat().setPlayerSuffix(null, player, "&"+arg[1]);
                    //player.sendMessage(pl.pc + "Теперь цвет Вашего ника - " + pl.getChat().getPlayerSuffix(player).replaceAll("&", "\u00a7") + " " + player.getName());
                    s.sendMessage(pl.pc + "Теперь у игрока " + player.getName() + " цвет ника - " + pl.getChat().getPlayerSuffix(player).replaceAll("&", "\u00a7")  + player.getName());
                }
            }}
        return true;
    }
}
