package org.dawnoftimebuilder;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.function.Supplier;

public class DoTBConfig {
    //public final static String ARMOR_MATERIAL_CATEGORY = "armor_properties";
    public final static String BLOCK_CATEGORY = "block_properties";
    public final static String WORLD_GENERATION_CATEGORY = "world_generation";
    public final static String ENTITY_CATEGORY = "entity_properties";
    public final static Config COMMON_CONFIG;
    final static ForgeConfigSpec COMMON_SPEC;
    // Armors
    /*public static ArmorConfig IRON_PLATE_ARMOR_CONFIG;
    public static ArmorConfig HOLY_ARMOR_CONFIG;
    public static ArmorConfig JAPANESE_LIGHT_ARMOR_CONFIG;
    public static ArmorConfig O_YOROI_ARMOR_CONFIG;
    public static ArmorConfig RAIJIN_ARMOR_CONFIG;
    public static ArmorConfig PHARAOH_ARMOR_CONFIG;
    public static ArmorConfig ANUBIS_ARMOR_CONFIG;
    public static ArmorConfig CENTURION_ARMOR_CONFIG;
    public static ArmorConfig QUETZALCOATL_ARMOR_CONFIG;*/
    // General
    public static ForgeConfigSpec.IntValue DRYING_TIME_VARIATION;
    public static ForgeConfigSpec.IntValue CLIMBING_PLANT_GROWTH_CHANCE;
    public static ForgeConfigSpec.IntValue CLIMBING_PLANT_SPREAD_CHANCE;
    public static ForgeConfigSpec.IntValue STICK_BUNDLE_GROWTH_CHANCE;
    public static ForgeConfigSpec.IntValue SILKMOTH_SPAWN_CHANCE;
    public static ForgeConfigSpec.IntValue SILKMOTH_ROTATION_MAX_RANGE;
    public static ForgeConfigSpec.BooleanValue SILKMOTH_MUST_DIE;
    public static ForgeConfigSpec.IntValue SILKMOTH_ROTATION_CHANGE;
    public static ForgeConfigSpec.BooleanValue SILKMOTH_MUTE;
    public static ForgeConfigSpec.IntValue JAPANESE_DRAGON_HEALTH;
    public static ForgeConfigSpec.IntValue JAPANESE_DRAGON_ATTACK;
    public static ForgeConfigSpec.BooleanValue JAPANESE_DRAGON_MUTE;

    static {
        final Pair<Config, ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(Config::new);
        COMMON_SPEC = pair.getRight();
        COMMON_CONFIG = pair.getLeft();
    }

