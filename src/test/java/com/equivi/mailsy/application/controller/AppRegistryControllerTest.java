package com.equivi.mailsy.application.controller;

import com.equivi.mailsy.application.service.AppRegistryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class AppRegistryControllerTest {

    @Mock
    private AppRegistryService appRegistryService;

    @InjectMocks
    private AppRegistryController appRegistryController;

    private static final String appRegistryKey = "ABC-123";

    @Test
    public void testCheckRegistryKey() throws Exception {
        appRegistryController.checkRegistryKey(appRegistryKey);
        verify(appRegistryService).isApplicationExpired(appRegistryKey);
    }
}