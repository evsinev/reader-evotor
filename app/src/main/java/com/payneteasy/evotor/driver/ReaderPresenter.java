package com.payneteasy.evotor.driver;

import com.payneteasy.android.sdk.card.BankCard;
import com.payneteasy.android.sdk.processing.ConfigurationContinuation;
import com.payneteasy.android.sdk.processing.ProcessingContinuation;
import com.payneteasy.android.sdk.reader.CardError;
import com.payneteasy.android.sdk.reader.CardReaderEvent;
import com.payneteasy.android.sdk.reader.CardReaderProblem;
import com.payneteasy.android.sdk.reader.ICardReaderPresenter;

public class ReaderPresenter implements ICardReaderPresenter {

    @Override
    public void cardReaderStateChanged(CardReaderEvent cardReaderEvent) {

    }

    @Override
    public ProcessingContinuation onCard(BankCard bankCard) {
        return null;
    }

    @Override
    public void onCardError(CardError cardError) {

    }

    @Override
    public void onReaderNotSupported(CardReaderProblem cardReaderProblem) {

    }

    @Override
    public void onAudioData(short[] shorts, int i) {

    }

    @Override
    public void onReaderSerialNumber(String s) {

    }

    @Override
    public ConfigurationContinuation onConfiguration() {
        return null;
    }
}
