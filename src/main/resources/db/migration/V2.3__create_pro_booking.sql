DELIMITER $$
CREATE PROCEDURE `PRO_BOOKING`(
IN pi_player_id bigint,
IN pi_match_id bigint,
IN pi_match_day date,
IN pi_type int,
IN pi_create_user_id bigint,
IN pi_comment VARCHAR(2000),
OUT po_response VARCHAR(200))
BEGIN
DECLARE v_booking_id  bigint unsigned DEFAULT 1;

INSERT INTO `football`.`booking` (`n_player_id`, `n_match_id`, `d_match_day`, `n_type`, `n_created_user_id`, `s_comment`, `d_created_at`)
VALUES (pi_player_id, pi_match_id, pi_match_day, pi_type, pi_create_user_id, pi_comment, sysdate());

SELECT LAST_INSERT_ID()
INTO v_booking_id;

INSERT INTO `football`.`booking_log` ( `n_booking_id`, `n_user_id`, `s_reason`, `n_status_old`, `n_status_new`, `d_created_at`)
VALUES (v_booking_id, pi_create_user_id, 'booking', '0', '1', sysdate());

SET po_response = 'OK';

END$$
DELIMITER ;
