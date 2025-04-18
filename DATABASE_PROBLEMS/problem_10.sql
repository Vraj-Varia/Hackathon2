USE rarebooks;

-- Delete volumes associated with Thorndike Press
DELETE v
FROM Volume v
JOIN Book b ON v.ISBN = b.ISBN
JOIN Publisher p ON b.publisher_id = p.publisher_id
WHERE p.publisher_name = 'Thorndike Press';

-- Delete books associated with Thorndike Press
DELETE b
FROM Book b
JOIN Publisher p ON b.publisher_id = p.publisher_id
WHERE p.publisher_name = 'Thorndike Press';

-- Delete the publisher
DELETE FROM Publisher
WHERE publisher_name = 'Thorndike Press';
