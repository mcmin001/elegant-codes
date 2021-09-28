package com.elegant.codes.tools.common.tool.uuid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UUIDUtil {
    private static final Logger logger = LoggerFactory.getLogger(UUIDUtil.class);

    private static final String DEFAULT_UUID_GENERATOR = "com.elegant.codes.tools.common.tool.uuid.SnowFlakeUUIDgenerator";

    private static UUIDGenerator uuidGenerator;

    public static String getUUID(String className){
        switch (className){
            case DEFAULT_UUID_GENERATOR:
                return SnowFlakeUUIDgenerator.genUUID();
            default:
                return SnowFlakeUUIDgenerator.genUUID();
        }
    }

    public static String getUUID(){
        return getUUID(DEFAULT_UUID_GENERATOR);
    }

}
