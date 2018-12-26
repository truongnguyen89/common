USE football;

CREATE TABLE `params` (
    `s_type` VARCHAR(200) NOT NULL COMMENT 'loai tham so',
    `s_code` VARCHAR(200) NOT NULL DEFAULT '1' COMMENT 'ma tham so',
    `s_name` VARCHAR(2000) COLLATE UTF8_UNICODE_CI DEFAULT 'Ten tham so' COMMENT 'ten tham so',
    `s_value` VARCHAR(3000) COLLATE UTF8_UNICODE_CI NOT NULL DEFAULT '1' COMMENT 'gia tri tham so',
    `n_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'trang thai ban ghi',
    `d_created_at` DATETIME NOT NULL,
    `d_updated_at` DATETIME,
    CONSTRAINT params_uq UNIQUE (s_type , s_code)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8 COLLATE = UTF8_UNICODE_CI;
