--D10 
 
CREATE TRIGGER  tr_insert_shippers 
ON    shippers
INSTEAD OF INSERT,
UPDATE
AS
BEGIN 
DECLARE @v_name  varchar(40)
SELECT @v_name = inserted.companyname
FROM inserted
IF
(SELECT companyname FROM inserted) = (SELECT companyname FROM shippers  WHERE companyname = @v_name)
BEGIN   
PRINT'Company Name Can Not Be Duplicated'
END
ELSE 
BEGIN 
INSERT INTO shippers  
SELECT * 
FROM inserted 
END
END 

INSERT Shippers VALUES ( 4, 'Federal Shipping' ) 
 