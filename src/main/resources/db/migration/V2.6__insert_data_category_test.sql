/*---roles---*/
INSERT INTO role (`s_code`, `s_name`, `n_status`, `d_created_at`)
VALUES ('ADMIN', 'Admin', '1', sysdate());
INSERT INTO role (`s_code`, `s_name`, `n_status`, `d_created_at`)
VALUES ('USER', 'User', '1', sysdate());
INSERT INTO role (`s_code`, `s_name`, `n_status`, `d_created_at`)
VALUES ('MANAGER', 'Manager', '1', sysdate());

/*---user---*/
INSERT INTO user (`s_username`, `s_password`, `s_name`, `s_email`, `s_phone`, `s_address`, `n_type`, `n_status`, `n_role_id`, `d_created_at`)
VALUES ('admin', '$2a$10$UG6216D09ShICr1.i.zccez0f/6eP3pEoDvEE/9g/NjaVAGoWO5Oy', 'Nguyễn Quang Trường', 'truongnq@gmail.com', '0962266682', 'Hà Nội', '1', '1', 1, sysdate());
INSERT INTO user (`s_username`, `s_password`, `s_name`, `s_email`, `s_phone`, `s_address`, `n_type`, `n_status`, `n_role_id`, `d_created_at`)
VALUES ('truongnq', '$2a$10$UG6216D09ShICr1.i.zccez0f/6eP3pEoDvEE/9g/NjaVAGoWO5Oy', 'Nguyễn Quang Trường', 'truongnq@gmail.com', '0962266682', 'Hà Nội', '1', '1', 1, sysdate());
INSERT INTO user (`s_username`, `s_password`, `s_name`, `s_email`, `s_phone`, `s_address`, `n_type`, `n_status`, `n_role_id`, `d_created_at`)
VALUES ('user', '$2a$10$UG6216D09ShICr1.i.zccez0f/6eP3pEoDvEE/9g/NjaVAGoWO5Oy', 'Nguyễn Quang Trường 2', 'truongnq2@gmail.com', '0962266682', 'Hà Nội', '1', '1', 2, sysdate());
INSERT INTO user (`s_username`, `s_password`, `s_name`, `s_email`, `s_phone`, `s_address`, `n_type`, `n_status`, `n_role_id`, `d_created_at`)
VALUES ('user1', '$2a$10$UG6216D09ShICr1.i.zccez0f/6eP3pEoDvEE/9g/NjaVAGoWO5Oy', 'Nguyễn Quang Trường 3', 'truongnq3@gmail.com', '0962266682', 'Hà Nội', '1', '1', 2, sysdate());
INSERT INTO user (`s_username`, `s_password`, `s_name`, `s_email`, `s_phone`, `s_address`, `n_type`, `n_status`, `n_role_id`, `d_created_at`)
VALUES ('manager', '$2a$10$UG6216D09ShICr1.i.zccez0f/6eP3pEoDvEE/9g/NjaVAGoWO5Oy', 'Nguyễn Quang Trường 4', 'truongnq4@gmail.com', '0962266682', 'Hà Nội', '1', '1', 3, sysdate());
/*---params---*/
/*---Cau hinh cho cac column cua bang user---*/
/*---Co import data test---*/
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('SYSTEM','IMPORT_DATA_WEATHER_LOCAL_TEST','Cờ import data weather local from open weather test','1',1,sysdate());
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('SYSTEM','IMPORT_DATA_AREA_TEST','Cờ import data area từ trang thống kê chính phủ','1',1,sysdate());
/*---USER.status---*/
/*---Gia cho cac khung gio, bang match.price---*/
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('PRICE','SANG','Giá buổi sáng','400000',1,sysdate());
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('PRICE','TRUA','Giá buổi trưa','500000',1,sysdate());
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('PRICE','CHIEU','Giá buổi chiều','600000',1,sysdate());
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('PRICE','VANG','Giá giờ vàng','800000',1,sysdate());
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('PRICE','TOI','Giá buổi tối','700000',1,sysdate());
/*---Cau hinh cho cac column cua bang booking---*/
/*---Cau hinh tai khoan Gmail gui di---*/
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('GMAIL','ACCOUNT','Tài khoản gmail gửi','ecpay.it',1,sysdate());
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('GMAIL','PASS','Mật khẩu tài khoản gmail gửi','Ecpayit2017',1,sysdate());
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('EMAIL','FROM_MAIL_DEFAUL','Tài khoản email gửi đi mặc định','ecpay.it@gmail.com',1,sysdate());

