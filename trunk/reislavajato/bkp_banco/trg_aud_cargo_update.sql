DELIMITER $$
CREATE TRIGGER trg_aud_cargo_update
BEFORE UPDATE ON cargo
FOR EACH ROW BEGIN
INSERT INTO cargo_aud
SET processo_operacao = 'Altera��o',
desc_cargo = OLD.desc_cargo,
codigo = OLD.codigo,
usuario_operacao = 'Administrador',
tela = 'Tela Altera��o',
dt_operacao = NOW(); END$$
DELIMITER ;




