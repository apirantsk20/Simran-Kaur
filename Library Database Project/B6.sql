--B6 
SELECT  o.orderID       AS OrderID,
		p.productName       AS ProductName,
		c.companyName       AS CompanyName,
CONVERT(CHAR(12), o.orderDate, 107)   AS OrderDate,
CONVERT(CHAR(12),DATEADD(DAY, 10, o.shippedDate), 107) AS NewShippedDate,
		d.quantity * p.unitPrice     AS OrderCost
FROM    orders            o
JOIN    customers  c ON c.customerID = o.customerID
JOIN    orderDetails  d ON d.orderID = o.orderID
JOIN    products  p ON p.productID = d.productID
WHERE   o.orderDate BETWEEN 'Jan 1 1992' AND 'Mar 30 1992' AND  d.quantity * p.unitPrice >= 1500.00
ORDER BY o.orderID 