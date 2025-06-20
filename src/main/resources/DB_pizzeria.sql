CREATE DATABASE carrozzeria;
USE carrozzeria;

INSERT INTO vehicles (plate_number, brand, model, engine, color, year, vin, photo, owner_name, owner_phone) VALUES
-- Automobili
('WG64RZH', 'Fiat', 'Panda', '1.2 Benzina', 'Bianco', 2012, 'VF1ABCDE123456789', 'https://images.clickdealer.co.uk/vehicles/6673/6673936/large1/159622751.jpg', 'Mario Rossi', '3456789012'),
('EF456GH', 'Volkswagen', 'Golf', '1.6 TDI', 'Grigio', 2018, 'WVWZZZ1KZJW123456', 'https://prod.pictures.autoscout24.net/listing-images/73eea339-817e-4bc9-a6a3-b17048912f66_eb792e2d-1306-4023-8819-77932fa33e35.jpg/480x360.webp', 'Luisa Bianchi', '3491122334'),
('IJ789KL', 'Toyota', 'Yaris', '1.3 Hybrid', 'Blu', 2015, 'JTDBR32E520123456', 'https://www.netcarshow.com/Toyota-Yaris-2015-Front_Three-Quarter.3a338e0e.jpg', 'Andrea Verdi', '3289988776'),
('MJC2035', 'BMW', '320d', '2.0 Diesel', 'Nero', 2020, 'WBA8E91060GV12345', 'https://www.netcarshow.com/BMW-3-Series_Touring-2020-Front_Three-Quarter.f0373e50.jpg', 'Carlo Neri', '3334445566'),
('AV64JJL', 'Peugeot', '208', '1.4 HDi', 'Rosso', 2016, 'VF3CC8HP0DT123456', 'https://www.ymark.com/wp-content/uploads/2018/07/4AA65EF4-18C7-4149-8B75-180E4AB2DD3E-1080x675.jpeg', 'Giulia Bianchi', '3925567890'),
('UV678WX', 'Ford', 'Fiesta', '1.0 EcoBoost', 'Argento', 2014, 'WF0DXXGAKD4R12345', NULL, 'Paolo Neri', '3401234567'),
('YZ901AB', 'Audi', 'A3', '1.5 TFSI', 'Bianco', 2021, 'WAUZZZ8V4JA012345', NULL, 'Francesca Verde', '3895566778'),

-- Moto
('MO123AA', 'Yamaha', 'MT-07', '689cc Benzina', 'Blu', 2019, 'JYARM0616KA123456', NULL, 'Luca Bruni', '3345678901'),
('MO456BB', 'Ducati', 'Monster 821', '821cc Benzina', 'Rosso', 2017, 'ZDM1RB5N8HB123456', NULL, 'Sara Viola', '3609988776'),

-- Furgone
('FU789CC', 'Mercedes-Benz', 'Sprinter 311 CDI', '2.1 Diesel', 'Bianco', 2016, 'WDB9061311S123456', NULL, 'Impresa Edile Bianchi', '3894411223');