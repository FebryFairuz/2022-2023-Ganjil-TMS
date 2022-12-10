-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 10, 2022 at 05:39 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ibik_api_academic`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `id` int(11) NOT NULL,
  `code` varchar(10) DEFAULT NULL,
  `name` varchar(50) DEFAULT '',
  `credit` int(11) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `code`, `name`, `credit`, `is_active`) VALUES
(1, 'TIFA3S3', 'Teknologi Microservices / Webservices', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `programs`
--

CREATE TABLE `programs` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT '',
  `description` varchar(255) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `programs`
--

INSERT INTO `programs` (`id`, `name`, `description`, `is_active`) VALUES
(1, 'Bachelor Degree', 'S1', 1),
(2, 'Master Degree', 'S2', 1),
(3, 'Diploma Degree', 'D3', 1);

-- --------------------------------------------------------

--
-- Table structure for table `program_study`
--

CREATE TABLE `program_study` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT '',
  `code` varchar(10) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  `program_id` int(11) DEFAULT NULL,
  `faculty_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `program_study`
--

INSERT INTO `program_study` (`id`, `name`, `code`, `description`, `is_active`, `program_id`, `faculty_id`) VALUES
(1, 'Fakultas Bisnis', 'FB', NULL, 1, 1, NULL),
(2, 'Fakultas Pariwisata dan Informatika', 'FPI', NULL, 1, 1, NULL),
(3, 'Akuntansi', 'AK', NULL, 1, 1, 1),
(4, 'Manajemen', 'MJ', NULL, 1, 1, 1),
(5, 'Biokewirausahaan', 'BK', NULL, 1, 1, 1),
(6, 'Teknologi Informatika', 'TI', NULL, 1, 1, 2),
(7, 'Sistem Informasi', 'SI', NULL, 1, 1, 2),
(8, 'Pariwisata', 'PW', NULL, 1, 1, 2),
(10, 'Pajak Keuangan', 'PK', NULL, 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `npm` varchar(15) DEFAULT '',
  `firstname` varchar(20) DEFAULT NULL,
  `middlename` varchar(20) DEFAULT '',
  `lastname` varchar(20) DEFAULT NULL,
  `program_id` int(11) NOT NULL,
  `program_study_id` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `birthdate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `npm`, `firstname`, `middlename`, `lastname`, `program_id`, `program_study_id`, `email`, `birthdate`) VALUES
(1, '192310011', 'Reza', 'Zaini', 'Arab', 1, 6, '192310011@student.ibik.ac.id', '2000-11-12'),
(2, '192310016', 'Candra', 'Agnitya', 'Wiguna', 1, 6, '192310016@student.ibik.ac.id', '2000-11-12'),
(3, '202310007', 'Shania', 'Oktaviani', 'Gunawan', 1, 6, '202310007@student.ibik.ac.id', '2000-11-12'),
(4, '202310014', 'Angelive', NULL, 'Hilsunny', 1, 6, '202310014@student.ibik.ac.id', '2000-11-12'),
(6, '202310016', 'Michael', 'Mervin', 'Ruswan', 1, 6, '202310016@student.ibik.ac.id', '2000-11-12'),
(7, '202310015', 'Irvan', 'Ariansyah', 'Rizky', 1, 6, '202310015@student.ibik.ac.id', '2000-11-12'),
(8, '202310017', 'Novi', 'Damayanti', 'Widia', 1, 6, '202310017@student.ibik.ac.id', '2000-11-12'),
(9, '202310018', 'Raiyana', 'Winata', 'Jan', 1, 6, '202310018@student.ibik.ac.id', '2000-11-12'),
(10, '202310020', 'Thesya', NULL, 'Marcella', 1, 6, '202310020@student.ibik.ac.id', '2000-11-12'),
(11, '202310021', 'Muhammad', NULL, 'Ilham', 1, 6, '202310021@student.ibik.ac.id', '2000-11-12'),
(12, '202310028', 'Diva', NULL, 'Lutfiando', 1, 6, '202310028@student.ibik.ac.id', '2000-11-12'),
(13, '202310034', 'Raihan', 'Dwi', 'Pratama', 1, 6, '202310034@student.ibik.ac.id', '2000-11-12'),
(14, '202310038', 'Raihan', 'Dwi', 'Win Cahya', 1, 6, '202310038@student.ibik.ac.id', '2000-11-12'),
(15, '202310041', 'Muhammad', 'Fadhlurrahman', 'Audya', 1, 6, '202310041@student.ibik.ac.id', '2000-11-12'),
(16, '202310055', 'Ryan', 'Sachio', 'Rohandy', 1, 6, '202310055@student.ibik.ac.id', '2000-11-12'),
(17, '202310061', 'Eki', NULL, 'Virgiana', 1, 6, '202310061@student.ibik.ac.id', '2000-11-12'),
(18, '202310063', 'Muhamad', 'Kahfi', 'Al', 1, 6, '202310063@student.ibik.ac.id', '2000-11-12'),
(19, '202310064', 'Achmad', NULL, 'Buhori', 1, 6, '202310064@student.ibik.ac.id', '2000-11-12'),
(20, '202310065', 'Fachry', 'Alam', 'Syah', 1, 6, '202310065@student.ibik.ac.id', '2000-11-12'),
(21, '202310067', 'Yudhistira', NULL, 'Kusuma', 1, 6, '202310067@student.ibik.ac.id', '2000-11-12'),
(22, '202310068', 'Afanda', 'Rafi', 'Faizulyan', 1, 6, '202310068@student.ibik.ac.id', '2000-11-12'),
(23, '202310072', 'Fajar', NULL, 'Alfianto', 1, 6, '202310072@student.ibik.ac.id', '2000-11-12'),
(24, '202310077', 'Nicholas', NULL, 'Fico', 1, 6, '202310077@student.ibik.ac.id', '2000-11-12'),
(25, '222310082', 'Soni', NULL, 'Nugraha', 1, 6, '222310082@student.ibik.ac.id', '2000-11-12'),
(26, '202310099', 'Jaenudin', '', 'Munawaroh', 1, 7, 'jaenudin@gmail.com', '2000-01-23'),
(29, '202310098', 'Upin', 'Bin', 'Kak Rossss', 1, 6, 'upin.ipn@gmail.com', '2000-01-23'),
(30, '11111', 'udin', 'petot', 'sedunia', 1, 6, 'udin@sedunia.com', '2022-12-29'),
(31, '222222111', 'Udin', 'Sedunia', 'Test', 2, 6, 'udin@gmail.com', '2022-12-15');

-- --------------------------------------------------------

--
-- Table structure for table `student_rel_courses`
--

CREATE TABLE `student_rel_courses` (
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `programs`
--
ALTER TABLE `programs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `program_study`
--
ALTER TABLE `program_study`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_clsuoncsm6le76elr6r117u99` (`code`),
  ADD KEY `FKgf1o7td7vrje5cauq3so07rq2` (`program_id`),
  ADD KEY `FKcd2ktf2pvri17mher1eoicgs5` (`faculty_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `npm` (`npm`),
  ADD KEY `FKosyri4p0rpereimcss9cm3cwv` (`program_id`),
  ADD KEY `FKikk2bx8ym3e7nst2rea4oi2d6` (`program_study_id`);

--
-- Indexes for table `student_rel_courses`
--
ALTER TABLE `student_rel_courses`
  ADD PRIMARY KEY (`student_id`,`course_id`),
  ADD KEY `FKbgpnxmkbq4lg48e4jm27rdi1q` (`course_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `programs`
--
ALTER TABLE `programs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `program_study`
--
ALTER TABLE `program_study`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `program_study`
--
ALTER TABLE `program_study`
  ADD CONSTRAINT `FKcd2ktf2pvri17mher1eoicgs5` FOREIGN KEY (`faculty_id`) REFERENCES `program_study` (`id`),
  ADD CONSTRAINT `FKgf1o7td7vrje5cauq3so07rq2` FOREIGN KEY (`program_id`) REFERENCES `programs` (`id`);

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `FKikk2bx8ym3e7nst2rea4oi2d6` FOREIGN KEY (`program_study_id`) REFERENCES `program_study` (`id`),
  ADD CONSTRAINT `FKosyri4p0rpereimcss9cm3cwv` FOREIGN KEY (`program_id`) REFERENCES `programs` (`id`);

--
-- Constraints for table `student_rel_courses`
--
ALTER TABLE `student_rel_courses`
  ADD CONSTRAINT `FKbgpnxmkbq4lg48e4jm27rdi1q` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`),
  ADD CONSTRAINT `FKhmy4g8coq39gdyiihe6fhjf6g` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
