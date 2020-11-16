# Table, Create Table
user, CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email_ID` varchar(50) DEFAULT NULL,
  `Mobile_No` varchar(15) DEFAULT NULL,
  `Address` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci



CREATE TABLE `loanapplication` (
  `applno` int(11) NOT NULL AUTO_INCREMENT,
  `ADDRES` varchar(150) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `mobile` varchar(25) DEFAULT NULL,
  `bindicator` varchar(25) DEFAULT NULL,
  `bstructure` varchar(25) DEFAULT NULL,
  `amtrequest` int(25) DEFAULT NULL,
  `dateofapply` varchar(25) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  `loanTenure` int(25) DEFAULT NULL,
  `typeOfLoan` varchar(25) DEFAULT NULL,
  `taxindicator` varchar(25) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `amtEligible` int(25) DEFAULT NULL,
  `Rate_of_Interest` varchar(25) DEFAULT NULL,
  `monthlyPayment` varchar(25) DEFAULT NULL,
  `termPaymentAmount` varchar(25) DEFAULT NULL,
  `Loan_closure_Date` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`applno`),
  KEY `username` (`username`),
  CONSTRAINT `loanapplication_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Loan application details'

