DELIMITER $$
CREATE TRIGGER trg_aud_servico_delete
BEFORE DELETE ON servico
FOR EACH ROW BEGIN
INSERT INTO servico_aud
SET processo_operacao = 'Exclusão',
descricao = OLD.descricao,
servico_id = OLD.servico_id,
pct_comissao = OLD.pct_comissao,
vlr_servico = OLD.vlr_servico,
tela = 'Tela Exclusão',
usuario_operacao = 'Administrador',
dt_operacao = NOW(); END$$
DELIMITER ;