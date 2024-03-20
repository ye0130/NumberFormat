package me.qingshou.numberformat.util;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.qingshou.lib.SimpleLib;
import me.qingshou.lib.util.handle.AnyUnit;
import me.qingshou.lib.util.handle.StringUtil;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class PAPI extends PlaceholderExpansion {
    public boolean canRegister() {
        return true;
    }

    public boolean persist() {
        return true;
    }

    public String getAuthor() {
        return "QingShou";
    }

    public String getIdentifier() {
        return "nf";
    }

    public String getVersion() {
        return "1.0.0";
    }

    public String onPlaceholderRequest(Player player, String identifier) {
        try {
            AnyUnit anyUnit = SimpleLib.getAnyUnit();
            String papi = PlaceholderAPI.setPlaceholders((OfflinePlayer) player, "%" + identifier + "%");
            if (papi.contains("-")) {
                double value1 = Double.parseDouble(papi.split("-")[0]);
                double value2 = Double.parseDouble(papi.split("-")[1]);

                return anyUnit.format(value1) + "-" + anyUnit.format(value2);
            }
            if (!StringUtil.isNumber(papi)) {
                return papi + "非数值";
            }
            return anyUnit.format(Double.parseDouble(papi));
        } catch (Exception exception) {
            return "变量错误0";
        }
    }
}