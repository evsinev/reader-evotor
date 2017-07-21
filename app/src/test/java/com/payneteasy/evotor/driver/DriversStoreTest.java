package com.payneteasy.evotor.driver;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DriversStoreTest {
    @Test
    public void createNew() throws Exception {
        DriversStore store = new DriversStore();
        int id = store.createNew();
        Assert.assertEquals(1, id);
        store.remove(id);
    }

}