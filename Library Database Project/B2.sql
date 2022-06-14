--B2
SELECT  productID     AS ProductID,
productName     AS ProductName,
englishName     AS EnglishName,
unitPrice     AS UnitPrice
FROM   products
WHERE  unitPrice < 8.00
ORDER BY productid 