USE football;

DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `n_user_id` bigint(11) NOT NULL COMMENT 'id cua ban ghi user, nguoi quan ly san bong',
  `s_onesignal_app_id` varchar(100) NOT NULL COMMENT 'app id tu onesignal',
  `s_onesignal_device_id` varchar(100) NOT NULL COMMENT 'player id tu onesignal',
  `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`),
  CONSTRAINT `device_user_fk` FOREIGN KEY (`n_user_id`) REFERENCES `user` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `s_title` varchar(200) NOT NULL COLLATE utf8_unicode_ci COMMENT 'tieu de thong bao',
  `s_contents` varchar(200) NOT NULL COLLATE utf8_unicode_ci COMMENT 'tieu de thong bao',
  `n_type` int(2) DEFAULT '1' COMMENT 'loai thong bao',
  `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `notification_queue`;
CREATE TABLE `notification_queue` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `n_notification_id` bigint(11) NOT NULL COMMENT 'id cua ban ghi notification',
  `n_device_id` bigint(11) NOT NULL COMMENT 'id cua ban ghi device',
  `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`),
  CONSTRAINT `notification_queue_fk` FOREIGN KEY (`n_notification_id`) REFERENCES `notification` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `notification_queue_device_fk` FOREIGN KEY (`n_device_id`) REFERENCES `device` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `notification_log`;
CREATE TABLE `notification_log` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `n_queue_id` bigint(11) NOT NULL COMMENT 'id cua ban ghi notification_queue',
  `s_onesignal_id` varchar(100) NOT NULL COMMENT 'id ban ghi notification tu onesignal sau khi gui len thanh cong',
  `n_recipients` int(2) DEFAULT '0' COMMENT 'so nguoi nhan duoc ban tin thong bao',
  `s_response_code` varchar(100) NOT NULL COMMENT 'ma loi tra ve tu Onesignal',
  `s_description` varchar(100) NOT NULL COMMENT 'mo ta loi tra ve tu Onesignal',
  `d_created_at` datetime NOT NULL,
  `n_duration` int(7) COMMENT 'so ml nhan kq tu onesignal',
  PRIMARY KEY (`n_id`),
  CONSTRAINT `notification_log_queue_fk` FOREIGN KEY (`n_queue_id`) REFERENCES `queue` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
