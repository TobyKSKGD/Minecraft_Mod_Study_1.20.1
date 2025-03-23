package com.besson.study;

import com.besson.study.block.ModBlocks;
import com.besson.study.item.ModItemGroups;
import com.besson.study.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudyMod implements ModInitializer {
	public static final String MOD_ID = "study-mod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	// 模组加载
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.registerItems(); // 初始化调用模组中的注册类
		ModItemGroups.registerGroups(); // 初始化调用模组物品菜单
		ModBlocks.registerModBlocks(); // 初始化调用方块注册类
		LOGGER.info("Hello Fabric world!");
	}
}