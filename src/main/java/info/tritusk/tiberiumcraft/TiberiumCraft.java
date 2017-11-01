package info.tritusk.tiberiumcraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "tiberiumcraft", name = "TiberiumCraft", version = "@VERSION@", useMetadata = true)
public final class TiberiumCraft {

    private static final TiberiumCraft INSTANCE = new TiberiumCraft();

    @Mod.InstanceFactory
    public static TiberiumCraft getInstance() {
        return INSTANCE;
    }

    @SidedProxy(serverSide = "info.tritusk.tiberiumcraft.server.TiberiumProxyServer", clientSide = "info.tritusk.tiberiumcraft.client.TiberiumProxyClient")
    public static TiberiumProxy proxy;

    private TiberiumCraft() {
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

}
