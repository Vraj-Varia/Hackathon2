SELECT 
    YEAR(s.sale_date) AS year,
    MONTH(s.sale_date) AS month,
    DAY(s.sale_date) AS day,
    SUM(s.sale_total_amt) AS sales
FROM 
    Sale s
WHERE 
    YEAR(s.sale_date) = 2021
GROUP BY 
    YEAR(s.sale_date), 
    MONTH(s.sale_date), 
    DAY(s.sale_date) WITH ROLLUP
HAVING 
    year IS NOT NULL;
