package pl.minestaritems.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pl.minestaritems.Disguises;
import pl.minestaritems.LegacyText;
import pl.minestaritems.MinestarItem;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Inject(method = "getName", at = @At("HEAD"), cancellable = true)
    private void minestaritems$name(CallbackInfoReturnable<Text> cir) {
        MinestarItem it = Disguises.lookup((ItemStack) (Object) this);
        if (it != null) cir.setReturnValue(LegacyText.parse(it.name));
    }

    @Inject(method = "hasGlint", at = @At("HEAD"), cancellable = true)
    private void minestaritems$glint(CallbackInfoReturnable<Boolean> cir) {
        MinestarItem it = Disguises.lookup((ItemStack) (Object) this);
        if (it != null && it.glint) cir.setReturnValue(true);
    }
}
