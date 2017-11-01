package info.tritusk.tiberiumcraft.client;

import info.tritusk.tiberiumcraft.TiberiumProxy;
import info.tritusk.tiberiumcraft.api.TiberiumReferences;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = "tiberiumcraft", value = Side.CLIENT)
public final class TiberiumProxyClient extends TiberiumProxy {
    @Override
    public void init(FMLInitializationEvent event) {

    }

    @SubscribeEvent
    public static void onModelRegistry(ModelRegistryEvent event) {
        TiberiumProxy.logger.debug("Tiberium is now infecting ModelRegistry");
        OBJLoader.INSTANCE.addDomain("tiberiumcraft");

        /* Code from FrogCraft: Rebirth
        RegHelper.registerModel(FrogRegistees.ION_CANNON);
        RegHelper.registerModel(FrogRegistees.ION_CANNON_FRAME);
         */

        ModelLoader.setCustomModelResourceLocation(TiberiumReferences.TIBERIUM_CRYSTAL, 0, modelOf("tiberiumcraft", "tiberium_crystal_red"));
        ModelLoader.setCustomModelResourceLocation(TiberiumReferences.TIBERIUM_CRYSTAL, 1, modelOf("tiberiumcraft", "tiberium_crystal_blue"));
        ModelLoader.setCustomModelResourceLocation(TiberiumReferences.TIBERIUM_CRYSTAL, 2, modelOf("tiberiumcraft", "tiberium_crystal_green"));
        /*
        ModelLoader.setCustomModelResourceLocation(TiberiumReferences.TIBERIUM, 0, modelOf("tiberiumcraft", "tiberium_red"));
        ModelLoader.setCustomModelResourceLocation(TiberiumReferences.TIBERIUM, 1, modelOf("tiberiumcraft", "tiberium_blue"));
        ModelLoader.setCustomModelResourceLocation(TiberiumReferences.TIBERIUM, 2, modelOf("tiberiumcraft", "tiberium_green"));*/
    }

    private static ModelResourceLocation modelOf(String domain, String path) {
        return new ModelResourceLocation(domain + ":" + path, "inventory");
    }
}
