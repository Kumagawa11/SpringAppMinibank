
CREATE 
TABLE users 
(
    id INT PRIMARY KEY AUTO_INCREMENT, 
    username VARCHAR(255) NOT NULL, 
    password VARCHAR(255) NOT NULL
);

CREATE 
TABLE accounts 
(
    id INT PRIMARY KEY AUTO_INCREMENT, 
    user_id INT NOT NULL,
    FOREIGN KEY(user_id) REFERENCES users(id),
    balance DECIMAL(10, 0), 
    account_number INT NOT NULL 
);


CREATE 
TABLE transaction 
(
    id INT PRIMARY KEY AUTO_INCREMENT, 
    account_id INT NOT NULL, 
    FOREIGN KEY(account_id) REFERENCES accounts(id), 
    amount DECIMAL(10, 0), 
    description TEXT NOT NULL, 
    created_at TIMESTAMP NOT NULL, 
    type ENUM('deposit', 'withdraw', 'transfer') NOT NULL
);