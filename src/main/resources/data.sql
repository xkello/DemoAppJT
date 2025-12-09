INSERT INTO USERS (FIRST_NAME, LAST_NAME, USERNAME, USER_TYPE, ROLE, TEAM)
VALUES ('Michal', 'Makas', 'mmakas', 'USER', 'MANAGER', 'DEV');

INSERT INTO USERS (FIRST_NAME, LAST_NAME, USERNAME, USER_TYPE, ROLE, TEAM)
VALUES ('Jana', 'Nováková', 'jnovakova', 'USER', 'EMPLOYEE', 'DEV');

INSERT INTO USERS (FIRST_NAME, LAST_NAME, USERNAME, USER_TYPE, ROLE, TEAM)
VALUES ('Peter', 'Šéf', 'psef', 'USER', 'DIRECTOR', 'DIRECTOR');


INSERT INTO VACATION_REQUEST (
    APPROVED_BY_DIRECTOR,
    APPROVED_BY_MANAGER,
    CREATED_DATE,
    DAYS,
    END_DATE,
    END_PART_OF_DAY,
    START_DATE,
    START_PART_OF_DAY,
    STATUS,
    CREATED_BY_ID
) VALUES (
             '-',
             'Martin',
             '2016-08-14',
             4.00,
             '2016-09-08',
             'Full day',
             '2016-09-05',
             'Full day',
             'APPROVED_BY_MANAGER',
             1
         );

INSERT INTO VACATION_REQUEST (
    APPROVED_BY_DIRECTOR,
    APPROVED_BY_MANAGER,
    CREATED_DATE,
    DAYS,
    END_DATE,
    END_PART_OF_DAY,
    START_DATE,
    START_PART_OF_DAY,
    STATUS,
    CREATED_BY_ID
) VALUES (
             '-',
             'Martin',
             '2016-12-05',
             1.00,
             '2016-12-07',
             'Full day',
             '2016-12-07',
             'Full day',
             'APPROVED_BY_MANAGER',
             1
         );

INSERT INTO VACATION_REQUEST (
    APPROVED_BY_DIRECTOR,
    APPROVED_BY_MANAGER,
    CREATED_DATE,
    DAYS,
    END_DATE,
    END_PART_OF_DAY,
    START_DATE,
    START_PART_OF_DAY,
    STATUS,
    CREATED_BY_ID
) VALUES (
             '-',
             'Martin',
             '2016-10-31',
             2.00,
             '2016-12-23',
             'Full day',
             '2016-12-22',
             'Full day',
             'APPROVED_BY_MANAGER',
             1
         );

INSERT INTO VACATION_REQUEST (
    APPROVED_BY_DIRECTOR,
    APPROVED_BY_MANAGER,
    CREATED_DATE,
    DAYS,
    END_DATE,
    END_PART_OF_DAY,
    START_DATE,
    START_PART_OF_DAY,
    STATUS,
    CREATED_BY_ID
) VALUES (
             '-',
             'Martin',
             '2016-10-31',
             4.00,
             '2016-12-30',
             'Full day',
             '2016-12-27',
             'Full day',
             'APPROVED_BY_MANAGER',
             1
         );

INSERT INTO VACATION_REQUEST (
    APPROVED_BY_DIRECTOR,
    APPROVED_BY_MANAGER,
    CREATED_DATE,
    DAYS,
    END_DATE,
    END_PART_OF_DAY,
    START_DATE,
    START_PART_OF_DAY,
    STATUS,
    CREATED_BY_ID
) VALUES (
             '-',
             'Martin',
             '2016-10-31',
             2.00,
             '2017-01-03',
             'Full day',
             '2017-01-02',
             'Full day',
             'APPROVED_BY_MANAGER',
             1
         );

-- večer → ráno (pol dňa + pol dňa = 1.0)

INSERT INTO VACATION_REQUEST (
    APPROVED_BY_DIRECTOR,
    APPROVED_BY_MANAGER,
    CREATED_DATE,
    DAYS,
    END_DATE,
    END_PART_OF_DAY,
    START_DATE,
    START_PART_OF_DAY,
    STATUS,
    CREATED_BY_ID
) VALUES (
             '-',
             'Martin',
             '2017-02-07',
             1.00,
             '2017-02-25',
             'Morning',
             '2017-02-24',
             'Evening',
             'APPROVED_BY_MANAGER',
             1
         );


INSERT INTO VACATION_REQUEST (
    APPROVED_BY_DIRECTOR,
    APPROVED_BY_MANAGER,
    CREATED_DATE,
    DAYS,
    END_DATE,
    END_PART_OF_DAY,
    START_DATE,
    START_PART_OF_DAY,
    STATUS,
    CREATED_BY_ID
) VALUES (
             '-',
             'Michal',
             '2017-06-01',
             1.00,
             '2017-06-15',
             'Evening',
             '2017-06-15',
             'Morning',
             'APPROVED_BY_MANAGER',
             2
         );

INSERT INTO VACATION_REQUEST (
    APPROVED_BY_DIRECTOR,
    APPROVED_BY_MANAGER,
    CREATED_DATE,
    DAYS,
    END_DATE,
    END_PART_OF_DAY,
    START_DATE,
    START_PART_OF_DAY,
    STATUS,
    CREATED_BY_ID
) VALUES (
             '-',
             'Michal',
             '2017-07-10',
             5.00,
             '2017-07-28',
             'Full day',
             '2017-07-24',
             'Full day',
             'NEW',
             2
         );


INSERT INTO VACATION_REQUEST (
    APPROVED_BY_DIRECTOR,
    APPROVED_BY_MANAGER,
    CREATED_DATE,
    DAYS,
    END_DATE,
    END_PART_OF_DAY,
    START_DATE,
    START_PART_OF_DAY,
    STATUS,
    CREATED_BY_ID
) VALUES (
             '-',
             'Board',
             '2017-09-01',
             5.00,
             '2017-09-15',
             'Full day',
             '2017-09-11',
             'Full day',
             'APPROVED_BY_MANAGER',
             3
         );
