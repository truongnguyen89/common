package com.football.common.model.weather;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.football.common.constant.Constant;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 13-Dec-18
 * Time: 11:54 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = Constant.TABLE.WEATHER_INFO)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class WeatherInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "n_id")
    private Long id;
    @Column(name = "n_weather_local_id")
    private Long weatherLocalId;
    @Column(name = "n_long_time_key")
    private Long longTimeKey;
    @Column(name = "s_temp")
    private String temp;
    @Column(name = "s_temp_min")
    private String tempMin;
    @Column(name = "s_temp_max")
    private String tempMax;
    @Column(name = "s_pressure")
    private String pressure;
    @Column(name = "s_sea_level")
    private String seaLevel;
    @Column(name = "s_grnd_level")
    private String grndLevel;
    @Column(name = "s_humidity")
    private String humidity;
    @Column(name = "s_temp_kf")
    private String tempKf;
    @Column(name = "s_weather_main")
    private String weatherMain;
    @Column(name = "s_weather_description")
    private String weatherDescription;
    @Column(name = "s_weather_icon")
    private String weatherIcon;
    @Column(name = "s_clouds")
    private String clouds;
    @Column(name = "s_wind_speed")
    private String windSpeed;
    @Column(name = "s_wind_deg")
    private String windDeg;
    @Column(name = "s_rain_1h")
    private String rain1h;
    @Column(name = "s_rain_3h")
    private String rain3h;
    @Column(name = "s_sunrise")
    private String sunrise;
    @Column(name = "s_sunset")
    private String sunset;
    @Column(name = "d_created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE.FORMAT.FULL_DATE, timezone = "Asia/Ho_Chi_Minh")
    private Date createdAt;
    @Column(name = "d_updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE.FORMAT.FULL_DATE, timezone = "Asia/Ho_Chi_Minh")
    private Date updatedAt;

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWeatherLocalId() {
        return weatherLocalId;
    }

    public void setWeatherLocalId(Long weatherLocalId) {
        this.weatherLocalId = weatherLocalId;
    }

    public Long getLongTimeKey() {
        return longTimeKey;
    }

    public void setLongTimeKey(Long longTimeKey) {
        this.longTimeKey = longTimeKey;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(String seaLevel) {
        this.seaLevel = seaLevel;
    }

    public String getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(String grndLevel) {
        this.grndLevel = grndLevel;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTempKf() {
        return tempKf;
    }

    public void setTempKf(String tempKf) {
        this.tempKf = tempKf;
    }

    public String getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(String weatherMain) {
        this.weatherMain = weatherMain;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(String windDeg) {
        this.windDeg = windDeg;
    }

    public String getRain1h() {
        return rain1h;
    }

    public void setRain1h(String rain1h) {
        this.rain1h = rain1h;
    }

    public String getRain3h() {
        return rain3h;
    }

    public void setRain3h(String rain3h) {
        this.rain3h = rain3h;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
