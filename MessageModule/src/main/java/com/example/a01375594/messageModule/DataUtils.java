package com.example.a01375594.messageModule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 01375594 on 2018/5/8.
 */

public class DataUtils {

    public static List<ItemEntity> generatorData(int count) {
        List<ItemEntity> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ItemEntity itemEntity = new ItemEntity(i, "消息name" + i);
            items.add(itemEntity);
        }
        return items;
    }
}
