INSERT INTO user_details (birth_date, id, name)
VALUES
    (current_date(), 1001, 'UTTU'),
    (current_date(), 1002, 'ISHA'),
    (current_date(), 1003, 'RONNY');

INSERT INTO post(id,user_id,description)
VALUES
    (123, 1001, 'Wanna Learn AW'),
    (124, 1002, 'Wanna Learn devops'),
    (125, 1003, 'Wanna Learn AZURE');