package Gather;

import Utilities.ItemConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class GatherItems {
    private static final ItemStackManager manager = ItemStackManager.getInstance();

    public static void InitializeOreItems() {
        manager.addItem(GatherEnum.STONE_ORE.name(), new ItemConstructor(Material.COBBLESTONE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Булыжник")
                .lore(ChatColor.GRAY + "[⭒⭒⭒⭒⭒] Материал")
                .build());

        manager.addItem(GatherEnum.COAL_ORE.name(), new ItemConstructor(Material.COAL_ORE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Угольная руда")
                .lore(ChatColor.GRAY + "[★⭒⭒⭒⭒] Материал")
                .build());

        manager.addItem(GatherEnum.IRON_ORE.name(), new ItemConstructor(Material.IRON_ORE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Железная руда")
                .lore(ChatColor.GRAY + "[★⭒⭒⭒⭒] Материал")
                .build());

        manager.addItem(GatherEnum.COPPER_ORE.name(), new ItemConstructor(Material.ORANGE_CONCRETE_POWDER)
                .amount(1)
                .displayName(ChatColor.GRAY + "Оловянная руда")
                .lore(ChatColor.GRAY + "[★⭒⭒⭒⭒] Материал")
                .build());

        manager.addItem(GatherEnum.TIN_ORE.name(), new ItemConstructor(Material.WHITE_CONCRETE_POWDER)
                .amount(1)
                .displayName(ChatColor.GRAY + "Медная руда")
                .lore(ChatColor.GRAY + "[★⭒⭒⭒⭒] Материал")
                .build());

        manager.addItem(GatherEnum.ZINC_ORE.name(), new ItemConstructor(Material.WHITE_CONCRETE_POWDER)
                .amount(1)
                .displayName(ChatColor.GRAY + "Цинковая руда")
                .lore(ChatColor.GRAY + "[★★⭒⭒⭒] Материал")
                .build());

        manager.addItem(GatherEnum.GOLD_ORE.name(), new ItemConstructor(Material.GOLD_ORE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Золотая руда")
                .lore(ChatColor.GRAY + "[★⭒⭒⭒⭒] Материал")
                .build());

        manager.addItem(GatherEnum.QUARTZ_ORE.name(), new ItemConstructor(Material.NETHER_QUARTZ_ORE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Кварцeвая руда")
                .lore(ChatColor.GRAY + "[★★⭒⭒⭒] Материал")
                .build());

        manager.addItem(GatherEnum.TITAN_ORE.name(), new ItemConstructor(Material.BLUE_STAINED_GLASS)
                .amount(1)
                .displayName(ChatColor.GRAY + "Титановая руда")
                .lore(ChatColor.GRAY + "[★★★★⭒] Материал")
                .build());

        manager.addItem(GatherEnum.PLATINUM_ORE.name(), new ItemConstructor(Material.IRON_ORE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Платинавоя руда")
                .lore(ChatColor.GRAY + "[★★★★⭒] Материал")
                .build());

        manager.addItem(GatherEnum.ETERNAL_FLAME_ORE.name(), new ItemConstructor(Material.MAGMA_BLOCK)
                .amount(1)
                .displayName(ChatColor.GRAY + "Руда вечного пламени")
                .lore(ChatColor.GRAY + "[★★★★★] Материал")
                .build());

        manager.addItem(GatherEnum.AETHERELITE_ORE.name(), new ItemConstructor(Material.SNOW_BLOCK)
                .amount(1)
                .displayName(ChatColor.GRAY + "Аезерелитовая руда")
                .lore(ChatColor.GRAY + "[★★★★★] Материал")
                .build());

        manager.addItem(GatherEnum.MITHRIL_ORE.name(), new ItemConstructor(Material.DIAMOND_ORE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Мифриловая руда")
                .lore(ChatColor.GRAY + "[★★★★★] Материал")
                .build());

        manager.addItem(GatherEnum.ADAMANTITE_ORE.name(), new ItemConstructor(Material.REDSTONE_ORE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Адамантитовая руда")
                .lore(ChatColor.GRAY + "[✬★★★★] Материал")
                .build());

        manager.addItem(GatherEnum.TENEBRIS_ORE.name(), new ItemConstructor(Material.OBSIDIAN)
                .amount(1)
                .displayName(ChatColor.GRAY + "Тенебрис")
                .lore(ChatColor.GRAY + "[✬✬★★★] Материал")
                .build());
        manager.addItem(GatherEnum.T1_FISHING_ROD.name(), new ItemConstructor(Material.FISHING_ROD)
                .amount(1)
                .displayName(ChatColor.GRAY + "Сучок")
                .lore(ChatColor.GRAY + "[⭒⭒⭒⭒⭒] Удочка", "", ChatColor.GRAY + "Скорость ловли: " + ChatColor.GOLD + "5", "", ChatColor.GRAY + "Шанс доп. улова: " + ChatColor.GOLD + "0")
                .build());

        manager.addItem(GatherEnum.T2_FISHING_ROD.name(), new ItemConstructor(Material.FISHING_ROD)
                .amount(1)
                .displayName(ChatColor.GRAY + "Старая удочка")
                .lore(ChatColor.GRAY + "[★⭒⭒⭒⭒] Удочка", "", ChatColor.GRAY + "Скорость ловли: " + ChatColor.GOLD + "10", "", ChatColor.GRAY + "Шанс доп. улова: " + ChatColor.GOLD + "0")
                .build());

        manager.addItem(GatherEnum.T3_FISHING_ROD.name(), new ItemConstructor(Material.FISHING_ROD)
                .amount(1)
                .displayName(ChatColor.GRAY + "Удочка")
                .lore(ChatColor.GRAY + "[★★⭒⭒⭒] Удочка", "", ChatColor.GRAY + "Скорость ловли: " + ChatColor.GOLD + "20", "", ChatColor.GRAY + "Шанс доп. улова: " + ChatColor.GOLD + "1")
                .build());

        manager.addItem(GatherEnum.T4_FISHING_ROD.name(), new ItemConstructor(Material.FISHING_ROD)
                .amount(1)
                .displayName(ChatColor.GRAY + "Укрепленная удочка")
                .lore(ChatColor.GRAY + "[★★★⭒⭒] Удочка", "", ChatColor.GRAY + "Скорость ловли: " + ChatColor.GOLD + "40", "", ChatColor.GRAY + "Шанс доп. улова: " + ChatColor.GOLD + "1")
                .build());

        manager.addItem(GatherEnum.T5_FISHING_ROD.name(), new ItemConstructor(Material.FISHING_ROD)
                .amount(1)
                .displayName(ChatColor.GRAY + "Сверхпрочная удочка")
                .lore(ChatColor.GRAY + "[★★★★⭒] Удочка", "", ChatColor.GRAY + "Скорость ловли: " + ChatColor.GOLD + "80", "", ChatColor.GRAY + "Шанс доп. улова: " + ChatColor.GOLD + "2")
                .build());

        manager.addItem(GatherEnum.T6_FISHING_ROD.name(), new ItemConstructor(Material.FISHING_ROD)
                .amount(1)
                .displayName(ChatColor.GRAY + "Совершеное удилище")
                .lore(ChatColor.GRAY + "[★★★★★] Удочка", "", ChatColor.GRAY + "Скорость ловли: " + ChatColor.GOLD + "160", "", ChatColor.GRAY + "Шанс доп. улова: " + ChatColor.GOLD + "2")
                .build());

        manager.addItem(GatherEnum.T1_PICKAXE.name(), new ItemConstructor(Material.WOODEN_PICKAXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Деревянная кирка")
                .lore(ChatColor.GRAY + "[⭒⭒⭒⭒⭒] Кирка", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "5", "", ChatColor.GRAY + "Фактор удачи: " + ChatColor.GOLD + "0")
                .build());

        manager.addItem(GatherEnum.T2_PICKAXE.name(), new ItemConstructor(Material.STONE_PICKAXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Каменная кирка")
                .lore(ChatColor.GRAY + "[★⭒⭒⭒⭒] Кирка", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "10", "", ChatColor.GRAY + "Фактор удачи: " + ChatColor.GOLD + "0")
                .build());

        manager.addItem(GatherEnum.T3_PICKAXE.name(), new ItemConstructor(Material.IRON_PICKAXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Железная кирка")
                .lore(ChatColor.GRAY + "[★★⭒⭒⭒] Кирка", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "20", "", ChatColor.GRAY + "Фактор удачи: " + ChatColor.GOLD + "1")
                .build());

        manager.addItem(GatherEnum.T4_PICKAXE.name(), new ItemConstructor(Material.GOLDEN_PICKAXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Золотая кирка")
                .lore(ChatColor.GRAY + "[★★★⭒⭒] Кирка", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "40", "", ChatColor.GRAY + "Фактор удачи: " + ChatColor.GOLD + "1")
                .build());

        manager.addItem(GatherEnum.T5_PICKAXE.name(), new ItemConstructor(Material.DIAMOND_PICKAXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Алмазная кирка")
                .lore(ChatColor.GRAY + "[★★★★⭒] Кирка", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "80", "", ChatColor.GRAY + "Фактор удачи: " + ChatColor.GOLD + "2")
                .build());

        manager.addItem(GatherEnum.T6_PICKAXE.name(), new ItemConstructor(Material.NETHERITE_PICKAXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Незеритовая кирка")
                .lore(ChatColor.GRAY + "[★★★★★] Кирка", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "160", "", ChatColor.GRAY + "Фактор удачи: " + ChatColor.GOLD + "2")
                .build());

        manager.addItem(GatherEnum.T1_AXE.name(), new ItemConstructor(Material.WOODEN_AXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Деревянный топор")
                .lore(ChatColor.GRAY + "[⭒⭒⭒⭒⭒] Топор", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "5", "", ChatColor.GRAY + "Шанс доп. добычи: " + ChatColor.GOLD + "0")
                .build());

        manager.addItem(GatherEnum.T2_AXE.name(), new ItemConstructor(Material.STONE_AXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Каменный топор")
                .lore(ChatColor.GRAY + "[★⭒⭒⭒⭒] Топор", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "10", "", ChatColor.GRAY + "Шанс доп. добычи: " + ChatColor.GOLD + "0")
                .build());

        manager.addItem(GatherEnum.T3_AXE.name(), new ItemConstructor(Material.IRON_AXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Железный топор")
                .lore(ChatColor.GRAY + "[★★⭒⭒⭒] Топор", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "20", "", ChatColor.GRAY + "Шанс доп. добычи: " + ChatColor.GOLD + "1")
                .build());

        manager.addItem(GatherEnum.T4_AXE.name(), new ItemConstructor(Material.GOLDEN_AXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Золотой топор")
                .lore(ChatColor.GRAY + "[★★★⭒⭒] Топор", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "40", "", ChatColor.GRAY + "Шанс доп. добычи: " + ChatColor.GOLD + "1")
                .build());

        manager.addItem(GatherEnum.T5_AXE.name(), new ItemConstructor(Material.DIAMOND_AXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Алмазный топор")
                .lore(ChatColor.GRAY + "[★★★★⭒] Топор", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "80", "", ChatColor.GRAY + "Шанс доп. добычи: " + ChatColor.GOLD + "2")
                .build());

        manager.addItem(GatherEnum.T6_AXE.name(), new ItemConstructor(Material.NETHERITE_AXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Незеритовый топор")
                .lore(ChatColor.GRAY + "[★★★★★] Топор", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "160", "", ChatColor.GRAY + "Шанс доп. добычи: " + ChatColor.GOLD + "2")
                .build());

        manager.addItem(GatherEnum.T1_HOE.name(), new ItemConstructor(Material.WOODEN_HOE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Деревянная мотыга")
                .lore(ChatColor.GRAY + "[⭒⭒⭒⭒⭒] Мотыга", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "5", "", ChatColor.GRAY + "Шанс доп. добычи: " + ChatColor.GOLD + "0")
                .build());

        manager.addItem(GatherEnum.T2_HOE.name(), new ItemConstructor(Material.STONE_HOE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Каменная мотыга")
                .lore(ChatColor.GRAY + "[★⭒⭒⭒⭒] Мотыга", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "10", "", ChatColor.GRAY + "Шанс доп. добычи: " + ChatColor.GOLD + "0")
                .build());

        manager.addItem(GatherEnum.T3_HOE.name(), new ItemConstructor(Material.IRON_HOE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Железная мотыга")
                .lore(ChatColor.GRAY + "[★★⭒⭒⭒] Мотыга", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "20", "", ChatColor.GRAY + "Шанс доп. добычи: " + ChatColor.GOLD + "1")
                .build());

        manager.addItem(GatherEnum.T4_HOE.name(), new ItemConstructor(Material.GOLDEN_HOE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Золотая мотыга")
                .lore(ChatColor.GRAY + "[★★★⭒⭒] Мотыга", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "40", "", ChatColor.GRAY + "Шанс доп. добычи: " + ChatColor.GOLD + "1")
                .build());

        manager.addItem(GatherEnum.T5_HOE.name(), new ItemConstructor(Material.DIAMOND_HOE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Алмазная мотыга")
                .lore(ChatColor.GRAY + "[★★★★⭒] Мотыга", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "80", "", ChatColor.GRAY + "Шанс доп. добычи: " + ChatColor.GOLD + "2")
                .build());

        manager.addItem(GatherEnum.T6_HOE.name(), new ItemConstructor(Material.NETHERITE_HOE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Незеритовая мотыга")
                .lore(ChatColor.GRAY + "[★★★★★] Мотыга", "", ChatColor.GRAY + "Скорость добычи: " + ChatColor.GOLD + "160", "", ChatColor.GRAY + "Шанс доп. добычи: " + ChatColor.GOLD + "2")
                .build());

        manager.addItem(GatherEnum.T1_FISHING_ROD.name(), new ItemConstructor(Material.FISHING_ROD)
                .amount(1)
                .displayName(ChatColor.GRAY + "Сучок")
                .lore(ChatColor.GRAY + "[⭒⭒⭒⭒⭒] Удочка", "", ChatColor.GRAY + "Скорость ловли: " + ChatColor.GOLD + "5", "", ChatColor.GRAY + "Шанс доп. улова: " + ChatColor.GOLD + "0")
                .build());

        manager.addItem(GatherEnum.T2_FISHING_ROD.name(), new ItemConstructor(Material.FISHING_ROD)
                .amount(1)
                .displayName(ChatColor.GRAY + "Старая удочка")
                .lore(ChatColor.GRAY + "[★⭒⭒⭒⭒] Удочка", "", ChatColor.GRAY + "Скорость ловли: " + ChatColor.GOLD + "10", "", ChatColor.GRAY + "Шанс доп. улова: " + ChatColor.GOLD + "0")
                .build());

        manager.addItem(GatherEnum.T3_FISHING_ROD.name(), new ItemConstructor(Material.FISHING_ROD)
                .amount(1)
                .displayName(ChatColor.GRAY + "Удочка")
                .lore(ChatColor.GRAY + "[★★⭒⭒⭒] Удочка", "", ChatColor.GRAY + "Скорость ловли: " + ChatColor.GOLD + "20", "", ChatColor.GRAY + "Шанс доп. улова: " + ChatColor.GOLD + "1")
                .build());

        manager.addItem(GatherEnum.T4_FISHING_ROD.name(), new ItemConstructor(Material.FISHING_ROD)
                .amount(1)
                .displayName(ChatColor.GRAY + "Укрепленная удочка")
                .lore(ChatColor.GRAY + "[★★★⭒⭒] Удочка", "", ChatColor.GRAY + "Скорость ловли: " + ChatColor.GOLD + "40", "", ChatColor.GRAY + "Шанс доп. улова: " + ChatColor.GOLD + "1")
                .build());

        manager.addItem(GatherEnum.T5_FISHING_ROD.name(), new ItemConstructor(Material.FISHING_ROD)
                .amount(1)
                .displayName(ChatColor.GRAY + "Сверхпрочная удочка")
                .lore(ChatColor.GRAY + "[★★★★⭒] Удочка", "", ChatColor.GRAY + "Скорость ловли: " + ChatColor.GOLD + "80", "", ChatColor.GRAY + "Шанс доп. улова: " + ChatColor.GOLD + "2")
                .build());

        manager.addItem(GatherEnum.T6_FISHING_ROD.name(), new ItemConstructor(Material.FISHING_ROD)
                .amount(1)
                .displayName(ChatColor.GRAY + "Совершеное удилище")
                .lore(ChatColor.GRAY + "[★★★★★] Удочка", "", ChatColor.GRAY + "Скорость ловли: " + ChatColor.GOLD + "160", "", ChatColor.GRAY + "Шанс доп. улова: " + ChatColor.GOLD + "2")
                .build());

        manager.addItem(GatherEnum.MENU_FISHING.name(), new ItemConstructor(Material.FISHING_ROD)
                .amount(1)
                .displayName(ChatColor.RED + "Рыболовство")
                .lore(ChatColor.GRAY + "[★★★★★] Меню")
                .build());

        manager.addItem(GatherEnum.MENU_MINING.name(), new ItemConstructor(Material.IRON_ORE)
                .amount(1)
                .displayName(ChatColor.RED + "Шахтерство")
                .lore(ChatColor.GRAY + "[★★★★★] Меню")
                .build());

        manager.addItem(GatherEnum.MENU_TOOLS.name(), new ItemConstructor(Material.NETHERITE_PICKAXE)
                .amount(1)
                .displayName(ChatColor.RED + "Инструменты")
                .lore(ChatColor.GRAY + "[★★★★★] Меню")
                .build());

        manager.addItem(GatherEnum.MENU_FARMING.name(), new ItemConstructor(Material.WHEAT)
                .amount(1)
                .displayName(ChatColor.RED + "Фермерство")
                .lore(ChatColor.GRAY + "[★★★★★] Меню")
                .build());

        manager.addItem(GatherEnum.MENU_LUMBER.name(), new ItemConstructor(Material.IRON_AXE)
                .amount(1)
                .displayName(ChatColor.RED + "Лесорубство")
                .lore(ChatColor.GRAY + "[★★★★★] Меню")
                .build());

        manager.addItem(GatherEnum.MENU_PROF.name(), new ItemConstructor(Material.END_ROD)
                .amount(1)
                .displayName(ChatColor.RED + "Меню Профессий")
                .lore(ChatColor.GRAY + "[★★★★★] Меню")
                .build());
// Ресы
        manager.addItem(GatherEnum.COAL.name(), new ItemConstructor(Material.COAL)
                .amount(1)
                .displayName(ChatColor.GRAY + "Уголь")
                .lore(ChatColor.GRAY + "[★⭒⭒⭒⭒] Материал")
                .build());

        manager.addItem(GatherEnum.BRASS_INGOT.name(), new ItemConstructor(Material.GOLD_INGOT)
                .amount(1)
                .displayName(ChatColor.GRAY + "Слиток Латуни")
                .lore(ChatColor.GRAY + "[★★⭒⭒⭒] Материал")
                .build());

    }
}
