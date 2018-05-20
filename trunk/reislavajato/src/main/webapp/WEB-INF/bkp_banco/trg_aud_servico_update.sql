DELIMITER $$
CREATE TRIGGER trg_aud_servico_update
BEFORE UPDATE ON servico
FOR EACH ROW BEGIN
INSERT INTO servico_aud
SET processo_operacao = 'Alteração',
descricao = OLD.descricao,
servico_id = OLD.servico_id,
pct_comissao = OLD.pct_comissao,
observacao = OLD.observacao,
vlr_servico = OLD.vlr_servico,
tela = 'Tela Alteração',
usuario_operacao = 'Administrador',
dt_operacao = NOW(); END$$
DELIMITER ;
