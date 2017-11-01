package info.tritusk.tiberiumcraft.server;

import info.tritusk.tiberiumcraft.TiberiumProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public final class TiberiumProxyServer extends TiberiumProxy {
    @Override
    public void init(FMLInitializationEvent event) {
        logger.info("Woohoo! Tiberium is now infecting your server!");
    }
}
