package me.KG20.supertools.Main;

import me.KG20.supertools.proxy.ClientProxy;
import me.KG20.supertools.proxy.CommonProxy;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Constants.modid)
public class SuperTools
{

    private static CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);


    public SuperTools(){
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        proxy.construct();
    }



    @SubscribeEvent
    public void setup(FMLCommonSetupEvent event){
        proxy.setup();
    }

    @SubscribeEvent
    public void ready(FMLLoadCompleteEvent event){
        proxy.complete();
    }


}