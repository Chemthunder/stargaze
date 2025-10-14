package silly.chemthunder.stargaze.index;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import silly.chemthunder.stargaze.Stargaze;
import silly.chemthunder.stargaze.effect.EnlightenedStatusEffect;

public interface StargazeStatusEffects {
    RegistryEntry<StatusEffect> ENLIGHTENED = create("enlightened", new EnlightenedStatusEffect(StatusEffectCategory.NEUTRAL, 0xbd00d8));

    private static RegistryEntry<StatusEffect> create(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Stargaze.id(name), statusEffect);
    }

    static void init() {
    }
}
