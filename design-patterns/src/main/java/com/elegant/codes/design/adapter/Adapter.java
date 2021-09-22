package com.elegant.codes.design.adapter;

public class Adapter extends AC220V implements DC5V{
    @Override
    public int output5Voltage() {
        int output220Voltage = output220Voltage();
        int outputVoltage = 0;
        if(0!=output220Voltage){
            outputVoltage = output220Voltage / 44;
        }
        return outputVoltage;
    }
}
