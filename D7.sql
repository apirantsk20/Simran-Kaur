--D7 

CREATE PROCEDURE sp_shipping_date
(   @p_ship_date date  ) 
AS 
SELECT  o.OrderID  AS OrderID, 
c.CompanyName  AS CustomerName,
s.CompanyName  AS ShipperName,
o.OrderDate  AS OrderDate,
o.ShippedDate  AS ShippedDate
FROM  Orders o
JOIN        Customers c ON o.CustomerID = c.CustomerID
JOIN        Shippers s ON o.ShipperID  = s.ShipperID
WHERE  o.ShippedDate = @p_ship_date     
AND DATEADD(DAY,-10,O.ShippedDate) = o.OrderDate
GO 
EXEC sp_shipping_date '1993-11-29'    