USE rarebooks;

SELECT 
    b.ISBN,
    w.title,
    p.publisher_name,
    b.edition,
    b.binding,
    b.copyright_year,
    COUNT(v.inventory_id) AS count
FROM 
    Volume v
JOIN 
    Book b ON v.ISBN = b.ISBN
JOIN 
    Work w ON b.work_numb = w.work_numb
JOIN 
    Publisher p ON b.publisher_id = p.publisher_id
WHERE 
    v.sale_id IS NULL
GROUP BY 
    b.ISBN,
    w.title,
    p.publisher_name,
    b.edition,
    b.binding,
    b.copyright_year
ORDER BY 
    p.publisher_name;
