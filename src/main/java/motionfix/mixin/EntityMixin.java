package motionfix.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.llamalad7.mixinextras.sugar.Local;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;


@Mixin(Entity.class)
public class EntityMixin {


	@ModifyArgs(method = "readNbt", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;setVelocity(DDD)V"))
	private void replaceMotion(Args args,@Local (ordinal = 0) double d, @Local (ordinal = 1) double e, @Local (ordinal = 2) double f) {

		args.set(0, d);
		args.set(1, e);
		args.set(2, f);
	}
}