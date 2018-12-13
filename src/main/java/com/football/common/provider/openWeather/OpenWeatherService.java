package com.football.common.provider.openWeather;

import com.football.common.model.weather.WeatherInfo;
import com.football.common.model.weather.WeatherLocal;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 13-Dec-18
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public interface OpenWeatherService {

    WeatherInfo getCurrentWeatherData(long localId);

    List<WeatherInfo> get5DayWeather(long localId);

    List<WeatherLocal> getWatherLocalFromFile(File file);

}
