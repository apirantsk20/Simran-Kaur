--C2
CREATE VIEW vw_employee_info (EmployeeID, Name, BirthDate) 
AS
SELECT   employeeID,
		 (firstName + ' ' + lastName),
		 birthDate
FROM     employees 
 
SELECT * 
FROM vw_employee_info
WHERE EmployeeID IN ( 3, 6, 9 ) 