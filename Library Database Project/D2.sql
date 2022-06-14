--D2 
CREATE PROCEDURE sp_orders_by_dates 
(   @start_shipped_date date, 
@end_shipped_date date )
AS
SELECT  o.orderid  AS OrderID, 
o.customerid  AS CustomerID,  
c.companyname  AS CompanyName, 
s.companyname  AS ShipperName, 
o.shippeddate  AS ShippedDate
FROM  orders o
JOIN customers c ON o.customerid = c.customerid 
JOIN shippers s ON s.shipperid = o.shipperid 
WHERE  shippeddate BETWEEN CONVERT (CHAR(18),@start_shipped_date, 120)
AND CONVERT (CHAR(18),@end_shipped_date, 120) 
GO 

EXEC sp_orders_by_dates '1991-01-01', '1991-12-31' 
 