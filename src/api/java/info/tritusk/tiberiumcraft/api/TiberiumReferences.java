package info.tritusk.tiberiumcraft.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nonnull;

@GameRegistry.ObjectHolder("tiberiumcraft")
@SuppressWarnings("all")
public final class TiberiumReferences {
    @GameRegistry.ObjectHolder("tiberium")
    @Nonnull
    public static final Block TIBERIUM = null;

    @GameRegistry.ObjectHolder("tiberium_crystal")
    @Nonnull
    public static final Item TIBERIUM_CRYSTAL = null;

    @GameRegistry.ObjectHolder("tiberium")
    @Nonnull
    public static final Potion TIBERIUM_INFECTED = null;
}
