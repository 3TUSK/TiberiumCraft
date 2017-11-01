package info.tritusk.tiberiumcraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityIonCannonBeam extends EntityThrowable {
    public EntityIonCannonBeam(World worldIn) {
        super(worldIn);
    }

    public EntityIonCannonBeam(World worldIn, EntityLivingBase thrower) {
        super(worldIn, thrower);
    }

    @Override
    protected void onImpact(RayTraceResult result) {

    }
}
