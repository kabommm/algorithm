-- 코드를 입력하세요
# 테이블이 두개다? JOIN
SELECT animal_in.ANIMAL_ID, animal_in.NAME # 동물의 아이디와 이름을 조회
FROM ANIMAL_INS AS animal_in
INNER JOIN ANIMAL_OUTS AS animal_out  # 두 테이블의 컬럼이 모두 같으므로 INNER JOIN
ON animal_in.ANIMAL_ID = animal_out.ANIMAL_ID 
WHERE animal_out.DATETIME < animal_in.DATETIME # 보호 시작일보다 입양일이 더 빠른
ORDER BY animal_in.DATETIME; # 보호 시작일이 빠른 순으로 조회