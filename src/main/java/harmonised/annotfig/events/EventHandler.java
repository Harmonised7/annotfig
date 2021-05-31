package harmonised.annotfig.events;

import harmonised.annotfig.config.ConfigProcessor;
import harmonised.annotfig.config.SaoConfig;
import harmonised.annotfig.util.Reference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
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
            ConfigProcessor.readConfig( SaoConfig.class );
//            ConfigProcessor.saveConfig( SaoConfig.class );
        }
    }
}