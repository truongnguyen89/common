USE football;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `s_code` varchar(50) NOT NULL COMMENT 'ma role',
  `s_name` varchar(100) NOT NULL COMMENT 'ten role',
  `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `s_email` varchar(100) COMMENT 'email',
  `s_password` varchar(100) COMMENT 'mat khau',
  `s_name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'ten hien thi',
  `s_phone` varchar(50) DEFAULT '0987654321' COMMENT 'SDT',
  `s_address` varchar(200) COLLATE utf8_unicode_ci COMMENT 'dia chi',
  `n_type` int(2) DEFAULT '1' COMMENT 'loai tai khoan',
  `n_status` tinyint(1) DEFAULT '1' COMMENT 'trang thai ban ghi',
  `b_email_verified` bit(1) COMMENT 'trang thai kich hoat email, tai khoan',
  `s_image_url` varchar(255) COMMENT 'Link avatar',
  `s_provider`  varchar(25) COMMENT 'nguon tai khoan, local hay google, hay facebook...',
  `s_provider_id`  varchar(255) COMMENT 'ID cua tai khoan tren provider',
  `d_created_at` datetime,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `n_user_id` bigint(11) COMMENT 'id cua ban ghi user, nguoi quan ly san bong',
  `n_role_id` bigint(11) COMMENT 'id cua ban ghi role',
  `s_name` varchar(100) NOT NULL COMMENT 'ten role',
  `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`),
  CONSTRAINT `user_role_user_fk` FOREIGN KEY (`n_user_id`) REFERENCES `user` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_role_role_fk` FOREIGN KEY (`n_role_id`) REFERENCES `role` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `group_role`;
CREATE TABLE `group_role` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `s_code` varchar(50) NOT NULL COMMENT 'ma group role',
  `s_name` varchar(100) NOT NULL COMMENT 'ten group role',
  `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `group_role_map`;
CREATE TABLE `group_role_map` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `n_group_role_id` bigint(11) COMMENT 'id cua ban ghi group_role',
  `n_role_id` bigint(11) COMMENT 'id cua ban ghi role',
  `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`),
  CONSTRAINT `map_group_role_fk` FOREIGN KEY (`n_group_role_id`) REFERENCES `group_role` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `map_role_fk` FOREIGN KEY (`n_role_id`) REFERENCES `role` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `user_group_role`;
CREATE TABLE `user_group_role` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `n_user_id` bigint(11) COMMENT 'id cua ban ghi user, nguoi quan ly san bong',
  `n_group_role_id` bigint(11) COMMENT 'id cua ban ghi group_role',
  `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`),
  CONSTRAINT `user_group_role_user_fk` FOREIGN KEY (`n_user_id`) REFERENCES `user` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_group_role_fk` FOREIGN KEY (`n_group_role_id`) REFERENCES `group_role` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `n_user_id` bigint(11) NOT NULL COMMENT 'id cua ban ghi user',
  `s_token` varchar(2000) NOT NULL COMMENT 'token sau khi login',
  `n_type` int(2) DEFAULT '1' COMMENT 'loai token',
  `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_expiration_at` datetime NOT NULL COMMENT 'thoi gian het han cua token',
  `d_created_at` datetime NOT NULL COMMENT 'thoi gian tao ban ghi',
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`),
  CONSTRAINT `token_user_fk` FOREIGN KEY (`n_user_id`) REFERENCES `user` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
