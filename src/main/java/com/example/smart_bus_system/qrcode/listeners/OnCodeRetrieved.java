package com.example.smart_bus_system.qrcode.listeners;

public interface OnCodeRetrieved
{
    void onSuccess(String code);
    void onFailed();
}
