package info.tritusk.tiberiumcraft.api;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class TiberiumAPI {

    public static final DamageSource TIBERIUM = new DamageSource("tiberium").setDamageBypassesArmor().setDamageIsAbsolute();

    public static final CreativeTabs TAB = new CreativeTabs("tiberium") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(TiberiumReferences.TIBERIUM_CRYSTAL);
        }
    };

}
