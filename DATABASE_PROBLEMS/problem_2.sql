USE rarebooks;

SELECT 
    cc.condition_description,
    SUM(v.selling_price) AS total_sales
FROM 
    Volume v
JOIN 
    Condition_Codes cc ON v.condition_code = cc.condition_code
JOIN 
    Sale s ON v.sale_id = s.sale_id
WHERE 
    v.selling_price IS NOT NULL
GROUP BY 
    cc.condition_description
ORDER BY 
    total_sales DESC;
