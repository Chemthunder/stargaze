package silly.chemthunder.stargaze.index;

import net.acoyt.acornlib.api.items.AcornItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import silly.chemthunder.stargaze.Stargaze;
import silly.chemthunder.stargaze.item.LenseItem;
import silly.chemthunder.stargaze.item.LensedSpyglassItem;

import java.util.function.Function;

public interface StargazeItems {
//    Item ROASTED_KLAPMALLOW_STICK = create("roasted_klapmallow_stick", KlapmallowItem::new, new AcornItemSettings()
//            .maxCount(1)
//            .food(new FoodComponent(5, 2.5f, true)).useRemainder(Items.STICK));

    // lenses
    Item BEFOULED_LENSE = create("befouled_lense", LenseItem::new, new AcornItemSettings()
            .maxCount(1)
    );

    Item WAYFOUND_LENSE = create("wayfound_lense", LenseItem::new, new AcornItemSettings()
            .maxCount(1)
    );

    Item REVEALING_LENSE = create("revealing_lense", LenseItem::new, new AcornItemSettings()
            .maxCount(1)
    );

    Item BEFOULED_SPYGLASS = create("befouled_spyglass", LensedSpyglassItem::new, new AcornItemSettings()
            .maxCount(1)
    );

    static Item create(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        return Items.register(RegistryKey.of(RegistryKeys.ITEM, Stargaze.id(name)), factory, settings);
    }

    static void init() {
        //   modifyItemNameColor(AMARANTHINE_CLEAVER, 0x90403e);

    }
}
