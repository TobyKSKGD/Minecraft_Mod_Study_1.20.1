package com.besson.study.item;

import com.besson.study.StudyMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {

    // 实例化一个物品 “SHIT”
    public static final Item SHIT = registerItems("food/shit", new Item(new Item.Settings()));
    // Item.Settings() 就是物品的基本设定，默认就是 Minecraft 中的物品设定，可以自行在 Settings 中查看
    // 命名空间中使用 / 表示位置，一般命名物品时最好加上所属分类，这样方便后续查找

    public static Item registerItems(String id, Item item) {
        return registerItems(new Identifier(StudyMod.MOD_ID, id), item); // Identifier 是 Minecraft 中的命名空间
        // 如果缺失命名空间将会默认在 “minecraft” 中
        // 空间命名需要注意必须是 ASCII 码的小写的 [a-z] 或 数字 [0-9] 或 _ 或 . 或 - 或 / 其它通通为非法字符
        // 空间命名中不要出现大写字母！！！要不然就报错！！！千万注意！！！
    }

    public static Item registerItems(Identifier id, Item item) {
        return registerItems(RegistryKey.of(Registries.ITEM.getKey(), id), item); // Registries 是 Minecraft 中的注册表项
    }

    public static Item registerItems(RegistryKey<Item> key, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return (Item) Registry.register(Registries.ITEM, key, item);
    }

    // addItemToItemGroup 方法将物品添加进创造模式物品栏中
    private static void addItemToItemGroup(FabricItemGroupEntries entries){
        entries.add(SHIT);
    }

    // 初始化整个类（辅助注册方法），需要在模组的主类中调用
    public static void registerItems() {
        // 通过 modifyEntriesEvent 方法将物品添加进物品栏
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemToItemGroup);
        // ItemGroups 是 Minecraft 中的物品栏，其中有原版的各种分类
        /*
         * BUILDING_BLOCKS：建筑方块
         * COLORED_BLOCKS：染色方块
         * NATURAL：自然方块
         * FUNCTIONAL：功能方块
         * REDSTONE：红石
         * HOTBAR：快捷栏
         * SEARCH：搜索栏
         * TOOLS：工具栏
         * COMBAT：战斗相关工具
         * FOOD_AND_DRINK：食物和饮品
         * INGREDIENTS：原材料
         * SPAWN_EGGS：怪物蛋
         * OPERATOR：管理员用品
         * INVENTORY：生存模式下的物品栏
         * */
    }
}