/*---booking.type---*/
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('BOOKING','TYPE_PLAYER_BOOKING','Người chơi đặt sân','1',1,sysdate());
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('BOOKING','TYPE_MANAGER_BOOKING','Quản lý đặt sân','2',1,sysdate());
/*---booking.status---*/
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('BOOKING','STATUS_NEW','Yêu cầu đặt sân','1',1,sysdate());
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('BOOKING','STATUS_MANAGER_AGREE','Quản lý sân đã nhận','2',1,sysdate());
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('BOOKING','STATUS_CANCEL','Hủy yêu cầu đặt sân','3',1,sysdate());
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('BOOKING','STATUS_MANAGER_REFUSE','Quản lý từ chối đặt sân','4',1,sysdate());
/*---Cau hinh open weather---*/

INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('OPEN_WEATHER','URL','Đường dẫn url call ws','https://api.openweathermap.org/data/2.5/forecast?id={0}&appid={1}&units=metric&lang=vi',1,sysdate());
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('OPEN_WEATHER','API_KEY','Key của acc đã đăng ký tài khoản trên trang openweather.com','9837f9ff93fe008f7a60f907606e5d78',1,sysdate());
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('OPEN_WEATHER','TIME_OUT','Timeout','10000',1,sysdate());
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('OPEN_WEATHER','CONNECTION_TIME_OUT','Connect timeout','10000',1,sysdate());

/*---param thong bao gui cho quan ly san bong khi co dat san moi---*/
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('NOTIFICATION_TO_MANAGER_WHEN_BOOKING','TITLE','[{0}] Có booking mới','1',1,sysdate());
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('NOTIFICATION_TO_MANAGER_WHEN_BOOKING','CONTENT','Thông báo cho booking mới có nội dung : \nNgười chơi\n{0}\nThông tin booking\n{1}\nNgười đặt\n{2}\n','1',1,sysdate());

/*---param thong bao gui cho thiet bi login truoc do va co thiet bi login moi tren 1 user---*/
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('NOTIFICATION_UNSUBSCRIBE_OTHER','TITLE','Thông báo login thiết bị mới','1',1,sysdate());
INSERT INTO `params` (`s_type`,`s_code`,`s_name`,`s_value`,`n_status`,`d_created_at`)
VALUES('NOTIFICATION_UNSUBSCRIBE_OTHER','CONTENT','Tài khoản của bạn đã được login tại thiết bị mới có id = {0}','1',1,sysdate());

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
INSERT INTO `matchs` (`n_sub_stadium_id`,`n_match_schedule_id`,`n_price`,`n_type`,`n_status`,`d_created_at`)
VALUES (3,2,800000,1,1,sysdate());
INSERT INTO `matchs` (`n_sub_stadium_id`,`n_match_schedule_id`,`n_price`,`n_type`,`n_status`,`d_created_at`)
VALUES (3,2,600000,2,1,sysdate());
INSERT INTO `matchs` (`n_sub_stadium_id`,`n_match_schedule_id`,`n_price`,`n_type`,`n_status`,`d_created_at`)
VALUES (2,3,500000,1,1,sysdate());
INSERT INTO `matchs` (`n_sub_stadium_id`,`n_match_schedule_id`,`n_price`,`n_type`,`n_status`,`d_created_at`)
VALUES (2,4,400000,2,1,sysdate());
/*---commit---*/
commit;