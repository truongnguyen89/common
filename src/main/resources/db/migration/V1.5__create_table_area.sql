USE football;

DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `n_city_provincial_id` bigint(11) NOT NULL COMMENT 'id cua ban ghi tinh thanh',
  `n_county_district_id` bigint(11) COMMENT 'id cua ban ghi quan huyen',
  `n_commune_id` bigint(11) COMMENT 'id cua ban ghi phuong xa',
  `n_type` tinyint(1) NOT NULL DEFAULT '3' COMMENT '1 - Tinh/TP, 2 - Quan/Huyen, 3 - Phuong/Xa',
  `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`),
  CONSTRAINT `area_fk_1` FOREIGN KEY (`n_city_provincial_id`) REFERENCES `city_provincial` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `area_fk_2` FOREIGN KEY (`n_county_district_id`) REFERENCES `county_district` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `area_fk_3` FOREIGN KEY (`n_commune_id`) REFERENCES `commune` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

