-- Escolhendo banco de dados.
USE av2_dev_bd;

-- Insert tabela aluno
INSERT INTO aluno (nome,matricula,senha)
    VALUES  ('Alysson Avena', '2016202232', 'Alysson2016'),
            ('Lucas Estrela', '2017101079', 'Lucas2017');
            

-- Insert tabela aluno_has_turma
INSERT INTO aluno_has_turma (aluno_idaluno, turma_materia_idmateria, turma_professor_idprofessor, AV1, APS_1, AV2, APS_2, AV3)
    VALUES  (1, 1, 2, 6.1, 3, 5.1, 2, 0 ),
            (1, 2, 2, 7, 3, 6.1, 2, 0 ),
            (2, 1, 1, 6.1, 3, 6, 2, 0 ),
            (2, 2, 1, 6.1, 3, 6, 2, 0 );

-- Insert tabela materia
INSERT INTO materia (nome)
    VALUES  ('Desenvolvimento em Banco de Dados'),
            ('Desenvolvimento Web');

-- Insert tabela aluno
INSERT INTO professor (matricula,nome,senha)
    VALUES  ('2010202021', 'Anderson', 'Anderson2010'),
            ('2010202120', 'Marcelo Perantoni', 'Marcelo2010');

-- Insert tabela turma  
INSERT INTO turma (materia_idmateria ,professor_idprofessor ,codigo_turma)
    VALUES  (1, 1, 1),
            (2, 2, 2);
