package com.besson.study.block;

import com.besson.study.StudyMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    // 注册一个 SHIT_BLOCK 方块
    public static final Block SHIT_BLOCK = register("shit_block", new Block(AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK)));

    // 注册方块实体方法
    public static Block register(String id, Block block) {
        registerBlockItems(id, block); // 在注册方块实体的同时顺便注册方块物品
        return Registry.register(Registries.BLOCK, new Identifier(StudyMod.MOD_ID, id), block);
    }

    // 物品栏中的方块物品注册方法
    public static void registerBlockItems(String id, Block block){
        Registry.register(Registries.ITEM,
                new Identifier(StudyMod.MOD_ID, id),
                new BlockItem(block, new Item.Settings()));
    }

    // 辅助注册方法
    public static void registerModBlocks(){

    }
}
