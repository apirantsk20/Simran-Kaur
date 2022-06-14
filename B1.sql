--B1 
SELECT  o.orderID     AS OrderID,
o.quantity     AS Quantity,
p.productID     AS ProductID,
p.reorderLevel    AS ReorderLevel,
s.supplierID     AS SupplierID 
 
FROM  OrderDetails        o
JOIN  products  p ON p.productID = o.productID 
JOIN  suppliers  s ON s.supplierID = p.supplierID 
WHERE  o.quantity BETWEEN 65 AND 70 
ORDER BY o.orderID