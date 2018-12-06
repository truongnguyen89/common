/*---user---*/
INSERT INTO user (`s_username`, `s_password`, `s_name`, `s_email`, `s_phone`, `s_address`, `n_type`, `n_status`, `d_created_at`)
VALUES ('truongnq', '123456', 'Nguyễn Quang Trường', 'truongnq@gmail.com', '0962266682', 'Hà Nội', '1', '1', sysdate());
INSERT INTO user (`s_username`, `s_password`, `s_name`, `s_email`, `s_phone`, `s_address`, `n_type`, `n_status`, `d_created_at`)
VALUES ('truongnq2', '123456', 'Nguyễn Quang Trường 2', 'truongnq2@gmail.com', '0962266682', 'Hà Nội', '1', '1', sysdate());
INSERT INTO user (`s_username`, `s_password`, `s_name`, `s_email`, `s_phone`, `s_address`, `n_type`, `n_status`, `d_created_at`)
VALUES ('truongnq3', '123456', 'Nguyễn Quang Trường 3', 'truongnq3@gmail.com', '0962266682', 'Hà Nội', '1', '1', sysdate());
INSERT INTO user (`s_username`, `s_password`, `s_name`, `s_email`, `s_phone`, `s_address`, `n_type`, `n_status`, `d_created_at`)
VALUES ('truongnq4', '123456', 'Nguyễn Quang Trường 4', 'truongnq4@gmail.com', '0962266682', 'Hà Nội', '1', '1', sysdate());
/*---params---*/
INSERT INTO `params`
(`s_type`,
`s_code`,
`s_name`,
`s_value`,
`n_status`,
`d_created_at`)
VALUES
('TYPE',
'CODE',
'NAME',
'1',
1,
sysdate());

/*---stadium---*/
INSERT INTO `stadium` (`s_name`,`s_address`,`s_email`,`s_phone`,`s_longitude`,`s_latitude`,`n_count_sub_stadium`,`n_type`,`n_status`,`d_created_at`,`d_updated_at`)
VALUES ('Sân bóng Thành Phát','Hoàng Minh Giám','thanhphat@gmail.com','0989666777','21.898989','105.787878',4,1,1,sysdate(),NULL);
INSERT INTO `stadium` (`s_name`,`s_address`,`s_email`,`s_phone`,`s_longitude`,`s_latitude`,`n_count_sub_stadium`,`n_type`,`n_status`,`d_created_at`,`d_updated_at`)
VALUES ('Sân bóng Thuỷ Lợi','Đại Học Thuỷ Lợi','thuyloi@gmail.com','0989666777','21.898989','105.787878',4,1,1,sysdate(),NULL);
INSERT INTO `stadium` (`s_name`,`s_address`,`s_email`,`s_phone`,`s_longitude`,`s_latitude`,`n_count_sub_stadium`,`n_type`,`n_status`,`d_created_at`,`d_updated_at`)
VALUES ('Sân bóng Định Công','Định Công','dinhcong@gmail.com','0989666777','21.898989','105.787878',4,1,1,sysdate(),NULL);
INSERT INTO `stadium` (`s_name`,`s_address`,`s_email`,`s_phone`,`s_longitude`,`s_latitude`,`n_count_sub_stadium`,`n_type`,`n_status`,`d_created_at`,`d_updated_at`)
VALUES ('Sân bóng Hai Bà Trưng','Hai Bà Trưng','haibatrung@gmail.com','0989666777','21.898989','105.787878',4,1,1,sysdate(),NULL);
/*---sub_stadium---*/
INSERT INTO `sub_stadium` (`n_stadium_id`,`s_number`,`n_length`,`n_width`,`n_type`,`n_status`,`d_created_at`,`d_updated_at`)
VALUES (2,'1',40,20,1,1,sysdate(),NULL);
INSERT INTO `sub_stadium` (`n_stadium_id`,`s_number`,`n_length`,`n_width`,`n_type`,`n_status`,`d_created_at`,`d_updated_at`)
VALUES (2,'2',40,20,1,1,sysdate(),NULL);
INSERT INTO `sub_stadium` (`n_stadium_id`,`s_number`,`n_length`,`n_width`,`n_type`,`n_status`,`d_created_at`,`d_updated_at`)
VALUES (3,'3',40,20,1,1,sysdate(),NULL);
INSERT INTO `sub_stadium` (`n_stadium_id`,`s_number`,`n_length`,`n_width`,`n_type`,`n_status`,`d_created_at`,`d_updated_at`)
VALUES (3,'4',40,20,1,1,sysdate(),NULL);
INSERT INTO `sub_stadium` (`n_stadium_id`,`s_number`,`n_length`,`n_width`,`n_type`,`n_status`,`d_created_at`,`d_updated_at`)
VALUES (2,'1',40,20,1,1,sysdate(),NULL);
/*---stadium_manager---*/
INSERT INTO `stadium_manager` (`n_user_id`,`n_stadium_id`,`n_type`,`n_status`,`d_created_at`)
VALUES (2,2,1,1,sysdate());
INSERT INTO `stadium_manager` (`n_user_id`,`n_stadium_id`,`n_type`,`n_status`,`d_created_at`)
VALUES (2,2,2,1,sysdate());
INSERT INTO `stadium_manager` (`n_user_id`,`n_stadium_id`,`n_type`,`n_status`,`d_created_at`)
VALUES (3,3,1,1,sysdate());
INSERT INTO `stadium_manager` (`n_user_id`,`n_stadium_id`,`n_type`,`n_status`,`d_created_at`)
VALUES (3,4,2,1,sysdate());
/*---match_schedule---*/
INSERT INTO `match_schedule` (`s_start_time`,`s_end_time`,`n_type`,`n_status`,`d_created_at`)
VALUES ('17:30','19:00',2,1,sysdate());
INSERT INTO `match_schedule` (`s_start_time`,`s_end_time`,`n_type`,`n_status`,`d_created_at`)
VALUES ('19:00','20:30',3,1,sysdate());
INSERT INTO `match_schedule` (`s_start_time`,`s_end_time`,`n_type`,`n_status`,`d_created_at`)
VALUES ('20:30','22:00',3,1,sysdate());
INSERT INTO `match_schedule` (`s_start_time`,`s_end_time`,`n_type`,`n_status`,`d_created_at`)
VALUES ('22:00','23:30',3,1,sysdate());
/*---match---*/
INSERT INTO `match` (`n_sub_stadium_id`,`n_match_schedule_id`,`n_price`,`n_type`,`n_status`,`d_created_at`)
VALUES (3,2,800000,1,1,sysdate());
INSERT INTO `match` (`n_sub_stadium_id`,`n_match_schedule_id`,`n_price`,`n_type`,`n_status`,`d_created_at`)
VALUES (3,2,600000,2,1,sysdate());
INSERT INTO `match` (`n_sub_stadium_id`,`n_match_schedule_id`,`n_price`,`n_type`,`n_status`,`d_created_at`)
VALUES (2,3,500000,1,1,sysdate());
INSERT INTO `match` (`n_sub_stadium_id`,`n_match_schedule_id`,`n_price`,`n_type`,`n_status`,`d_created_at`)
VALUES (2,4,400000,2,1,sysdate());
/*---commit---*/
commit;