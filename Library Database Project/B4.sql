--B4 
SELECT		 s.supplierID     AS SupplierID, 
			 s.name      AS Name,
			 p.productName     AS ProductName,
			 p.reorderLevel    AS ReorderLevel,
			 p.unitsInStock    AS UnitsInStock
FROM		 suppliers s
JOIN		 products        p ON s.supplierID = p.supplierID
WHERE		 p.reorderLevel = p.unitsInStock
ORDER BY	 s.supplierId	