--B10
SELECT  SUBSTRING (productName,1,1)    AS ProductName,
COUNT (productName)      AS Total
FROM   products
GROUP BY SUBSTRING (productName,1,1) HAVING  COUNT (productName) >= 3 
