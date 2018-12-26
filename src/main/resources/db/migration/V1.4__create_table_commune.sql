USE football;

CREATE TABLE `commune` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `s_code` varchar(10) NOT NULL COMMENT 'ma phuong xa',
  `s_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'ten phuong xa',
  `n_county_district_id` bigint(11) NOT NULL COMMENT 'id cua ban ghi quan huyen',
  `s_level` varchar(10) NOT NULL DEFAULT '1' COMMENT 'Phuong, xa, thi tran',
  `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`),
  CONSTRAINT `commune_fk` FOREIGN KEY (`n_county_district_id`) REFERENCES `county_district` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

