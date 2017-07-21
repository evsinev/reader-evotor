package com.payneteasy.evotor.driver;

import com.payneteasy.android.sdk.logger.ILogger;
import com.payneteasy.android.sdk.util.LoggerUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import ru.evotor.devices.drivers.paysystem.IPaySystem;

public class DriversStore {

    private static final ILogger LOG = LoggerUtil.create(DriversStore.class);

    private final AtomicInteger lastDeviceId = new AtomicInteger(0);
    private final Map<Integer, IPaySystem> map;

    public DriversStore() {
        this.map = new HashMap<>();
    }

    public IPaySystem find(int aId) {
        LOG.debug("find({})", aId);
        return map.get(aId);
    }

    public int createNew() {
        LOG.debug("createNew()");
        int deviceId = lastDeviceId.incrementAndGet();
        map.put(deviceId, new PaySystemImpl(deviceId));
        return deviceId;
    }

    public void open(int aDeviceId) {
        LOG.debug("open({})", aDeviceId);
        map.put(aDeviceId, new PaySystemImpl(aDeviceId));
    }

    public void remove(int aDevice) {
        LOG.debug("remove({})", aDevice);
        map.remove(aDevice);
    }
}
