-- CRIAÇÃO SEQUENCIA --
CREATE SEQUENCE VEM_SER.SEQ_ESTUDANTE
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

DROP SEQUENCE VEM_SER.SEQ_ESTUDANTE;

-- CRIAÇÃO TABELA --
CREATE TABLE Estudante (
	id_est NUMBER,
	nome VARCHAR2(200) NOT NULL,
	data_nascimento DATE NOT NULL,
	nr_matricula NUMBER(10) NOT NULL,
	ativo CHAR(1) NOT NULL,
	PRIMARY KEY (id_est),
	UNIQUE (nr_matricula)
)

-- INSERÇÃO --
INSERT INTO VEM_SER.ESTUDANTE(ID_EST, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Jeff', TO_DATE('12/02/2003', 'dd-mm-yyyy'), 1234567890, 'S');

INSERT INTO VEM_SER.ESTUDANTE(ID_EST, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Mateus', TO_DATE('28/08/2002', 'dd-mm-yyyy'), 09387654321, 'S');

INSERT INTO VEM_SER.ESTUDANTE(ID_EST, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Wesley', TO_DATE('15/03/2002', 'dd-mm-yyyy'), 4123351234, 'S');

INSERT INTO VEM_SER.ESTUDANTE(ID_EST, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Amanda', TO_DATE('24/02/1999', 'dd-mm-yyyy'), 3412334242, 'N');

INSERT INTO VEM_SER.ESTUDANTE(ID_EST, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Gustavo', TO_DATE('13/12/2000', 'dd-mm-yyyy'), 4321232456, 'N');

INSERT INTO VEM_SER.ESTUDANTE(ID_EST, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Francisco', TO_DATE('24/05/2000', 'dd-mm-yyyy'), 3214452476, 'S');

INSERT INTO VEM_SER.ESTUDANTE(ID_EST, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Marcos', TO_DATE('19/02/1994', 'dd-mm-yyyy'), 5328592831, 'N');

INSERT INTO VEM_SER.ESTUDANTE(ID_EST, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Godines', TO_DATE('22/12/1994', 'dd-mm-yyyy'), 7323442831, 'N');

INSERT INTO VEM_SER.ESTUDANTE(ID_EST, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Carlos', TO_DATE('22/04/1994', 'dd-mm-yyyy'), 5323895431, 'S');

INSERT INTO VEM_SER.ESTUDANTE(ID_EST, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Lívia', TO_DATE('09/03/2003', 'dd-mm-yyyy'), 2325345411, 'S');


-- SELEÇÃO --
SELECT * FROM VEM_SER.ESTUDANTE;

SELECT ID_EST, NOME, NR_MATRICULA, ATIVO FROM VEM_SER.ESTUDANTE;
