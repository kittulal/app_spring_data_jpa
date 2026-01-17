CREATE TABLE department (
    id BIGINT PRIMARY KEY,
    code VARCHAR(20) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100),
    active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
---------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE employee (
    id BIGINT PRIMARY KEY,
    emp_code VARCHAR(20) UNIQUE NOT NULL,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(150) UNIQUE,
    salary DECIMAL(12,2),
    designation VARCHAR(100),
    joining_date DATE,
    status VARCHAR(20),
    department_id BIGINT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT fk_department
        FOREIGN KEY (department_id)
        REFERENCES department(id)
);
---------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO department
(id, code, name, location, active, created_at, updated_at)
VALUES
(1, 'ENG', 'Engineering', 'Bangalore', TRUE, NOW(), NOW()),
(2, 'HR', 'Human Resources', 'Hyderabad', TRUE, NOW(), NOW()),
(3, 'FIN', 'Finance', 'Mumbai', TRUE, NOW(), NOW()),
(4, 'SAL', 'Sales', 'Delhi', TRUE, NOW(), NOW()),
(5, 'SUP', 'Support', 'Chennai', TRUE, NOW(), NOW());

---------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO employee
(id, emp_code, first_name, last_name, email, salary, designation,
 joining_date, status, department_id, created_at, updated_at)
VALUES
-- Engineering (4)
(101, 'EMP001', 'Amit', 'Sharma', 'amit.sharma@company.com', 95000, 'Senior Engineer', '2021-03-15', 'ACTIVE', 1, NOW(), NOW()),
(102, 'EMP002', 'Rahul', 'Verma', 'rahul.verma@company.com', 90000, 'Engineer', '2022-06-10', 'ACTIVE', 1, NOW(), NOW()),
(103, 'EMP003', 'Sandeep', 'Reddy', 'sandeep.reddy@company.com', 98000, 'Tech Lead', '2020-01-20', 'ACTIVE', 1, NOW(), NOW()),
(104, 'EMP004', 'Vikram', 'Iyer', 'vikram.iyer@company.com', 87000, 'Engineer', '2023-02-01', 'ACTIVE', 1, NOW(), NOW()),

-- HR (3)
(105, 'EMP005', 'Priya', 'Nair', 'priya.nair@company.com', 60000, 'HR Executive', '2021-08-12', 'ACTIVE', 2, NOW(), NOW()),
(106, 'EMP006', 'Anita', 'Kulkarni', 'anita.kulkarni@company.com', 65000, 'HR Manager', '2019-05-25', 'ACTIVE', 2, NOW(), NOW()),
(107, 'EMP007', 'Neha', 'Gupta', 'neha.gupta@company.com', 58000, 'HR Analyst', '2022-11-03', 'ACTIVE', 2, NOW(), NOW()),

-- Finance (3)
(108, 'EMP008', 'Rohit', 'Mehta', 'rohit.mehta@company.com', 78000, 'Accountant', '2020-09-17', 'ACTIVE', 3, NOW(), NOW()),
(109, 'EMP009', 'Kavita', 'Joshi', 'kavita.joshi@company.com', 82000, 'Senior Accountant', '2018-04-11', 'ACTIVE', 3, NOW(), NOW()),
(110, 'EMP010', 'Manoj', 'Agarwal', 'manoj.agarwal@company.com', 85000, 'Finance Lead', '2017-07-01', 'ACTIVE', 3, NOW(), NOW()),

-- Sales (4)
(111, 'EMP011', 'Arjun', 'Singh', 'arjun.singh@company.com', 70000, 'Sales Executive', '2022-01-10', 'ACTIVE', 4, NOW(), NOW()),
(112, 'EMP012', 'Pooja', 'Malhotra', 'pooja.malhotra@company.com', 72000, 'Sales Executive', '2021-06-18', 'ACTIVE', 4, NOW(), NOW()),
(113, 'EMP013', 'Karan', 'Bansal', 'karan.bansal@company.com', 76000, 'Sales Manager', '2019-10-05', 'ACTIVE', 4, NOW(), NOW()),
(114, 'EMP014', 'Sneha', 'Chopra', 'sneha.chopra@company.com', 74000, 'Account Manager', '2020-12-14', 'ACTIVE', 4, NOW(), NOW()),

