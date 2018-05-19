DELIMITER $$
CREATE TRIGGER trg_aud_servico_delete
BEFORE DELETE ON servico
FOR EACH ROW BEGIN
INSERT INTO aud_servico
SET processo_alteracao = 'Delete',
descricao = OLD.descricao,
servico_id = OLD.servico_id,
pct_comissao = OLD.pct_comissao,
vlr_servico = OLD.vlr_servico,

dt_alteracao = NOW(); END$$
DELIMITER ;