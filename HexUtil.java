// your package

import org.bukkit.ChatColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class HexUtil {
    private static final Pattern HEX_PATTERN = Pattern.compile("&#([A-Fa-f0-9])([A-Fa-f0-9])([A-Fa-f0-9])([A-Fa-f0-9])([A-Fa-f0-9])([A-Fa-f0-9])");
    @Contract("_ -> new")
    public static @NotNull String formatHex(String text) {
        return ChatColor.translateAlternateColorCodes('&', HEX_PATTERN.matcher(text).replaceAll("&x&$1&$2&$3&$4&$5&$6"));
    }
    public static @NotNull List<String> formatHex(List<String> messages){
        List<String> result = new ArrayList<>();

        if(messages != null) {
            for(String message : messages) result.add(formatHex(message));
        }

        return result;
    }
}