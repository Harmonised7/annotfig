package harmonised.annotfig.client;

import harmonised.annotfig.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber( value = Dist.CLIENT, modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE )
public class ClientHandler
{
    private static boolean isServerLocal = false;

    @SubscribeEvent
    public static void worldLoad( ClientPlayerNetworkEvent.LoggedInEvent event )
    {
        if( event.getPlayer().level.isClientSide() )
            isServerLocal = Minecraft.getInstance().isLocalServer();
    }

    public static boolean isServerLocal()
    {
        return isServerLocal;
    }
}
