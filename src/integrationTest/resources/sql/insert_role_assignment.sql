DELETE FROM role_assignment;

INSERT INTO public.role_assignment
(id, actor_id_type, actor_id, role_type, role_name, classification, grant_type, role_category, read_only, begin_time, end_time, "attributes", created,authorisations)
VALUES('638e8e7a-7d7c-4027-9d53-ea4b1095eab1', 'IDAM', '123e4567-e89b-42d3-a456-556642445613', 'ORGANISATION', 'salaried-judge', 'PUBLIC', 'STANDARD', NULL, false, '2021-01-01 12:00:00.000', '2022-01-01 11:00:00.000', '{"region": "north-east", "contractType": "SALARIED", "jurisdiction": "divorce"}', '2020-06-24 17:35:08.546',ARRAY['dev']);

INSERT INTO public.role_assignment
(id, actor_id_type, actor_id, role_type, role_name, classification, grant_type, role_category, read_only, begin_time, end_time, "attributes", created)
VALUES('333d2a84-9dfa-4bf0-be5e-bf748656acc5', 'IDAM', '123e4567-e89b-42d3-a456-556642445613', 'ORGANISATION', 'salaried-judge', 'PUBLIC', 'STANDARD', NULL, true, '2021-01-01 12:00:00.000', '2022-01-01 11:00:00.000', '{"region": "north-east", "contractType": "SALARIED", "jurisdiction": "divorce"}', '2020-06-24 17:35:42.318');

INSERT INTO public.role_assignment
(id, actor_id_type, actor_id, role_type, role_name, classification, grant_type, role_category, read_only, begin_time, end_time, "attributes", created)
VALUES('cf89f230-0023-4bb6-b548-30da6a944172', 'IDAM', '123e4567-e89b-42d3-a456-556642445613', 'ORGANISATION', 'salaried-judge', 'PUBLIC', 'STANDARD', NULL, true, '2021-01-01 12:00:00.000', '2022-01-01 11:00:00.000', '{"region": "north-east", "contractType": "SALARIED", "jurisdiction": "divorce"}', '2020-06-25 12:30:41.166');

INSERT INTO public.role_assignment
(id, actor_id_type, actor_id, role_type, role_name, classification, grant_type, role_category, read_only, begin_time, end_time, "attributes", created)
VALUES('44276b66-11eb-42f5-a4dc-510fec18b0fb', 'IDAM', '123e4567-e89b-42d3-a456-556642445614', 'ORGANISATION', 'salaried-judge', 'PUBLIC', 'STANDARD', NULL, true, '2021-01-01 12:00:00.000', '2022-01-01 11:00:00.000', '{"region": "north-east", "contractType": "SALARIED", "jurisdiction": "divorce"}', '2020-06-25 12:32:03.683');

INSERT INTO public.role_assignment
(id, actor_id_type, actor_id, role_type, role_name, classification, grant_type, role_category, read_only, begin_time, end_time, "attributes", created)
VALUES('2ef8ebf3-266e-45d3-a3b8-4ce1e5d93b9f', 'IDAM', '123e4567-e89b-42d3-a456-556642445612', 'CASE', 'salaried-judge', 'PUBLIC', 'SPECIFIC', 'JUDICIAL', false, '2021-08-01 00:00:00.000', '2022-01-01 00:00:00.000', '{"caseId": "1234567890123456", "region": "south-east", "contractType": "SALARIED", "jurisdiction": "divorce"}', '2020-07-24 15:05:01.988');

