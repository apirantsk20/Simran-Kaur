--D5 
CREATE PROCEDURE sp_customer_city 
(   @p_city  varchar(15)  ) 
AS 
SELECT  customerid  AS CustomerID,  
companyname  AS CompanyName,  
address  AS Address, 
city   AS City,  
phone   AS Phone 
FROM  customers  WHERE  city = @p_city 
GO 

EXEC sp_customer_city 'Paris' 
 