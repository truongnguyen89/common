USE football;

DROP TABLE IF EXISTS `booking_log`;
CREATE TABLE `booking_log` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `n_booking_id` bigint(11) NOT NULL COMMENT 'id cua ban ghi booking',
  `n_user_id` bigint(11) NOT NULL COMMENT 'id cua nguoi thuc hien khoi tao, cap nhat ban ghi booking',
  `s_reason` varchar(2000) COLLATE utf8_unicode_ci COMMENT 'ghi chu, ly do',
  `n_status_old` int(2) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi booking truoc khi thay doi',
  `n_status_new` int(2) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi booking sau khi thay doi',
  `d_created_at` datetime NOT NULL,
  PRIMARY KEY (`n_id`),
  CONSTRAINT `booking_log_booking_fk` FOREIGN KEY (`n_booking_id`) REFERENCES `booking` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `booking_log_user_fk` FOREIGN KEY (`n_user_id`) REFERENCES `user` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
