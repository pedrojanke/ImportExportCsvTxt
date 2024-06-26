CREATE DEFINER=`root`@`localhost` TRIGGER `integracao_dados_AFTER_INSERT` AFTER INSERT ON `integracao_dados` FOR EACH ROW BEGIN
DECLARE gender VARCHAR(250);
DECLARE category VARCHAR(250);
DECLARE media VARCHAR(250);
DECLARE mediatype VARCHAR(250);
DECLARE classification VARCHAR(250);
DECLARE participant VARCHAR(250);

SELECT NAME INTO gender FROM integracao.gender
WHERE NAME = new.genero;

    -- Inserindo os dados na tabela correspondente no banco de dados de destino 
    IF (gender IS NULL) THEN
		INSERT INTO integracao.gender (id, name, registrion_date, inactivation_date)
        VALUES (uuid(), NEW.genero, CURRENT_DATE(), NULL);
	END IF;    

SELECT NAME INTO category FROM integracao.category
WHERE NAME = new.categoria;

    -- Inserindo os dados na tabela correspondente no banco de dados de destino
    IF (category IS NULL) THEN
		INSERT INTO integracao.category (id, name, registrion_date, inactivation_date)
        VALUES (uuid(), NEW.categoria, CURRENT_DATE(), NULL);
	END IF;

SELECT NAME INTO media FROM integracao.media
WHERE NAME = new.midia;

    -- Inserindo os dados na tabela correspondente no banco de dados de destino
    IF (media IS NULL) THEN
		INSERT INTO integracao.media (id, name, registrion_date, inactivation_date)
        VALUES (uuid(), NEW.midia, CURRENT_DATE(), NULL);
	END IF;


SELECT NAME INTO mediatype FROM integracao.mediatype
WHERE NAME = new.tipo_midia;

    -- Inserindo os dados na tabela correspondente no banco de dados de destino
    IF (mediatype IS NULL) THEN
		INSERT INTO integracao.mediatype (id, name, registrion_date, inactivation_date)
        VALUES (uuid(), NEW.tipo_midia, CURRENT_DATE(), NULL);
	END IF;

SELECT NAME INTO classification FROM integracao.classification
WHERE NAME = new.classificacao;

    -- Inserindo os dados na tabela correspondente no banco de dados de destino
    IF (classification IS NULL) THEN
		INSERT INTO integracao.classification (id, name, registrion_date, inactivation_date)
        VALUES (uuid(), NEW.classificacao, CURRENT_DATE(), NULL);
	END IF;

SELECT NAME INTO participant FROM integracao.participant
WHERE NAME = new.participante;

    -- Inserindo os dados na tabela correspondente no banco de dados de destino
    IF (participant IS NULL) THEN
		INSERT INTO integracao.participant (id, name, registrion_date, inactivation_date)
        VALUES (uuid(), NEW.participante, CURRENT_DATE(), NULL);
	END IF;
END