-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2016 at 03:35 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory`
--

-- --------------------------------------------------------

--
-- Table structure for table `bus_cus`
--

CREATE TABLE `bus_cus` (
  `name` varchar(50) NOT NULL,
  `email` varchar(60) NOT NULL,
  `user` varchar(20) NOT NULL,
  `mno` bigint(20) NOT NULL,
  `pass` varchar(15) NOT NULL,
  `address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bus_cus`
--

INSERT INTO `bus_cus` (`name`, `email`, `user`, `mno`, `pass`, `address`) VALUES
('Anil', 'anil@gmail.com', 'anil', 897652463, 'anil', 'Allahabad'),
('Ravi Verma', 'naughtyverma008@gmail.com', 'verma', 7382976649, 'verma', 'Vijayawada'),
('Shubham', 'skgeniusfamily@gmail.com', 'skgenius', 9560816088, 'qwerty', 'Hauz Khas'),
('Sandeep', 'veeranala.sandeep@gmail.com', 'sandeep', 8137082148, 'sandeep', 'Kadapa');

-- --------------------------------------------------------

--
-- Table structure for table `bus_transaction`
--

CREATE TABLE `bus_transaction` (
  `ticket` int(11) NOT NULL DEFAULT '1',
  `TranNo` bigint(20) NOT NULL,
  `email` varchar(60) NOT NULL,
  `date_time` varchar(30) NOT NULL,
  `init` varchar(15) NOT NULL,
  `dest` varchar(15) NOT NULL,
  `bus_no` varchar(10) NOT NULL,
  `depart_date_time` varchar(30) NOT NULL,
  `amount` bigint(20) NOT NULL,
  `number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bus_transaction`
--

INSERT INTO `bus_transaction` (`ticket`, `TranNo`, `email`, `date_time`, `init`, `dest`, `bus_no`, `depart_date_time`, `amount`, `number`) VALUES
(1, 4, 'skgeniusfamily@gmail.com', '2016-May-01 12:12:50', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-11', 3978, 2),
(1, 5, 'skgeniusfamily@gmail.com', '2016-May-01 12:17:33', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-04', 5967, 3),
(1, 6, 'skgeniusfamily@gmail.com', '2016-May-01 13:06:52', 'Mumbai', 'Kolkata', 'MuKofs101', '5:00 AM2016-05-19', 11600, 4),
(1, 7, 'skgeniusfamily@gmail.com', '2016-May-01 15:18:19', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-19', 5967, 3),
(1, 8, 'skgeniusfamily@gmail.com', '2016-May-01 19:45:55', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-18', 5967, 3),
(1, 9, 'skgeniusfamily@gmail.com', '2016-May-01 22:03:31', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-18', 5967, 3),
(1, 10, 'skgeniusfamily@gmail.com', '2016-May-03 02:17:34', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-19', 5967, 3),
(1, 11, 'anil@gmail.com', '2016-May-03 09:08:14', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-19', 5967, 3),
(1, 12, 'skgeniusfamily@gmail.com', '2016-May-03 20:28:15', 'New Delhi', 'New Delhi', 'KoChfs101', '5:00 AM2016-05-04', 5560, 2),
(1, 13, 'skgeniusfamily@gmail.com', '2016-May-03 20:30:18', 'New Delhi', 'New Delhi', 'KoChfs101', '5:00 AM2016-05-04', 5560, 2),
(1, 14, 'skgeniusfamily@gmail.com', '2016-May-03 20:35:49', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-17', 3978, 2),
(1, 15, 'skgeniusfamily@gmail.com', '2016-May-03 20:37:24', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-10', 3978, 2),
(1, 16, 'skgeniusfamily@gmail.com', '2016-May-03 20:37:41', 'Chennai', 'New Delhi', 'DlChfs101', '5:00 AM2016-05-10', 5978, 2),
(1, 17, 'skgeniusfamily@gmail.com', '2016-May-03 20:38:02', 'Chennai', 'New Delhi', 'DlChfs101', '5:00 AM2016-05-17', 5978, 2),
(1, 18, 'skgeniusfamily@gmail.com', '2016-May-03 20:39:23', 'Chennai', 'New Delhi', 'DlChfs102', '5:00 AM2016-05-17', 7707, 3),
(1, 19, 'skgeniusfamily@gmail.com', '2016-May-03 20:39:44', 'Kolkata', 'Mumbai', 'MuKofs101', '5:00 AM2016-05-17', 8700, 3),
(1, 20, 'skgeniusfamily@gmail.com', '2016-May-03 20:47:39', 'Mumbai', 'Chennai', 'MuChfs105', '7:00 PM2016-05-04', 4200, 2),
(1, 21, 'skgeniusfamily@gmail.com', '2016-May-03 20:48:02', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-17', 5967, 3),
(1, 22, 'skgeniusfamily@gmail.com', '2016-May-03 20:48:57', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-18', 7956, 4),
(1, 23, 'skgeniusfamily@gmail.com', '2016-May-03 20:50:32', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-17', 3978, 2),
(1, 24, 'skgeniusfamily@gmail.com', '2016-May-03 20:54:36', 'New Delhi', 'Chennai', 'DlChfs102', '5:00 AM2016-05-17', 5138, 2),
(1, 25, 'skgeniusfamily@gmail.com', '2016-May-04 10:13:46', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-11', 7956, 4),
(1, 26, 'skgeniusfamily@gmail.com', '2016-May-04 19:54:46', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-10', 3978, 2),
(1, 27, 'skgeniusfamily@gmail.com', '2016-May-04 19:55:09', 'Chennai', 'Kolkata', 'KoChfs101', '5:00 AM2016-05-17', 5560, 2),
(1, 28, 'skgeniusfamily@gmail.com', '2016-May-04 19:55:23', 'Chennai', 'Kolkata', 'KoChfs101', '5:00 AM2016-05-17', 5560, 2),
(1, 29, 'skgeniusfamily@gmail.com', '2016-May-04 19:56:51', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 5967, 3),
(1, 30, 'skgeniusfamily@gmail.com', '2016-May-04 19:57:19', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-04', 7956, 4),
(1, 31, 'skgeniusfamily@gmail.com', '2016-May-04 21:31:45', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-04', 5967, 3),
(1, 32, 'skgeniusfamily@gmail.com', '2016-May-04 21:40:49', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 7956, 4),
(1, 33, 'skgeniusfamily@gmail.com', '2016-May-04 21:41:46', 'New Delhi', 'Chennai', 'DlChfs101', '5:00 AM2016-05-05', 8967, 3),
(1, 34, 'skgeniusfamily@gmail.com', '2016-May-04 21:43:37', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-11', 5967, 3),
(1, 35, 'skgeniusfamily@gmail.com', '2016-May-04 21:44:00', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-11', 5967, 3),
(1, 36, 'skgeniusfamily@gmail.com', '2016-May-04 21:44:21', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-04', 3978, 2),
(1, 37, 'skgeniusfamily@gmail.com', '2016-May-04 21:45:37', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-11', 3978, 2),
(1, 38, 'skgeniusfamily@gmail.com', '2016-May-04 21:46:32', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-11', 3978, 2),
(1, 39, 'skgeniusfamily@gmail.com', '2016-May-04 21:46:57', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 5967, 3),
(1, 40, 'skgeniusfamily@gmail.com', '2016-May-04 21:47:52', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 3978, 2),
(1, 41, 'skgeniusfamily@gmail.com', '2016-May-04 21:48:32', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 3978, 2),
(1, 42, 'skgeniusfamily@gmail.com', '2016-May-04 21:48:43', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 3978, 2),
(1, 43, 'skgeniusfamily@gmail.com', '2016-May-04 21:53:43', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 3978, 2),
(1, 44, 'skgeniusfamily@gmail.com', '2016-May-04 21:54:37', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 3978, 2),
(1, 45, 'skgeniusfamily@gmail.com', '2016-May-04 21:55:13', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 3978, 2),
(1, 46, 'skgeniusfamily@gmail.com', '2016-May-04 21:55:49', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 3978, 2),
(1, 47, 'skgeniusfamily@gmail.com', '2016-May-04 21:56:00', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 3978, 2),
(1, 48, 'skgeniusfamily@gmail.com', '2016-May-04 21:56:17', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 3978, 2),
(1, 49, 'skgeniusfamily@gmail.com', '2016-May-04 21:56:30', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 3978, 2),
(1, 50, 'skgeniusfamily@gmail.com', '2016-May-04 21:56:50', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 3978, 2),
(1, 51, 'skgeniusfamily@gmail.com', '2016-May-04 21:58:01', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 3978, 2),
(1, 52, 'skgeniusfamily@gmail.com', '2016-May-04 22:00:35', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 5967, 3),
(1, 53, 'skgeniusfamily@gmail.com', '2016-May-04 22:01:08', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 5967, 3),
(1, 54, 'skgeniusfamily@gmail.com', '2016-May-04 22:03:34', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 5967, 3),
(1, 55, 'skgeniusfamily@gmail.com', '2016-May-04 22:03:59', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 5967, 3),
(1, 56, 'skgeniusfamily@gmail.com', '2016-May-04 22:05:24', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 5967, 3),
(1, 57, 'skgeniusfamily@gmail.com', '2016-May-04 22:06:12', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 5967, 3),
(1, 58, 'skgeniusfamily@gmail.com', '2016-May-04 22:06:24', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 5967, 3),
(1, 59, 'skgeniusfamily@gmail.com', '2016-May-04 22:08:53', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-05', 5967, 3),
(1, 60, 'skgeniusfamily@gmail.com', '2016-May-04 22:09:41', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-17', 3978, 2),
(1, 61, 'skgeniusfamily@gmail.com', '2016-May-04 22:10:57', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-06', 3978, 2),
(1, 62, 'skgeniusfamily@gmail.com', '2016-May-04 22:12:17', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-11', 5967, 3),
(1, 63, 'skgeniusfamily@gmail.com', '2016-May-04 22:12:45', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-11', 5967, 3),
(1, 64, 'skgeniusfamily@gmail.com', '2016-May-04 22:13:45', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-11', 5967, 3),
(1, 65, 'anil@gmail.com', '2016-May-04 22:22:13', 'New Delhi', 'Mumbai', 'DlMufs104', '12:00 PM2016-05-18', 7845, 5),
(1, 66, 'veeranala.sandeep@gmail.com', '2016-May-04 23:19:54', 'Mumbai', 'Chennai', 'MuChfs101', '5:00 AM2016-05-05', 8400, 4),
(1, 67, 'veeranala.sandeep@gmail.com', '2016-May-04 23:29:10', 'Mumbai', 'Chennai', 'MuChfs101', '5:00 AM2016-05-05', 8400, 4),
(1, 68, 'veeranala.sandeep@gmail.com', '2016-May-04 23:30:47', 'Mumbai', 'Chennai', 'MuChfs101', '5:00 AM2016-05-05', 8400, 4),
(1, 69, 'veeranala.sandeep@gmail.com', '2016-May-04 23:34:14', 'Mumbai', 'Chennai', 'MuChfs101', '5:00 AM2016-05-05', 8400, 4),
(1, 70, 'anil@gmail.com', '2016-May-05 00:24:58', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-10', 7956, 4),
(1, 71, 'skgeniusfamily@gmail.com', '2016-May-05 12:29:38', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-06', 3978, 2),
(1, 72, 'skgeniusfamily@gmail.com', '2016-May-06 16:05:31', 'New Delhi', 'Chennai', 'DlChfs103', '12:00 PM2016-05-11', 5978, 2),
(1, 73, 'skgeniusfamily@gmail.com', '2016-May-06 16:06:14', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-11', 5967, 3),
(1, 74, 'skgeniusfamily@gmail.com', '2016-May-10 16:55:08', 'Mumbai', 'New Delhi', 'DlMufs101', '5:00 AM2016-05-24', 5967, 3);

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `dept` varchar(70) NOT NULL,
  `status` varchar(10) NOT NULL DEFAULT 'out',
  `username` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`id`, `name`, `dept`, `status`, `username`) VALUES
(2, 'Dr. Rajat Kumar Bind', 'Cardiology', 'in', 'raj'),
(3, 'Dr. Shivendra Singh', 'Cardiac Surgery', 'out', 'shivendra'),
(4, 'Dr. Harsh Kumar Singh', 'Urology', 'out', 'harsh'),
(5, 'Dr. Ravi Varma Kumar', 'Dental Services', 'in', 'varma');

-- --------------------------------------------------------

--
-- Table structure for table `passwords`
--

CREATE TABLE `passwords` (
  `type` int(11) NOT NULL,
  `inventory` varchar(20) NOT NULL DEFAULT 'password',
  `hospital` varchar(20) NOT NULL DEFAULT 'password',
  `image` mediumblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `passwords`
--

INSERT INTO `passwords` (`type`, `inventory`, `hospital`, `image`) VALUES
(1, 'inventory', 'hospital', 0x6a6176612e696f2e46696c65496e70757453747265616d4065656165393533),
(2, 'staff', 'password', 0x30);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `Reg.no` int(11) NOT NULL,
  `doe` varchar(50) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `mname` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `mno` varchar(20) NOT NULL,
  `email` varchar(70) NOT NULL,
  `bg` varchar(10) DEFAULT NULL,
  `sym` varchar(255) DEFAULT NULL,
  `suffer` varchar(255) DEFAULT NULL,
  `cd` varchar(255) DEFAULT NULL,
  `doc` varchar(60) DEFAULT 'Dr. Shubham Kumar',
  `med` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`Reg.no`, `doe`, `name`, `fname`, `mname`, `age`, `sex`, `address`, `mno`, `email`, `bg`, `sym`, `suffer`, `cd`, `doc`, `med`) VALUES
(1, 'Wed Apr 27 21:07:37 IST 2016', 'Rahul Pandey', 'GS Pandey', 'Sunita Pandey', 18, 'Male', 'Gorakhpur', '9795033668', 'rahulpandeyshiv@gmail.com', 'O+', 'Heart Pain', 'Heartache', 'Cardiology', 'Dr. Rajat Kumar Bind', 'Operated'),
(2, 'Thu Apr 28 01:13:19 IST 2016', 'Anuj Bhatla', 'Papa', 'Ma', 18, 'Male', 'Jaipur', '9560879544', 'anuj@gmail.com', 'O+', 'Bleeding', 'Check Up', 'Family medicine', 'null', 'No'),
(3, 'Thu Apr 28 01:58:32 IST 2016', 'Dinesh', 'Dinesh Papa', 'Dinesh Mami', 18, 'Male', 'Andhra Pradesh', '9876567865', 'dineshdanny@gmail.com', 'O+', 'Urinary Pain', 'Bladder Pain', 'Urology', 'null', 'No'),
(4, 'Mon May 02 03:24:06 IST 2016', 'Anuj', 'Dad', 'Mom', 18, 'Male', 'Jaipur', '9876786756', 'anuj@bhatla.com', 'O+', 'Bleeding', 'Bleeding', 'General & Laparoscopic surgery', 'Dr. Rajat Kumar Bind', 'No'),
(5, 'Mon May 02 12:25:06 IST 2016', 'Pala', 'Prashanth', 'Mom', 18, 'Male', 'Vijayawada', '8976789876', 'pala@gmail.com', 'O+', 'dental problems', 'cavity', 'Dental Services', 'Dr. Ravi Varma Kumar', 'No'),
(6, 'Thu May 05 00:28:46 IST 2016', 'Ram', 'Dashrath', 'Kaushalya', 18, 'Male', 'Ayodhya', '8976578644', 'ram@sita.com', 'AB', 'Headache', 'Headache', 'Family medicine', 'Dr. Ravi Varma Kumar', 'No'),
(7, 'Thu May 05 00:37:33 IST 2016', 'Aryan Goyal', 'Archana Goyal', 'Naveen Goyal', 20, 'Male', 'Jaipur', '9828564655', 'aryangoyal@gmail.com', 'O+', 'Bleeding', 'Fracture', 'Emergency medical services', 'null', 'No'),
(8, 'Thu May 05 12:22:58 IST 2016', 'Akash', 'dad', 'mom', 18, 'Male', 'Nizamabad', '9878765456', 'akashcool@gmail.com', 'O+', 'Sleeping Syndrome', 'Hypertentation', 'Cardiology', 'Dr. Rajat Kumar Bind', 'Operated');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `Serial No.` int(11) NOT NULL,
  `Product_Name` varchar(50) NOT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `MRP` float DEFAULT NULL,
  `Discount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`Serial No.`, `Product_Name`, `Quantity`, `MRP`, `Discount`) VALUES
