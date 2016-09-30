DELIMITER $$
	DROP PROCEDURE IF EXISTS novoJogo $$
	CREATE PROCEDURE novoJogo ()
		main: BEGIN
				
					CREATE TABLE PRIMEIRO_ACESSO(
						ID_PA INTEGER NOT NULL,
						PRIMEIRO_ACESSO BOOLEAN NOT NULL,
						PRIMARY KEY (ID_PA)
                    );
					INSERT INTO PRIMEIRO_ACESSO VALUES
                    ('1', TRUE);
 
					CREATE TABLE TECNICOS(
						ID_TECNICO INTEGER NOT NULL,
						NOME VARCHAR(45) NOT NULL,
						NACIONALIDADE VARCHAR(45) NOT NULL,
						RODADA INTEGER NOT NULL,
						ESCOLHIDO BOOLEAN NOT NULL,
						PRIMARY KEY (ID_TECNICO)
					);
					
                    INSERT INTO TECNICOS VALUES
					('1', 'Roger', 'Alemão', '1','FALSE'),
					('2', 'Tite', 'Brasileiro', '1','FALSE'),
					('3', 'Muricy Baralho', 'Coreano', '1', 'FALSE'),
					('4', 'Cuca', 'Argelino', '1', 'FALSE');

					CREATE TABLE CLUBES(
						ID_CLUBE INTEGER NOT NULL,
						ID_TECNICO INTEGER,
						NOME VARCHAR(45) NOT NULL,
						PONTUACAO INTEGER NOT NULL,
						VITORIAS INTEGER NOT NULL,
						EMPATES INTEGER NOT NULL,
						DERROTAS INTEGER NOT NULL,
						SALDO_GOLS INTEGER NOT NULL,
						GP INTEGER NOT NULL,
						GC INTEGER NOT NULL,
						
						PRIMARY KEY (ID_CLUBE),
						FOREIGN KEY (ID_TECNICO) REFERENCES TECNICOS(ID_TECNICO)
					);
					
                    insert into clubes values
					('1','1','Lajeandense','0','0','0','0','0','0','0'),
					('2','2','Aimore','0','0','0','0','0','0','0'),
					('3','3','Caxias','0','0','0','0','0','0','0'),
					('4','4','Passo Fundo','0','0','0','0','0','0','0');
					                    
					CREATE TABLE JOGADORES(
						ID_JOGADOR INTEGER NOT NULL,
						ID_CLUBE INTEGER NOT NULL,
						NOME VARCHAR(45) NOT NULL,
						POSICAO VARCHAR(45) NOT NULL,
						ATAQUE INTEGER NOT NULL,
						DEFESA INTEGER NOT NULL,
						IDADE INTEGER NOT NULL,
						TITULAR BOOLEAN NOT NULL,
						
						PRIMARY KEY (ID_JOGADOR),
						FOREIGN KEY(ID_CLUBE) REFERENCES CLUBES (ID_CLUBE)
					);	
                    
                    
                    insert into jogadores values
					/* ------------------------------ Jogadores do Lajeadense  ------------------------------*/

					 /* -----> Titulares */
					('1','1','Lauro', 'Goleiro', 18, 71, 35, TRUE),
					('2','1','Rodrigo Cardoso', 'Lateral Esquerdo', 55, 63, 26, TRUE),
					('3','1','Leo', 'Lateral Direito', 57, 65, 20, TRUE),
					('4','1','Rodrigo Vareta', 'Zagueiro', 30, 61, 25, TRUE),
					('5','1','Edson Borges', 'Zagueiro', 28, 60, 31, TRUE),
					('6','1','Du', 'Meia', 68, 55, 26, TRUE),
					('7','1','Maurinho', 'Meia', 66, 53, 32, TRUE),
					('8','1','Erik', 'Meia', 69, 58, 21, TRUE),
					('9','1','Alan', 'Meia', 68, 60, 32, TRUE),
					('10','1','Giovani', 'Atacante', 74, 27, 24, TRUE),
					('11','1','Murilo', 'Atacante', 73, 29, 21, TRUE),

					 /* -----> Reservas */
					('12','1','Paulo', 'Goleiro', 9, 64, 28, FALSE),
					('13','1','Diego Hoffman', 'Lateral Direito', 49, 51, 23, FALSE),
					('14','1','Gabriel', 'Zagueiro', 18, 48, 34, FALSE),
					('15','1','Mateus', 'Meia', 57, 40, 28, FALSE),
					('16','1','Maraba', 'Meia', 54, 38, 29, FALSE),
					('17','1','Diego Miranda', 'Atacante', 66, 25, 31, FALSE),


					/* ------------------------------ Jogadores do Aimore  ------------------------------*/

					 /* -----> Titulares */
					('18','2','Alessandro', 'Goleiro', 17, 68, 27, TRUE),
					('19','2','Mateus', 'Lateral Direito', 52, 63, 23, TRUE),
					('20','2','Joao Henrique', 'Lateral Direito', 50, 61, 20, TRUE),
					('21','2','Cesar Lucena', 'Zagueiro', 29, 67, 35, TRUE),
					('22','2','Diego Rocha', 'Zagueiro', 33, 66, 24, TRUE),
					('23','2','Talysson', 'Meia', 71, 40, 24, TRUE),
					('24','2','Danilo Goiano', 'Meia', 67, 45, 33, TRUE),
					('25','2','Joazinho', 'Meia', 66, 42, 20, TRUE),
					('26','2','Tiago Alemao', 'Meia', 64, 38, 25, TRUE),
					('27','2','Lucas Kattah', 'Atacante', 68, 33, 21, TRUE),
					('28','2','Elias', 'Atacante', 73, 44, 22, TRUE),

					 /* -----> Reservas */
					('29','2','Mikael', 'Goleiro', 11, 63, 19, FALSE),
					('30','2','Donato', 'Lateral Esquerdo', 48, 65, 22, FALSE),
					('31','2','Diego Superti', 'Zagueiro', 39, 57, 25, FALSE),
					('32','2','Bruno Araujo', 'Meia', 61, 55, 24, FALSE),
					('33','2','Moacir', 'Meia', 63, 57, 22, FALSE),
					('34','2','Igor Nobre', 'Atacante', 75, 60, 25, FALSE),


					/* ------------------------------ Jogadores do Caxias  ------------------------------*/

					 /* -----> Titulares */
					('35','3','Marcelo Pitol', 'Goleiro', 15, 69, 33, TRUE),
					('36','3','Veloso', 'Lateral Direito', 54, 64, 30, TRUE),
					('37','3','Fabinho', 'Lateral Esquerdo', 50, 51, 32, TRUE),
					('38','3','Bronzatti', 'Zagueiro', 28, 68, 29, TRUE),
					('39','3','Lacerda', 'Zagueiro', 25, 53, 31, TRUE),
					('40','3','Glauber', 'Meia', 63, 55, 34, TRUE),
					('41','3','Raone', 'Meia', 57, 59, 34, TRUE),
					('42','3','Rafael Dutra', 'Meia', 68, 60, 32, TRUE),
					('43','3','Tallys', 'Meia', 63, 54, 28, TRUE),
					('44','3','Sato', 'Atacante', 71, 55, 26, TRUE),
					('45','3','Mailson', 'Atacante', 78, 50, 25, TRUE),

					 /* -----> Reservas */
					('46','3','Hugo', 'Goleiro', 7, 55, 25, FALSE),
					('47','3','Lipe', 'Lateral Esquerdo', 57, 30, 26, FALSE),
					('48','3','Breno', 'Zagueiro', 19, 69, 29, FALSE),
					('49','3','Dinei', 'Meia', 60, 54, 32, FALSE),
					('50','3','Ramos', 'Meia', 61, 60, 32, FALSE),
					('51','3','Clebinho', 'Atacante', 69, 61, 29, FALSE),


					/* ------------------------------ Jogadores do Passo Fundo  ------------------------------*/

					 /* -----> Titulares */
					('52','4','Matheus', 'Goleiro', 20, 71, 29, TRUE),
					('53','4','Alisson Gaucho', 'Lateral Direito', 65, 70, 23, TRUE),
					('54','4','Thiago Machado', 'Lateral Esquerdo', 55, 61, 31, TRUE),
					('55','4','Gustavo Jose', 'Zagueiro', 44, 72, 27, TRUE),
					('56','4','Leo Kanu', 'Zagueiro', 53, 69, 28, TRUE),
					('57','4','Renan Oliveira', 'Meia', 69, 44, 33,  TRUE),
					('58','4','Branquinho', 'Meia', 72, 55, 26, TRUE),
					('59','4','Rudieiro', 'Meia', 60, 80, 28, TRUE),
					('60','4','Nata', 'Meia', 61, 50, 30, TRUE),
					('61','4','Hyantony', 'Atacante', 88, 87, 31, TRUE),
					('62','4','Jean Silva', 'Atacante', 61, 57, 26, TRUE),

					 /* -----> Reservas */
					('63','4','Guilherme', 'Goleiro', 10, 59, 24, FALSE),
					('64','4','Brida', 'Lateral Direito', 67, 44, 31, FALSE),
					('65','4','Marcio Nunes', 'Zagueiro', 58, 68, 35, FALSE),
					('66','4','Amaral', 'Meia', 53, 73, 32, FALSE),
					('67','4','Leandro Capiroto', 'Meia', 66, 66, 66, FALSE),
					('68','4','Dudu Mandai', 'Atacante', 69, 53, 23, FALSE);
                    



					CREATE TABLE CLASSIFICACAO(
						ID_CLASSIFICACAO INTEGER NOT NULL,
						ID_CLUBE INTEGER NOT NULL,
						POSICAO VARCHAR(5) NOT NULL, 
						PONTUACAO INTEGER NOT NULL,
						VITORIAS INTEGER NOT NULL,
						EMPATES INTEGER NOT NULL,
						DERROTAS INTEGER NOT NULL,
						SALDO_GOLS INTEGER NOT NULL,
						GP INTEGER NOT NULL,
						GC INTEGER NOT NULL,
						
						PRIMARY KEY (ID_CLASSIFICACAO),
						FOREIGN KEY(ID_CLUBE) REFERENCES CLUBES (ID_CLUBE)
					);
						
					
					insert into classificacao values
					('1','1','1','0','0','0','0','0','0','0'),
					('2','2','2','0','0','0','0','0','0','0'),
					('3','3','3','0','0','0','0','0','0','0'),
					('4','4','4','0','0','0','0','0','0','0');
		
		END $$
DELIMITER ;


DELIMITER $$
	DROP PROCEDURE IF EXISTS deletarTabelas $$
	CREATE PROCEDURE deletarTabelas ()
		main: BEGIN
				drop table primeiro_acesso;
				drop table jogadores;
				drop table classificacao;
                drop table clubes;
				drop table tecnicos;
		END $$
DELIMITER ;


call deletarTabelas();
call novoJogo();







