package harmonised.annotfig.events;

import harmonised.annotfig.AnnotfigMod;
import harmonised.annotfig.config.Configs;
import harmonised.annotfig.config.acConfig;
import harmonised.annotfig.util.Reference;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber( modid = Reference.MOD_ID )
public class EventHandler
{
    @SubscribeEvent
    public static void jumpEvent( LivingEvent.LivingJumpEvent event )
    {
        if( event.getEntityLiving() instanceof PlayerEntity )
        {
            Configs.parseConfig( "annotfig" );
//            Configs.saveConfig( "annotfig" );
        }
    }

    @SubscribeEvent
    public static void playerTickEvent( TickEvent.PlayerTickEvent event )
    {
//        System.out.println( AnnotfigMod.isLocal() + " " + AnnotfigMod.isServerLocal() );
    }

    @SubscribeEvent
    public static void worldTickEvent( TickEvent.WorldTickEvent event )
    {
//        System.out.println( AnnotfigMod.isLocal() + " " + AnnotfigMod.isServerLocal() );
    }
}