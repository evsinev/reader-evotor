package com.payneteasy.evotor.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.payneteasy.android.sdk.logger.ILogger;
import com.payneteasy.android.sdk.logger.SdkLoggerFactory;
import com.payneteasy.android.sdk.util.LoggerUtil;
import com.payneteasy.evotor.driver.DriversStore;
import com.payneteasy.evotor.stubs.PaySystemDriverServiceImpl;
import com.payneteasy.evotor.stubs.VirtualDriverManagerServiceImpl;

import static ru.evotor.devices.drivers.Constants.INTENT_FILTER_DRIVER_MANAGER;
import static ru.evotor.devices.drivers.Constants.INTENT_FILTER_PAY_SYSTEM;
import static ru.evotor.devices.drivers.Constants.INTENT_FILTER_VIRTUAL_DRIVER_MANAGER;

public class DriversManagerService extends Service {

    private static final ILogger LOG = LoggerUtil.create(DriversManagerService.class);

    private final DriversStore drivers = new DriversStore();

    public DriversManagerService() {
        LOG.debug("init()");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SdkLoggerFactory.initializeRemoteLogging(getApplicationContext());
        SdkLoggerFactory.dumpCurrentSession();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LOG.debug("onBind({})", intent);

        switch (intent.getAction()) {
            case INTENT_FILTER_VIRTUAL_DRIVER_MANAGER:
                return new VirtualDriverManagerServiceImpl(drivers);

            case INTENT_FILTER_PAY_SYSTEM:
                return new PaySystemDriverServiceImpl(drivers);

            default:
                return null;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        SdkLoggerFactory.dumpCurrentSession();
    }
}
