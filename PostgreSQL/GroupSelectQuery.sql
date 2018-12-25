SELECT 
  "STUDENTS"."GROUP_ID"
FROM 
  public."STUDENTS"
GROUP BY "STUDENTS"."GROUP_ID"
HAVING COUNT("STUDENTS"."GROUP_ID") < 10;




