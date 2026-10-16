INSERT 
INTO users (id, username, password) 
VALUES
(1, 'user01', 'password01'),
(2, 'user02', 'password02'),
(3, 'user03', 'password03'),
(4, 'user04', 'password04'),
(5, 'user05', 'password05'),
(6, 'user06', 'password06'),
(7, 'user07', 'password07'),
(8, 'user08', 'password08'),
(9, 'user09', 'password09'),
(10, 'user10', 'password10'), 
(11, 'test', 'test');

INSERT 
INTO accounts (id, user_id, balance, account_number) 
VALUES
(1, 1, 100000, 100000001),
(2, 2, 250000, 100000002),
(3, 3, 50000, 100000003),
(4, 4, 780000, 100000004),
(5, 5, 120000, 100000005),
(6, 6, 300000, 100000006),
(7, 7, 0, 100000007),
(8, 8, 1500000, 100000008),
(9, 9, 45000, 100000009),
(10, 10, 999999, 100000010), 
(11, 11, 500, 100000011);