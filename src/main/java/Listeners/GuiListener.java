package Listeners;

import GUI.GUIEnums;
import GUI.GUIManager;
import Gather.*;
import Gather.Resources.Ore;
import Gather.Resources.Resource;
import Gather.Tools.Pickaxe;
import Gather.Tools.Tool;
import Recipes.BlastFurnaceRecipesManager;
import Utilities.ResourceConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class GuiListener extends BaseListener {
    private final HashMap<ItemStack, Inventory> itemStackInventoryHashMap = GUIManager.itemStackInventoryHashMap;
    private static final ResourceManager resourceM =  ResourceManager.getInstance();
    private static final ItemStackManager ItemStackM = ItemStackManager.getInstance();


    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getItem() == null) return;
        if (!e.getItem().equals(ItemStackManager.getInstance().getItem(GatherEnum.MENU_PROF.name()))) return;
        e.getPlayer().openInventory(itemStackInventoryHashMap.get(e.getItem()));
    }

    @EventHandler
    public void onInventoryDrag(final InventoryDragEvent e) {
        Inventory inv = e.getInventory();
        for (ItemStack item : itemStackInventoryHashMap.keySet())
            if (inv == itemStackInventoryHashMap.get(item))
                e.setCancelled(true);
    }

    @EventHandler
    public void onToolGuiClick(final InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv != itemStackInventoryHashMap.get(ItemStackManager.getInstance().getItem(GatherEnum.MENU_TOOLS.name()))) return;
        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        Player player = (Player) e.getWhoClicked();

        ArrayList<Pickaxe> pickaxesArrayList = resourceM.getPickaxesArrayList();
        for (Pickaxe pickaxe : pickaxesArrayList) {
            if (clickedItem.equals(pickaxe.getTool())) {
                player.getInventory().addItem(pickaxe.getTool());
                break;
            }
        }
        player.closeInventory();
    }

    @EventHandler
    public void onOreGuiClick(final InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv != itemStackInventoryHashMap.get(ItemStackManager.getInstance().getItem(GatherEnum.MENU_MINING.name()))) return;
        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        Player player = (Player) e.getWhoClicked();
        World world = player.getWorld();
        ArrayList<Ore> oreArrayList = resourceM.getOreArrayList();
        ArmorStand as = (ArmorStand) world.spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
        for (Ore ore : oreArrayList) {
            if (clickedItem.equals(ore.getDrop())) {
                as = new ResourceConstructor(as)
                        .setName(ChatColor.GOLD + "[T" + ore.getTier() + "] " + ore.getName())
                        .setType(ResourceConstructor.ResourceType.ORE)
                        .setMaterial(ore.getDrop())
                        .build();
                break;
            }
        }
        player.closeInventory();
    }

    @EventHandler
    public void onGatheringGuiClick(final InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv != itemStackInventoryHashMap.get(ItemStackM.getItem(GatherEnum.MENU_PROF.name()))) return;
        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        Player player = (Player) e.getWhoClicked();
        player.closeInventory();

        for (ItemStack itemStack : itemStackInventoryHashMap.keySet())
            if (clickedItem.equals(itemStack)) {
                player.openInventory(itemStackInventoryHashMap.get(itemStack));
                break;
            }
    }

    // Players:

    @EventHandler
    public void onBlastFurnaceInteract(PlayerInteractEvent e) {
        if (e.getClickedBlock() != null)
            if (e.getClickedBlock().getType().equals(Material.BLAST_FURNACE))
                if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    e.setCancelled(true);
                    e.getPlayer().openInventory(GUIManager.InitializeGUI(GUIEnums.GUIType.BLAST_FURNACE));
                }

    }

    @EventHandler
    public void onBlastFurnaceClick(InventoryClickEvent e) {
        if (e.getClickedInventory() != null)
            if (e.getView().getTitle().equals(ChatColor.RED + "Доменная печь")) {
                if (e.getCurrentItem() != null) {
                    if (e.getCurrentItem().getType().equals(Material.BLAST_FURNACE)) {
                        BlastFurnaceRecipesManager.craft(e.getView().getTopInventory(), (Player) e.getWhoClicked());
                        e.setCancelled(true);
                    }
                    if (e.getCurrentItem().getType().equals(Material.WHITE_STAINED_GLASS_PANE) || e.getCurrentItem().getType().equals(Material.YELLOW_STAINED_GLASS_PANE) || e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)  )
                        e.setCancelled(true);
                }

            }
    }
}