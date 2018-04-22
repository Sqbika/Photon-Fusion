package com.sqbika.photonfusion.utility;

import com.sqbika.photonfusion.reference.Reference;
import net.minecraft.util.ResourceLocation;

public class ResourceLocationHelper {
    public static ResourceLocation ToResourceLocation(String name) {
        return new ResourceLocation(name);
    }

    public static ResourceLocation[] ToResourceLocation(String... names) {
        ResourceLocation[] result = new ResourceLocation[names.length];
        for (int i = 0; i < names.length; i++) {
            result[i] = ToResourceLocation(names[i]);
        }
        return result;
    }
}
