package com.equivi.mailsy.application.service;

import com.equivi.mailsy.application.data.dao.AppRegistryDao;
import com.equivi.mailsy.application.data.model.AppRegistryEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AppRegistryServiceImplTest {

    @Mock
    private AppRegistryDao appRegistryDao;

    @InjectMocks
    private AppRegistryServiceImpl appRegistryService;

    private String customerName = "CUSTOMER 1";

    private String registryKey = "ABC-123456";

    @Test
    public void testIsAppExpired_AppRegistryNotFound() throws Exception {

        when(appRegistryDao.findByRegistryKey(anyString())).thenReturn(null);

        assertFalse(appRegistryService.isApplicationExpired(registryKey));
    }


    @Test
    public void testIsAppExpired_ExpiryDateBeforeToday() throws Exception {

        givenAppRegistryEntityMock(customerName, registryKey, false);

        assertFalse(appRegistryService.isApplicationExpired(registryKey));
    }

    @Test
    public void testIsAppExpired_ExpiryDateAfterToday() throws Exception {

        givenAppRegistryEntityMock(customerName, registryKey, true);

        assertTrue(appRegistryService.isApplicationExpired(registryKey));
    }

    private void givenAppRegistryEntityMock(String customerName, String registryKey, boolean isAfterExpiryDate) {
        AppRegistryEntity appRegistryEntity = new AppRegistryEntity();
        appRegistryEntity.setCustomerName(customerName);
        appRegistryEntity.setRegistryKey(registryKey);
        //Expiry Date
        Calendar calendar = Calendar.getInstance();

        if (isAfterExpiryDate) {
            calendar.add(Calendar.DATE,1);
        }

        appRegistryEntity.setExpiryDate(calendar.getTime());

        when(appRegistryDao.findByRegistryKey(anyString())).thenReturn(appRegistryEntity);
    }

}