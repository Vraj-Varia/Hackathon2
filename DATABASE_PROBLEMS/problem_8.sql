INSERT INTO Sale (customer_numb, sale_date, sale_total_amt, credit_card_numb, exp_month, exp_year)
VALUES (3, '2021-11-03', 125.00, '1234 5678 9101 4321', 7, 23);

SET @last_sale_id = LAST_INSERT_ID();

UPDATE Volume
SET sale_id = @last_sale_id, selling_price = 125.00
WHERE inventory_id = 67;
