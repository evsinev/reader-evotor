package com.payneteasy.evotor.stubs;

import android.os.RemoteException;

import com.payneteasy.evotor.driver.DriversStore;

import ru.evotor.devices.drivers.IPaySystemDriverService;
import ru.evotor.devices.drivers.paysystem.PayInfo;
import ru.evotor.devices.drivers.paysystem.PayResult;

public class PaySystemDriverServiceImpl extends IPaySystemDriverService.Stub {

    private final DriversStore drivers;

    public PaySystemDriverServiceImpl(DriversStore aDrivers) {
        drivers = aDrivers;
    }

    @Override
    public PayResult payment(int i, PayInfo payInfo) throws RemoteException {
        return drivers.find(i).payment(payInfo);
    }

    @Override
    public PayResult cancelPayment(int i, PayInfo payInfo, String s) throws RemoteException {
        return drivers.find(i).cancelPayment(payInfo, s);
    }

    @Override
    public PayResult payback(int i, PayInfo payInfo, String s) throws RemoteException {
        return drivers.find(i).payback(payInfo, s);
    }

    @Override
    public PayResult cancelPayback(int i, PayInfo payInfo, String s) throws RemoteException {
        return drivers.find(i).cancelPayback(payInfo, s);
    }

    @Override
    public PayResult closeSession(int i) throws RemoteException {
        return drivers.find(i).closeSession();
    }

    @Override
    public void openServiceMenu(int i) throws RemoteException {
        drivers.find(i).openServiceMenu();
    }

    @Override
    public String getBankName(int i) throws RemoteException {
        return drivers.find(i).getBankName();
    }

    @Override
    public int getTerminalNumber(int i) throws RemoteException {
        return drivers.find(i).getTerminalNumber();
    }

    @Override
    public String getTerminalID(int i) throws RemoteException {
        return drivers.find(i).getTerminalID();
    }

    @Override
    public String getMerchNumber(int i) throws RemoteException {
        return drivers.find(i).getMerchNumber();
    }

    @Override
    public String getMerchCategoryCode(int i) throws RemoteException {
        return drivers.find(i).getMerchCategoryCode();
    }

    @Override
    public String getMerchEngName(int i) throws RemoteException {
        return drivers.find(i).getMerchEngName();
    }

    @Override
    public String getCashier(int i) throws RemoteException {
        return drivers.find(i).getCashier();
    }

    @Override
    public String getServerIP(int i) throws RemoteException {
        return drivers.find(i).getServerIP();
    }

    @Override
    public boolean isNotNeedRRN(int i) throws RemoteException {
        return drivers.find(i).isNotNeedRRN();
    }
}
