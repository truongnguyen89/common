DELIMITER $$
CREATE PROCEDURE `PRO_COUNT_PARAM_EXIST`(IN pi_type VARCHAR(200),IN pi_code VARCHAR(200),OUT po_count INT)
BEGIN
SELECT COUNT(*) INTO po_count FROM params WHERE (pi_type IS NULL OR s_type = pi_type) AND (pi_code IS NULL OR s_code = pi_code);
END$$
DELIMITER ;
