package org.dawnoftimebuilder.registry;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.dawnoftimebuilder.block.IBlockCustomItem;
import org.dawnoftimebuilder.block.french.LimestoneChimneyBlock;
import org.dawnoftimebuilder.block.precolumbian.*;
import org.dawnoftimebuilder.block.roman.BirchCouch;
import org.dawnoftimebuilder.block.roman.BirchFootstool;
import org.dawnoftimebuilder.block.roman.CypressBlock;
import org.dawnoftimebuilder.block.roman.SandstoneColumnBlock;
import org.dawnoftimebuilder.block.templates.*;
import org.dawnoftimebuilder.block.german.*;
import org.dawnoftimebuilder.block.general.*;
import org.dawnoftimebuilder.block.japanese.*;
import org.dawnoftimebuilder.util.DoTBFoods;

import static net.minecraft.block.Blocks.*;
import static net.minecraftforge.common.PlantType.CROP;
import static net.minecraftforge.common.PlantType.PLAINS;
import static org.dawnoftimebuilder.DawnOfTimeBuilder.DOTB_TAB;
import static org.dawnoftimebuilder.DawnOfTimeBuilder.MOD_ID;

public class DoTBBlocksRegistry {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

	//General
    public static final RegistryObject<Block> ACACIA_PLANKS_EDGE = reg("acacia_planks_edge", new EdgeBlock(AbstractBlock.Properties.copy(ACACIA_PLANKS)).setBurnable());
	public static final RegistryObject<Block> ACACIA_PLANKS_PLATE = reg("acacia_planks_plate", new PlateBlock(AbstractBlock.Properties.copy(ACACIA_PLANKS)).setBurnable());
	public static final RegistryObject<Block> ACACIA_PERGOLA = reg("acacia_pergola", new PergolaBlock(AbstractBlock.Properties.copy(ACACIA_PLANKS)).setBurnable());
	public static final RegistryObject<Block> ACACIA_LATTICE = reg("acacia_lattice", new LatticeBlock(AbstractBlock.Properties.copy(ACACIA_PLANKS)).setBurnable());
	public static final RegistryObject<Block> ACACIA_BEAM = reg("acacia_beam", new BeamBlock(AbstractBlock.Properties.copy(ACACIA_PLANKS)).setBurnable());
	public static final RegistryObject<Block> ACACIA_WALL = reg("acacia_wall", new WallBlockDoTB(AbstractBlock.Properties.copy(ACACIA_PLANKS)).setBurnable());
	public static final RegistryObject<Block> ACACIA_SUPPORT_BEAM = reg("acacia_support_beam", new SupportBeamBlock(AbstractBlock.Properties.copy(ACACIA_PLANKS)).setBurnable());
	public static final RegistryObject<Block> ACACIA_SUPPORT_SLAB = reg("acacia_support_slab", new SupportSlabBlock(AbstractBlock.Properties.copy(ACACIA_PLANKS)).setBurnable());
	public static final RegistryObject<Block> BIRCH_PLANKS_EDGE = reg("birch_planks_edge", new EdgeBlock(AbstractBlock.Properties.copy(BIRCH_PLANKS)).setBurnable());
	public static final RegistryObject<Block> BIRCH_PLANKS_PLATE = reg("birch_planks_plate", new PlateBlock(AbstractBlock.Properties.copy(BIRCH_PLANKS)).setBurnable());
	public static final RegistryObject<Block> BIRCH_PERGOLA = reg("birch_pergola", new PergolaBlock(AbstractBlock.Properties.copy(BIRCH_PLANKS)).setBurnable());
	public static final RegistryObject<Block> BIRCH_LATTICE = reg("birch_lattice", new LatticeBlock(AbstractBlock.Properties.copy(BIRCH_PLANKS)).setBurnable());
	public static final RegistryObject<Block> BIRCH_BEAM = reg("birch_beam", new BeamBlock(AbstractBlock.Properties.copy(BIRCH_PLANKS)).setBurnable());
	public static final RegistryObject<Block> BIRCH_WALL = reg("birch_wall", new WallBlockDoTB(AbstractBlock.Properties.copy(BIRCH_PLANKS)).setBurnable());
	public static final RegistryObject<Block> BIRCH_SUPPORT_BEAM = reg("birch_support_beam", new SupportBeamBlock(AbstractBlock.Properties.copy(BIRCH_PLANKS)).setBurnable());
	public static final RegistryObject<Block> BIRCH_SUPPORT_SLAB = reg("birch_support_slab", new SupportSlabBlock(AbstractBlock.Properties.copy(BIRCH_PLANKS)).setBurnable());
	public static final RegistryObject<Block> CANDLESTICK = reg("candlestick", new CandlestickBlock(AbstractBlock.Properties.copy(CAULDRON)));
	public static final RegistryObject<Block> DARK_OAK_PLANKS_EDGE = reg("dark_oak_planks_edge", new EdgeBlock(AbstractBlock.Properties.copy(DARK_OAK_PLANKS)).setBurnable());
	public static final RegistryObject<Block> DARK_OAK_PLANKS_PLATE = reg("dark_oak_planks_plate", new PlateBlock(AbstractBlock.Properties.copy(DARK_OAK_PLANKS)).setBurnable());
	public static final RegistryObject<Block> DARK_OAK_PERGOLA = reg("dark_oak_pergola", new PergolaBlock(AbstractBlock.Properties.copy(DARK_OAK_PLANKS)).setBurnable());
	public static final RegistryObject<Block> DARK_OAK_LATTICE = reg("dark_oak_lattice", new LatticeBlock(AbstractBlock.Properties.copy(DARK_OAK_PLANKS)).setBurnable());
	public static final RegistryObject<Block> DARK_OAK_BEAM = reg("dark_oak_beam", new BeamBlock(AbstractBlock.Properties.copy(DARK_OAK_PLANKS)).setBurnable());
	public static final RegistryObject<Block> DARK_OAK_WALL = reg("dark_oak_wall", new WallBlockDoTB(AbstractBlock.Properties.copy(DARK_OAK_PLANKS)).setBurnable());
	public static final RegistryObject<Block> DARK_OAK_SUPPORT_BEAM = reg("dark_oak_support_beam", new SupportBeamBlock(AbstractBlock.Properties.copy(DARK_OAK_PLANKS)).setBurnable());
	public static final RegistryObject<Block> DARK_OAK_SUPPORT_SLAB = reg("dark_oak_support_slab", new SupportSlabBlock(AbstractBlock.Properties.copy(DARK_OAK_PLANKS)).setBurnable());
	public static final RegistryObject<Block> JUNGLE_PLANKS_EDGE = reg("jungle_planks_edge", new EdgeBlock(AbstractBlock.Properties.copy(JUNGLE_PLANKS)).setBurnable());
	public static final RegistryObject<Block> JUNGLE_PLANKS_PLATE = reg("jungle_planks_plate", new PlateBlock(AbstractBlock.Properties.copy(JUNGLE_PLANKS)).setBurnable());
	public static final RegistryObject<Block> JUNGLE_PERGOLA = reg("jungle_pergola", new PergolaBlock(AbstractBlock.Properties.copy(JUNGLE_PLANKS)).setBurnable());
	public static final RegistryObject<Block> JUNGLE_LATTICE = reg("jungle_lattice", new LatticeBlock(AbstractBlock.Properties.copy(JUNGLE_PLANKS)).setBurnable());
	public static final RegistryObject<Block> JUNGLE_BEAM = reg("jungle_beam", new BeamBlock(AbstractBlock.Properties.copy(JUNGLE_PLANKS)).setBurnable());
	public static final RegistryObject<Block> JUNGLE_WALL = reg("jungle_wall", new WallBlockDoTB(AbstractBlock.Properties.copy(JUNGLE_PLANKS)).setBurnable());
	public static final RegistryObject<Block> JUNGLE_SUPPORT_BEAM = reg("jungle_support_beam", new SupportBeamBlock(AbstractBlock.Properties.copy(JUNGLE_PLANKS)).setBurnable());
	public static final RegistryObject<Block> JUNGLE_SUPPORT_SLAB = reg("jungle_support_slab", new SupportSlabBlock(AbstractBlock.Properties.copy(JUNGLE_PLANKS)).setBurnable());
	public static final RegistryObject<Block> OAK_PLANKS_PLATE = reg("oak_planks_plate", new PlateBlock(AbstractBlock.Properties.copy(OAK_PLANKS)).setBurnable());
    public static final RegistryObject<Block> OAK_PLANKS_EDGE = reg("oak_planks_edge", new EdgeBlock(AbstractBlock.Properties.copy(OAK_PLANKS)).setBurnable());
	public static final RegistryObject<Block> OAK_PERGOLA = reg("oak_pergola", new PergolaBlock(AbstractBlock.Properties.copy(OAK_PLANKS)).setBurnable());
	public static final RegistryObject<Block> OAK_LATTICE = reg("oak_lattice", new LatticeBlock(AbstractBlock.Properties.copy(OAK_PLANKS)).setBurnable());
	public static final RegistryObject<Block> OAK_BEAM = reg("oak_beam", new BeamBlock(AbstractBlock.Properties.copy(OAK_PLANKS)).setBurnable());
	public static final RegistryObject<Block> OAK_WALL = reg("oak_wall", new WallBlockDoTB(AbstractBlock.Properties.copy(OAK_PLANKS)).setBurnable());
	public static final RegistryObject<Block> OAK_SUPPORT_BEAM = reg("oak_support_beam", new SupportBeamBlock(AbstractBlock.Properties.copy(OAK_PLANKS)).setBurnable());
	public static final RegistryObject<Block> OAK_SUPPORT_SLAB = reg("oak_support_slab", new SupportSlabBlock(AbstractBlock.Properties.copy(OAK_PLANKS)).setBurnable());
	public static final RegistryObject<Block> RAMMED_DIRT = reg("rammed_dirt", new BlockDoTB(AbstractBlock.Properties.copy(TERRACOTTA)));
	public static final RegistryObject<Block> SPRUCE_PLANKS_EDGE = reg("spruce_planks_edge", new EdgeBlock(AbstractBlock.Properties.copy(SPRUCE_PLANKS)).setBurnable());
	public static final RegistryObject<Block> SPRUCE_PLANKS_PLATE = reg("spruce_planks_plate", new PlateBlock(AbstractBlock.Properties.copy(SPRUCE_PLANKS)).setBurnable());
	public static final RegistryObject<Block> SPRUCE_PERGOLA = reg("spruce_pergola", new PergolaBlock(AbstractBlock.Properties.copy(SPRUCE_PLANKS)).setBurnable());
	public static final RegistryObject<Block> SPRUCE_LATTICE = reg("spruce_lattice", new LatticeBlock(AbstractBlock.Properties.copy(SPRUCE_PLANKS)).setBurnable());
	public static final RegistryObject<Block> SPRUCE_BEAM = reg("spruce_beam", new BeamBlock(AbstractBlock.Properties.copy(SPRUCE_PLANKS)).setBurnable());
	public static final RegistryObject<Block> SPRUCE_WALL = reg("spruce_wall", new WallBlockDoTB(AbstractBlock.Properties.copy(SPRUCE_PLANKS)).setBurnable());
	public static final RegistryObject<Block> SPRUCE_SUPPORT_BEAM = reg("spruce_support_beam", new SupportBeamBlock(AbstractBlock.Properties.copy(SPRUCE_PLANKS)).setBurnable());
	public static final RegistryObject<Block> SPRUCE_SUPPORT_SLAB = reg("spruce_support_slab", new SupportSlabBlock(AbstractBlock.Properties.copy(SPRUCE_PLANKS)).setBurnable());
	public static final RegistryObject<Block> THATCH_WHEAT = reg("thatch_wheat", new BlockDoTB(AbstractBlock.Properties.of(Material.GRASS, MaterialColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.GRASS)).setBurnable(80, 30));
	public static final RegistryObject<Block> THATCH_WHEAT_EDGE = reg("thatch_wheat_edge", new EdgeBlock(AbstractBlock.Properties.copy(THATCH_WHEAT.get())).setBurnable(80, 30));
	public static final RegistryObject<Block> THATCH_WHEAT_PLATE = reg("thatch_wheat_plate", new PlateBlock(AbstractBlock.Properties.copy(THATCH_WHEAT.get())).setBurnable(80, 30));
	public static final RegistryObject<Block> THATCH_WHEAT_SLAB = reg("thatch_wheat_slab", new SlabBlockDoTB(AbstractBlock.Properties.copy(THATCH_WHEAT.get())).setBurnable(80, 30));
	public static final RegistryObject<Block> THATCH_WHEAT_STAIRS = reg("thatch_wheat_stairs", new StairsBlockDoTB(THATCH_WHEAT.get()).setBurnable(80, 30));
	public static final RegistryObject<Block> THATCH_BAMBOO = reg("thatch_bamboo", new BlockDoTB(AbstractBlock.Properties.copy(THATCH_WHEAT.get())).setBurnable(40, 30));
	public static final RegistryObject<Block> THATCH_BAMBOO_EDGE = reg("thatch_bamboo_edge", new EdgeBlock(AbstractBlock.Properties.copy(THATCH_WHEAT.get())).setBurnable(40, 30));
	public static final RegistryObject<Block> THATCH_BAMBOO_PLATE = reg("thatch_bamboo_plate", new PlateBlock(AbstractBlock.Properties.copy(THATCH_WHEAT.get())).setBurnable(40, 30));
	public static final RegistryObject<Block> THATCH_BAMBOO_SLAB = reg("thatch_bamboo_slab", new SlabBlockDoTB(AbstractBlock.Properties.copy(THATCH_WHEAT.get())).setBurnable(40, 30));
	public static final RegistryObject<Block> THATCH_BAMBOO_STAIRS = reg("thatch_bamboo_stairs", new StairsBlockDoTB(THATCH_BAMBOO.get()).setBurnable(40, 30));
	public static final RegistryObject<Block> FIREPLACE = reg("fireplace", new FireplaceBlock(Material.STONE,1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> IRON_PORTCULLIS = reg("iron_portcullis", new PortcullisBlock(Material.METAL, 5.0F, 6.0F, SoundType.METAL));

	//French
	public static final RegistryObject<Block> COBBLED_LIMESTONE = reg("cobbled_limestone", new BlockDoTB(Material.STONE, 2.0F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> LIMESTONE_BRICKS = reg("limestone_bricks", new BlockDoTB(Material.STONE,1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> LIMESTONE_BRICKS_EDGE = reg("limestone_bricks_edge", new EdgeBlock(LIMESTONE_BRICKS.get()));
	public static final RegistryObject<Block> LIMESTONE_BRICKS_PLATE = reg("limestone_bricks_plate", new PlateBlock(LIMESTONE_BRICKS.get()));
	public static final RegistryObject<Block> LIMESTONE_BRICKS_SLAB = reg("limestone_bricks_slab", new SlabBlockDoTB(LIMESTONE_BRICKS.get()));
	public static final RegistryObject<Block> LIMESTONE_BRICKS_STAIRS = reg("limestone_bricks_stairs", new StairsBlockDoTB(LIMESTONE_BRICKS.get()));
	public static final RegistryObject<Block> LIMESTONE_BRICKS_WALL = reg("limestone_bricks_wall", new WallBlockDoTB(Material.STONE, 1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> LIMESTONE_BALUSTER = reg("limestone_baluster", new EdgeBlock(Material.STONE, 1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> LIMESTONE_CHIMNEY = reg("limestone_chimney", new LimestoneChimneyBlock(Material.STONE, 1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> LIMESTONE_FIREPLACE = reg("limestone_fireplace", new MultiblockFireplaceBlock(Material.STONE, 2.0F, 6.0F, SoundType.STONE));

	//German
	public static final RegistryObject<Block> FLAT_ROOF_TILES = reg("flat_roof_tiles", new BlockDoTB(Material.STONE,1.5F, 5.0F, SoundType.STONE));
	public static final RegistryObject<Block> FLAT_ROOF_TILES_STAIRS = reg("flat_roof_tiles_stairs", new StairsBlockDoTB(FLAT_ROOF_TILES.get()));
	public static final RegistryObject<Block> FLAT_ROOF_TILES_PLATE = reg("flat_roof_tiles_plate", new PlateBlock(FLAT_ROOF_TILES.get()));
	public static final RegistryObject<Block> FLAT_ROOF_TILES_SLAB = reg("flat_roof_tiles_slab", new SlabBlockDoTB(FLAT_ROOF_TILES.get()));
	public static final RegistryObject<Block> FLAT_ROOF_TILES_EDGE = reg("flat_roof_tiles_edge", new EdgeBlock(FLAT_ROOF_TILES.get()));
	public static final RegistryObject<Block> LATTICE_GLASS = reg("lattice_glass", new GlassBlock(Material.GLASS, 1.0F, 1.0F, SoundType.GLASS));
	public static final RegistryObject<Block> LATTICE_GLASS_PANE = reg("lattice_glass_pane", new PaneBlockDoTB(Material.GLASS, 1.0F, 1.0F, SoundType.GLASS)); //TODO translucent
	public static final RegistryObject<Block> LATTICE_WAXED_OAK_WINDOW = reg("lattice_waxed_oak_window", new SidedWindowBlock(Material.GLASS, 2.0F, 3.0F, SoundType.GLASS));
	public static final RegistryObject<Block> LATTICE_STONE_BRICKS_WINDOW = reg("lattice_stone_bricks_window", new LatticeStoneBricksWindowBlock(Material.STONE, 1.5F, 6.0F, SoundType.GLASS));
	public static final RegistryObject<Block> STONE_BRICKS_ARROWSLIT = reg("stone_bricks_arrowslit", new StoneBricksArrowslitBlock(Material.STONE, 1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> STONE_BRICKS_CHIMNEY = reg("stone_bricks_chimney", new StoneBricksChimneyBlock(Material.STONE, 1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> STONE_BRICKS_EDGE = reg("stone_bricks_edge", new EdgeBlock(STONE_BRICKS));
	public static final RegistryObject<Block> STONE_BRICKS_FIREPLACE = reg("stone_bricks_fireplace", new MultiblockFireplaceBlock(Material.STONE, 2.0F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> STONE_BRICKS_MACHICOLATION = reg("stone_bricks_machicolation", new StoneBricksMachicolationBlock(Material.STONE, 1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> STONE_BRICKS_PLATE = reg("stone_bricks_plate", new PlateBlock(STONE_BRICKS));
	public static final RegistryObject<Block> WAXED_OAK_FRAMED_RAMMED_DIRT = reg("waxed_oak_framed_rammed_dirt", new BlockDoTB(Material.WOOD, 2.0F, 3.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_DOOR = reg("waxed_oak_door", new DoorBlockDoTB(Material.WOOD, 1.5F, 6.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_TRAPDOOR = reg("waxed_oak_trapdoor", new TrapDoorBlock(Material.WOOD, 2.0F, 3.0F, SoundType.WOOD));
	public static final RegistryObject<Block> WAXED_OAK_SHUTTERS = reg("waxed_oak_shutters", new ShuttersBlock(Material.WOOD, 2.0F, 2.0F, SoundType.WOOD));
	public static final RegistryObject<Block> WAXED_OAK_LOG_STRIPPED = reg("waxed_oak_log_stripped", new RotatedPillarBlockDoTB(Material.WOOD, 2.5F, 5.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_BEAM = reg("waxed_oak_beam", new BeamBlock(Material.WOOD, 2.0F, 3.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_SUPPORT_BEAM = reg("waxed_oak_support_beam", new SupportBeamBlock(Material.WOOD, 2.0F, 3.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_SUPPORT_SLAB = reg("waxed_oak_support_slab", new SupportSlabBlock(Material.WOOD, 1.5F, 3.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_SMALL_SHUTTERS = reg("waxed_oak_small_shutters", new SmallShuttersBlock(Material.WOOD, 2.0F, 2.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_TIMBER_FRAME = reg("waxed_oak_timber_frame", new BlockDoTB(Material.WOOD, 3.0F, 5.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_TIMBER_FRAME_CORNER = reg("waxed_oak_timber_frame_corner", new WaxedOakTimberFrameCornerBlock(Material.WOOD, 3.0F, 5.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_TIMBER_FRAME_CROSSED = reg("waxed_oak_timber_frame_crossed", new BlockDoTB(Material.WOOD, 3.0F, 5.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_TIMBER_FRAME_PILLAR = reg("waxed_oak_timber_frame_pillar", new RotatedPillarBlockDoTB(Material.WOOD, 3.0F, 5.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_TIMBER_FRAME_SQUARED = reg("waxed_oak_timber_frame_squared", new BlockDoTB(Material.WOOD, 3.0F, 5.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_FENCE = reg("waxed_oak_fence", new FenceBlockDoTB(Material.WOOD, 2.0F, 3.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_WALL = reg("waxed_oak_wall", new WallBlockDoTB(Material.WOOD, 1.5F, 6.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_PERGOLA = reg("waxed_oak_pergola", new PergolaBlock(Material.WOOD, 2.0F, 3.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_LATTICE = reg("waxed_oak_lattice", new LatticeBlock(Material.WOOD, 2.0F, 3.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_PLANKS = reg("waxed_oak_planks", new BlockDoTB(Material.WOOD, 2.0F, 3.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_PLANKS_EDGE = reg("waxed_oak_planks_edge", new EdgeBlock(WAXED_OAK_PLANKS.get()).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_PLANKS_PLATE = reg("waxed_oak_planks_plate", new PlateBlock(WAXED_OAK_PLANKS.get()).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_PLANKS_SLAB = reg("waxed_oak_planks_slab", new SlabBlockDoTB(WAXED_OAK_PLANKS.get()).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_PLANKS_STAIRS = reg("waxed_oak_planks_stairs", new StairsBlockDoTB(WAXED_OAK_PLANKS.get()).setBurnable());
	public static final RegistryObject<Block> WAXED_OAK_CHANDELIER = reg("waxed_oak_chandelier", new WaxedOakChandelier(Material.WOOD, 2.0F, 3.0F, SoundType.WOOD));
	public static final RegistryObject<Block> WAXED_OAK_CHAIR = reg("waxed_oak_chair", new WaxedOakChairBlock(Material.WOOD, 2.0F, 2.0F, SoundType.WOOD, 11.0F));

	//Japanese
	public static final RegistryObject<Block> CHARRED_SPRUCE_LOG_STRIPPED = reg("charred_spruce_log_stripped", new RotatedPillarBlockDoTB(Material.WOOD, 2.5F, 5.0F, SoundType.WOOD).setBurnable(2, 3));
	public static final RegistryObject<Block> CHARRED_SPRUCE_PLANKS = reg("charred_spruce_planks", new BlockDoTB(Material.WOOD, 2.5F, 6.0F, SoundType.WOOD).setBurnable(2, 3));
	public static final RegistryObject<Block> CHARRED_SPRUCE_PLANKS_EDGE = reg("charred_spruce_planks_edge", new EdgeBlock(CHARRED_SPRUCE_PLANKS.get()).setBurnable(2, 3));
	public static final RegistryObject<Block> CHARRED_SPRUCE_PLANKS_PLATE = reg("charred_spruce_planks_plate", new PlateBlock(CHARRED_SPRUCE_PLANKS.get()).setBurnable(2, 3));
	public static final RegistryObject<Block> CHARRED_SPRUCE_PLANKS_SLAB = reg("charred_spruce_planks_slab", new SlabBlockDoTB(CHARRED_SPRUCE_PLANKS.get()).setBurnable(2, 3));
	public static final RegistryObject<Block> CHARRED_SPRUCE_PLANKS_STAIRS = reg("charred_spruce_planks_stairs", new StairsBlockDoTB(CHARRED_SPRUCE_PLANKS.get()).setBurnable(2, 3));
	public static final RegistryObject<Block> CHARRED_SPRUCE_BOARDS =reg("charred_spruce_boards", new BlockDoTB(Material.WOOD, 2.5F, 5.0F, SoundType.WOOD));
	public static final RegistryObject<Block> CHARRED_SPRUCE_DOOR = reg("charred_spruce_door", new DoorBlockDoTB(Material.WOOD, 1.5F, 6.0F, SoundType.WOOD));
	public static final RegistryObject<Block> CHARRED_SPRUCE_TRAPDOOR = reg("charred_spruce_trapdoor", new TrapDoorBlock(Material.WOOD, 2.0F, 3.0F, SoundType.WOOD));
	public static final RegistryObject<Block> CHARRED_SPRUCE_SHUTTERS = reg("charred_spruce_shutters", new CharredSpruceShuttersBlock(Material.WOOD, 2.0F, 2.0F, SoundType.WOOD));
	public static final RegistryObject<Block> CHARRED_SPRUCE_TALL_SHUTTERS = reg("charred_spruce_tall_shutters", new CharredSpruceTallShuttersBlock(Material.WOOD, 2.0F, 2.0F, SoundType.WOOD));
	public static final RegistryObject<Block> CHARRED_SPRUCE_FOUNDATION = reg("charred_spruce_foundation", new BlockDoTB(Material.WOOD, 2.5F, 5.0F, SoundType.WOOD).setBurnable(2, 3));
	public static final RegistryObject<Block> CHARRED_SPRUCE_FOUNDATION_SLAB = reg("charred_spruce_foundation_slab", new SlabBlockDoTB(Material.WOOD, 2.5F, 5.0F, SoundType.WOOD).setBurnable(2, 3));
	public static final RegistryObject<Block> CHARRED_SPRUCE_WALL = reg("charred_spruce_wall", new WallBlockDoTB(Material.WOOD, 2.5F, 5.0F, SoundType.WOOD).setBurnable(2, 10));
	public static final RegistryObject<Block> CHARRED_SPRUCE_FENCE = reg("charred_spruce_fence", new FenceBlockDoTB(Material.WOOD, 2.5F, 5.0F, SoundType.WOOD).setBurnable(2, 10));
	public static final RegistryObject<Block> CHARRED_SPRUCE_RAILING = reg("charred_spruce_railing", new CharredSpruceRailingBlock(Material.WOOD, 2.0F, 2.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> CHARRED_SPRUCE_PERGOLA = reg("charred_spruce_pergola", new PergolaBlock(Material.WOOD, 2.0F, 3.0F, SoundType.WOOD).setBurnable(2, 3));
	public static final RegistryObject<Block> CHARRED_SPRUCE_LATTICE = reg("charred_spruce_lattice", new LatticeBlock(Material.WOOD, 2.0F, 3.0F, SoundType.WOOD).setBurnable(2, 3));
	public static final RegistryObject<Block> CHARRED_SPRUCE_SUPPORT_SLAB = reg("charred_spruce_support_slab", new SupportSlabBlock(Material.WOOD, 1.5F, 3.0F, SoundType.WOOD).setBurnable(2, 3));
	public static final RegistryObject<Block> CHARRED_SPRUCE_SUPPORT_BEAM = reg("charred_spruce_support_beam", new SupportBeamBlock(Material.WOOD, 2.0F, 3.0F, SoundType.WOOD).setBurnable(2, 3));
	public static final RegistryObject<Block> CHARRED_SPRUCE_BEAM = reg("charred_spruce_beam", new BeamBlock(Material.WOOD, 2.0F, 3.0F, SoundType.WOOD).setBurnable(2, 3));
	public static final RegistryObject<Block> CHARRED_SPRUCE_TIMBER_FRAME = reg("charred_spruce_timber_frame", new BlockDoTB(Material.WOOD, 3.0F, 6.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> CHARRED_SPRUCE_TIMBER_FRAME_PILLAR = reg("charred_spruce_timber_frame_pillar", new RotatedPillarBlockDoTB(Material.WOOD, 3.0F, 6.0F, SoundType.WOOD).setBurnable());
	public static final RegistryObject<Block> RED_PAINTED_BEAM = reg("red_painted_beam", new BeamBlock(Material.WOOD, 2.0F, 3.0F, SoundType.WOOD).setBurnable(2, 3));
	public static final RegistryObject<Block> GRAY_ROOF_TILES = reg("gray_roof_tiles", new BlockDoTB(Material.STONE,1.5F, 5.0F, SoundType.STONE));
	public static final RegistryObject<Block> GRAY_ROOF_TILES_STAIRS = reg("gray_roof_tiles_stairs", new StairsBlockDoTB(GRAY_ROOF_TILES.get()));
	public static final RegistryObject<Block> GRAY_ROOF_TILES_PLATE = reg("gray_roof_tiles_plate", new PlateBlock(GRAY_ROOF_TILES.get()));
	public static final RegistryObject<Block> GRAY_ROOF_TILES_SLAB = reg("gray_roof_tiles_slab", new SlabBlockDoTB(GRAY_ROOF_TILES.get()));
	public static final RegistryObject<Block> GRAY_ROOF_TILES_EDGE = reg("gray_roof_tiles_edge", new EdgeBlock(GRAY_ROOF_TILES.get()));
	public static final RegistryObject<Block> GRAY_ROOF_TILES_WALL = reg("gray_roof_tiles_wall", new WallBlockDoTB(Material.STONE,1.5F, 5.0F, SoundType.STONE));
	public static final RegistryObject<Block> CHARRED_SPRUCE_ROOF_SUPPORT = reg("charred_spruce_roof_support", new MixedRoofSupportBlock((SlabBlock) GRAY_ROOF_TILES_SLAB.get(), CHARRED_SPRUCE_PLANKS.get()));
	//TODO Redo stepping stone's textures
	public static final RegistryObject<Block> STEPPING_STONES = reg("stepping_stones", new BlockDoTB(Block.Properties.of(Material.SAND, MaterialColor.STONE).strength(1.2F).sound(SoundType.GRAVEL)));
	public static final RegistryObject<Block> STEPPING_STONES_SLAB = reg("stepping_stones_slab", new SlabBlockDoTB(STEPPING_STONES.get()));
	public static final RegistryObject<Block> CAST_IRON_TEAPOT_GRAY = reg("cast_iron_teapot_gray", new CastIronTeapotBlock(Material.METAL, 0.8F, 0.8F, SoundType.METAL));
	public static final RegistryObject<Block> CAST_IRON_TEAPOT_GREEN = reg("cast_iron_teapot_green", new CastIronTeapotBlock(Material.METAL, 0.8F, 0.8F, SoundType.METAL));
	public static final RegistryObject<Block> CAST_IRON_TEAPOT_DECORATED = reg("cast_iron_teapot_decorated", new CastIronTeapotBlock(Material.METAL, 0.8F, 0.8F, SoundType.METAL));
	public static final RegistryObject<Block> CAST_IRON_TEACUP_GRAY = reg("cast_iron_teacup_gray", new CastIronTeacupBlock(Material.METAL, 0.6F, 0.6F, SoundType.METAL));
	public static final RegistryObject<Block> CAST_IRON_TEACUP_GREEN = reg("cast_iron_teacup_green", new CastIronTeacupBlock(Material.METAL, 0.6F, 0.6F, SoundType.METAL));
	public static final RegistryObject<Block> CAST_IRON_TEACUP_DECORATED = reg("cast_iron_teacup_decorated", new CastIronTeacupBlock(Material.METAL, 0.6F, 0.6F, SoundType.METAL));
	public static final RegistryObject<Block> BAMBOO_DRYING_TRAY = reg("bamboo_drying_tray", new DryerBlock(Material.WOOD, 1.0F, 1.0F, SoundType.WOOD));
	public static final RegistryObject<Block> CAMELLIA = reg("camellia", new GrowingBushBlock("camellia_seeds", PLAINS, 3));
	public static final RegistryObject<Block> MULBERRY = reg("mulberry", new MulberryBlock("mulberry", PLAINS, 3, 2, DoTBFoods.MULBERRY));
	public static final RegistryObject<Block> IKEBANA_FLOWER_POT = reg("ikebana_flower_pot", new IkebanaFlowerPotBlock(Material.CLAY, 2.0F, 2.0F, SoundType.GRAVEL));
	public static final RegistryObject<Block> SPRUCE_LOW_TABLE = reg("spruce_low_table" ,new SpruceLowTableBlock(Material.WOOD, 2.0F, 2.0F, SoundType.WOOD));
	public static final RegistryObject<Block> SPRUCE_LEGLESS_CHAIR = reg("spruce_legless_chair", new SpruceLeglessChairBlock(Material.WOOD, 2.0F, 2.0F, SoundType.WOOD, 3.0F));
	public static final RegistryObject<Block> WHITE_LITTLE_FLAG = reg("white_little_flag", new LittleFlagBlock(Material.WOOL, 0.8F, 0.8F, SoundType.WOOL));
	public static final RegistryObject<Block> PAPER_DOOR = reg("paper_door", new PaperDoorBlock(Material.WOOL, 2.0F, 2.0F, SoundType.WOOL).setBurnable());
	public static final RegistryObject<Block> PAPER_WALL = reg("paper_wall", new PaneBlockDoTB(Material.WOOL, 1.0F, 1.0F, SoundType.WOOL).setBurnable());
	public static final RegistryObject<Block> PAPER_WALL_FLAT = reg("paper_wall_flat", new PaneBlockDoTB(Material.WOOL, 1.0F, 1.0F, SoundType.WOOL).setBurnable());
	public static final RegistryObject<Block> PAPER_WALL_WINDOWS = reg("paper_wall_window", new PaneBlockDoTB(Material.WOOL, 1.0F, 1.0F, SoundType.WOOL).setBurnable());
	public static final RegistryObject<Block> PAPER_WALL_FLOWERY = reg("paper_wall_flowery", new PaneBlockDoTB(Material.WOOL, 1.0F, 1.0F, SoundType.WOOL).setBurnable());
	public static final RegistryObject<Block> PAPER_FOLDING_SCREEN = reg("paper_folding_screen", new FoldingScreenBlock(Material.WOOL, 1.0F, 1.0F, SoundType.WOOL).setBurnable());
	public static final RegistryObject<Block> RED_PAPER_LANTERN = reg("red_paper_lantern", new PaperLanternBlock(Material.WOOL, 0.5F, 0.5F, SoundType.WOOL));
	public static final RegistryObject<Block> PAPER_LAMP = reg("paper_lamp", new PaperLampBlock(Material.WOOL, 2.0F, 1.5F, SoundType.WOOL));
	public static final RegistryObject<Block> STONE_LANTERN = reg("stone_lantern", new StoneLanternBlock(Material.STONE, 4.0F, 9.0F, SoundType.STONE));
	public static final RegistryObject<Block> RICE = reg("rice", new WaterDoubleCropsBlock("rice", 2));
	public static final RegistryObject<Block> SMALL_TATAMI_MAT = reg("small_tatami_mat", new SmallTatamiMatBlock(Material.CLOTH_DECORATION, 0.6F, 0.6F, SoundType.WOOL));
	public static final RegistryObject<Block> SMALL_TATAMI_FLOOR = reg("small_tatami_floor", new SmallTatamiFloorBlock(Material.CLOTH_DECORATION, 0.6F, 0.6F, SoundType.WOOL));
	public static final RegistryObject<Block> TATAMI_MAT = reg("tatami_mat", new TatamiMatBlock(Material.CLOTH_DECORATION, 0.6F, 0.6F, SoundType.WOOL));
	public static final RegistryObject<Block> TATAMI_FLOOR = reg("tatami_floor", new TatamiFloorBlock(Material.CLOTH_DECORATION, 0.6F, 0.6F, SoundType.WOOL));
	public static final RegistryObject<Block> LIGHT_GRAY_FUTON = reg("light_gray_futon", new FutonBlock(DyeColor.GRAY, Material.WOOD, 0.2F, 0.2F, SoundType.WOOD));
	public static final RegistryObject<Block> IRORI_FIREPLACE = reg("irori_fireplace", new IroriFireplace(Material.STONE, 1.5F, 1.5F, SoundType.WOOD));
	public static final RegistryObject<Block> SAKE_BOTTLE = reg("sake_bottle", new SakeBottleBlock(Material.CLAY, 0.8F, 0.8F, SoundType.GRAVEL));
	public static final RegistryObject<Block> SAKE_CUP = reg("sake_cup", new SakeCupBlock(Material.CLAY, 0.6F, 0.6F, SoundType.GRAVEL));
	public static final RegistryObject<Block> STICK_BUNDLE = reg("stick_bundle", new StickBundleBlock(Material.WOOD, 2.0F, 3.0F, SoundType.WOOD).setBurnable());

	//Persian
	public static final RegistryObject<Block> PERSIAN_CARPET_RED = reg("persian_carpet_red", new CarpetBlockDoTB(Material.CLOTH_DECORATION, 0.1F, 0.1F, SoundType.WOOL));
	public static final RegistryObject<Block> MORAQ_MOSAIC_TILES_DELICATE = reg("moraq_mosaic_tiles_delicate", new BlockDoTB(Material.STONE, 1.0F, 1.0F, SoundType.STONE));
	public static final RegistryObject<Block> MORAQ_MOSAIC_TILES_TRADITIONAL = reg("moraq_mosaic_tiles_traditional", new BlockDoTB(Material.STONE, 1.0F, 1.0F, SoundType.STONE));
	public static final RegistryObject<Block> MORAQ_MOSAIC_TILES_BORDER = reg("moraq_mosaic_tiles_border", new BlockDoTB(Material.STONE, 1.0F, 1.0F, SoundType.STONE));

	//Pre_columbian
	public static final RegistryObject<Block> COMMELINA = reg("commelina", new SoilCropsBlock("commelina", PLAINS));
	public static final RegistryObject<Block> PLASTERED_STONE = reg("plastered_stone", new BlockDoTB(Material.STONE,1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> PLASTERED_STONE_EDGE = reg("plastered_stone_edge", new EdgeBlock(PLASTERED_STONE.get()));
	public static final RegistryObject<Block> PLASTERED_STONE_PLATE = reg("plastered_stone_plate", new PlateBlock(PLASTERED_STONE.get()));
	public static final RegistryObject<Block> PLASTERED_STONE_SLAB = reg("plastered_stone_slab", new SlabBlockDoTB(PLASTERED_STONE.get()));
	public static final RegistryObject<Block> PLASTERED_STONE_STAIRS = reg("plastered_stone_stairs", new StairsBlockDoTB(PLASTERED_STONE.get()));
	public static final RegistryObject<Block> PLASTERED_STONE_WINDOW = reg("plastered_stone_window", new PlasteredStoneWindowBlock(Material.STONE, 1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> CHISELED_PLASTERED_STONE = reg("chiseled_plastered_stone", new BlockDoTB(Material.STONE,1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> CHISELED_PLASTERED_STONE_FRIEZE = reg("chiseled_plastered_stone_frieze", new PlateBlock(CHISELED_PLASTERED_STONE.get()));
	public static final RegistryObject<Block> ORNAMENTED_CHISELED_PLASTERED_STONE = reg("ornamented_chiseled_plastered_stone", new BlockDoTB(Material.STONE,1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> RED_PLASTERED_STONE = reg("red_plastered_stone", new BlockDoTB(Material.STONE,1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> RED_CHISELED_PLASTERED_STONE = reg("red_chiseled_plastered_stone", new BlockDoTB(Material.STONE,1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> RED_ORNAMENTED_CHISELED_PLASTERED_STONE = reg("red_ornamented_chiseled_plastered_stone", new BlockDoTB(Material.STONE,1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> RED_PLASTERED_STONE_EDGE = reg("red_plastered_stone_edge", new EdgeBlock(RED_PLASTERED_STONE.get()));
	public static final RegistryObject<Block> RED_PLASTERED_STONE_FRIEZE = reg("red_plastered_stone_frieze", new PlateBlock(RED_PLASTERED_STONE.get()));
	public static final RegistryObject<Block> RED_PLASTERED_STONE_PLATE = reg("red_plastered_stone_plate", new PlateBlock(RED_PLASTERED_STONE.get()));
	public static final RegistryObject<Block> RED_PLASTERED_STONE_SLAB = reg("red_plastered_stone_slab", new SlabBlockDoTB(RED_PLASTERED_STONE.get()));
	public static final RegistryObject<Block> RED_PLASTERED_STONE_STAIRS = reg("red_plastered_stone_stairs", new StairsBlockDoTB(RED_PLASTERED_STONE.get()));
	public static final RegistryObject<Block> RED_SMALL_PLASTERED_STONE_FRIEZE = reg("red_small_plastered_stone_frieze", new EdgeBlock(RED_PLASTERED_STONE.get()));
	public static final RegistryObject<Block> RED_ORNAMENTED_PLASTERED_STONE_FRIEZE = reg("red_ornamented_plastered_stone_frieze", new PlateBlock(RED_PLASTERED_STONE.get()));
	public static final RegistryObject<Block> RED_SCULPTED_PLASTERED_STONE_FRIEZE = reg("red_sculpted_plastered_stone_frieze", new RedSculptedPlasteredStoneFriezeBlock(Material.STONE,1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> GREEN_CHISELED_PLASTERED_STONE = reg("green_chiseled_plastered_stone", new BlockDoTB(Material.STONE,1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> GREEN_ORNAMENTED_CHISELED_PLASTERED_STONE = reg("green_ornamented_chiseled_plastered_stone", new BlockDoTB(Material.STONE,1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> GREEN_ORNAMENTED_PLASTERED_STONE_FRIEZE = reg("green_ornamented_plastered_stone_frieze", new PlateBlock(PLASTERED_STONE.get()));
	public static final RegistryObject<Block> GREEN_PLASTERED_STONE_FRIEZE = reg("green_plastered_stone_frieze", new PlateBlock(PLASTERED_STONE.get()));
	public static final RegistryObject<Block> GREEN_SCULPTED_PLASTERED_STONE_FRIEZE = reg("green_sculpted_plastered_stone_frieze", new GreenSculptedPlasteredStoneFriezeBlock(Material.STONE, 1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> GREEN_SMALL_PLASTERED_STONE_FRIEZE = reg("green_small_plastered_stone_frieze", new EdgeBlock(PLASTERED_STONE.get()));
	public static final RegistryObject<Block> WILD_MAIZE = reg("wild_maize", new WildMaizeBlock(AbstractBlock.Properties.copy(DANDELION)));
	public static final RegistryObject<Block> MAIZE = reg("maize", new DoubleCropsBlock("maize", CROP, 4, DoTBFoods.MAIZE));
	public static final RegistryObject<Block> RED_ORNAMENTED_PLASTERED_STONE = reg("red_ornamented_plastered_stone", new BlockDoTB(Material.STONE, 1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> PLASTERED_STONE_COLUMN = reg("plastered_stone_column", new PlasteredStoneColumnBlock(Material.STONE, 1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> PLASTERED_STONE_CRESSET = reg("plastered_stone_cresset", new PlasteredStoneCressetBlock(Material.STONE, 1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> FEATHERED_SERPENT_SCULPTURE = reg("feathered_serpent_sculpture", new FeatheredSerpentSculptureBlock(Material.STONE, 1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> SERPENT_SCULPTED_COLUMN = reg("serpent_sculpted_column", new SerpentSculptedColumnBlock(Material.STONE, 1.5F, 6.0F, SoundType.STONE));

	//Roman
	public static final RegistryObject<Block> OCHRE_ROOF_TILES = reg("ochre_roof_tiles", new BlockDoTB(Material.STONE, 1.5F, 5.0F, SoundType.STONE));
	public static final RegistryObject<Block> OCHRE_ROOF_TILES_EDGE = reg("ochre_roof_tiles_edge", new EdgeBlock(Material.STONE, 2.0F, 3.0F, SoundType.STONE));
	public static final RegistryObject<Block> OCHRE_ROOF_TILES_PLATE = reg("ochre_roof_tiles_plate", new PlateBlock(Material.STONE, 2.0F, 3.0F, SoundType.STONE));
	public static final RegistryObject<Block> OCHRE_ROOF_TILES_STAIRS = reg("ochre_roof_tiles_stairs", new StairsBlockDoTB(OCHRE_ROOF_TILES.get()));
	public static final RegistryObject<Block> OCHRE_ROOF_TILES_WALL = reg("ochre_roof_tiles_wall", new WallBlockDoTB(Material.STONE, 1.5F, 6.0F, SoundType.STONE));
	public static final RegistryObject<Block> SANDSTONE_BOT_OCHRE_ROOF_TILES_TOP = reg("sandstone_bot_ochre_roof_tiles_top", new NoItemBlock(Material.STONE, 0.8F, 0.8F, SoundType.STONE));
	public static final RegistryObject<Block> OCHRE_ROOF_TILES_SLAB = reg("ochre_roof_tiles_slab", new MixedSlabBlock(OCHRE_ROOF_TILES.get()).addMixedBlockRecipe((SlabBlock) SANDSTONE_SLAB, SANDSTONE_BOT_OCHRE_ROOF_TILES_TOP.get(), false));
	public static final RegistryObject<Block> SANDSTONE_COLUMN = reg("sandstone_column", new SandstoneColumnBlock(Material.STONE, 0.8F, 0.8F, SoundType.STONE));
	public static final RegistryObject<Block> MOSAIC_FLOOR = reg("mosaic_floor", new BlockDoTB(Material.STONE, 1.5F, 3.0F, SoundType.STONE));
	public static final RegistryObject<Block> BIRCH_FOOTSTOOL = reg("birch_footstool", new BirchFootstool(Material.WOOD, 2.0F, 2.0F, SoundType.WOOD, 9.0F));
	public static final RegistryObject<Block> BIRCH_COUCH = reg("birch_couch", new BirchCouch(Material.WOOD, 2.0F, 2.0F, SoundType.WOOD, 13.0F));
	public static final RegistryObject<Block> WILD_GRAPE = reg("wild_grape", new WildPlantBlock(AbstractBlock.Properties.copy(DANDELION)));
	public static final RegistryObject<Block> CYPRESS = reg("cypress", new CypressBlock(Material.LEAVES, 0.2F, 0.2F, SoundType.CROP).setBurnable());

	private static RegistryObject<Block> reg(String name, Block block){
		Item item;
		String itemName = null;
		if(block instanceof IBlockCustomItem){
			item = ((IBlockCustomItem)block).getCustomItemBlock();
			itemName = ((IBlockCustomItem)block).getCustomItemName();
		}else{
			item = new BlockItem(block, new Item.Properties().tab(DOTB_TAB));
		}
		if(item != null) DoTBItemsRegistry.reg(itemName == null ? name : itemName, item);
		return BLOCKS.register(name, () -> block);
	}
}