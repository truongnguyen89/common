USE football;

CREATE TABLE `city_provincial` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `s_code` varchar(10) NOT NULL COMMENT 'ma tinh thanh pho',
  `s_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'ten tinh thanh pho',
  `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

