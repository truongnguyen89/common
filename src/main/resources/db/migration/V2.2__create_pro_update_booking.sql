DELIMITER $$
CREATE PROCEDURE `PRO_UPDATE_BOOKING`(
IN pi_booking_id BIGINT,
IN pi_status INT,
IN pi_create_user_id BIGINT,
IN pi_reason VARCHAR(2000),
OUT po_response VARCHAR(200))
BEGIN
DECLARE v_old_status INT UNSIGNED DEFAULT 1;
DECLARE v_match_id BIGINT UNSIGNED DEFAULT 1;

SELECT
    n_status, n_match_id
INTO v_old_status , v_match_id FROM
    booking
WHERE
    n_id = pi_booking_id;

UPDATE booking
SET
    n_status = pi_status,
    d_updated_at = SYSDATE()
WHERE
    n_id = pi_booking_id;

INSERT INTO `football`.`booking_log` ( `n_booking_id`, `n_user_id`, `s_reason`, `n_status_old`, `n_status_new`, `d_created_at`)
VALUES (pi_booking_id, pi_create_user_id, pi_reason, v_old_status, pi_status, SYSDATE());

SET po_response = 'OK';

END$$
DELIMITER ;