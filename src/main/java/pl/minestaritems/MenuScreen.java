package pl.minestaritems;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class MenuScreen extends Screen {
    private static final int PER_PAGE = 10;   // 2 kolumny x 5 rzedow
    private static String selectedCategory = null;
    private static int page = 0;
    private static boolean captureMode = false;

    public MenuScreen() {
        super(Text.literal("Minestar SkyPvP Items"));
    }

    private List<String> categories() {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (MinestarItem i : Store.data.items) set.add(i.category);
        return new ArrayList<>(set);
    }

    private List<MinestarItem> visible() {
        List<MinestarItem> out = new ArrayList<>();
        for (MinestarItem i : Store.data.items) if (i.category.equals(selectedCategory)) out.add(i);
        return out;
    }

    @Override
    protected void init() {
        List<String> cats = categories();
        if (selectedCategory == null || !cats.contains(selectedCategory)) {
            selectedCategory = cats.isEmpty() ? "" : cats.get(0);
            page = 0;
        }

        // zakladki kategorii
        int tabW = 90, tabGap = 4;
        int totalW = cats.size() * tabW + (cats.size() - 1) * tabGap;
        int x0 = (width - totalW) / 2;
        for (int c = 0; c < cats.size(); c++) {
            String cat = cats.get(c);
            ButtonWidget b = ButtonWidget.builder(
                Text.literal((cat.equals(selectedCategory) ? "\u00a7e" : "") + cat),
                btn -> { selectedCategory = cat; page = 0; clearAndInit(); })
                .dimensions(x0 + c * (tabW + tabGap), 28, tabW, 20).build();
            addDrawableChild(b);
        }

        // przycisk trybu - na gorze, zeby zawsze byl widoczny
        addDrawableChild(ButtonWidget.builder(
            Text.literal(captureMode ? "\u00a7e\u25cf TRYB: ZAPAMIĘTYWANIE WYGLĄDU (kliknij, by wrócić)" : "TRYB: zakładanie itemu (kliknij, by zapamiętywać wygląd)"),
            b -> { captureMode = !captureMode; clearAndInit(); })
            .dimensions(width / 2 - 170, 52, 340, 20).build());

        // lista itemow (2 kolumny)
        List<MinestarItem> list = visible();
        int pages = Math.max(1, (list.size() + PER_PAGE - 1) / PER_PAGE);
        if (page >= pages) page = pages - 1;
        int colW = 170, gap = 6;
        int left = (width - (colW * 2 + gap)) / 2;
        int top = 78;
        ItemStack held = heldStack();
        MinestarItem active = held == null ? null : Disguises.lookup(held);

        for (int n = 0; n < PER_PAGE; n++) {
            int idx = page * PER_PAGE + n;
            if (idx >= list.size()) break;
            MinestarItem it = list.get(idx);
            int col = n % 2, row = n / 2;
            Text label = LegacyText.parse(it.name);
            if (active == it) label = Text.empty().append(label).append(Text.literal(" \u00a7a\u2714"));
            ButtonWidget b = ButtonWidget.builder(label, btn -> { if (captureMode) capture(it); else toggle(it); })
                .dimensions(left + col * (colW + gap), top + row * 24, colW, 20).build();
            addDrawableChild(b);
        }

        int navY = top + 5 * 24 + 4;
        addDrawableChild(ButtonWidget.builder(Text.literal("<"), b -> { page--; clearAndInit(); })
            .dimensions(width / 2 - 70, navY, 30, 20).build()).active = page > 0;
        addDrawableChild(ButtonWidget.builder(Text.literal(">"), b -> { page++; clearAndInit(); })
            .dimensions(width / 2 + 40, navY, 30, 20).build()).active = page < pages - 1;
        addDrawableChild(ButtonWidget.builder(Text.literal("Wyłącz dla przedmiotu w ręce"), b -> clearHeld())
            .dimensions(width / 2 - 100, navY + 26, 200, 20).build());

    }

    private ItemStack heldStack() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return null;
        ItemStack s = mc.player.getMainHandStack();
        return s.isEmpty() ? null : s;
    }

    private void say(String msg) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player != null) mc.player.sendMessage(Text.literal(msg), true);
    }

    private void toggle(MinestarItem it) {
        ItemStack held = heldStack();
        if (held == null) {
            say("\u00a7cMusisz trzymać przedmiot w ręce.");
            return;
        }
        String fp = Disguises.fingerprint(held);
        if (it.id.equals(Store.data.disguises.get(fp))) {
            Store.data.disguises.remove(fp);
            say("\u00a7eWyłączono — przedmiot wygląda znowu normalnie.");
        } else {
            Store.data.disguises.put(fp, it.id);
            say("\u00a7aGotowe — widzisz to tylko Ty.");
        }
        Store.save();
        clearAndInit();
    }

    /** Zapisuje wyglad PRAWDZIWEGO itemu z reki (np. z serwera) jako wyglad wybranego itemu z menu. */
    private void capture(MinestarItem it) {
        ItemStack held = heldStack();
        if (held == null) { say("\u00a7cWeź do ręki prawdziwy item z serwera."); return; }
        it.material = net.minecraft.registry.Registries.ITEM.getId(held.getItem()).getPath();
        net.minecraft.util.Identifier model = held.get(net.minecraft.component.DataComponentTypes.ITEM_MODEL);
        net.minecraft.util.Identifier def = net.minecraft.registry.Registries.ITEM.getId(held.getItem());
        it.itemModel = (model == null || model.equals(def)) ? null : model.toString();
        net.minecraft.component.type.CustomModelDataComponent cmd =
            held.get(net.minecraft.component.DataComponentTypes.CUSTOM_MODEL_DATA);
        it.cmdFloats = cmd == null ? new ArrayList<>() : new ArrayList<>(cmd.floats());
        it.cmdStrings = cmd == null ? new ArrayList<>() : new ArrayList<>(cmd.strings());
        Store.save();
        say("\u00a7aZapamiętano wygląd. Teraz wyłącz tryb zapamiętywania i załóż item.");
    }

    private void clearHeld() {
        ItemStack held = heldStack();
        if (held == null) { say("\u00a7cMusisz trzymać przedmiot w ręce."); return; }
        if (Store.data.disguises.remove(Disguises.fingerprint(held)) != null) {
            Store.save();
            say("\u00a7eWyłączono — przedmiot wygląda znowu normalnie.");
        }
        clearAndInit();
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        super.render(ctx, mouseX, mouseY, delta);
        ctx.drawCenteredTextWithShadow(textRenderer, title, width / 2, 10, 0xFFFFFF);
        ctx.drawCenteredTextWithShadow(textRenderer,
            Text.literal("Weź przedmiot do ręki i kliknij item — zmienia się tylko u Ciebie"),
            width / 2, 19, 0xAAAAAA);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
