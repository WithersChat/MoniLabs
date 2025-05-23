package net.neganote.monilabs.common.block;

import com.gregtechceu.gtceu.api.block.ActiveBlock;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.client.model.generators.ModelFile;
import net.neganote.monilabs.common.machine.multiblock.PrismaticCrucibleMachine;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import org.jetbrains.annotations.NotNull;

public class PrismaticActiveBlock extends ActiveBlock {

    public static final IntegerProperty COLOR = IntegerProperty.create("prismatic_color", 0, 11);

    public PrismaticActiveBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(COLOR, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(COLOR);
    }

    public static NonNullBiConsumer<DataGenContext<Block, PrismaticActiveBlock>, RegistrateBlockstateProvider> createPrismaticActiveModel(String name,
                                                                                                                                          ResourceLocation texturePath) {
        return (ctx, prov) -> {
            ActiveBlock block = ctx.getEntry();
            ModelFile inactive = prov.models().cubeAll(texturePath.getPath(), texturePath.withPrefix("block/"));
            ModelFile active_red = prov.models().cubeAll(name + "_red",
                    texturePath.withPrefix("block/").withSuffix("_red"));
            ModelFile active_orange = prov.models().cubeAll(name + "_orange",
                    texturePath.withPrefix("block/").withSuffix("_orange"));
            ModelFile active_yellow = prov.models().cubeAll(name + "_yellow",
                    texturePath.withPrefix("block/").withSuffix("_yellow"));
            ModelFile active_lime = prov.models().cubeAll(name + "_lime",
                    texturePath.withPrefix("block/").withSuffix("_lime"));
            ModelFile active_green = prov.models().cubeAll(name + "_green",
                    texturePath.withPrefix("block/").withSuffix("_green"));
            ModelFile active_teal = prov.models().cubeAll(name + "_teal",
                    texturePath.withPrefix("block/").withSuffix("_teal"));
            ModelFile active_cyan = prov.models().cubeAll(name + "_cyan",
                    texturePath.withPrefix("block/").withSuffix("_cyan"));
            ModelFile active_azure = prov.models().cubeAll(name + "_azure",
                    texturePath.withPrefix("block/").withSuffix("_azure"));
            ModelFile active_blue = prov.models().cubeAll(name + "_blue",
                    texturePath.withPrefix("block/").withSuffix("_blue"));
            ModelFile active_indigo = prov.models().cubeAll(name + "_indigo",
                    texturePath.withPrefix("block/").withSuffix("_indigo"));
            ModelFile active_magenta = prov.models().cubeAll(name + "_magenta",
                    texturePath.withPrefix("block/").withSuffix("_magenta"));
            ModelFile active_pink = prov.models().cubeAll(name + "_pink",
                    texturePath.withPrefix("block/").withSuffix("_pink"));
            // I know this looks godawful, but it's what Spotless gives me :sadcowboy:
            prov.getVariantBuilder(block)
                    .partialState().with(ActiveBlock.ACTIVE, false).modelForState().modelFile(inactive).addModel()

                    .partialState().with(ActiveBlock.ACTIVE, true).with(COLOR, PrismaticCrucibleMachine.Color.RED.key)
                    .modelForState().modelFile(active_red).addModel()

                    .partialState().with(ActiveBlock.ACTIVE, true)
                    .with(COLOR, PrismaticCrucibleMachine.Color.ORANGE.key).modelForState().modelFile(active_orange)
                    .addModel()

                    .partialState().with(ActiveBlock.ACTIVE, true)
                    .with(COLOR, PrismaticCrucibleMachine.Color.YELLOW.key).modelForState().modelFile(active_yellow)
                    .addModel()

                    .partialState().with(ActiveBlock.ACTIVE, true).with(COLOR, PrismaticCrucibleMachine.Color.LIME.key)
                    .modelForState().modelFile(active_lime).addModel()

                    .partialState().with(ActiveBlock.ACTIVE, true).with(COLOR, PrismaticCrucibleMachine.Color.GREEN.key)
                    .modelForState().modelFile(active_green).addModel()

                    .partialState().with(ActiveBlock.ACTIVE, true).with(COLOR, PrismaticCrucibleMachine.Color.TEAL.key)
                    .modelForState().modelFile(active_teal).addModel()

                    .partialState().with(ActiveBlock.ACTIVE, true).with(COLOR, PrismaticCrucibleMachine.Color.CYAN.key)
                    .modelForState().modelFile(active_cyan).addModel()

                    .partialState().with(ActiveBlock.ACTIVE, true).with(COLOR, PrismaticCrucibleMachine.Color.AZURE.key)
                    .modelForState().modelFile(active_azure).addModel()

                    .partialState().with(ActiveBlock.ACTIVE, true).with(COLOR, PrismaticCrucibleMachine.Color.BLUE.key)
                    .modelForState().modelFile(active_blue).addModel()

                    .partialState().with(ActiveBlock.ACTIVE, true)
                    .with(COLOR, PrismaticCrucibleMachine.Color.INDIGO.key).modelForState().modelFile(active_indigo)
                    .addModel()

                    .partialState().with(ActiveBlock.ACTIVE, true)
                    .with(COLOR, PrismaticCrucibleMachine.Color.MAGENTA.key).modelForState().modelFile(active_magenta)
                    .addModel()

                    .partialState().with(ActiveBlock.ACTIVE, true).with(COLOR, PrismaticCrucibleMachine.Color.PINK.key)
                    .modelForState().modelFile(active_pink).addModel();
        };
    }

    public BlockState changeColor(BlockState state, int colorKey) {
        if (state.is(this)) {
            return state.setValue(COLOR, colorKey);
        }
        return state;
    }
}
