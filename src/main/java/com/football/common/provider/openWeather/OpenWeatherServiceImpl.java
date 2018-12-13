package com.football.common.provider.openWeather;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.football.common.constant.Constant;
import com.football.common.file.FileCommon;
import com.football.common.message.MessageCommon;
import com.football.common.model.weather.WeatherInfo;
import com.football.common.model.weather.WeatherLocal;
import com.football.common.util.DateCommon;
import com.football.common.util.JsonCommon;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 13-Dec-18
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OpenWeatherServiceImpl implements OpenWeatherService {

    String url = "https://api.openweathermap.org/data/2.5/forecast?id={0}&appid={1}&units=metric&lang=vi";
    String apiKey = "9837f9ff93fe008f7a60f907606e5d78";
    int timeOut = 10000;
    int timeOutConnect = 10000;

//    String url = Cache.getValueParamFromCache(Constant.PARAMS.TYPE.OPEN_WEATHER, Constant.PARAMS.CODE.URL);
//    String apiKey = Cache.getValueParamFromCache(Constant.PARAMS.TYPE.OPEN_WEATHER, Constant.PARAMS.CODE.API_KEY);
//    int timeOut = Cache.getIntParamFromCache(Constant.PARAMS.TYPE.OPEN_WEATHER, Constant.PARAMS.CODE.TIME_OUT, 60000);
//    int timeOutConnect = Cache.getIntParamFromCache(Constant.PARAMS.TYPE.OPEN_WEATHER, Constant.PARAMS.CODE.CONNECTION_TIME_OUT, 60000);

    @Override
    public WeatherInfo getCurrentWeatherData(long localId) {
        return null;
    }

    @Override
    public List<WeatherInfo> get5DayWeather(long localId) {
        List<WeatherInfo> weatherInfoList = new ArrayList<>();
        HttpURLConnection connection = null;
        String[] params = {localId + "", apiKey};
        String realUrl = MessageCommon.getMessage(url, params);
        StringBuffer jsonString = new StringBuffer();
        try {
            URL obj = new URL(realUrl);
            connection = (HttpURLConnection) obj.openConnection();
            connection.setConnectTimeout(timeOutConnect);
            connection.setReadTimeout(timeOut);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod(RequestMethod.GET.name());
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }
            br.close();
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readValue(jsonString.toString(), JsonNode.class);
            try {
                int returnCode = jsonNode.get("cod").asInt();
                if (returnCode != HttpStatus.OK.value())
                    return weatherInfoList;
                else {
                    JsonNode nodeList = jsonNode.get("list");
                    if (nodeList != null && nodeList instanceof ArrayNode) {
                        for (JsonNode nd : nodeList) {
                            weatherInfoList.add(getWeatherInfoFromJson(localId, nd));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherInfoList;
    }

    public WeatherInfo getWeatherInfoFromJson(long localId, JsonNode nd) {
        WeatherInfo weatherInfo = new WeatherInfo();
        try {
            weatherInfo.setWeatherLocalId(localId);
            weatherInfo.setCreatedAt(DateCommon.convertStringToDateByPattern(nd.get("dt_txt").asText(), "yyyy-MM-dd HH:mm:ss"));
            weatherInfo.setLongTimeKey(weatherInfo.getCreatedAt().getTime());
            JsonNode nodeMain = nd.get("main");
            weatherInfo.setTemp(nodeMain.get("temp").asText());
            weatherInfo.setTempMin(nodeMain.get("temp_min").asText());
            weatherInfo.setTempMax(nodeMain.get("temp_max").asText());
            weatherInfo.setTempKf(nodeMain.get("temp_kf").asText());
            weatherInfo.setPressure(nodeMain.get("pressure").asText());
            weatherInfo.setSeaLevel(nodeMain.get("sea_level").asText());
            weatherInfo.setGrndLevel(nodeMain.get("grnd_level").asText());
            weatherInfo.setHumidity(nodeMain.get("humidity").asText());

            JsonNode weather = nd.get("weather");
            if (weather != null && weather instanceof ArrayNode) {
                for (JsonNode subWeatherInfo : weather) {
                    weatherInfo.setWeatherMain(subWeatherInfo.get("main").asText());
                    weatherInfo.setWeatherDescription(subWeatherInfo.get("description").asText());
                    weatherInfo.setWeatherIcon(subWeatherInfo.get("icon").asText());
                    break;
                }
            }

            JsonNode clouds = nd.get("weather");
            if (clouds != null)
                weatherInfo.setClouds(clouds.get("all") != null ? clouds.get("all").asText() : "");

            JsonNode wind = nd.get("wind");
            if (wind != null) {
                weatherInfo.setWindSpeed(wind.get("speed") != null ? wind.get("speed").asText() : "");
                weatherInfo.setWindDeg(wind.get("deg") != null ? wind.get("deg").asText() : "");
            }
            JsonNode rain = nd.get("rain");
            if (rain != null) {
                weatherInfo.setRain1h(rain.get("1h") != null ? rain.get("1h").asText() : "");
                weatherInfo.setRain3h(rain.get("3h") != null ? rain.get("3h").asText() : "");
            }

            JsonNode sys = nd.get("sys");
            if (sys != null) {
                weatherInfo.setSunrise(sys.get("sunrise") != null ? sys.get("sunrise").asText() : "");
                weatherInfo.setSunset(sys.get("sunset") != null ? sys.get("sunset").asText() : "");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return weatherInfo;
    }

    public static void main(String[] args) {
        System.out.println(JsonCommon.objectToJsonLog(new OpenWeatherServiceImpl().get5DayWeather(1581129)));
    }

    @Override
    public List<WeatherLocal> getWatherLocalFromFile(File file) {
        List<WeatherLocal> weatherLocalList = new ArrayList<>();
        try {
            StringBuffer cityListJson = FileCommon.readStringBufferFromTextFile(file);
            if (cityListJson != null) {
                ObjectMapper om = new ObjectMapper();
                JsonNode nodeList = (JsonNode) om.readValue(cityListJson.toString(), JsonNode.class);
                if (nodeList != null && nodeList instanceof ArrayNode) {
                    for (JsonNode nd : nodeList) {
                        if (!"VN".equals(nd.get("country").asText()))
                            continue;
                        weatherLocalList.add(getWeatherLocalFromJson(nd));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return weatherLocalList;
    }

    public WeatherLocal getWeatherLocalFromJson(JsonNode nd) {
        WeatherLocal weatherLocal = new WeatherLocal();
        try {
            weatherLocal.setOpenWeatherId(nd.get("id").longValue());
            weatherLocal.setName(nd.get("name").asText());
            weatherLocal.setCountry(nd.get("country").asText());
            weatherLocal.setLatitude(nd.get("coord").get("lat").asText());
            weatherLocal.setLongitude(nd.get("coord").get("lon").asText());
            if ("VN".equals(weatherLocal.getCountry()))
                weatherLocal.setStatus(Constant.STATUS_OBJECT.ACTIVE);
            else
                weatherLocal.setStatus(Constant.STATUS_OBJECT.INACTIVE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weatherLocal;
    }
}
