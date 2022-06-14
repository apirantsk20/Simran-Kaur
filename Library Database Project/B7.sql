--B7
SELECT  o.orderID      AS OrderID, 
		d.unitPrice      AS UnitPrice,
		d.quantity      AS Quantity 
FROM    orders  o 
		JOIN  customers c ON c.customerID = o.customerID 
		JOIN  orderDetails d ON o.orderID = d.orderID
WHERE   c.city = 'Vancouver'
ORDER BY o.orderID 
 