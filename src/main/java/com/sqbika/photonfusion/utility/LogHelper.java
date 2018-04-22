package com.sqbika.photonfusion.utility;

import com.sqbika.photonfusion.Main;
import org.apache.logging.log4j.Level;

import com.sqbika.photonfusion.reference.Reference;


public class LogHelper {
    public static void log(Level logLevel, Object object)
    {
        net.minecraftforge.fml.common.FMLLog.log(Main.MODNAME, logLevel, String.valueOf(object));
    }

    public static void all(Object object)
    {
        log(Level.ALL, object);
    }

    public static void debug(Object object)
    {
        log(Level.DEBUG, object);
    }

    public static void error(Object object)
    {
        log(Level.ERROR, object);
    }

    public static void fatal(Object object)
    {
        log(Level.FATAL, object);
    }

    public static void info(Object object)
    {
        log(Level.INFO, object);
    }

    public static void off(Object object)
    {
        log(Level.OFF, object);
    }

    public static void trace(Object object)
    {
        log(Level.TRACE, object);
    }

    public static void warn(Object object)
    {
        log(Level.WARN, object);
    }
}
