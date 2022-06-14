--C7 
CREATE VIEW vw_orders (OrderID, CustomerID, CompanyName, City, Country, ShippedDate) 
AS 
SELECT  o.orderID,
		c.customerID,
		c.companyName,
		c.city,
		c.country,  
		o.shippedDate
FROM	orders  o
JOIN    customers c ON o.customerID = c.customerID 

SELECT *
FROM vw_orders 
WHERE ShippedDate 
BETWEEN '1993-01-01' AND '1993-01-31'
ORDER BY CompanyName, Country 