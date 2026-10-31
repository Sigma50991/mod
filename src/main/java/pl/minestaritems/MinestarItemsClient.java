package pl.minestaritems;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class MinestarItemsClient implements ClientModInitializer {
    public static KeyBinding openMenuKey;

    @Override
    public void onInitializeClient() {
        Store.load();

        // Domyslnie J. Zmienisz w: Opcje -> Sterowanie (Controls) -> "Minestar SkyPvP Items".
        openMenuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.minestaritems.open_menu",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_J,
            "category.minestaritems"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openMenuKey.wasPressed()) {
                if (client.currentScreen == null && client.player != null) {
                    client.setScreen(new MenuScreen());
                }
            }
        });

        // Opis (lore) widoczny tylko u Ciebie.
        ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> {
            MinestarItem it = Disguises.lookup(stack);
            if (it == null) return;
            lines.clear();
            lines.add(LegacyText.parse(it.name));
            for (String l : it.lore) lines.add(LegacyText.parse(l));
        });
    }
}
