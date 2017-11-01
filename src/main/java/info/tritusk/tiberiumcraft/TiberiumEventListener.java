package info.tritusk.tiberiumcraft;

import info.tritusk.tiberiumcraft.api.TiberiumAPI;
import info.tritusk.tiberiumcraft.api.TiberiumReferences;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public final class TiberiumEventListener {
    private TiberiumEventListener() {
        throw new UnsupportedOperationException("Not constructable");
    }

    @SubscribeEvent
    public void onDeath(LivingDeathEvent event) {
        Random rng = event.getEntityLiving().getRNG();
        if (event.getSource() == TiberiumAPI.TIBERIUM) {
            event.getEntity().entityDropItem(new ItemStack(TiberiumReferences.TIBERIUM_CRYSTAL, rng.nextInt(3), rng.nextInt(10)), 0.50001F);
        }
    }

    @SubscribeEvent
    public void onPlayerDrop(PlayerDropsEvent event) {
        if (event.getSource() == TiberiumAPI.TIBERIUM) {
            Iterator<EntityItem> iterator = event.getDrops().iterator();
            ArrayList<EntityItem> newDrops = new ArrayList<>();
            Random rng = event.getEntityPlayer().getRNG();
            while (iterator.hasNext()) {
                EntityItem item = iterator.next();
                if (rng.nextInt(10) == 0) {
                    EntityItem replacement = new EntityItem(item.getEntityWorld(), item.posX, item.posY, item.posZ, new ItemStack(TiberiumReferences.TIBERIUM_CRYSTAL, rng.nextInt(3), item.getItem().getCount()));
                    replacement.motionX = item.motionX;
                    replacement.motionY = item.motionY;
                    replacement.motionZ = item.motionZ;
                    newDrops.add(replacement);
                    iterator.remove();
                }
            }
            event.getDrops().addAll(newDrops);
        }
    }
}
