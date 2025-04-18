USE rarebooks;

SELECT 
    cc.condition_description,
    COUNT(v.inventory_id) AS count
FROM 
    Volume v
JOIN 
    Condition_Codes cc ON v.condition_code = cc.condition_code
WHERE 
    v.sale_id IS NULL
GROUP BY 
    cc.condition_description
ORDER BY 
    cc.condition_description;
