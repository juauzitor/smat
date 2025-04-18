CREATE TABLE Company (
    CompanyId UUID NOT NULL PRIMARY KEY,
    CompanyName VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE Task_Category (
    taskCategoryId UUID NOT NULL PRIMARY KEY,
    categoryName VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE Work_Frequency (
    work_Frequency_Id UUID NOT NULL PRIMARY KEY,
    start_Work_Frequency DateTime NOT NULL,
    end_Work_Frequency DateTime NOT NULL
);
