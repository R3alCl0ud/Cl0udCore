package cl0udcore;

import java.io.File;
import java.io.IOException;

import cl0udcore.util.JSON.JSONUtils;
import cl0udcore.util.JSON.ParseException;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.*;

@Mod(modid = Cl0udCore.MODID, name = Cl0udCore.NAME, version = Cl0udCore.VERSION)
public class Cl0udCore
{

	public static final String MODID = "cl0udcore";
	public static final String NAME = "Cl0udCore";
	public static final String VERSION = "1.0.0";
	public static File ASSETS_DIR;
	
	public Cl0udCore()
	{

	}
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		
		ASSETS_DIR = new File(event.getModConfigurationDirectory(), "Cl0udCore/assets");
		
		
		if(!ASSETS_DIR.exists())
		{
			ASSETS_DIR.mkdirs();
		}
		try
		{
			testJson(ASSETS_DIR);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e)
		{
			
			e.printStackTrace();
		}

		
	}
	
	public void testJson(File put) throws IOException, ParseException
	{
		JSONUtils.updateJson(put, "testname");

	}
}
