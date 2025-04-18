INSERT INTO Publisher (publisher_name) VALUES ('Thorndike Press');


INSERT INTO Author (author_last_first) VALUES ('Rowling, JK');


INSERT INTO Work (author_numb, title) 
VALUES ((SELECT author_numb FROM Author WHERE author_last_first = 'Rowling, JK'), 'Harry Potter and Sorcerer''s Stone');


INSERT INTO Book (ISBN, work_numb, publisher_id, edition, binding, copyright_year) 
VALUES ('978-0-78622-272-8', 
        (SELECT work_numb FROM Work WHERE title = 'Harry Potter and Sorcerer''s Stone'), 
        (SELECT publisher_id FROM Publisher WHERE publisher_name = 'Thorndike Press'), 
        1, 'Leather', '1999');


INSERT INTO Volume (ISBN, condition_code, date_acquired, asking_price, selling_price, sale_id) 
VALUES ('978-0-78622-272-8', 
        (SELECT condition_code FROM Condition_Codes WHERE condition_description = 'Excellent'), 
        '2018-03-01', 100.00, NULL, NULL);
