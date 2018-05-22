DELIMITER $$
CREATE TRIGGER trg_aud_cargo_delete
BEFORE DELETE ON cargo
FOR EACH ROW BEGIN
INSERT INTO cargo_aud
SET processo_operacao = 'Exclusão',
desc_cargo = OLD.desc_cargo,
codigo = OLD.codigo,
usuario_operacao = 'Administrador',
tela = 'Tela Exclusão',
dt_operacao = NOW(); END$$
DELIMITER ;




