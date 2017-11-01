package info.tritusk.tiberiumcraft.block;

import info.tritusk.tiberiumcraft.TiberiumType;
import info.tritusk.tiberiumcraft.api.TiberiumAPI;
import info.tritusk.tiberiumcraft.api.TiberiumReferences;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tiberium extends Block {

    public static final PropertyEnum<TiberiumType> TYPE = PropertyEnum.create("type", TiberiumType.class);

    public Tiberium() {
        super(Material.GLASS);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos) {
        return new AxisAlignedBB(0.05D, 0.0D, 0.05D, 0.95D, 0.9D, 0.95D);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos) {
        return new AxisAlignedBB(0.05D, 0.0D, 0.05D, 0.95D, 0.9D, 0.95D).offset(pos);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return state.getValue(TYPE).ordinal();
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        int quantityDropped = 1 + RANDOM.nextInt(fortune * 2);
        return Collections.singletonList(new ItemStack(TiberiumReferences.TIBERIUM_CRYSTAL, quantityDropped, this.damageDropped(state)));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TYPE).ordinal();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(TYPE, TiberiumType.VALUES[meta]);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public boolean isBlockNormalCube(IBlockState blockState) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        return false;
    }

    @Override
    public void onBlockExploded(World worldIn, BlockPos pos, Explosion explosionIn) {
        for (int n = 0; n < 20; n++) {
            worldIn.setBlockState(pos.add(RANDOM.nextGaussian() * 10, RANDOM.nextGaussian() * 3, RANDOM.nextGaussian() * 10), worldIn.getBlockState(pos));
        }
        super.onBlockExploded(worldIn, pos, explosionIn);
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        entityIn.attackEntityFrom(TiberiumAPI.TIBERIUM, 1.0F);
        if (entityIn instanceof EntityLiving) {
            PotionEffect effect = new PotionEffect(TiberiumReferences.TIBERIUM_INFECTED, 1200, 2, false, false);
            effect.setCurativeItems(Collections.emptyList());
            ((EntityLiving) entityIn).addPotionEffect(effect);
        }
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (rand.nextInt(100) < 5) {
            worldIn.setBlockState(pos.add(rand.nextGaussian() * 10, rand.nextGaussian() * 10, rand.nextGaussian() * 10), state);
        }
    }
}
