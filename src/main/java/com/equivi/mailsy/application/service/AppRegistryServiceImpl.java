package com.equivi.mailsy.application.service;

import com.equivi.mailsy.application.data.dao.AppRegistryDao;
import com.equivi.mailsy.application.data.model.AppRegistryEntity;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AppRegistryServiceImpl implements AppRegistryService {

    @Autowired
    private AppRegistryDao appRegistryDao;


    public boolean isApplicationExpired(String appRegistryKey) {

        AppRegistryEntity appRegistryEntity = appRegistryDao.findByRegistryKey(appRegistryKey);

        if (appRegistryEntity == null) {
            return false;
        }

        DateTime expiryDate = new DateTime(appRegistryEntity.getExpiryDate());
        DateTime todayDate = new DateTime(new Date());
        return isExpiryDate(expiryDate, todayDate);
    }

    private boolean isExpiryDate(DateTime expiryDate, DateTime todayDate) {
        return DateTimeComparator.getDateOnlyInstance().compare(expiryDate, todayDate) == 1;
    }
}
