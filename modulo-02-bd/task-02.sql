-- TESK-01 --
-- Ordem decrescente dos nomes: --
SELECT * FROM PAIS ORDER BY nome DESC;

-- Logragouros de cep filtrados por a% --
SELECT logradouro, cep FROM endereco
WHERE lower(logradouro) LIKE 'a%'

-- Todos os endereços com cep com final 0 --
SELECT * FROM endereco
WHERE TRIM(CEP) LIKE '%0'

-- Todos os endereços que tenham numero entre 1 e 100 --
SELECT * FROM ENDERECO
WHERE numero > 0 AND numero < 101

-- Todos os enderecos que comecem com "Rua" e ordenação por cep DESC --
SELECT * FROM ENDERECO
WHERE lower(LOGRADOURO) LIKE 'rua%'
ORDER BY CEP DESC 

-- Quantidade de enderecos cadastrados na tablela --
SELECT COUNT(*) AS Quantidade_Enderecos FROM ENDERECO

-- ERRADO - Quantidade de enderecos cadastrados agrupados pelo id na cidade --
SELECT COUNT(*) AS Quantidade_enderecos_Conceicao FROM CIDADE e, Endereco en
WHERE e.ID_CIDADE = 1 AND en.ID_CIDADE = 1

-- Correção - Quantidade de enderecos cadastrados agrupados pelo id na cidade --
SELECT 
	ID_CIDADE, COUNT(*) AS Quantidade
FROM 
	ENDERECO
GROUP BY 
	ID_CIDADE

