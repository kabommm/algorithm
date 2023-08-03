-- 코드를 입력하세요
SELECT ins.ANIMAL_ID, ins.ANIMAL_TYPE, ins.NAME # 아이디, 생물 종, 이름을 조회
FROM ANIMAL_INS ins
INNER JOIN ANIMAL_OUTS outs
ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE 
    (ins.SEX_UPON_INTAKE LIKE '%Intact%') # 들어올 당시에는 중성화되지 않았지만
    AND
    (outs.SEX_UPON_OUTCOME NOT LIKE '%Intact%') # 나갈 당시에는 중성화된
ORDER BY ins.ANIMAL_ID; # 아이디 순으로 조회