DELIMITER $$
CREATE PROCEDURE `PRO_TEST`(IN pi_type VARCHAR(200),IN pi_code VARCHAR(200),OUT po_count INT)
BEGIN
SELECT COUNT(*) INTO po_count FROM params where (pi_type is null );
END$$
DELIMITER ;
