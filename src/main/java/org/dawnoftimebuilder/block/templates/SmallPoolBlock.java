package org.dawnoftimebuilder.block.templates;

import javax.annotation.Nullable;

import org.dawnoftimebuilder.util.DoTBBlockStateProperties;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class SmallPoolBlock extends BasePoolBlock {

	private static final VoxelShape[] SHAPES = SmallPoolBlock.makeShapes();
	private static final VoxelShape[] SMALL_SHAPES = SmallPoolBlock.makeSmallShapes();

	public SmallPoolBlock(final Properties propertiesIn) {
		super(propertiesIn, 6, 4);
		this.registerDefaultState(this.defaultBlockState().setValue(BlockStateProperties.BOTTOM, true));
	}

	@Override
	protected void createBlockStateDefinition(final StateContainer.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(BlockStateProperties.BOTTOM);
	}

	@Override
	public VoxelShape getShape(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
		int index = 0;
		if (state.getValue(BlockStateProperties.NORTH)) {
			index += 1;
		}
		if (state.getValue(BlockStateProperties.EAST)) {
			index += 2;
		}
		if (state.getValue(BlockStateProperties.SOUTH)) {
			index += 4;
		}
		if (state.getValue(BlockStateProperties.WEST)) {
			index += 8;
		}
		if (state.getValue(DoTBBlockStateProperties.HAS_PILLAR)) {
			index += 16;
		}
		if (state.getValue(BlockStateProperties.BOTTOM)) {
			index += 32;
		}
		return SmallPoolBlock.SMALL_SHAPES[index];
	}

	@Override
	public VoxelShape getCollisionShape(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
		int index = 0;
		if (state.getValue(BlockStateProperties.NORTH)) {
			index += 1;
		}
		if (state.getValue(BlockStateProperties.EAST)) {
			index += 2;
		}
		if (state.getValue(BlockStateProperties.SOUTH)) {
			index += 4;
		}
		if (state.getValue(BlockStateProperties.WEST)) {
			index += 8;
		}
		if (state.getValue(DoTBBlockStateProperties.HAS_PILLAR)) {
			index += 16;
		}
		return SmallPoolBlock.SHAPES[index];
	}

	private static VoxelShape[] makeShapes() {
		final VoxelShape	vs_floor	= Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D);
		final VoxelShape	vs_north	= Block.box(0.0D, 10.0D, 0.0D, 16.0D, 16.0D, 2.0D);
		final VoxelShape	vs_east		= Block.box(14.0D, 10.0D, 0.0D, 16.0D, 16.0D, 16.0D);
		final VoxelShape	vs_south	= Block.box(0.0D, 10.0D, 14.0D, 16.0D, 16.0D, 16.0D);
		final VoxelShape	vs_west		= Block.box(0.0D, 10.0D, 0.0D, 2.0D, 16.0D, 16.0D);
		final VoxelShape	vs_pillar	= Block.box(4.0D, 10.0D, 4.0D, 12.0D, 16.0D, 12.0D);
		final VoxelShape[]	shapes		= new VoxelShape[32];
		for (int i = 0; i < 32; i++) {
			VoxelShape temp = vs_floor;
			if ((i & 1) == 0) { // Check first bit : 0 -> North true
				temp = VoxelShapes.or(temp, vs_north);
			}
			if ((i >> 1 & 1) == 0) { // Check second bit : 0 -> East true
				temp = VoxelShapes.or(temp, vs_east);
			}
			if ((i >> 2 & 1) == 0) { // Check third bit : 0 -> South true
				temp = VoxelShapes.or(temp, vs_south);
			}
			if ((i >> 3 & 1) == 0) { // Check fourth bit : 0 -> West true
				temp = VoxelShapes.or(temp, vs_west);
			}
			if ((i >> 4 & 1) == 1) { // Check fifth bit : 1 -> Pillar true
				temp = VoxelShapes.or(temp, vs_pillar);
			}
			shapes[i] = temp;
		}
		return shapes;
	}

	private static VoxelShape[] makeSmallShapes() {
		final VoxelShape	vs_floor	= Block.box(0.0D, 8.0D, 0.0D, 16.0D, 10.0D, 16.0D);
		final VoxelShape	vs_north	= Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 2.0D);
		final VoxelShape	vs_east		= Block.box(14.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
		final VoxelShape	vs_south	= Block.box(0.0D, 8.0D, 14.0D, 16.0D, 16.0D, 16.0D);
		final VoxelShape	vs_west		= Block.box(0.0D, 8.0D, 0.0D, 2.0D, 16.0D, 16.0D);
		final VoxelShape	vs_pillar	= Block.box(4.0D, 10.0D, 4.0D, 12.0D, 16.0D, 12.0D);
		final VoxelShape	vs_bottom	= Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);
		final VoxelShape[]	shapes		= new VoxelShape[64];
		for (int i = 0; i < 64; i++) {
			VoxelShape temp = vs_floor;
			if ((i & 1) == 0) { // Check first bit : 0 -> North true
				temp = VoxelShapes.or(temp, vs_north);
			}
			if ((i >> 1 & 1) == 0) { // Check second bit : 0 -> East true
				temp = VoxelShapes.or(temp, vs_east);
			}
			if ((i >> 2 & 1) == 0) { // Check third bit : 0 -> South true
				temp = VoxelShapes.or(temp, vs_south);
			}
			if ((i >> 3 & 1) == 0) { // Check fourth bit : 0 -> West true
				temp = VoxelShapes.or(temp, vs_west);
			}
			if ((i >> 4 & 1) == 1) { // Check fifth bit : 1 -> Pillar true
				temp = VoxelShapes.or(temp, vs_pillar);
			}
			if ((i >> 5 & 1) == 1) { // Check fifth bit : 1 -> Bottom true
				temp = VoxelShapes.or(temp, vs_bottom);
			}
			shapes[i] = temp;
		}
		return shapes;
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockState state = super.getStateForPlacement(context);
		if(state != null){
			if(!canSupportCenter(context.getLevel(), context.getClickedPos().below(), Direction.UP)){
				state = state.setValue(BlockStateProperties.BOTTOM, false);
			}
		}
		return state;
	}

	@Override
	public BlockState updateShape(BlockState stateIn, Direction directionIn, BlockState facingStateIn, IWorld worldIn, BlockPos currentPosIn, BlockPos facingPosIn) {
		stateIn = super.updateShape(stateIn, directionIn, facingStateIn, worldIn, currentPosIn, facingPosIn);
		if(directionIn == Direction.DOWN) {
			stateIn = stateIn.setValue(BlockStateProperties.BOTTOM, canSupportCenter(worldIn, facingPosIn, Direction.UP));
		}
		return stateIn;
	}
}