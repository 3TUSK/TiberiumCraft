package info.tritusk.tiberiumcraft.item;

import info.tritusk.tiberiumcraft.TiberiumType;
import info.tritusk.tiberiumcraft.api.TiberiumAPI;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class TiberiumCrystal extends Item {
    public TiberiumCrystal() {
        super();
        this.setCreativeTab(TiberiumAPI.TAB);
        this.setMaxStackSize(16);
        this.setUnlocalizedName("tiberium");
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltips, ITooltipFlag flag) {
        tooltips.add(I18n.format("item.tiberium.info"));
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + TiberiumType.VALUES[stack.getMetadata()];
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (world.rand.nextInt(100) == 0 && entity instanceof EntityPlayerMP) {
            List<ItemStack> inv = ((EntityPlayerMP) entity).inventory.mainInventory;
            for (ItemStack item : inv) {
                if (world.rand.nextInt(100) == 0) {
                    if (!item.isEmpty() && !(item.getItem() instanceof TiberiumCrystal)) {
                        //TODO: Index-based loop?
                        inv.set(inv.indexOf(item), new ItemStack(this, item.getCount(), item.getMetadata()));
                        entity.sendMessage(new TextComponentTranslation("chat.tiberiumCorrosion"));
                    }
                }
            }
        }
    }
}
