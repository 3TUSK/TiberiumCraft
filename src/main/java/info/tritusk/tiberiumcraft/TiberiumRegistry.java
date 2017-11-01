package info.tritusk.tiberiumcraft;

import info.tritusk.tiberiumcraft.block.Tiberium;
import info.tritusk.tiberiumcraft.entity.EntityIonCannonBeam;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

@Mod.EventBusSubscriber(modid = "tiberiumcraft")
public final class TiberiumRegistry {

    @SubscribeEvent
    public static void onRegisterBlock(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(new Tiberium().setRegistryName("tiberiumcraft", "tiberium"));
    }

    @SubscribeEvent
    public static void onRegisterEntity(RegistryEvent.Register<EntityEntry> event) {
        event.getRegistry().register(EntityEntryBuilder
                .<EntityIonCannonBeam>create()
                .entity(EntityIonCannonBeam.class)
                .id("tiberiumcraft:ion_cannon_beam", 0)
                .tracker(160, 5, true)
                .name("EntityIonCannonBeam")
                .build());
    }
}
