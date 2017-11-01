package info.tritusk.tiberiumcraft;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

public abstract class TiberiumProxy {

    @Nonnull
    public static Logger logger;

    protected TiberiumProxy() {
        // TODO ???
    }

    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    public abstract void init(FMLInitializationEvent event);

    public void postInit(FMLPostInitializationEvent event) {
        // TODO Stub
    }
}
