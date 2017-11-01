package info.tritusk.tiberiumcraft.client;

import info.tritusk.tiberiumcraft.entity.EntityIonCannonBeam;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderIonCannonBeam extends Render<EntityIonCannonBeam> {

    protected RenderIonCannonBeam(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(EntityIonCannonBeam entity, double d1, double d2, double d3, float f1, float f2) {
        // TODO Stub
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityIonCannonBeam entity) {
        return null;
    }
}
