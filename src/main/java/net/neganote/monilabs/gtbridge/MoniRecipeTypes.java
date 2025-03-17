package net.neganote.monilabs.gtbridge;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;
import net.neganote.monilabs.common.machine.multiblock.PrismaticCrucibleMachine.Color;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MoniRecipeTypes {
    public static final GTRecipeType PRISMATIC_CRUCIBLE_RECIPES = GTRecipeTypes
            .register("prismatic_crucible", GTRecipeTypes.MULTIBLOCK)
            .addDataInfo(data -> {
                if (data.contains("input_states")) {
                    int inputStatesCount = data.getInt("input_states");

                    if (inputStatesCount == 1) {
                        int modulus = data.getInt("input_states_0");
                        return LocalizationUtils.format("monilabs.recipe.required_color",
                                LocalizationUtils.format(Color.getColorFromKey(modulus).nameKey));

                    }
                    if (inputStatesCount == Color.COLOR_COUNT) {
                        return LocalizationUtils.format("monilabs.recipe.any_input_color");

                    }

                    return LocalizationUtils.format("monilabs.recipe.required_colors_start") +
                        IntStream.range(0, inputStatesCount)
                            .map(i -> data.getInt("output_states_" + i))
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(LocalizationUtils.format("monilabs.recipe.color_list_separator")));
                }
                // Default behavior
                return LocalizationUtils.format("monilabs.recipe.any_input_color");
            })
            .addDataInfo(data -> {
                if (data.contains("output_states")) {
                    boolean isRelative = (data.contains("color_change_relative")
                            && data.getBoolean("color_change_relative"));
                    int outputStatesCount = data.getInt("output_states");

                    if (isRelative) {
                        if (outputStatesCount == 1) {
                            int modulus = data.getInt("output_states_0");
                            return LocalizationUtils.format("monilabs.recipe.result_color_relative",
                                        String.valueOf(modulus));
                        }
                        if (outputStatesCount == Color.COLOR_COUNT) {
                            return LocalizationUtils.format("monilabs.recipe.fully_random_color");
                        }
                        return LocalizationUtils.format("monilabs.recipe.color_list_random_start_relative") +
                            IntStream.range(0, outputStatesCount)
                                .map(i -> data.getInt("output_states_" + i))
                                .mapToObj(String::valueOf)
                                .collect(Collectors.joining(LocalizationUtils.format("monilabs.recipe.color_list_separator")));

                    } else {
                        if (outputStatesCount == 1) {
                            int modulus = data.getInt("output_states_0");
                            return LocalizationUtils.format("monilabs.recipe.result_color",
                                    LocalizationUtils.format(Color.getColorFromKey(modulus).nameKey));
                        }
                        if (outputStatesCount == Color.COLOR_COUNT) {
                            return LocalizationUtils.format("monilabs.recipe.fully_random_color");
                        }
                        return LocalizationUtils.format("monilabs.recipe.color_list_random_start") +
                            IntStream.range(0, outputStatesCount)
                                .map(i -> data.getInt("output_states_" + i))
                                .mapToObj(s -> LocalizationUtils.format(Color.getColorFromKey(s).nameKey))
                                .collect(Collectors.joining(LocalizationUtils.format("monilabs.recipe.color_list_separator")));
                    }
                }
                // Default behavior
                return LocalizationUtils.format("monilabs.recipe.mistake_output_colors");
            })
            .setMaxIOSize(3, 1, 1, 0)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static void init() {
    }
}
