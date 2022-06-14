--B5 
SELECT  o.orderID      AS OrderID,
c.companyName      AS CompanyName,
c.contactName      AS ContactName, 
CONVERT (CHAR(12), o.shippedDate, 107)  AS ShippedDate,
DATEDIFF (YEAR, o.shippedDate, 'Jan 1 2009') AS  ElapsedYears
FROM   orders  o 
JOIN  customers c
ON o.customerID = c.customerID
WHERE  shippedDate >= 'Jan 1 1994'
ORDER BY o.orderID, ElapsedYears 
 
 