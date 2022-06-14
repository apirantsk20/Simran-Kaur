--C1
CREATE VIEW		 vw_supplier_items (SupplierID, Name, ProductID, ProductName) 
AS
SELECT  DISTINCT s.supplierID,
				 s.name,
				 p.productID,   
				 p.productName
FROM			 suppliers s 
JOIN			 products p  ON s.supplierID = p.supplierID 

SELECT *
FROM vw_supplier_items 
ORDER BY Name, ProductID