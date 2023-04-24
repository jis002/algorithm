-- 코드를 입력하세요
SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, DATE_FORMAT(r.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
FROM USED_GOODS_BOARD b, USED_GOODS_REPLY r
WHERE b.board_id = r.board_id AND b.created_date BETWEEN "2022-10-01" AND "2022-10-31"
ORDER BY r.created_date, b.title; 