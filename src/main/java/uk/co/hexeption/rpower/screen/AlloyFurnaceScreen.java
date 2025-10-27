package uk.co.hexeption.rpower.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import uk.co.hexeption.rpower.Rpower;

public class AlloyFurnaceScreen extends AbstractContainerScreen<AlloyFurnaceMenu> {

    private static final ResourceLocation GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(Rpower.MODID, "textures/gui/alloy_furnace/alloy_furnace.png");
    private static final ResourceLocation ARROW_TEXTURE = ResourceLocation.fromNamespaceAndPath(Rpower.MODID, "textures/gui/alloy_furnace/arrow.png");
    private static final ResourceLocation FIRE_TEXTURE = ResourceLocation.fromNamespaceAndPath(Rpower.MODID, "textures/gui/alloy_furnace/fire.png");

    private final AlloyFurnaceMenu menu;

    public AlloyFurnaceScreen(AlloyFurnaceMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.menu = menu;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);

        if (menu.getBurnProgress() > 0) {
            int burningPercentage = Mth.ceil((this.menu).getBurnProgress() * 13.0F) + 1;
            guiGraphics.blit(FIRE_TEXTURE, x + 17, y + 25 + 13 - burningPercentage, 0, 13 - burningPercentage, 14, burningPercentage + 1, 50,41);
        }

    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        guiGraphics.blit(ARROW_TEXTURE, x + 107, y + 35, 0, 0, (int) (menu.getCookProgress() * 24), 17, 24, 17);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
