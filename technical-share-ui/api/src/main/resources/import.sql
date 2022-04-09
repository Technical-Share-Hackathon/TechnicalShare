INSERT INTO links (link_whatsapp, link_teams) VALUES ('ABCD', 'EFGH')
INSERT INTO links (link_whatsapp, link_teams) VALUES ('MNOP', 'QRST')
INSERT INTO links (link_whatsapp, link_teams) VALUES ('YZAB', 'CDEF')

INSERT INTO interesses (primeiro_interesse, segundo_interesse, terceiro_interesse, quarto_interesse, quinto_interesse) VALUES ('UX', 'UI', 'Front End', 'Angular', 'Java Script')
INSERT INTO interesses (primeiro_interesse, segundo_interesse, terceiro_interesse, quarto_interesse, quinto_interesse) VALUES ('Back-end', 'Java', 'Spring','JPA', 'Docker')
INSERT INTO interesses (primeiro_interesse, segundo_interesse, terceiro_interesse, quarto_interesse, quinto_interesse) VALUES ('FullStack', 'Java', 'TypeScript', 'PHP', 'C++')

INSERT INTO hard_skills (primeira_skill, segunda_skill, terceira_skill, quarta_skill, quinta_skill) VALUES ('Java', 'Spring Framework', 'JPA', 'Docker', 'Ansible')
INSERT INTO hard_skills (primeira_skill, segunda_skill, terceira_skill, quarta_skill, quinta_skill) VALUES ('Angular', 'Java Script', 'UX', 'UI', 'JAVA')
INSERT INTO hard_skills (primeira_skill, segunda_skill, terceira_skill, quarta_skill, quinta_skill) VALUES ('FullStack', 'Spring', 'Angular','PHP','C++')

INSERT INTO soft_skills (primeira_skill, segunda_skill, terceira_skill, quarta_skill, quinta_skill) VALUES ('Criativo', 'Liderança', 'Trabalho em equipe', 'Atento a detalhes', 'Pro Ativo')
INSERT INTO soft_skills (primeira_skill, segunda_skill) VALUES ('Inteligência Emocional', 'Colaborativo')
INSERT INTO soft_skills (primeira_skill, segunda_skill, terceira_skill) VALUES ('Self Pitch', 'Resiliência', 'Comunicativa')

INSERT INTO usuario (nome, link_foto, profissao_atual, resumo, email, senha, interesses_id, hard_skills_id, links_id, soft_skills_id) VALUES ( 'Laura Lopes','https://i.imgur.com/QilXedT.jpg', 'Scrum Master' , '10 Anos de Scrum Master nas costas fi, gira, trello TFS', 'jorginho10@hotmail.com', '1234',3,1,3,2);
INSERT INTO usuario (nome, link_foto, profissao_atual, resumo, email, senha, interesses_id, hard_skills_id, links_id, soft_skills_id) VALUES ( 'João Roberto Marinho','https://i.imgur.com/P1plcar.jpg','Tech Lead','Atuei em diversas empresas ao longo da carreira, sempre trabalhando em grandes bancos', 'maraira@hotmail.com', '1234', 2,2,2,3);
INSERT INTO usuario (nome, link_foto, profissao_atual, resumo, email, senha, interesses_id, hard_skills_id, links_id, soft_skills_id) VALUES ( 'Leila Joana','https://i.imgur.com/hUlZzld.jpg', 'Desenvolvedora FullStack', 'Já atuei em diversas tecnologias e stacks, uma verdadeira fullstack', 'lelei@hotmail.com', '1234', 1,3,1,1);

UPDATE soft_skills SET usuario_id = 1 WHERE id_soft_skills = 1;
UPDATE soft_skills SET usuario_id = 3 WHERE id_soft_skills = 2;
UPDATE soft_skills SET usuario_id = 2 WHERE id_soft_skills = 3;

UPDATE hard_skills SET usuario_id = 1 WHERE id_hard_skills = 1;
UPDATE hard_skills SET usuario_id = 3 WHERE id_hard_skills = 2;
UPDATE hard_skills SET usuario_id = 2 WHERE id_hard_skills = 3;

UPDATE interesses SET usuario_id = 1 WHERE id_interesses = 1;
UPDATE interesses SET usuario_id = 3 WHERE id_interesses = 2;
UPDATE interesses SET usuario_id = 2 WHERE id_interesses = 3;





