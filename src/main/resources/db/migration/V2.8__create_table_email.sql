USE football;
DROP TABLE IF EXISTS `email`;
CREATE TABLE `email` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `s_from_adress` varchar(50) NOT NULL COMMENT 'dia chi gui mail',
  `s_to_adress` varchar(100) NOT NULL COMMENT 'dia chi nhan mail',
  `s_cc_adress` varchar(100) COMMENT 'dia chi nhan mail CC',
  `s_subject` varchar(200) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Subject' COMMENT 'tieu de gui mail',
  `s_message` varchar(2000) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Message' COMMENT 'noi dung email',
  `s_file_name` varchar(300) COMMENT 'file dinh kem neu co',
  `n_type` int(2) NOT NULL DEFAULT '1' COMMENT 'loai email',
  `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
  `d_created_at` datetime NOT NULL,
  `d_updated_at` datetime,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
