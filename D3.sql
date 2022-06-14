--D3 
CREATE PROCEDURE sp_products
(    @p_prod_name varchar(40), 
@p_date_name varchar(12),   
@p_ord_date  int  )
AS
SELECT  p.ProductName        AS ProductName,  
p.UnitPrice  AS UnitPrice, 
p.UnitsInStock AS UnitsInStock,  
s.Name   AS Name
FROM  products  p 
JOIN        orderdetails  od ON p.ProductID  = od.ProductID
JOIN        orders   o ON od.OrderID   = o.OrderID 
JOIN        suppliers  s ON s.SupplierID = p.SupplierID
WHERE  p.ProductName LIKE @p_prod_name
AND DATEPART(year, o.OrderDate) = @p_ord_date 
AND  DATENAME(month, o.OrderDate) = @p_date_name
GO 

EXEC sp_products '%tofu%', 'December', 1992 