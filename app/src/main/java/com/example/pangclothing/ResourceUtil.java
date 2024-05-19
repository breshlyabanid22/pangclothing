package com.example.pangclothing;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

public class ResourceUtil {
    private static final Map<String, Integer> resourceCache = new HashMap<>();

    public static int getResourceId(Context context, String resourceName, String resourceType) {
        String key = resourceType + "/" + resourceName;
        if (resourceCache.containsKey(key)) {
            Integer resourceId = resourceCache.get(key);
            return resourceId != null ? resourceId : getDefaultResourceId(context, resourceType);
        } else {
            int resourceId = context.getResources().getIdentifier(resourceName, resourceType, context.getPackageName());
            resourceCache.put(key, resourceId);
            return resourceId;
        }
    }

    private static int getDefaultResourceId(Context context, String resourceType) {
        switch (resourceType) {
            case "drawable":
                return R.drawable.smartphone_xyz;
            case "string":
                return R.string.empty;
            default:
                return 0;
        }
    }
}