(16, 'T-Shirt', 300, 500, 50),
(19, 'Adida Desire DEO', 2000, 269, 9),
(20, 'XL Mens Shirt', 200, 389, 0),
(22, 'Dell Inspiron 15', 100, 46500, 2),
(23, 'Bermuda', 400, 150, 0),
(24, 'Hawells Wire', 4, 200, 0),
(25, 'Hockey Stick', 200, 1500, 0),
(26, 'Crizal EyeCare', 360, 1050, 51),
(27, 'Cricket Bat', 2, 5500, 5),
(28, 'Paraceatamol', 200, 250, 5),
(29, 'Sparx Shoes', 150, 700, 5),
(31, 'PediaSure', 1000, 550, 5),
(32, 'Lenovo Laptop', 200, 45000, 5),
(33, 'Sandlewood Soap', 200, 35, 1),
(34, 'Lenovo A6000+', 100, 7000, 10),
(35, 'Scale', 1000, 10, 0),
(36, 'Adidas Desire DEO', 10, 490, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bus_cus`
--
ALTER TABLE `bus_cus`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `bus_transaction`
--
ALTER TABLE `bus_transaction`
  ADD PRIMARY KEY (`TranNo`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `passwords`
--
ALTER TABLE `passwords`
  ADD PRIMARY KEY (`type`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`Reg.no`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`Serial No.`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bus_transaction`
--
ALTER TABLE `bus_transaction`
  MODIFY `TranNo` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;
--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `Reg.no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `Serial No.` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
