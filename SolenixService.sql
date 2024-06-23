INSERT INTO Satellite (name) VALUES ('SatelliteA');
INSERT INTO Satellite (name) VALUES ('SatelliteB');
INSERT INTO Satellite (name) VALUES ('SatelliteC');
INSERT INTO Satellite (name) VALUES ('SENTINEL-1A');
INSERT INTO Satellite (name) VALUES ('SENTINEL-1B');

INSERT INTO Event (Satellite_Id, event_date, description, priority) VALUES (1, '2024-06-21', 'Event 1 Description', 'High');
INSERT INTO Event (Satellite_Id, event_date, description, priority) VALUES (2, '2024-06-22', 'Event 2 Description', 'Medium');
INSERT INTO Event (Satellite_Id, event_date, description, priority) VALUES (3, '2024-06-23', 'Event 3 Description', 'Low');
INSERT INTO Event (Satellite_Id, event_date, description, priority) VALUES (1, '2024-06-24', 'Event 4 Description', 'High');
INSERT INTO Event (Satellite_Id, event_date, description, priority) VALUES (2, '2024-06-25', 'Event 5 Description', 'Medium');
