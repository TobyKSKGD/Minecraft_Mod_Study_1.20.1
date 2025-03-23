package com.besson.study.item;

import com.besson.study.StudyMod;
import com.besson.study.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    // 定义一个新的物品栏，其注册键是 study_group
    public static final RegistryKey<ItemGroup> STUDY_GROUP = register("study_group");
    // RegistryKey<ItemGroup> 作用是为 Minecraft 注册一个新的创造模式物品栏

    // register 创建一个物品栏的注册键（RegistryKey<ItemGroup>）
    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(StudyMod.MOD_ID, id));
    }

    // registerGroups 方法正式注册创造模式的物品栏
    public static void registerGroups(){
        Registry.register(
                Registries.ITEM_GROUP, // 注册到物品栏注册表
                STUDY_GROUP, // 物品栏的注册键
                ItemGroup.create(ItemGroup.Row.TOP, 7) // 创建物品栏
                        // 物品栏在创造模式 GUI 中的第一行（有 TOP、MIDDLE、BOTTOM）
                        .displayName(Text.translatable("itemGroup.study_group")) // 设置物品栏的名字，对应 lang 中的 itemGroup.study_group
                        .icon(() -> new ItemStack(ModItems.SHIT)) // 设置物品栏的图标，比如这里指定 SHIT 为物品栏图标
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.SHIT); // 将 SHIT 物品加入这个物品栏
                            entries.add(ModBlocks.SHIT_BLOCK); // 将 SHIT_BLOCK 物品加入这个物品栏
                        }).build());
    }
}
