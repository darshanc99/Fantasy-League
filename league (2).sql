-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 20, 2018 at 06:04 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `league`
--

-- --------------------------------------------------------

--
-- Table structure for table `league`
--

CREATE TABLE `league` (
  `player_id` int(11) NOT NULL,
  `player_name` varchar(40) DEFAULT NULL,
  `team` varchar(255) DEFAULT NULL,
  `price` int(255) DEFAULT '0',
  `Goal` int(11) DEFAULT '0',
  `Assist` int(11) NOT NULL DEFAULT '0',
  `Yellow_Card` int(11) NOT NULL DEFAULT '0',
  `Red_Card` int(11) NOT NULL DEFAULT '0',
  `Saves` int(11) NOT NULL DEFAULT '0',
  `Total` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `league`
--

INSERT INTO `league` (`player_id`, `player_name`, `team`, `price`, `Goal`, `Assist`, `Yellow_Card`, `Red_Card`, `Saves`, `Total`) VALUES
(1, 'Sergio Aguero', 'MCI', 0, 0, 0, 0, 0, 0, 0),
(2, 'Harry Kane', 'TOT', 0, 0, 0, 0, 0, 0, 0),
(3, 'A. Mitrovic', 'FUL', 5, 0, 0, 0, 0, 0, 0),
(4, 'Glenn Murray', 'BHA', 5, 0, 0, 0, 0, 0, 0),
(5, 'Oliver Giroud', 'CHE', 4, 0, 0, 0, 0, 0, 0),
(6, 'Jose Holebas', 'WAT', 4, 0, 0, 0, 0, 0, 0),
(7, 'Benjamin Mendy', 'MCI', 4, 0, 0, 0, 0, 0, 0),
(8, 'Luciano Vietto', 'FUL', 4, 0, 0, 0, 0, 0, 0),
(9, 'Romelu Lukaku', 'MAN', 0, 0, 0, 0, 0, 0, 0),
(10, 'Callum Wilson', 'BOU', 4, 0, 0, 0, 0, 0, 0),
(11, 'Aaron Wan-Bissaka', 'CRY', 0, 0, 0, 0, 0, 0, 0),
(12, 'Mohamed Diame', 'NEW', 0, 0, 0, 0, 0, 0, 0),
(13, 'Ricardo Pereira', 'LEI', 0, 0, 0, 0, 0, 0, 0),
(14, 'Will Hughes', 'WAT', 0, 0, 0, 0, 0, 0, 0),
(15, 'Wilfred Ndidi', 'LEI', 0, 0, 0, 0, 0, 0, 0),
(16, 'Joe Hart', 'BUR', 0, 0, 0, 0, 0, 0, 0),
(17, 'Neil Etheridge', 'CAR', 0, 0, 0, 0, 0, 0, 0),
(18, 'Alex McCarthy', 'SOU', 0, 0, 0, 0, 0, 0, 0),
(19, 'Mat Ryan', 'BHA', 0, 0, 0, 0, 0, 0, 0),
(20, 'Rui Patricio', 'WOL', 0, 0, 0, 0, 0, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `league`
--
ALTER TABLE `league`
  ADD PRIMARY KEY (`player_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `league`
--
ALTER TABLE `league`
  MODIFY `player_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
