-- 코드를 입력하세요
SELECT ins.NAME, ins.DATETIME   # 이름과 보호 시작일을 조회
FROM ANIMAL_INS ins
LEFT JOIN ANIMAL_OUTS outs
ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE outs.DATETIME IS NULL # 아직 입양을 못 간 동물
ORDER BY ins.DATETIME   # 보호 시작일 순
LIMIT 3;    # 동물 3마리