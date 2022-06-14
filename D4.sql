
 
--D4 
CREATE PROCEDURE sp_unit_prices
(    @min_price money,   
@max_price money  )
AS 
SELECT   productid AS ProductID,  
productname AS ProductName,  
englishname AS EnglishName, 
unitprice AS UnitPrice
FROM   products
WHERE   unitprice 
BETWEEN @min_price AND @max_price 
GO 


 
EXEC sp_unit_prices 5.50, 8.00