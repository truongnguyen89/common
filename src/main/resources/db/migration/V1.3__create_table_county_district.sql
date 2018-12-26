USE football;

CREATE TABLE `county_district` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `s_code` varchar(10) NOT NULL COMMENT 'ma quan huyen',
  `s_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'ten quan huyen',
  `n_city_provincial_id` bigint(11) NOT NULL COMMENT 'id cua ban ghi tinh thanh pho',
  `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`),
  CONSTRAINT `county_district_fk` FOREIGN KEY (`n_city_provincial_id`) REFERENCES `city_provincial` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

