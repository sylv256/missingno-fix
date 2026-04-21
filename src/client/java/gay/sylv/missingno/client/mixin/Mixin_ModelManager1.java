package gay.sylv.missingno.client.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.client.renderer.texture.SpriteLoader;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;

@Mixin(targets = "net.minecraft.client.resources.model.ModelManager$1")
public abstract class Mixin_ModelManager1 {
	@Shadow
	protected abstract Material.@Nullable Baked bakeForAtlas(Material material,
			SpriteLoader.Preparations atlas);

	@Shadow
	@Final
	SpriteLoader.Preparations val$blockAtlas;

	@WrapMethod(method = "bake")
	private Material.Baked fixMissingnoBake(
			Material material,
			Operation<Material.Baked> original
	) {
		if (!material.sprite().equals(Identifier.withDefaultNamespace("missingno"))) {
			return original.call(material);
		}

		return this.bakeForAtlas(material, this.val$blockAtlas);
	}
}
