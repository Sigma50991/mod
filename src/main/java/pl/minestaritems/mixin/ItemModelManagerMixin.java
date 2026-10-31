package pl.minestaritems.mixin;

import net.minecraft.client.item.ItemModelManager;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import pl.minestaritems.Disguises;
import pl.minestaritems.MinestarItem;

import java.util.List;

/** Podmienia model rysowanego przedmiotu (reka, GUI, ekwipunek) - tylko u Ciebie. */
@Mixin(ItemModelManager.class)
public abstract class ItemModelManagerMixin {

    @ModifyVariable(method = "update", at = @At("HEAD"), argsOnly = true)
    private ItemStack minestaritems$model(ItemStack stack) {
        MinestarItem it = Disguises.lookup(stack);
        if (it == null) return stack;
        Item target = Disguises.materialOf(it);
        if (target == null) return stack;

        boolean hasLook = it.itemModel != null
            || (it.cmdFloats != null && !it.cmdFloats.isEmpty())
            || (it.cmdStrings != null && !it.cmdStrings.isEmpty());
        if (target == stack.getItem() && !hasLook) return stack;

        ItemStack fake = new ItemStack(target, stack.getCount());
        if (it.itemModel != null) {
            Identifier id = Identifier.tryParse(it.itemModel);
            if (id != null) fake.set(DataComponentTypes.ITEM_MODEL, id);
        }
        boolean f = it.cmdFloats != null && !it.cmdFloats.isEmpty();
        boolean st = it.cmdStrings != null && !it.cmdStrings.isEmpty();
        if (f || st) {
            fake.set(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(
                f ? it.cmdFloats : List.of(), List.of(), st ? it.cmdStrings : List.of(), List.of()));
        }
        return fake;
    }
}
