package org.dawnoftimebuilder.block.general;

import static net.minecraft.util.Hand.MAIN_HAND;

import java.util.Random;

import org.dawnoftimebuilder.block.templates.BasePoolBlock;
import org.dawnoftimebuilder.block.templates.BlockDoTB;
import org.dawnoftimebuilder.registry.DoTBBlocksRegistry;
import org.dawnoftimebuilder.util.DoTBBlockStateProperties;
import org.dawnoftimebuilder.util.DoTBBlockStateProperties.WaterTrickleEnd;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class WaterTrickleBlock extends BlockDoTB
{

	public WaterTrickleBlock(final Properties propertiesIn)
	{
		super(propertiesIn);
		this.registerDefaultState(this.defaultBlockState().setValue(DoTBBlockStateProperties.NORTH_TRICKLE, false).setValue(DoTBBlockStateProperties.EAST_TRICKLE, false).setValue(DoTBBlockStateProperties.SOUTH_TRICKLE, false)
				.setValue(DoTBBlockStateProperties.WEST_TRICKLE, false).setValue(DoTBBlockStateProperties.CENTER_TRICKLE, false).setValue(BlockStateProperties.UNSTABLE, true)
				.setValue(DoTBBlockStateProperties.WATER_TRICKLE_END, WaterTrickleEnd.FADE));
	}

	@Override
	protected void createBlockStateDefinition(final StateContainer.Builder<Block, BlockState> builder)
	{
		super.createBlockStateDefinition(builder);
		builder.add(DoTBBlockStateProperties.NORTH_TRICKLE, DoTBBlockStateProperties.EAST_TRICKLE, DoTBBlockStateProperties.SOUTH_TRICKLE, DoTBBlockStateProperties.WEST_TRICKLE, DoTBBlockStateProperties.CENTER_TRICKLE,
				BlockStateProperties.UNSTABLE, DoTBBlockStateProperties.WATER_TRICKLE_END);
	}

	@Override
	public void setPlacedBy(final World p_180633_1_, final BlockPos p_180633_2_, final BlockState p_180633_3_, final LivingEntity p_180633_4_, final ItemStack p_180633_5_)
	{
		super.setPlacedBy(p_180633_1_, p_180633_2_, p_180633_3_, p_180633_4_, p_180633_5_);

		if (!p_180633_1_.isClientSide() && p_180633_3_.getValue(BlockStateProperties.UNSTABLE))
		{
			((ServerWorld) p_180633_1_).getBlockTicks().scheduleTick(p_180633_2_, this, 5);
		}
	}

	@Override
	public BlockState updateShape(final BlockState stateIn, final Direction directionIn, final BlockState facingStateIn, final IWorld worldIn, final BlockPos currentPosIn, final BlockPos facingPosIn)
	{
		// If a block above or under changed, the water trickle is set UNSTABLE. Unstable water trickles are updated on the next randomTick.
		if (directionIn == Direction.UP && facingStateIn.getBlock() instanceof WaterTrickleBlock)
		{
			if (!worldIn.isClientSide())
			{
				((ServerWorld) worldIn).getBlockTicks().scheduleTick(currentPosIn, this, 5);
			}
			return stateIn.setValue(BlockStateProperties.UNSTABLE, true);
		}
		if (directionIn == Direction.DOWN && worldIn instanceof World)
		{
			if (!worldIn.isClientSide())
			{
				((ServerWorld) worldIn).getBlockTicks().scheduleTick(currentPosIn, this, 5);
			}
			return stateIn.setValue(DoTBBlockStateProperties.WATER_TRICKLE_END, this.getWaterTrickleEnd((World) worldIn, facingPosIn, facingStateIn)).setValue(BlockStateProperties.UNSTABLE, true);
		}
		return stateIn;
	}

	/**
	 * Creates an array used to get the list of the water trickles produced by this block.
	 *
	 * @param currentState BlockState of the WaterTrickle.
	 * @return A boolean array that contains 5 booleans {north, east, south, west center}. Each true value correspond to a water trickle at the corresponding position.
	 */
	public boolean[] getWaterTrickleOutPut(final BlockState currentState)
	{
		return new boolean[] {
			currentState.getValue(DoTBBlockStateProperties.NORTH_TRICKLE), currentState.getValue(DoTBBlockStateProperties.EAST_TRICKLE), currentState.getValue(DoTBBlockStateProperties.SOUTH_TRICKLE),
			currentState.getValue(DoTBBlockStateProperties.WEST_TRICKLE), currentState.getValue(DoTBBlockStateProperties.CENTER_TRICKLE) };
	}

	/**
	 * Synchronize the water trickles with the water trickles produced by the block above.
	 *
	 * @param currentState Actual state of the block to synchronize.
	 * @param aboveState   BlockState of the block above.
	 * @return An updated BlockState with the updated trickles. Can be AIR blockstate if the block should disappear.
	 */
	public BlockState inheritWaterTrickles(final BlockState currentState, final BlockState aboveState)
	{
		final boolean[]			trickles		= ((WaterTrickleBlock) aboveState.getBlock()).getWaterTrickleOutPut(aboveState);
		final BooleanProperty[]	properties		= {
			DoTBBlockStateProperties.NORTH_TRICKLE, DoTBBlockStateProperties.EAST_TRICKLE, DoTBBlockStateProperties.SOUTH_TRICKLE, DoTBBlockStateProperties.WEST_TRICKLE, DoTBBlockStateProperties.CENTER_TRICKLE };
		int						i				= 0;
		BlockState				updatedState	= currentState;
		for (final BooleanProperty property : properties)
		{
			if (currentState.getValue(property) != trickles[i])
			{
				updatedState = updatedState.setValue(property, trickles[i]).setValue(BlockStateProperties.UNSTABLE, true);
			}
			i++;
		}
		return updatedState;
	}

	@Override
	public void tick(BlockState state, final ServerWorld world, final BlockPos pos, final Random rand)
	{
		super.tick(state, world, pos, rand);
		// We consider that this Water Trickle won't be unstable by the end of this random tick.
		state = state.setValue(BlockStateProperties.UNSTABLE, false);
		final BlockPos		bottomPos	= pos.below();
		BlockState			bottomState	= world.getBlockState(bottomPos);
		final BlockPos		abovePos	= pos.above();
		final BlockState	aboveState	= world.getBlockState(abovePos);

		// First we check if the block under has trickles. If yes, we check if there is some difference, and make it unstable if yes.
		if (bottomState.getBlock() instanceof WaterTrickleBlock)
		{
			final BlockState updatedState = this.inheritWaterTrickles(bottomState, state);
			if (updatedState.getValue(BlockStateProperties.UNSTABLE))
			{
				world.setBlock(bottomPos, bottomState.setValue(BlockStateProperties.UNSTABLE, true), 10);
			}
			// If the block under is not a water trickle and can be replaced and is not liquid, we put an unstable Flowing Water Trickle.
		}
		else if (bottomState.canBeReplaced(this.generateContext(world, bottomPos)) && world.getFluidState(bottomPos).getType().equals(Fluids.EMPTY))
		{
			bottomState = this.createFlowingTrickle(bottomState, this.getWaterTrickleOutPut(state), world, bottomPos);
			// If the block can contain fluid, we fill it with water.
		}
		else if (bottomState.getBlock() instanceof ILiquidContainer && ((ILiquidContainer) bottomState.getBlock()).canPlaceLiquid(world, bottomPos, bottomState, Fluids.WATER))
		{
			((ILiquidContainer) bottomState.getBlock()).placeLiquid(world, bottomPos, bottomState, Fluids.WATER.getSource(false));
		}

		final BlockState updatedState = this.updateWaterTrickle(world, state, bottomPos, bottomState, aboveState);
		world.setBlock(pos, updatedState, 10);
	}

	public BlockState updateWaterTrickle(final World world, BlockState currentState, final BlockPos bottomPos, final BlockState bottomState, final BlockState aboveState)
	{
		// We update the water trickle end, now that the bottom block has been updated.
		final WaterTrickleEnd lowerEnd = this.getWaterTrickleEnd(world, bottomPos, bottomState);
		currentState = currentState.setValue(DoTBBlockStateProperties.WATER_TRICKLE_END, lowerEnd);

		// Finally, we synchronize this water trickle with the block above. If it changes, this block stays unstable.
		if (aboveState.getBlock() instanceof WaterTrickleBlock)
		{
			currentState = this.inheritWaterTrickles(currentState, aboveState);
		}
		else
		{
			currentState = this.inheritWaterTrickles(currentState, this.defaultBlockState());
		}

		return currentState;
	}

	/**
	 * Generates a BlockState of Water Trickle based on the current block, and set it in the world if needed.
	 *
	 * @param currentState    BlockState of the current block. Will be returned by the function.
	 * @param trickles        Array of booleans that correspond to each of the 5 trickles.
	 * @param world           Level in which the Water Trickle must be set.
	 * @param waterTricklePos BlockPos where the Trickle must be placed.
	 * @return The new BlockState of the block (either a trickle or the old state).
	 */
	public BlockState createFlowingTrickle(final BlockState currentState, final boolean[] trickles, final World world, final BlockPos waterTricklePos)
	{
		final BooleanProperty[]	properties			= {
			DoTBBlockStateProperties.NORTH_TRICKLE, DoTBBlockStateProperties.EAST_TRICKLE, DoTBBlockStateProperties.SOUTH_TRICKLE, DoTBBlockStateProperties.WEST_TRICKLE, DoTBBlockStateProperties.CENTER_TRICKLE };
		int						i					= 0;
		int						numberOfTrickle		= 0;
		BlockState				waterTrickleState	= DoTBBlocksRegistry.WATER_FLOWING_TRICKLE.get().defaultBlockState();
		// Creates the BlockState of the trickle based on the source block.
		for (final BooleanProperty property : properties)
		{
			waterTrickleState = waterTrickleState.setValue(property, trickles[i]);
			if (trickles[i])
			{
				numberOfTrickle++;
			}
			i++;
		}
		// If the number of trickle is still null, then we don't create anything.
		if (numberOfTrickle > 0)
		{
			world.setBlock(waterTricklePos, waterTrickleState, 10);
			return waterTrickleState;
		}
		return currentState;
	}

	@Override
	public void animateTick(final BlockState state, final World worldIn, final BlockPos pos, final Random rand)
	{
		super.animateTick(state, worldIn, pos, rand);
		final boolean[] trickles = this.getWaterTrickleOutPut(state);
		if (state.getValue(DoTBBlockStateProperties.WATER_TRICKLE_END) == WaterTrickleEnd.SPLASH)
		{
			this.spawnFullParticles(worldIn, pos, trickles[0], rand, 0.5D, 0.4D);
			this.spawnFullParticles(worldIn, pos, trickles[1], rand, 0.6D, 0.5D);
			this.spawnFullParticles(worldIn, pos, trickles[2], rand, 0.5D, 0.6D);
			this.spawnFullParticles(worldIn, pos, trickles[3], rand, 0.5D, 0.6D);
			this.spawnFullParticles(worldIn, pos, trickles[4], rand, 0.5D, 0.5D);

			return;
		}

		final BlockState belowState = worldIn.getBlockState(pos.below());

		if (belowState.getBlock() instanceof BasePoolBlock && belowState.getValue(DoTBBlockStateProperties.LEVEL) > ((BasePoolBlock) belowState.getBlock()).faucetLevel)
		{
			this.spawnLimitedParticles(worldIn, pos, trickles[0], rand, 0.5D, 0.4D);
			this.spawnLimitedParticles(worldIn, pos, trickles[1], rand, 0.6D, 0.5D);
			this.spawnLimitedParticles(worldIn, pos, trickles[2], rand, 0.5D, 0.6D);
			this.spawnLimitedParticles(worldIn, pos, trickles[3], rand, 0.5D, 0.6D);
			this.spawnLimitedParticles(worldIn, pos, trickles[4], rand, 0.5D, 0.5D);
		}
	}

	private void spawnLimitedParticles(final World worldIn, final BlockPos pos, final boolean isOn, final Random rand, final double xOffset, final double zOffset)
	{
		if (isOn)
		{
			double offset = 0.75D;
			worldIn.addParticle(ParticleTypes.BUBBLE_POP, true, pos.getX() + xOffset + (rand.nextDouble() * offset - offset / 2.0D), pos.getY() + 0.1D, pos.getZ() + zOffset + (rand.nextDouble() * offset - offset / 2.0D), 0.0125D, 0.075D,
					0.0125D);

			offset = 0.60D;
			worldIn.addParticle(ParticleTypes.CLOUD, true, pos.getX() + xOffset + (rand.nextDouble() * offset - offset / 2.0D), pos.getY() + 0.0D, pos.getZ() + zOffset + (rand.nextDouble() * offset - offset / 2.0D), 0.0005D, 0.010D,
					0.0005D);
		}
	}

	private void spawnFullParticles(final World worldIn, final BlockPos pos, final boolean isOn, final Random rand, final double xOffset, final double zOffset)
	{
		if (isOn)
		{
			double offset;
			for (int i = 0; i < 4; i++)
			{
				offset = 0.75D;
				worldIn.addParticle(ParticleTypes.BUBBLE_POP, true, pos.getX() + xOffset + (rand.nextDouble() * offset - offset / 2.0D), pos.getY() + 0.1D, pos.getZ() + zOffset + (rand.nextDouble() * offset - offset / 2.0D), 0.0125D,
						0.075D, 0.0125D);

				offset = 0.60D;
				worldIn.addParticle(ParticleTypes.CLOUD, true, pos.getX() + xOffset + (rand.nextDouble() * offset - offset / 2.0D), pos.getY() + 0.0D, pos.getZ() + zOffset + (rand.nextDouble() * offset - offset / 2.0D), 0.0005D, 0.010D,
						0.0005D);
			}
		}
	}

	protected WaterTrickleEnd getWaterTrickleEnd(final World level, final BlockPos bottomPos, final BlockState bottomState)
	{
		if (bottomState.getBlock() instanceof WaterTrickleBlock)
		{
			return WaterTrickleEnd.STRAIGHT;
		}
		// If the face under the water trickle is full or if there is a fluid, there is a splash effect.
		if (!level.getFluidState(bottomPos).getType().equals(Fluids.EMPTY))
		{
			return WaterTrickleEnd.SPLASH;
		}
		return WaterTrickleEnd.FADE;
	}

	private BlockItemUseContext generateContext(final World level, final BlockPos fromPos)
	{
		final Vector3d vec = new Vector3d(fromPos.getX() + 0.5D, fromPos.getY(), fromPos.getZ() + 0.5D);
		return new BlockItemUseContext(level, null, MAIN_HAND, ItemStack.EMPTY, new BlockRayTraceResult(vec, Direction.DOWN, fromPos, false));
	}

	protected static BooleanProperty getPropertyFromDirection(final Direction facing)
	{
		switch (facing)
		{
			default:
				return DoTBBlockStateProperties.CENTER;
			case NORTH:
				return BlockStateProperties.NORTH;
			case SOUTH:
				return BlockStateProperties.SOUTH;
			case WEST:
				return BlockStateProperties.WEST;
			case EAST:
				return BlockStateProperties.EAST;
		}
	}

	@Override
	public PushReaction getPistonPushReaction(final BlockState p_149656_1_)
	{
		return PushReaction.DESTROY;
	}

	@Override
	public int getLightBlock(final BlockState p_200011_1_In, final IBlockReader p_200011_2_In, final BlockPos p_200011_3_In)
	{
		return 1;
	}

	@Override
	public boolean useShapeForLightOcclusion(final BlockState p_220074_1_In)
	{
		return false;
	}

	@Override
	public int getLightValue(final BlockState stateIn, final IBlockReader worldIn, final BlockPos posIn)
	{
		return 1;
	}

	@Override
	public VoxelShape getOcclusionShape(final BlockState p_196247_1_In, final IBlockReader p_196247_2_In, final BlockPos p_196247_3_In)
	{
		return VoxelShapes.empty();
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public float getShadeBrightness(final BlockState p_220080_1_, final IBlockReader p_220080_2_, final BlockPos p_220080_3_)
	{
		return 1.0F;
	}

	@Override
	public boolean propagatesSkylightDown(final BlockState p_200123_1_In, final IBlockReader p_200123_2_In, final BlockPos p_200123_3_In)
	{
		return true;
	}
}