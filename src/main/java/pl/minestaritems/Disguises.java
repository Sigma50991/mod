package pl.minestaritems;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public final class Disguises {
    private Disguises() {}

    /** Odcisk: typ przedmiotu + jego prawdziwa nazwa (jesli ma). Wszystkie takie same przedmioty sa przebrane. */
    public static String fingerprint(ItemStack stack) {
        Text n = stack.get(DataComponentTypes.CUSTOM_NAME);
        return Registries.ITEM.getId(stack.getItem()) + "|" + (n == null ? "" : n.getString());
    }

    public static MinestarItem lookup(ItemStack stack) {
        if (stack == null || stack.isEmpty() || Store.data.disguises.isEmpty()) return null;
        String id = Store.data.disguises.get(fingerprint(stack));
        return id == null ? null : Store.byId(id);
    }

    public static Item materialOf(MinestarItem it) {
        Identifier id = Identifier.tryParse(it.material.toLowerCase());
        if (id == null || !Registries.ITEM.containsId(id)) return null;
        return Registries.ITEM.get(id);
    }
}
