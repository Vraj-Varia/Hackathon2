SELECT 
    a.author_last_first AS author,
    w.title,
    COUNT(v.inventory_id) AS copies_sold,
    SUM(v.selling_price) AS total_sales
FROM 
    Volume v
JOIN 
    Book b ON v.ISBN = b.ISBN
JOIN 
    Work w ON b.work_numb = w.work_numb
JOIN 
    Author a ON w.author_numb = a.author_numb
JOIN 
    Sale s ON v.sale_id = s.sale_id
WHERE 
    MONTH(s.sale_date) = 7 AND YEAR(s.sale_date) = 2021
GROUP BY 
    a.author_last_first,
    w.title
ORDER BY 
    copies_sold DESC;
