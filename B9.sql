--B9
SELECT  productID      AS  ProductID, 
		productName      AS ProductName,
		quantityPerUnit     AS QuantityPerUnit, 
		unitPrice      AS UnitPrice
FROM    products  
WHERE CHARINDEX ('choc', productName)>0 OR CHARINDEX ('tofu', productName)>0
ORDER BY productid 