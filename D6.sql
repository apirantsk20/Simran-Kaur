--D6 
CREATE PROCEDURE sp_reorder_qty
(   @p_qty smallint  ) 
AS
SELECT  p.ProductID  AS ProductID,
p.ProductName  AS ProductName,
s.Name   AS Name,
p.UnitsInStock AS UnitsInStock, 
p.ReorderLevel AS ReorderLevel
FROM  products p
JOIN        Suppliers s ON p.SupplierID = s.SupplierID
WHERE  p.UnitsInStock - p.ReorderLevel < @p_qty 
GO 

EXEC sp_reorder_qty 9