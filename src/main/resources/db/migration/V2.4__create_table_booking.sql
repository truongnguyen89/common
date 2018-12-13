USE football;

DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `n_player_id` bigint(11) NOT NULL COMMENT 'id cua nguoi thue san',
  `n_match_id` bigint(11) NOT NULL COMMENT 'id cua khung gio voi sub stadium cu the',
  `d_match_day` date NOT NULL COMMENT 'ngay du kien dien ra tran dau se dat',
  `n_type` int(2) NOT NULL DEFAULT '1' COMMENT 'loai nguoi quan ly, pho hay truong, chu hay lam thue',
  `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `n_created_user_id` bigint(11) NOT NULL COMMENT 'id cua nguoi dat san, co the la nguoi thue san hoa nguoi quan ly dat giup',
  `s_comment` varchar(2000) COLLATE utf8_unicode_ci COMMENT 'ghi chu',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`),
  CONSTRAINT `booking_player_fk` FOREIGN KEY (`n_player_id`) REFERENCES `user` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `booking_match_fk` FOREIGN KEY (`n_match_id`) REFERENCES `match` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `booking_created_fk` FOREIGN KEY (`n_created_user_id`) REFERENCES `user` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
