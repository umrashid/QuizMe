-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 29, 2019 at 04:48 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `QuizMe`
--

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `questionID` int(11) NOT NULL,
  `question` varchar(1000) NOT NULL,
  `correct` varchar(255) NOT NULL,
  `option1` varchar(255) NOT NULL,
  `option2` varchar(255) NOT NULL,
  `option3` varchar(255) NOT NULL,
  `categoryID` int(11) NOT NULL,
  `difficultyID` int(11) NOT NULL,
  `questionTypeID` int(11) NOT NULL,
  `ImagePath` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`questionID`, `question`, `correct`, `option1`, `option2`, `option3`, `categoryID`, `difficultyID`, `questionTypeID`, `ImagePath`) VALUES
(83, 'What is the capital of Canada?', 'Ottawa', 'Toronto', 'Vancouver', 'Montreal', 1, 1, 1, NULL),
(84, 'What is the capital of USA?', 'Washington DC', 'Chicago', 'Los Angeles', 'New York', 1, 1, 1, NULL),
(85, 'What is the capital of UK?', 'London', 'Manchester', 'Liverpool', 'Birmingham', 1, 1, 1, NULL),
(86, 'What is the capital of Egypt?', 'Cairo', 'Alexandria', 'Luxor', 'Giza', 1, 2, 1, NULL),
(87, 'What is the capital of Australia?', 'Canberra', 'Sydney', 'Melbourne', 'Brisbane', 1, 2, 1, NULL),
(88, 'What is the capital of Greece?', 'Athens', 'Mykonons', 'Santorini', 'Larissa', 1, 2, 1, NULL),
(89, 'What is the capital of Iran?', 'Tehran', 'Mashhad', 'Isfahan', 'Karaj', 1, 3, 1, NULL),
(90, 'What is the capital of Libya?', 'Tripoli', 'Benghazi', 'Misrata', 'Sirte', 1, 3, 1, NULL),
(91, 'What is the capital of Romania?', 'Bucharest', 'Brasov', 'Lasi', 'Cluj-Napoca', 1, 3, 1, NULL),
(93, 'How many planets are there in our Solar System?', 'Eight', 'Six', 'Seven', 'Ten', 2, 1, 1, 'null'),
(94, 'Which of the planet have rings around it?', 'Saturn', 'Venus    ', 'Mars    ', 'Jupiter', 2, 1, 1, 'null'),
(95, 'What is the nickname of Mars?', 'Red Planet', 'Red Dot     ', 'Red Marble     ', 'Rusty Planet', 2, 1, 1, 'null'),
(96, 'Which is the hottest planet in Solar System?', 'Venus', 'Mars', 'Mercury   ', 'Jupiter     ', 2, 2, 1, 'null'),
(97, 'Which of the following planet spin fastest?', 'Jupiter', 'Uranus', 'Mars', ' Mercury ', 2, 2, 1, 'null'),
(98, 'Halley?s Comet is seen after ______ years from Earth?', '75 years', '85 years', '90 years', '80 years', 2, 2, 1, 'null'),
(99, 'What is the brightest object in the Universe?', 'Quasars ', 'Super Nova', 'Constellation ', 'Stars', 2, 3, 1, 'null'),
(100, 'What?s the average temperature at visible surface o f sun a.k.a. Photosphere?', '5800k', '6000k', '5000k', '6500k', 2, 3, 1, 'null'),
(101, 'Which planet has the highest mountain in the Solar System?', 'Mars', 'Earth', 'Jupiter', 'Saturn', 2, 3, 1, 'null'),
(102, 'Who was the first President of United States of America?', 'George Washington', 'Thomas Jefferson     ', ' Abraham Lincoln', 'James Madison ', 3, 1, 1, 'null'),
(103, 'Who is the current Prime Minister of Canada?', 'Justin Trudeau', 'Jagmeet Singh', 'Donald Trump', 'Vladmir Putin', 3, 1, 1, 'null'),
(104, 'Where British Columbia Parliament Building located?', 'Victoria', 'Vancouver', 'Kelowna', 'Kamloops', 3, 1, 1, 'null'),
(105, 'Which country has largest democracy in the World?', 'India', 'China', 'USA', 'Russia', 3, 2, 1, 'null'),
(106, 'How many provinces are there in Canada?', 'Ten', 'Nine', 'Eleven', 'Twelve', 3, 2, 1, 'null'),
(107, 'Which President of USA had a famous speech ?We choose to go to the Moon? ?', 'John F. Kennedy', 'George W. Bush', 'Bill Clint', 'Gerald Ford', 3, 2, 1, 'null'),
(108, 'Who was the first Prime Minister of Great Britain', 'Robert Walpole', 'Theresa May', 'Boris Johnson', 'William Gladstone', 3, 3, 1, 'null'),
(109, 'Which country is not a member of Veto Power of United Nation?', 'Japan ', 'United Kingdom', 'France', 'China', 3, 3, 1, 'null'),
(110, 'Who was the first Prime Minister of Canada?', 'Sir John A Macdonald', 'Alexander Mackenzie', 'Sir John Abbott', 'Sir John Thompson', 3, 3, 1, 'null'),
(111, 'Which farm animal gives us milk?', 'Cow', 'Horse', 'Dog', 'Hen', 4, 1, 1, 'null'),
(112, 'Name the animal with pink color and curly tail', 'Pig', 'Skunk', 'Dog', 'Cow', 4, 1, 1, 'null'),
(113, 'Which of the animal is known as for chasing rats?', 'Cat', 'Kangaroo', 'Deer', 'Ox', 4, 1, 1, 'null'),
(114, 'Which is the fastest land animal?', 'Cheetah', 'Jackal', 'Tiger', 'Jaguar', 4, 2, 1, 'null'),
(115, 'In which continent, we cannot find Bees?', 'Antartica', 'Europe', 'Noth America', 'Antartica', 4, 2, 1, 'null'),
(116, 'Which of the following bird can fly?', 'Flamingo', 'Penguin', 'Ostrich', 'Kiwi', 4, 2, 1, 'null'),
(117, 'What is the national animal of Canada?', 'Beaver', 'Canadian Goose', 'Raccoon', 'Grizzly Bear', 4, 3, 1, 'null'),
(118, 'What do you call a baby goat?', 'Kid', 'Lamb', 'Cub', 'Pup', 4, 3, 1, 'null'),
(119, 'Among these birds, which one is the smallest?', 'Humming Bird', 'Nightingale', 'Sparrow', 'Crow', 4, 3, 1, 'null'),
(120, 'Which is the largest country in the World?', 'Russia', 'Canada', 'China', 'Russia', 5, 1, 1, 'null'),
(121, 'In which Mountain Range is Mount Everest?', 'The Himalayas', 'Rocky Mountain', 'The Alps', 'Andes', 5, 1, 1, 'null'),
(122, 'Which of the following is the longest river in the World?', 'Nile', 'Amazon', 'Ganga', 'Thames', 5, 1, 1, 'null'),
(123, 'Which city is situated on two continents?', 'Istanbul', 'Singapore', 'New Mexico', 'Milan', 5, 2, 1, 'null'),
(124, 'Which of the following sea separates Europe from Africa?', 'Mediterranean Sea', 'Arabian Sea', 'Black Sea', 'Caribbean Sea', 5, 2, 1, 'null'),
(125, 'Which is the largest Capital City in the World by Population?', 'Tokyo', 'New Delhi', 'Hong Kong', 'New York', 5, 2, 1, 'null'),
(126, 'Which Italian city is famous for its Canals?', 'Venice', 'florence', 'Rome', 'Milan', 5, 3, 1, 'null'),
(127, 'Which desert is located in Central Asia', 'Gobi Desert', 'Sahara Desert', 'Thar Desert', 'Arabian Sea', 5, 3, 1, NULL),
(128, 'Which canal divides North America and South America?', 'Panama Canal', 'Suzhou Canal', 'Suez Canal', 'Stockholm Canal', 5, 3, 1, 'null'),
(129, 'Which car is manufactured by a German company?', 'BMW', 'Nissan', 'TOYOTA', 'HONDA', 6, 1, 1, NULL),
(130, 'Which company manufactures the famous R8? ', 'AUDI', 'BMW', 'TOYOTA', 'HONDA', 6, 1, 1, NULL),
(131, 'Which company is famous for it\'s Electric cars? ', 'TESLA', 'NISSAN', 'AUDI', 'TOYOTA', 6, 1, 1, 'null'),
(132, 'Which company is the luxury vehicle marque of Honda?', 'ACURA', 'NISSAN', 'AUDI', 'ALFA ROMEO', 6, 2, 1, NULL),
(133, 'Which brand is a subsidiary of BMW?', 'ROLLS ROYCE', 'McLAREN', 'FERRARI', 'BENTLEY', 6, 2, 1, NULL),
(134, 'Which brand is owned by an American company that manufactures agricultural heavy equipment?', 'JOHN DERRE', 'DUCATI', 'MUSTANG', 'FERRARI', 6, 2, 1, NULL),
(135, 'When was Scuderia Ferrari Founded?', '1929', '1945', '1939', '1937', 6, 3, 1, 'null'),
(136, 'Which among these is the fastest category of cars?', 'Dragesters', 'F1', 'SUV', 'Sports Cars', 6, 3, 1, 'null'),
(137, '______ is a French automotive manufacturer, part of Groupe PSA', 'Peugot', 'Pagani', 'GTA Spano', 'Ferrari', 6, 3, 1, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`questionID`),
  ADD UNIQUE KEY `questionID` (`questionID`),
  ADD KEY `questionID_2` (`questionID`),
  ADD KEY `categoryID` (`categoryID`),
  ADD KEY `difficultyID` (`difficultyID`),
  ADD KEY `questionTypeID` (`questionTypeID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `questionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=156;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`categoryID`) REFERENCES `categories` (`categoryID`),
  ADD CONSTRAINT `question_ibfk_2` FOREIGN KEY (`difficultyID`) REFERENCES `difficultylevels` (`difficultyID`),
  ADD CONSTRAINT `question_ibfk_3` FOREIGN KEY (`questionTypeID`) REFERENCES `questiontype` (`questionTypeID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
