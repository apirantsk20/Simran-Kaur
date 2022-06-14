--B3 
SELECT  customerID	    AS CustomerID,
		companyName     AS CompanyName,
		country		    AS Country,
		phone			AS Phone
FROM   customers
WHERE  country IN ('Canada','USA')
ORDER BY customerID   