--B8 
SELECT  c.customerID      AS CustomerID,
		c.companyName      AS CompanyName, 
		c.fax       AS Fax,
		o.orderID      AS OrderID,
		o.orderDate      AS OrderDate
FROM    orders  o
JOIN    customers c ON o.customerID = c.customerID 
WHERE   o.shippedDate IS NULL 
ORDER BY c.customerID, o.orderID 