-- Support (6)
(115, 'EMP015', 'Ramesh', 'Patel', 'ramesh.patel@company.com', 50000, 'Support Engineer', '2023-04-01', 'ACTIVE', 5, NOW(), NOW()),
(116, 'EMP016', 'Sunita', 'Desai', 'sunita.desai@company.com', 52000, 'Support Engineer', '2022-09-09', 'ACTIVE', 5, NOW(), NOW()),
(117, 'EMP017', 'Nitin', 'Kumar', 'nitin.kumar@company.com', 54000, 'Senior Support Engineer', '2021-03-22', 'ACTIVE', 5, NOW(), NOW()),
(118, 'EMP018', 'Anjali', 'Mishra', 'anjali.mishra@company.com', 56000, 'Support Lead', '2019-08-30', 'ACTIVE', 5, NOW(), NOW()),
(119, 'EMP019', 'Deepak', 'Yadav', 'deepak.yadav@company.com', 58000, 'Support Engineer', '2020-05-16', 'INACTIVE', 5, NOW(), NOW()),
(120, 'EMP020', 'Shalini', 'Saxena', 'shalini.saxena@company.com', 60000, 'Support Manager', '2018-02-19', 'ACTIVE', 5, NOW(), NOW());
---------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO employee
(id, emp_code, first_name, last_name, email, salary, designation,
 joining_date, status, department_id, created_at, updated_at)
VALUES
-- Engineering (4)
(201, 'EMP021', 'Alice', 'Johnson', 'alice.johnson@company.com', 95000, 'Senior Engineer', '2021-03-15', 'ACTIVE', 1, NOW(), NOW()),
(202, 'EMP022', 'Bob', 'Smith', 'bob.smith@company.com', 90000, 'Engineer', '2022-06-10', 'ACTIVE', 1, NOW(), NOW()),
(203, 'EMP023', 'Charlie', 'Brown', 'charlie.brown@company.com', 98000, 'Tech Lead', '2020-01-20', 'ACTIVE', 1, NOW(), NOW()),
(204, 'EMP024', 'David', 'Miller', 'david.miller@company.com', 87000, 'Engineer', '2023-02-01', 'ACTIVE', 1, NOW(), NOW()),

-- HR (3)
(205, 'EMP025', 'Eva', 'Williams', 'eva.williams@company.com', 60000, 'HR Executive', '2021-08-12', 'ACTIVE', 2, NOW(), NOW()),
(206, 'EMP026', 'Frank', 'Taylor', 'frank.taylor@company.com', 65000, 'HR Manager', '2019-05-25', 'ACTIVE', 2, NOW(), NOW()),
(207, 'EMP027', 'Grace', 'Anderson', 'grace.anderson@company.com', 58000, 'HR Analyst', '2022-11-03', 'ACTIVE', 2, NOW(), NOW()),

-- Finance (3)
(208, 'EMP028', 'Henry', 'Thomas', 'henry.thomas@company.com', 78000, 'Accountant', '2020-09-17', 'ACTIVE', 3, NOW(), NOW()),
(209, 'EMP029', 'Irene', 'Moore', 'irene.moore@company.com', 82000, 'Senior Accountant', '2018-04-11', 'ACTIVE', 3, NOW(), NOW()),
(210, 'EMP030', 'Jack', 'Martin', 'jack.martin@company.com', 85000, 'Finance Lead', '2017-07-01', 'ACTIVE', 3, NOW(), NOW()),

-- Sales (4)
(211, 'EMP031', 'Kevin', 'Lee', 'kevin.lee@company.com', 70000, 'Sales Executive', '2022-01-10', 'ACTIVE', 4, NOW(), NOW()),
(212, 'EMP032', 'Laura', 'Perez', 'laura.perez@company.com', 72000, 'Sales Executive', '2021-06-18', 'ACTIVE', 4, NOW(), NOW()),
(213, 'EMP033', 'Mike', 'Clark', 'mike.clark@company.com', 76000, 'Sales Manager', '2019-10-05', 'ACTIVE', 4, NOW(), NOW()),
(214, 'EMP034', 'Nina', 'Lewis', 'nina.lewis@company.com', 74000, 'Account Manager', '2020-12-14', 'ACTIVE', 4, NOW(), NOW()),

-- Support (6)
(215, 'EMP035', 'Oscar', 'Walker', 'oscar.walker@company.com', 50000, 'Support Engineer', '2023-04-01', 'ACTIVE', 5, NOW(), NOW()),
(216, 'EMP036', 'Paula', 'Hall', 'paula.hall@company.com', 52000, 'Support Engineer', '2022-09-09', 'ACTIVE', 5, NOW(), NOW()),
(217, 'EMP037', 'Quinn', 'Allen', 'quinn.allen@company.com', 54000, 'Senior Support Engineer', '2021-03-22', 'ACTIVE', 5, NOW(), NOW()),
(218, 'EMP038', 'Rachel', 'Young', 'rachel.young@company.com', 56000, 'Support Lead', '2019-08-30', 'ACTIVE', 5, NOW(), NOW()),
(219, 'EMP039', 'Steve', 'King', 'steve.king@company.com', 58000, 'Support Engineer', '2020-05-16', 'INACTIVE', 5, NOW(), NOW()),
(220, 'EMP040', 'Tina', 'Scott', 'tina.scott@company.com', 60000, 'Support Manager', '2018-02-19', 'ACTIVE', 5, NOW(), NOW());
