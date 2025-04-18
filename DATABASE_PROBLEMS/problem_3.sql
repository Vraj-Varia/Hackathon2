USE rarebooks;

SELECT 
    a.author_last_first AS author,
    w.title,
    COUNT(v.inventory_id) AS count
FROM 
    Volume v
JOIN 
    Book b ON v.ISBN = b.ISBN
JOIN 
    Work w ON b.work_numb = w.work_numb
JOIN 
    Author a ON w.author_numb = a.author_numb
WHERE 
    v.sale_id IS NULL
GROUP BY 
    a.author_last_first,
    w.title
ORDER BY 
    author,
    title;
