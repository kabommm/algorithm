-- 코드를 입력하세요
# 테이블이 두개 = JOIN사용
SELECT ins.ANIMAL_ID, ins.NAME  # 아이디와 이름을 조회
FROM ANIMAL_INS ins
INNER JOIN ANIMAL_OUTS outs # 모든 열이 같으므로 INNER JOIN
ON ins.ANIMAL_ID = outs.ANIMAL_ID   # 외래키 조인
ORDER BY outs.DATETIME-ins.DATETIME DESC # 보호 기간이 긴 순
LIMIT 2;    # 동물 두 마리