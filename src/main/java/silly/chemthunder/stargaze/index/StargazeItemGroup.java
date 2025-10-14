package silly.chemthunder.stargaze.index;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import silly.chemthunder.stargaze.Stargaze;

public interface StargazeItemGroup{
    RegistryKey<ItemGroup> GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, Stargaze.id("stargaze"));
    ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.SPYGLASS))
            .displayName(Text.translatable("itemGroup.stargaze").styled(style -> style.withColor(0xbd00d8)))
            .build();

    static void init() {
        Registry.register(Registries.ITEM_GROUP, GROUP_KEY, ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(GROUP_KEY).register(StargazeItemGroup::addEntries);
    }

    private static void addEntries(FabricItemGroupEntries itemGroup) {
       // itemGroup.add(BulwarkBlocks.DISRUPTER);
        itemGroup.add(StargazeItems.BEFOULED_LENSE);
        itemGroup.add(StargazeItems.REVEALING_LENSE);
        itemGroup.add(StargazeItems.WAYFOUND_LENSE);
    }
}
