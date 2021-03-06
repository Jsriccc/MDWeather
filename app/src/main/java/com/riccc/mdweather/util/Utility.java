package com.riccc.mdweather.util;

import android.text.TextUtils;

import com.riccc.mdweather.db.MDWeatherDB;
import com.riccc.mdweather.model.City;
import com.riccc.mdweather.model.County;
import com.riccc.mdweather.model.Province;

/**
 * Created by Riccc on 15/10/8.
 */
public class Utility {

    public synchronized static boolean handleProvincesResponse(MDWeatherDB mdWeatherDB, String response){

        if(!TextUtils.isEmpty(response)){

            String[] allProvinces = response.split(",");
            if(allProvinces !=null && allProvinces.length>0){

                for(String p : allProvinces){

                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    mdWeatherDB.saveProvince(province);
                }

                return true;
            }

        }

        return false;
    }


    public synchronized static boolean handleCitiesResponse(MDWeatherDB mdWeatherDB, String response, int provinceId){

        if(!TextUtils.isEmpty(response)){

            String[] allCities = response.split(",");
            if(allCities !=null && allCities.length>0){

                for(String c : allCities){

                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    mdWeatherDB.saveCity(city);
                }

                return true;
            }

        }

        return false;
    }

    public synchronized static boolean handleCountiesResponse(MDWeatherDB mdWeatherDB, String response, int cityId){

        if(!TextUtils.isEmpty(response)){

            String[] allCounties = response.split(",");
            if(allCounties !=null && allCounties.length>0){

                for(String c : allCounties){

                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    mdWeatherDB.saveCounty(county);
                }

                return true;
            }

        }

        return false;
    }

}
