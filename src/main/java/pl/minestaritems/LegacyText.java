package pl.minestaritems;

import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;

/** Parser kodow &a, &l oraz &#RRGGBB -> Text (bez kursywy, jak w lore z serwera). */
public final class LegacyText {
    private LegacyText() {}

    public static MutableText parse(String s) {
        MutableText out = Text.empty();
        Style base = Style.EMPTY.withItalic(false);
        Style cur = base;
        StringBuilder buf = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if ((c == '&' || c == '\u00a7') && i + 1 < s.length()) {
                char n = s.charAt(i + 1);
                if (n == '#' && i + 8 <= s.length()) {
                    String hex = s.substring(i + 2, i + 8);
                    try {
                        int rgb = Integer.parseInt(hex, 16);
                        flush(out, buf, cur);
                        cur = base.withColor(TextColor.fromRgb(rgb)).withBold(cur.isBold());
                        i += 8;
                        continue;
                    } catch (NumberFormatException ignored) {
                        // zostaje zwykly tekst
                    }
                }
                Formatting f = Formatting.byCode(Character.toLowerCase(n));
                if (f != null) {
                    flush(out, buf, cur);
                    if (f == Formatting.RESET) cur = base;
                    else if (f.isColor()) cur = base.withColor(f);
                    else cur = cur.withFormatting(f);
                    i += 2;
                    continue;
                }
            }
            buf.append(c);
            i++;
        }
        flush(out, buf, cur);
        return out;
    }

    private static void flush(MutableText out, StringBuilder buf, Style style) {
        if (buf.length() == 0) return;
        out.append(Text.literal(buf.toString()).setStyle(style));
        buf.setLength(0);
    }
}
