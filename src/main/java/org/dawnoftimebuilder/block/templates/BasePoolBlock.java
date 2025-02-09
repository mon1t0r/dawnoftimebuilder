package org.dawnoftimebuilder.block.templates;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import org.dawnoftimebuilder.block.general.WaterTrickleBlock;
import org.dawnoftimebuilder.util.DoTBBlockStateProperties;
import org.dawnoftimebuilder.util.DoTBUtils;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.EmptyFluid;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BucketItem;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public abstract class BasePoolBlock extends BlockDoTB {
    /**
     * Method used to execute removeWaterAround(final Map<BlockPos, BlockState> testedPositionsIn, BlockState blockStateIn, final BlockPos blockPosIn, final World worldIn, final float prohibitedXIn, final float
     * prohibitedZIn)
     */
    public static boolean removeWaterAround(final BlockState blockStateIn, final BlockPos blockPosIn, final World worldIn) {
        return BasePoolBlock.removeWaterAround(new LinkedHashMap<>(), blockStateIn, blockPosIn, worldIn, 0.0f, 0.0f);
    }

    /**
     * Seynax : binary method to remove water on all associated pool
     */
    private static boolean removeWaterAround(final Map<BlockPos, BlockState> testedPositionsIn, BlockState blockStateIn, final BlockPos blockPosIn, final World worldIn, final float prohibitedXIn, final float prohibitedZIn) {
        boolean success = blockStateIn.getValue(DoTBBlockStateProperties.LEVEL) > 0;
        blockStateIn = blockStateIn.setValue(DoTBBlockStateProperties.LEVEL, 0);
        worldIn.setBlock(blockPosIn, blockStateIn, 10);
        if (prohibitedXIn != 1 && BasePoolBlock.removeWaterAroundOffset(testedPositionsIn, blockPosIn, worldIn, 1, 0)) {
            success = true;
        }
        if (prohibitedXIn != -1 && BasePoolBlock.removeWaterAroundOffset(testedPositionsIn, blockPosIn, worldIn, -1, 0)) {
            success = true;
        }
        if (prohibitedZIn != 1 && BasePoolBlock.removeWaterAroundOffset(testedPositionsIn, blockPosIn, worldIn, 0, 1)) {
            success = true;
        }
        if (prohibitedZIn != -1 && BasePoolBlock.removeWaterAroundOffset(testedPositionsIn, blockPosIn, worldIn, 0, -1)) {
            success = true;
        }
        return success;
    }

    /**
     * Used by removeWaterAround(final Map<BlockPos, BlockState> testedPositionsIn, BlockState blockStateIn, final BlockPos blockPosIn, final World worldIn, final float prohibitedXIn, final float prohibitedZIn)
     *
     * @param testedPositionsIn
     * @param blockPosIn
     * @param worldIn
     * @param x
     * @param z
     * @return
     */
    private static boolean removeWaterAroundOffset(final Map<BlockPos, BlockState> testedPositionsIn, final BlockPos blockPosIn, final World worldIn, final int x, final int z) {
        final BlockPos pos = blockPosIn.offset(x, 0, z);
        if (!testedPositionsIn.containsKey(pos)) {
            BlockState state = worldIn.getBlockState(pos);
            if (state.getBlock() instanceof PoolBlock) {
                testedPositionsIn.put(pos, state);
                return BasePoolBlock.removeWaterAround(testedPositionsIn, state, pos, worldIn, x, z);
            }
            if (state.getBlock() instanceof FaucetBlock) {
                state = state.setValue(DoTBBlockStateProperties.ACTIVATED, false);
                worldIn.setBlock(pos, state, 10);
            }
        }
        return false;
    }

    /**
     * Method used to execute hasOneActivatedFaucetOrJet(final Map<BlockPos, BlockState> testedPositionsIn, final BlockPos blockPosIn, final IWorld worldIn, final float prohibitedXIn, final float prohibitedZIn)
     *
     * @param blockPosIn
     * @param worldIn
     */
    public static EnumActivatorState hasOnePoolActivatorAround(final BlockPos blockPosIn, final IWorld worldIn) {
        return BasePoolBlock.hasOnePoolActivatorAround(new LinkedHashMap<>(), blockPosIn, worldIn, 0.0f, 0.0f);
    }

    /**
     * You can use hasOnePoolActivatorAround(final BlockPos blockPosIn, final IWorld worldIn) Seynax : binary method to remove water on all associated pool
     */
    private static EnumActivatorState hasOnePoolActivatorAround(final Map<BlockPos, BlockState> testedPositionsIn, final BlockPos blockPosIn, final IWorld worldIn, final float prohibitedXIn, final float prohibitedZIn) {
        if (testedPositionsIn.containsKey(blockPosIn)) {
            return EnumActivatorState.NO;
        }
        final BlockState state = worldIn.getBlockState(blockPosIn.above());
        testedPositionsIn.put(blockPosIn, state);

        if (state.getBlock() instanceof WaterTrickleBlock || state.getBlock() instanceof FaucetBlock && state.getValue(DoTBBlockStateProperties.ACTIVATED)) {
            return EnumActivatorState.ENABLED;
        }

        if (prohibitedXIn != 1 && EnumActivatorState.ENABLED.equals(BasePoolBlock.hasOnePoolActivatorAroundOffset(testedPositionsIn, worldIn, blockPosIn, 1, 0)) || prohibitedXIn != -1 && EnumActivatorState.ENABLED.equals(BasePoolBlock.hasOnePoolActivatorAroundOffset(testedPositionsIn, worldIn, blockPosIn, -1, 0)) || prohibitedZIn != 1 && EnumActivatorState.ENABLED.equals(BasePoolBlock.hasOnePoolActivatorAroundOffset(testedPositionsIn, worldIn, blockPosIn, 0, 1)) || prohibitedZIn != -1 && EnumActivatorState.ENABLED.equals(BasePoolBlock.hasOnePoolActivatorAroundOffset(testedPositionsIn, worldIn, blockPosIn, 0, -1))) {
            return EnumActivatorState.ENABLED;
        }

        return EnumActivatorState.NO;
    }

    public static EnumActivatorState hasOnePoolActivatorAroundOffset(final Map<BlockPos, BlockState> testedPositionsIn, final IWorld worldIn, final BlockPos baseBlockPosIn, final int xOffsetIn, final int zOffsetIn) {
        final BlockPos offsetBlockPos = baseBlockPosIn.offset(xOffsetIn, 0, zOffsetIn);
        final BlockState offsetState = worldIn.getBlockState(offsetBlockPos);

        if (offsetState.getBlock() instanceof BasePoolBlock) {
            return BasePoolBlock.hasOnePoolActivatorAround(testedPositionsIn, offsetBlockPos, worldIn, -xOffsetIn, -zOffsetIn);
        }

        return EnumActivatorState.NO;
    }

    private static PoolLevelAndSides levelOfPoolAround(final BlockPos blockPosIn, final IWorld worldIn) {
        return BasePoolBlock.levelOfPoolAround(new LinkedHashMap<>(), new PoolLevelAndSides(), blockPosIn, worldIn, 0.0f, 0.0f);
    }

    private static PoolLevelAndSides levelOfPoolAround(final Map<BlockPos, BlockState> testedPositionsIn, final PoolLevelAndSides poolLevelAndSidesIn, final BlockPos blockPosIn, final IWorld worldIn, final float prohibitedXIn, final float prohibitedZIn) {
        final boolean center = prohibitedXIn == 0 && prohibitedZIn == 0;

        if (prohibitedXIn != 1) {
            final int level = BasePoolBlock.poolLevelAroundOffset(testedPositionsIn, poolLevelAndSidesIn, blockPosIn, worldIn, 1, 0);
            if (level > 0 && center) {
                poolLevelAndSidesIn.right = true;
            }
            if (level > poolLevelAndSidesIn.level) {
                poolLevelAndSidesIn.level = level;
            }
        }

        if (prohibitedXIn != -1) {
            final int level = BasePoolBlock.poolLevelAroundOffset(testedPositionsIn, poolLevelAndSidesIn, blockPosIn, worldIn, -1, 0);
            if (level > 0 && center) {
                poolLevelAndSidesIn.left = true;
            }
            if (level > poolLevelAndSidesIn.level) {
                poolLevelAndSidesIn.level = level;
            }
        }

        if (prohibitedZIn != 1) {
            final int level = BasePoolBlock.poolLevelAroundOffset(testedPositionsIn, poolLevelAndSidesIn, blockPosIn, worldIn, 0, 1);
            if (level > 0 && center) {
                poolLevelAndSidesIn.north = true;
            }
            if (level > poolLevelAndSidesIn.level) {
                poolLevelAndSidesIn.level = level;
            }
        }

        if (prohibitedZIn != -1) {
            final int level = BasePoolBlock.poolLevelAroundOffset(testedPositionsIn, poolLevelAndSidesIn, blockPosIn, worldIn, 0, -1);
            if (level > 0 && center) {
                poolLevelAndSidesIn.south = true;
            }

            if (level > poolLevelAndSidesIn.level) {
                poolLevelAndSidesIn.level = level;
            }
        }

        return poolLevelAndSidesIn;
    }

    /**
     * Used by hasOnePoolActivatorAround(final BlockPos blockPosIn, final IWorld worldIn)
     *
     * @param testedPositionsIn
     * @param baseBlockPosIn
     * @param worldIn
     * @param xOffsetIn
     * @param zOffsetIn
     * @return
     */
    private static int poolLevelAroundOffset(final Map<BlockPos, BlockState> testedPositionsIn, final PoolLevelAndSides poolLevelAndSidesIn, final BlockPos baseBlockPosIn, final IWorld worldIn, final int xOffsetIn, final int zOffsetIn) {
        final BlockPos pos = baseBlockPosIn.offset(xOffsetIn, 0, zOffsetIn);
        if (testedPositionsIn.containsKey(pos)) {
            return -1;
        }
        final BlockState state = worldIn.getBlockState(pos);
        testedPositionsIn.put(pos, state);

        if (state.getBlock() instanceof BasePoolBlock) {
            BasePoolBlock.levelOfPoolAround(testedPositionsIn, poolLevelAndSidesIn, pos, worldIn, -xOffsetIn, -zOffsetIn);
            final int currentLevel = state.getValue(DoTBBlockStateProperties.LEVEL);

            return Math.max(currentLevel, poolLevelAndSidesIn.level);
        }

        return -1;
    }

    public final int maxLevel;
    public final int faucetLevel;

    public BasePoolBlock(final Properties propertiesIn, final int maxLevelIn, final int faucetLevelIn) {
        super(propertiesIn);
        this.registerDefaultState(this.defaultBlockState().setValue(BlockStateProperties.NORTH, false).setValue(BlockStateProperties.EAST, false).setValue(BlockStateProperties.SOUTH, false).setValue(BlockStateProperties.WEST, false).setValue(DoTBBlockStateProperties.HAS_PILLAR, false).setValue(DoTBBlockStateProperties.LEVEL, 0));
        this.maxLevel = maxLevelIn;
        this.faucetLevel = faucetLevelIn;
    }

    @Override
    protected void createBlockStateDefinition(final StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(BlockStateProperties.NORTH).add(BlockStateProperties.EAST).add(BlockStateProperties.SOUTH).add(BlockStateProperties.WEST).add(DoTBBlockStateProperties.HAS_PILLAR).add(DoTBBlockStateProperties.LEVEL);
    }

    @Override
    public BlockState getStateForPlacement(final BlockItemUseContext contextIn) {
        /*
         * Determined sides AND level by the highest level of surrounding adjacent pools. If none is found or the highest level is equal to 0, checks if a tap or a trickle of water exists above this pool or one of the adjacent
         * pools around, if yes, applies the level to 1 and launches a tick schedule otherwise the level is 0.
         */
        final PoolLevelAndSides levelAndSides = BasePoolBlock.levelOfPoolAround(contextIn.getClickedPos(), contextIn.getLevel());
        BlockState state = this.defaultBlockState().setValue(BlockStateProperties.NORTH, levelAndSides.south).setValue(BlockStateProperties.SOUTH, levelAndSides.north).setValue(BlockStateProperties.EAST, levelAndSides.right).setValue(BlockStateProperties.WEST, levelAndSides.left);

        int level = levelAndSides.level;
        if (level <= 0 && EnumActivatorState.ENABLED.equals(BasePoolBlock.hasOnePoolActivatorAround(contextIn.getClickedPos(), contextIn.getLevel()))) {
            level = 1;
            if (!contextIn.getLevel().isClientSide()) {
                ((ServerWorld) contextIn.getLevel()).getBlockTicks().scheduleTick(contextIn.getClickedPos(), this, 5);
            }
        }

        state = state.setValue(DoTBBlockStateProperties.LEVEL, level);


        return state;
    }

    @Override
    public ActionResultType use(BlockState blockStateIn, final World worldIn, final BlockPos blockPosIn, final PlayerEntity playerEntityIn, final Hand handIn, final BlockRayTraceResult blockRayTraceResultIn) {
        final ItemStack itemStack = playerEntityIn.getMainHandItem();
        if (!playerEntityIn.isCrouching()) {
            final int lastLevel = blockStateIn.getValue(DoTBBlockStateProperties.LEVEL);
            int nextLevel = lastLevel;
            boolean tryToChangeLevel = false;
            ItemStack newItemStack = null;

            if (itemStack.getItem() instanceof BucketItem) {
                if (((BucketItem) itemStack.getItem()).getFluid() instanceof WaterFluid) {
                    nextLevel = this.maxLevel;

                    if (!playerEntityIn.isCreative()) {
                        newItemStack = new ItemStack(Items.BUCKET);
                    }
                } else if (((BucketItem) itemStack.getItem()).getFluid() instanceof EmptyFluid) {
                    nextLevel = 0;

                    if (!playerEntityIn.isCreative()) {
                        newItemStack = new ItemStack(Items.WATER_BUCKET);
                    }
                }
                tryToChangeLevel = true;
            } else if (itemStack.getItem() instanceof PotionItem) {
                final Potion potion = PotionUtils.getPotion(itemStack);

                if (potion.getEffects().size() <= 0 && nextLevel + 1 < this.maxLevel) {
                    nextLevel++;

                    if (!playerEntityIn.isCreative()) {
                        newItemStack = new ItemStack(Items.GLASS_BOTTLE);
                    }
                }
                tryToChangeLevel = true;
            } else if (itemStack.getItem() instanceof GlassBottleItem) {
                final Potion potion = PotionUtils.getPotion(itemStack);

                if (potion.getEffects().size() <= 0 && nextLevel - 1 >= 0) {
                    nextLevel--;

                    if (!playerEntityIn.isCreative()) {
                        newItemStack = Items.POTION.getDefaultInstance();
                    }
                }
                tryToChangeLevel = true;
            }

            if (tryToChangeLevel) {
                if (nextLevel == lastLevel) {
                    return ActionResultType.CONSUME;
                }
                if (newItemStack != null) {
                    itemStack.shrink(1);
                    playerEntityIn.inventory.add(newItemStack);
                }

                blockStateIn = blockStateIn.setValue(DoTBBlockStateProperties.LEVEL, nextLevel);
                worldIn.setBlock(blockPosIn, blockStateIn, 10);

                if (nextLevel == 0) {
                    BasePoolBlock.removeWaterAround(blockStateIn, blockPosIn, worldIn);
                }

                return ActionResultType.SUCCESS;
            }
            if (itemStack.isEmpty()) {
                blockStateIn = blockStateIn.setValue(DoTBBlockStateProperties.HAS_PILLAR, !blockStateIn.getValue(DoTBBlockStateProperties.HAS_PILLAR));
                worldIn.setBlock(blockPosIn, blockStateIn, 10);
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.PASS;
    }

    /*
     * Seynax : allows the player to prevent the appearance of a pole in the basin below, under sneak conditions
     */
    @Override
    public void setPlacedBy(final World worldIn, final BlockPos blockPosIn, final BlockState blockStateIn, final LivingEntity entityIn, final ItemStack itemStackIn) {
        if (entityIn instanceof PlayerEntity && !entityIn.isShiftKeyDown()) {
            super.setPlacedBy(worldIn, blockPosIn, blockStateIn, entityIn, itemStackIn);

            final BlockPos blockPos = blockPosIn.below();
            BlockState blockState = worldIn.getBlockState(blockPos);
            if (blockState.getBlock() == this) {
                blockState = blockState.setValue(DoTBBlockStateProperties.HAS_PILLAR, true);
                worldIn.setBlock(blockPos, blockState, 10);
            }
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void tick(BlockState blockStateIn, final ServerWorld serverWorldIn, final BlockPos blockPosIn, final Random randomIn) {
        super.tick(blockStateIn, serverWorldIn, blockPosIn, randomIn);

        final boolean increase = EnumActivatorState.ENABLED.equals(BasePoolBlock.hasOnePoolActivatorAround(blockPosIn, serverWorldIn));

        if (increase) {
            final int level = blockStateIn.getValue(DoTBBlockStateProperties.LEVEL);

            if (level < this.maxLevel) {
                blockStateIn = blockStateIn.setValue(DoTBBlockStateProperties.LEVEL, level + 1);
                serverWorldIn.setBlock(blockPosIn, blockStateIn, 10);

                if (level + 1 < this.maxLevel) {
                    serverWorldIn.getBlockTicks().scheduleTick(blockPosIn, this, 5);
                }
            }
        } else {
            int level = blockStateIn.getValue(DoTBBlockStateProperties.LEVEL);

            if (level - 1 >= 0) {
                level--;
                blockStateIn = blockStateIn.setValue(DoTBBlockStateProperties.LEVEL, level);
                serverWorldIn.setBlock(blockPosIn, blockStateIn, 10);

                if (level - 1 >= 0) {
                    serverWorldIn.getBlockTicks().scheduleTick(blockPosIn, this, 5);
                }
            }
        }
    }

    @Override
    public BlockState updateShape(BlockState stateIn, final Direction directionIn, final BlockState facingStateIn, final IWorld worldIn, final BlockPos currentPosIn, final BlockPos facingPosIn) {
        if (directionIn.getAxis().isHorizontal()) {
            final boolean hasPoolInSide = facingStateIn.getBlock() == this;
            if (hasPoolInSide && facingStateIn.getValue(DoTBBlockStateProperties.LEVEL) >= 0) {
                stateIn = stateIn.setValue(DoTBBlockStateProperties.LEVEL, facingStateIn.getValue(DoTBBlockStateProperties.LEVEL));
            }
            switch (directionIn) {
                case NORTH:
                    stateIn = stateIn.setValue(BlockStateProperties.NORTH, hasPoolInSide);
                    break;
                case EAST:
                    stateIn = stateIn.setValue(BlockStateProperties.EAST, hasPoolInSide);
                    break;
                case SOUTH:
                    stateIn = stateIn.setValue(BlockStateProperties.SOUTH, hasPoolInSide);
                    break;
                case WEST:
                    stateIn = stateIn.setValue(BlockStateProperties.WEST, hasPoolInSide);
                    break;
                default:
                    break;
            }
        }

        int level = stateIn.getValue(DoTBBlockStateProperties.LEVEL);

        if (facingPosIn.getY() == currentPosIn.getY() + 1) {
            final int lastLevel = level;
            final EnumActivatorState state = BasePoolBlock.hasOnePoolActivatorAround(currentPosIn, worldIn);

            if (EnumActivatorState.ENABLED.equals(state)) {
                if (level < this.maxLevel) {
                    level++;
                }
            } else if (EnumActivatorState.DISABLED.equals(state) && level - 1 >= 0) {
                level--;
            }

            stateIn = stateIn.setValue(DoTBBlockStateProperties.LEVEL, level);

            if (!worldIn.isClientSide() && lastLevel != level) {
                ((ServerWorld) worldIn).getBlockTicks().scheduleTick(currentPosIn, this, 5);
            }
        }

        return stateIn;
    }

    @Override
    public void appendHoverText(final ItemStack stack, @Nullable final IBlockReader worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        DoTBUtils.addTooltip(tooltip, DoTBUtils.TOOLTIP_ADD_COLUMN);
    }

    @Override
    public int getLightBlock(final BlockState p_200011_1_In, final IBlockReader p_200011_2_In, final BlockPos p_200011_3_In) {
        return 1;
    }

    @Override
    public int getLightValue(final BlockState stateIn, final IBlockReader worldIn, final BlockPos posIn) {
        return 1;
    }

    @Override
    public boolean useShapeForLightOcclusion(final BlockState p_220074_1_In) {
        return false;
    }

    @Override
    public boolean propagatesSkylightDown(final BlockState p_200123_1_In, final IBlockReader p_200123_2_In, final BlockPos p_200123_3_In) {
        return true;
    }

    public final static class PoolLevelAndSides {
        public boolean left;
        public boolean right;
        public boolean north;
        public boolean south;
        public int level;

        public PoolLevelAndSides() {
            this.level = 0;
        }
    }

    public enum EnumActivatorState {
        NO, DISABLED, ENABLED,
    }
}