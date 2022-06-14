--D1 
CREATE PROCEDURE sp_emp_info 
             (   @p_emp_id int )
AS
       SELECT    employeeid  AS EmployeeID,  
				 lastname  AS LastName,
				 firstname  AS FirstName,
				 phone   AS Phone 
FROM			 Employees 
WHERE			 employeeid = @p_emp_id
GO 

 
EXEC sp_emp_info 7
 