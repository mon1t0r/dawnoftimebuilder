package org.dawnoftimebuilder.block.japanese;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import org.dawnoftimebuilder.block.templates.FenceBlockDoTB;
import org.dawnoftimebuilder.util.DoTBBlockStateProperties;
import org.dawnoftimebuilder.util.DoTBBlockStateProperties.FencePillar;
import org.dawnoftimebuilder.util.DoTBBlockUtils;

import javax.annotation.Nullable;
import java.util.List;

public class CharredSpruceRailingBlock extends FenceBlockDoTB {

	private static final EnumProperty<DoTBBlockStateProperties.FencePillar> FENCE_PILLAR = DoTBBlockStateProperties.FENCE_PILLAR;

	public CharredSpruceRailingBlock(Material materialIn, float hardness, float resistance, SoundType soundType) {
		super(materialIn, hardness, resistance, soundType);
		this.setDefaultState(this.getStateContainer().getBaseState().with(EAST, false).with(NORTH, false).with(FENCE_PILLAR, FencePillar.NONE).with(SOUTH, false).with(WEST, false));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(FENCE_PILLAR);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockState state = super.getStateForPlacement(context);
		if(state == null) return this.getDefaultState();
		if(context.isPlacerSneaking()){
			return state.with(FENCE_PILLAR, FencePillar.NONE);
		}else return this.getPillarShape(state, context.getWorld(), context.getPos());
	}

	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		stateIn = super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		if(this.hasNoPillar(stateIn)) return stateIn;
		else return this.getPillarShape(stateIn, worldIn, currentPos);
	}

	private BlockState getPillarShape(BlockState stateIn, IWorld worldIn, BlockPos currentPos){
		if((stateIn.get(EAST) || stateIn.get(WEST)) && (stateIn.get(NORTH) || stateIn.get(SOUTH))){
			if(worldIn.getBlockState(currentPos.up()).isSolid()) return stateIn.with(FENCE_PILLAR, FencePillar.PILLAR_BIG);
			else return stateIn.with(FENCE_PILLAR, FencePillar.CAP_PILLAR_BIG);
		}else return stateIn.with(FENCE_PILLAR, FencePillar.PILLAR_SMALL);
	}

    private boolean hasNoPillar(BlockState state){
		return state.get(FENCE_PILLAR) == FencePillar.NONE;
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		DoTBBlockUtils.addTooltip(tooltip, this);
	}
}
