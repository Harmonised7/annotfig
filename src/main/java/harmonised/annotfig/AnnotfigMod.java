package harmonised.annotfig;

import harmonised.annotfig.client.ClientHandler;
import harmonised.annotfig.config.ConfigEntry;
import harmonised.annotfig.config.Configs;
import harmonised.annotfig.config.acConfig;
import harmonised.annotfig.events.EventHandler;
import harmonised.annotfig.network.NetworkHandler;
import harmonised.annotfig.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod( Reference.MOD_ID )
public class AnnotfigMod
{
    private static boolean isLocal = false;

    private static final String PROTOCOL_VERSION = "1";
    private static final Logger LOGGER = LogManager.getLogger();

    public static SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder
            .named( new ResourceLocation( Reference.MOD_ID, "main_channel" ) )
            .clientAcceptedVersions( PROTOCOL_VERSION::equals )
            .serverAcceptedVersions( PROTOCOL_VERSION::equals )
            .networkProtocolVersion( () -> PROTOCOL_VERSION )
            .simpleChannel();


    public AnnotfigMod()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener( this::modsLoading );
        FMLJavaModLoadingContext.get().getModEventBus().addListener( this::clientLoading );
        Configs.register( Reference.MOD_ID, acConfig.class );
    }

    private void modsLoading( FMLCommonSetupEvent event )
    {
        NetworkHandler.registerPackets();
        MinecraftForge.EVENT_BUS.register( EventHandler.class );
    }

    private void clientLoading( FMLClientSetupEvent event )
    {
        isLocal = true;
    }

    public static boolean isLocal()
    {
        return isLocal;
    }

    public static boolean isServerLocal()
    {
        return ClientHandler.isServerLocal();
    }
}
