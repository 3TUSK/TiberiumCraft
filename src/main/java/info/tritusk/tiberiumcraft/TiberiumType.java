package info.tritusk.tiberiumcraft;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum TiberiumType implements IStringSerializable {
    RED, BLUE, GREEN;

    public static final TiberiumType[] VALUES = values();

    private final String serializedForm = this.name().toLowerCase(Locale.ENGLISH);

    @Override
    public String getName() {
        return serializedForm;
    }
}
