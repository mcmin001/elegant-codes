package com.elegant.codes.tools.common.tool.uuid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SnowFlakeUUIDgenerator extends UUIDGenerator{
    private static final Logger logger = LoggerFactory.getLogger(SnowFlakeUUIDgenerator.class);

    private SnowFlakeUUIDgenerator(){

    }

    public static SnowFlakeUUIDgenerator getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    public static String getUUID(){
        SnowFlakeUUIDgenerator var = getInstance();
        logger.info("fff");
        //System.out.println("SnowFlakeUUIDgenerator hashCode=" + var.hashCode());
        return var.genUUID();
    }


    @Override
    public String genUUID() {
        return "testUUID";
    }

    private enum Singleton{
        INSTANCE;
        private final SnowFlakeUUIDgenerator instance;

        Singleton(){
            instance = new SnowFlakeUUIDgenerator();
        }

        private SnowFlakeUUIDgenerator getInstance(){
            return instance;
        }
    }

}

