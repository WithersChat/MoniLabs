package net.neganote.monilabs.common.item;


import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.item.IComponentItem;
import com.gregtechceu.gtceu.api.item.component.ElectricStats;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import net.neganote.monilabs.MoniLabsMod;
import static net.neganote.monilabs.MoniLabsMod.REGISTRATE;

public class MoniItems {
    static {
        REGISTRATE.creativeModeTab(() -> MoniLabsMod.MONI_CREATIVE_TAB);
    }

    @SuppressWarnings("unused")
    public static ItemEntry<OmniToolItem> OMNITOOL = REGISTRATE.item("omnitool", (p) -> OmniToolItem.create(p, GTValues.IV))
            .lang("Omnitool")
            .defaultModel()
            .properties(p -> p.stacksTo(1).durability(0))
            .onRegister(attach(ElectricStats.createElectricItem(25_600_000L, GTValues.IV),
                    new PrecisionBreakBehavior(GTValues.IV)))
            .register();

    public static void init() {}

    // Copied from GTItems
    public static <T extends IComponentItem> NonNullConsumer<T> attach(IItemComponent... components) {
        return item -> item.attachComponents(components);
    }
}
