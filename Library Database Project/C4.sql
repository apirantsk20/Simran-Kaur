--C4
CREATE VIEW vw_order_cost (OrderID, OrderDate, ProductID, CompanyName, OrderCost)
AS
SELECT		o.orderID,
			o.orderDate,
			p.productID,
			c.companyName,
			(d.unitPrice * d.quantity)
FROM		orders  o 
JOIN        customers c ON o.customerID = c.customerID
JOIN        orderDetails d ON o.orderID    = d.orderID 
JOIN        products p ON p.productID  =  d.productID 
 
SELECT * 
FROM vw_order_cost 
WHERE orderID BETWEEN 10100 AND 10200
ORDER BY ProductID 
 