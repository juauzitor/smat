CREATE TABLE Company (
    Company_Id UUID NOT NULL PRIMARY KEY,
    Company_Name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE Task_Category (
    task_Category_Id UUID NOT NULL PRIMARY KEY,
    category_Name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE Work_Frequency (
    work_Frequency_Id UUID NOT NULL PRIMARY KEY,
    start_Work_Frequency DateTime NOT NULL,
    end_Work_Frequency DateTime NOT NULL
);

CREATE TABLE IF NOT EXISTS task_performed (
    task_performed_id UUID PRIMARY KEY,
    company_id UUID NOT NULL,
    task_category_id UUID NOT NULL,
    work_frequency_id UUID NOT NULL,
    description VARCHAR(1024) NOT NULL,
    FOREIGN KEY (company_id) REFERENCES company(company_id),
    FOREIGN KEY (task_category_id) REFERENCES task_category(task_category_id),
    FOREIGN KEY (work_frequency_id) REFERENCES work_frequency(work_frequency_id)
);

-- Inserindo empresas
INSERT INTO Company (Company_Id, Company_Name) VALUES
  (UUID '11111111-1111-1111-1111-111111111111', 'Acme Corp'),
  (UUID '22222222-2222-2222-2222-222222222222', 'Globex Inc');

-- Inserindo categorias de tarefas
INSERT INTO Task_Category (task_Category_Id, category_Name) VALUES
  (UUID '33333333-3333-3333-3333-333333333333', 'Manutenção'),
  (UUID '44444444-4444-4444-4444-444444444444', 'Desenvolvimento');

-- Inserindo frequências de trabalho
INSERT INTO Work_Frequency (work_Frequency_Id, start_Work_Frequency, end_Work_Frequency) VALUES
  (UUID '55555555-5555-5555-5555-555555555555', '2025-04-01 08:00:00', '2025-04-01 12:00:00'),
  (UUID '66666666-6666-6666-6666-666666666666', '2025-04-02 13:00:00', '2025-04-02 17:00:00');

-- Inserindo tarefas realizadas
INSERT INTO task_performed (task_performed_id, company_id, task_category_id, work_frequency_id, description) VALUES
  (UUID '77777777-7777-7777-7777-777777777777',
   UUID '11111111-1111-1111-1111-111111111111',
   UUID '33333333-3333-3333-3333-333333333333',
   UUID '55555555-5555-5555-5555-555555555555',
   'Revisão de equipamentos de ar condicionado'),

  (UUID '88888888-8888-8888-8888-888888888888',
   UUID '22222222-2222-2222-2222-222222222222',
   UUID '44444444-4444-4444-4444-444444444444',
   UUID '66666666-6666-6666-6666-666666666666',
   'Implementação de nova funcionalidade no sistema');
