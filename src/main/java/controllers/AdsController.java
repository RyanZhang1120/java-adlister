package controllers;

import dao.DaoFactory;
import models.Ad;

public class AdsController {
    public class AdController {

        public void createAd(String title, String description, double price) {
            long userId = 1L;
            Ad ad = new Ad(title, description, price, userId);
            DaoFactory.getAdsDao().insert(ad);
        }

    }

}
