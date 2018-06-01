DELIMITER $$
CREATE TRIGGER trg_aud_servico_delete
BEFORE DELETE ON servico
FOR EACH ROW BEGIN
INSERT INTO servico_aud
SET processo_operacao = 'Exclus�o',
descricao = OLD.descricao,
servico_id = OLD.servico_id,
observacao = OLD.observacao,
pct_comissao = OLD.pct_comissao,
vlr_servico = OLD.vlr_servico,
tela = 'Tela Exclus�o',
usuario_operacao = 'Administrador',
dt_operacao = NOW(); END$$
DELIMITER ;