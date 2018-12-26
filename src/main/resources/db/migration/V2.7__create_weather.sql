USE football;

CREATE TABLE `weather_local` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `n_open_weather_id` bigint(11) NOT NULL COMMENT 'id cua city tu openweathermap.org',
  `s_name` varchar(100) COLLATE utf8_unicode_ci COMMENT 'ten dia danh',
  `s_country` varchar(10) COMMENT 'ma quoc gia',
  `s_longitude` varchar(50) DEFAULT '21.020093' COMMENT 'kinh do',
  `s_latitude` varchar(50) DEFAULT '105.764075' COMMENT 'vi do',
  `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `weather_info` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `n_weather_local_id` bigint(11) COMMENT 'id cua city tu openweathermap.org',
  `n_long_time_key` bigint(14) NOT NULL COMMENT 'thoi gian cua thoi tiet',
  `s_temp` varchar(50) NOT NULL COMMENT 'nhiet do hien tai',
  `s_temp_min` varchar(50) NOT NULL COMMENT 'nhiet do thap nhat',
  `s_temp_max` varchar(50) NOT NULL COMMENT 'nhiet do cao nhat',
  `s_pressure` varchar(50) COMMENT 'ap suat khi quyen(o muc nuoc bien, neu khong co du lieu sea_level hoac grnd_level), hPa',
  `s_sea_level` varchar(50) COMMENT 'ap suat khi quyen tren mat bien, hPa',
  `s_grnd_level` varchar(50) COMMENT 'ap suat khi quyen tren mat dat, hPa',
  `s_humidity` varchar(50) COMMENT 'do am %',
  `s_temp_kf` varchar(50) COMMENT 'tham so noi bo cua openweathermap.org',
  `s_weather_main` varchar(100) COMMENT 'loai thoi tiet chinh : Clouds, rain...',
  `s_weather_description` varchar(1000) COLLATE utf8_unicode_ci COMMENT 'ma ta chi tiet thoi tiet',
  `s_weather_icon` varchar(20) COMMENT 'icon thoi tien tren trang openweathermap',
  `s_clouds` varchar(50) COMMENT 'ty le % co may',
  `s_wind_speed` varchar(50) COMMENT 'toc do gio, don vi m/second',
  `s_wind_deg` varchar(10) COMMENT 'huong gio',
  `s_rain_1h` varchar(50) COMMENT 'luong mua 1h qua, don vi mm',
  `s_rain_3h` varchar(50) COMMENT 'luong mua 3h qua, don vi mm',
  `s_sunrise` varchar(5) COMMENT 'mat troi moc - binh minh',
  `s_sunset` varchar(5) COMMENT 'mat troi lan - hoang hon',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;