    public final static class Config {
        Config(final ForgeConfigSpec.Builder builderIn) {

            /*builderIn.comment("----------------------------------------|| Armor settings ||---------------------------------------").push(ARMOR_MATERIAL_CATEGORY);
            IRON_PLATE_ARMOR_CONFIG = new ArmorConfig(builderIn, "iron_plate", 25, 3, 9, 7, 3, 6, 0.0D); // DIAMOND
            HOLY_ARMOR_CONFIG = new ArmorConfig(builderIn, "holy", 40, 4, 10, 8, 4, 4, 2.0D); // NETHERITE
            JAPANESE_LIGHT_ARMOR_CONFIG = new ArmorConfig(builderIn, "japanese_light", 12, 2, 7, 6, 2, 10, 0.0D); // IRON
            O_YOROI_ARMOR_CONFIG = new ArmorConfig(builderIn, "o_yoroi", 20, 3, 8, 6, 3, 16, 2.0D); // DIAMOND
            RAIJIN_ARMOR_CONFIG = new ArmorConfig(builderIn, "raijin", 35, 3, 9, 7, 3, 26, 2.0D); // NETHERITE
            CENTURION_ARMOR_CONFIG = new ArmorConfig(builderIn, "centurion", 22, 3, 7, 5, 3, 10, 3.0D); // DIAMOND
            PHARAOH_ARMOR_CONFIG = new ArmorConfig(builderIn, "pharaoh", 10, 3, 8, 6, 3, 37, 2.0D); // DIAMOND
            ANUBIS_ARMOR_CONFIG = new ArmorConfig(builderIn, "anubis", 25, 3, 8, 6, 3, 52, 3.0D); // NETHERITE
            QUETZALCOATL_ARMOR_CONFIG = new ArmorConfig(builderIn, "quetzalcoatl", 25, 2, 6, 5, 2, 20, 6.0D); // NETHERITE
            builderIn.pop();*/

            builderIn.comment("---------------------------------------|| Entity settings ||---------------------------------------").push(ENTITY_CATEGORY);
            builderIn.push("silkmoth");
            SILKMOTH_SPAWN_CHANCE = builderIn.comment("The probability to spawn a Silkmoth on a Mulberry each random tick is equal to 1/x, with x the following value :").defineInRange("silkmothSpawnChance", 400, 10, 10000);
            SILKMOTH_ROTATION_MAX_RANGE = builderIn.defineInRange("silkmothRotationMaxRange", 2, 0, 10);
            SILKMOTH_MUST_DIE = builderIn.define("silkmothDiesAfterOneDay", true);
            SILKMOTH_ROTATION_CHANGE = builderIn.comment("The probability to change the rotation point each tick is equal to 1/x, with x the following value :").defineInRange("silkmothRotationChange", 400, 10, 10000);
            SILKMOTH_MUTE = builderIn.define("silkmothMute", false);
            builderIn.pop();
            builderIn.push("japanese_dragon");
            JAPANESE_DRAGON_HEALTH = builderIn.defineInRange("japaneseDragonDefaultMaxHealth", 60, 1, 10000);
            JAPANESE_DRAGON_ATTACK = builderIn.defineInRange("japaneseDragonDefaultAttack", 4, 1, 100);
            JAPANESE_DRAGON_MUTE = builderIn.define("japaneseDragonMute", false);
            builderIn.pop();
            builderIn.pop();

            builderIn.comment("---------------------------------------|| Block settings ||----------------------------------------").push(BLOCK_CATEGORY);
            builderIn.push("dryer");
            DRYING_TIME_VARIATION = builderIn.comment("The drying time of an item is randomly set in an interval around the default time from the recipe. The following value defines the high bound of the interval in percents. IE, if you choose '20', the interval will be [ 83.3% , 120%]. If you chose '200', the interval will be [33.3% , 300%] :").defineInRange("dryingTimeVariationRange", 30, 0, 100000);
            builderIn.pop();
            builderIn.push("climbing_plant");
            CLIMBING_PLANT_GROWTH_CHANCE = builderIn.comment("The probability to grow is equal to 1/x, with x the following value :").defineInRange("climbingPlantGrowthChance", 16, 1, 200);
            CLIMBING_PLANT_SPREAD_CHANCE = builderIn.comment("If the plant could have grown (see climbingPlantGrowthChance), it has a probability to spread to an adjacent block equal to 1/x, with x the following value :").defineInRange("climbingPlantSpreadChance", 5, 1, 1000);
            builderIn.pop();
            builderIn.push("stick_bundle");
            STICK_BUNDLE_GROWTH_CHANCE = builderIn.comment("Worms have a probability to grow on random tick equal to 1/x, with x the following value :").defineInRange("stickBundleGrowthChance", 25, 1, 1000);
            builderIn.pop();
            builderIn.pop();
        }
    }

    public static class ArmorConfig {
        private final ForgeConfigSpec.IntValue durability;
        private final ForgeConfigSpec.IntValue helmetDef;
        private final ForgeConfigSpec.IntValue chestDef;
        private final ForgeConfigSpec.IntValue legsDef;
        private final ForgeConfigSpec.IntValue feetDef;
        private final ForgeConfigSpec.IntValue enchantability;
        private final ForgeConfigSpec.DoubleValue toughness;

        private ArmorConfig(final ForgeConfigSpec.Builder builderIn, String armorSet, int durability, int helmetDef, int chestDef, int legsDef, int feetDef, int enchantability, double toughness) {
            builderIn.push(armorSet);
            this.durability = builderIn.comment("DurabilityFactor is multiplied with a value that depends on the armor part (between 11 and 16) to get the total durability :").defineInRange(armorSet + "_durability_factor", durability, 1, 1000);
            this.helmetDef = builderIn.comment("Helmet damage reduction :").defineInRange(armorSet + "_defense_helmet", helmetDef, 1, 100);
            this.chestDef = builderIn.comment("Chest damage reduction :").defineInRange(armorSet + "_defense_chest", chestDef, 1, 100);
            this.legsDef = builderIn.comment("Legs damage reduction :").defineInRange(armorSet + "_defense_legs", legsDef, 1, 100);
            this.feetDef = builderIn.comment("Feet damage reduction :").defineInRange(armorSet + "_defense_feet", feetDef, 1, 100);
            this.enchantability = builderIn.comment("This armor's enchantability :").defineInRange(armorSet + "_enchantability", enchantability, 1, 100);
            this.toughness = builderIn.comment("This armor's toughness :").defineInRange(armorSet + "_toughness", toughness, 0.0D, 100.0D);
            builderIn.pop();
        }

        public Supplier<Integer> durabilitySupplier() {
            return this.durability::get;
        }

        public Supplier<Integer> helmetDefSupplier() {
            return this.helmetDef::get;
        }

        public Supplier<Integer> chestDefSupplier() {
            return this.chestDef::get;
        }

        public Supplier<Integer> legsDefSupplier() {
            return this.legsDef::get;
        }

        public Supplier<Integer> feetDefSupplier() {
            return this.feetDef::get;
        }

        public Supplier<Integer> enchantabilitySupplier() {
            return this.enchantability::get;
        }

        public Supplier<Float> toughnessSupplier() {
            return () -> this.toughness.get().floatValue();
        }
    }
}
