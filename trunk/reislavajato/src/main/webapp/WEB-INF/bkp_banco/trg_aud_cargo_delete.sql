DELIMITER $$
CREATE TRIGGER trg_aud_cargo_delete
BEFORE DELETE ON cargo
FOR EACH ROW BEGIN
INSERT INTO aud_cargo
SET processo_alteracao = 'Delete',
desc_cargo = OLD.desc_cargo,
codigo = OLD.codigo,

dt_alteracao = NOW(); END$$
DELIMITER ;