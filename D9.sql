--D9 
CREATE TRIGGER  tr_check_qty
ON    orderdetails 
FOR UPDATE 
AS 
BEGIN DECLARE @v_productid int 
SELECT  @v_productid = inserted.productid 
FROM   inserted
IF (SELECT quantity FROM inserted) > (SELECT unitsinstock FROM products  
WHERE ProductID = @v_productid) 
BEGIN
PRINT 'Order Quantity Can Not Exceed Stock Quantity'
ROLLBACK TRANSACTION 
END
END 
 
 UPDATE OrderDetails
 SET Quantity = 40
 WHERE OrderID = 10044  
 AND ProductID = 77 