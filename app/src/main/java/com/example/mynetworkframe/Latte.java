package com.example.mynetworkframe;

import android.app.Application;
import android.content.Context;

import com.example.mynetworkframe.net.ConfigType;

import java.util.HashMap;
import java.util.logging.Handler;

import static com.example.mynetworkframe.net.ConfigType.APPLICATION_CONTEXT;


//对外的工具类
public final class Latte {


    //把对象的引用转到配置项
    public static Configurator init(Context context) {
        getConfiguration().put(APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static HashMap<String, Object> getConfiguration() {
        return Configurator.getInstance().getLatteConfigs();
    }



    public static void test(){
    }
}
