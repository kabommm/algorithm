-- 코드를 입력하세요
# 테이블이 두개다? JOIN
SELECT animal_in.ANIMAL_ID, animal_in.NAME
FROM ANIMAL_INS AS animal_in
INNER JOIN ANIMAL_OUTS AS animal_out
ON animal_in.ANIMAL_ID = animal_out.ANIMAL_ID 
WHERE animal_out.DATETIME < animal_in.DATETIME
ORDER BY animal_in.DATETIME; # 보호 시작일이 빠른 순으로 조회