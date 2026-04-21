package gay.sylv.missingno.client;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class MissingnoFixClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
			Block block = new Block(Blocks.STONE.properties());
			Registry.register(BuiltInRegistries.BLOCK, id(), block);
			Registry.register(BuiltInRegistries.ITEM, id(), new BlockItem(block, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, id()))));
		}
	}

	private static Identifier id() {
		return Identifier.fromNamespaceAndPath("missingno-fix", "missingno");
	}
}
