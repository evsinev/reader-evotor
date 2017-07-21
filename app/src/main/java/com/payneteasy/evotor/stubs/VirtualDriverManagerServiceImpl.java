package com.payneteasy.evotor.stubs;

import android.os.RemoteException;

import com.payneteasy.evotor.driver.DriversStore;

import ru.evotor.devices.drivers.IVirtualDriverManagerService;

public class VirtualDriverManagerServiceImpl extends IVirtualDriverManagerService.Stub  {

    private final DriversStore drivers;

    public VirtualDriverManagerServiceImpl(DriversStore aDrivers) {
        drivers = aDrivers;
    }

    @Override
    public int addNewVirtualDevice() throws RemoteException {
        return drivers.createNew();
    }

    @Override
    public void recreateNewVirtualDevice(int aDeviceId) throws RemoteException {
        drivers.open(aDeviceId);
    }

    @Override
    public void destroy(int aDeviceId) throws RemoteException {
        drivers.remove(aDeviceId);
    }
}
