package com.payneteasy.evotor.driver;

import android.support.annotation.NonNull;

import ru.evotor.devices.drivers.paysystem.IPaySystem;
import ru.evotor.devices.drivers.paysystem.PayInfo;
import ru.evotor.devices.drivers.paysystem.PayResult;

/**
 * For the documentation please see the
 * https://github.com/evotor/device-drivers/blob/master/app/src/main/aidl/ru/evotor/devices/drivers/IPaySystemDriverService.aidl
 *
 * // todo The driver is not implemented yet. It always returns a success payment result.
 */
public class PaySystemImpl implements IPaySystem {

    private final int id;

    public PaySystemImpl(int id) {
        this.id = id;
    }

    @Override
    public PayResult payment(PayInfo aPayInfo) {
        return createSimpleResult();
    }

    /**
     * Производит отмену оплаты на указанную сумму
     */
    @Override
    public PayResult cancelPayment(PayInfo aPayInfo, String aRrn) {
        return createSimpleResult();
    }

    /**
     * Производит возврат на указанную сумму
     */
    @Override
    public PayResult payback(PayInfo aPayInfo, String aRrn) {
        return createSimpleResult();
    }

    /**
     *  Производит отмену возврата на указанную сумму
     * @param aPayInfo
     * @param aRrn
     * @return
     */
    @Override
    public PayResult cancelPayback(PayInfo aPayInfo, String aRrn) {
        return createSimpleResult();
    }

    /**
     * Close day.
     * Производит закрытие банковской смены
     * todo close day on the host
     * @return
     */
    @Override
    public PayResult closeSession() {
        return createSimpleResult();
    }

    /**
     * Открывает на терминале сервисное меню.
     *
     * Skipping.
     */
    @Override
    public void openServiceMenu() {

    }

    @Override
    public String getBankName() {
        return "test bank";
    }

    @Override
    public int getTerminalNumber() {
        return 123;
    }

    @Override
    public String getTerminalID() {
        return "123";
    }

    @Override
    public String getMerchNumber() {
        return "merchant 123";
    }

    @Override
    public String getMerchCategoryCode() {
        return "1023";
    }

    @Override
    public String getMerchEngName() {
        return "Merchant 1";
    }

    @Override
    public String getCashier() {
        return "Cashier";
    }

    @Override
    public String getServerIP() {
        return "1.2.3.4";
    }

    @Override
    public boolean isNotNeedRRN() {
        return false;
    }

    @NonNull
    private PayResult createSimpleResult() {
        return new PayResult("719405803368", new String[]{"hello", "from the driver"});
    }


}
