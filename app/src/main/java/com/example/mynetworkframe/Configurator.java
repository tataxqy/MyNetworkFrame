package com.example.mynetworkframe;

import com.example.mynetworkframe.net.ConfigType;

import java.util.HashMap;

//配置文件的存储以及获取
public class Configurator {
    private static final HashMap<String,Object> LATTE_CONFIGS =new HashMap<>();

    private Configurator()
    {
        //name（）以字符串的方式输出出来，这是枚举类的一个方法
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);

    }

    //静态内部类单例模式的初始化,线程安全的懒汉模式
    private static  class Holder{
        private static final Configurator INSTANCE =new Configurator();
    }
    public static Configurator getInstance()
    {
        return Holder.INSTANCE;
    }


    final HashMap<String,Object> getLatteConfigs(){
        return  LATTE_CONFIGS;
    }
    //初始化完成
    final void configure(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }

    public final Configurator withApiHost(String host)
    {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;

    }

    private void checkConfiguration()
    {
        //如果配置没有完成
        final boolean isReady=(boolean)LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if(!isReady){
            throw new RuntimeException("Configuration is not ready!");
        }
    }


    @SuppressWarnings("uncheck")
    final <T> T getConfiguration(Enum<ConfigType> key)
    {
        checkConfiguration();
        return (T)LATTE_CONFIGS.get(key);
    }





}
