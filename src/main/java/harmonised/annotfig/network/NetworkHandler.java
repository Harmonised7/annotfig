package harmonised.annotfig.network;

import harmonised.annotfig.AnnotfigMod;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.fml.network.NetworkDirection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NetworkHandler
{
    public static final Logger LOGGER = LogManager.getLogger();

    public static void registerPackets()
    {
        int index = 0;

        AnnotfigMod.HANDLER.registerMessage( index++, MessageConfig.class, MessageConfig::encode, MessageConfig::decode, MessageConfig::handlePacket ); }

    public static void sendToPlayer( MessageConfig packet, ServerPlayerEntity player )
    {
        AnnotfigMod.HANDLER.sendTo( packet, player.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT );
    }

    public static void sendToServer( MessageConfig packet )
    {
        AnnotfigMod.HANDLER.sendToServer( packet );
    }
}
