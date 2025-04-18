SELECT 
    v.inventory_id,
    w.title,
    cc.condition_description,
    v.selling_price
FROM 
    Volume v
JOIN 
    Book b ON v.ISBN = b.ISBN
JOIN 
    Work w ON b.work_numb = w.work_numb
JOIN 
    Condition_Codes cc ON v.condition_code = cc.condition_code
JOIN 
    Sale s ON v.sale_id = s.sale_id
WHERE 
    v.selling_price > (
        SELECT AVG(v2.selling_price)
        FROM Volume v2
        JOIN Sale s2 ON v2.sale_id = s2.sale_id
        WHERE MONTH(s2.sale_date) = 7 AND YEAR(s2.sale_date) = 2021
    )
ORDER BY 
    w.title;
