-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2022 at 05:19 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `minimarket`
--

-- --------------------------------------------------------

--
-- Table structure for table `chi_tiet_hd`
--

CREATE TABLE `chi_tiet_hd` (
  `ma_chitiet_hd` int(11) NOT NULL,
  `ma_hd` int(11) NOT NULL,
  `ma_hang` int(11) NOT NULL,
  `so_luong` int(11) NOT NULL,
  `tong_tien` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chi_tiet_hd`
--

INSERT INTO `chi_tiet_hd` (`ma_chitiet_hd`, `ma_hd`, `ma_hang`, `so_luong`, `tong_tien`) VALUES
(65, 84, 45, 1, 12000);

-- --------------------------------------------------------

--
-- Table structure for table `chi_tiet_nhap`
--

CREATE TABLE `chi_tiet_nhap` (
  `ma_chi_tiet_nhap` int(11) NOT NULL,
  `ma_nhap` int(11) NOT NULL,
  `ma_hang` int(11) NOT NULL,
  `so_luong_nhap` int(11) NOT NULL,
  `tong_tien_nhap` int(255) NOT NULL,
  `gia_nhap` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chi_tiet_nhap`
--

INSERT INTO `chi_tiet_nhap` (`ma_chi_tiet_nhap`, `ma_nhap`, `ma_hang`, `so_luong_nhap`, `tong_tien_nhap`, `gia_nhap`) VALUES
(8, 48, 43, 1, 20000, 20000),
(9, 49, 43, 1, 20000, 20000),
(10, 49, 45, 5, 10000, 10000),
(11, 51, 46, 2, 2000, 2000),
(12, 52, 47, 1, 2, 2),
(13, 53, 48, 1, 1000, 1000),
(14, 54, 48, 1, 1000, 1000),
(15, 55, 48, 1, 1000, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `hang_hoa`
--

CREATE TABLE `hang_hoa` (
  `ma_hang` int(11) NOT NULL,
  `ten_hang` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `id` int(11) NOT NULL,
  `gia_ban` int(255) NOT NULL,
  `so_luong` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hang_hoa`
--

INSERT INTO `hang_hoa` (`ma_hang`, `ten_hang`, `id`, `gia_ban`, `so_luong`) VALUES
(43, 'sua milo', 1, 24000, 1),
(45, 'sua milo 123', 1, 12000, 5),
(46, 'ư', 1, 2400, 2),
(47, 'f', 5, 2, 1),
(48, '1d', 6, 1200, 3);

-- --------------------------------------------------------

--
-- Table structure for table `hoa_don`
--

CREATE TABLE `hoa_don` (
  `ma_hd` int(11) NOT NULL,
  `manv_hd` int(11) NOT NULL,
  `ma_khach` int(11) DEFAULT NULL,
  `ngay_tao` datetime NOT NULL,
  `thanh_toan` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hoa_don`
--

INSERT INTO `hoa_don` (`ma_hd`, `manv_hd`, `ma_khach`, `ngay_tao`, `thanh_toan`) VALUES
(84, 7, NULL, '2022-01-02 21:56:27', 12000);

-- --------------------------------------------------------

--
-- Table structure for table `khach_hang`
--

CREATE TABLE `khach_hang` (
  `ma_khach` int(11) NOT NULL,
  `ten_khach` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `sdt_khach` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `diem` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khach_hang`
--

INSERT INTO `khach_hang` (`ma_khach`, `ten_khach`, `sdt_khach`, `diem`) VALUES
(2, 'Lee Min Ho', '0951753486', 10),
(6, 'Huyền', '032457235', 12),
(8, 'Dung', '012345678', 0),
(9, 'Ngọc', '056789123', 2),
(10, 'Mỹ Tâm', '012354235', 0),
(13, 'Phượng', '0123456789', 0),
(17, 'khach', '012345678', 0);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `ma_nv` int(11) NOT NULL,
  `ten_nv` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `ngay_sinh` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `gioi_tinh` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `dia_chi` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `sdt_nv` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `phan_quyen` int(11) NOT NULL,
  `thoi_gian` bigint(255) DEFAULT NULL,
  `luong` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`ma_nv`, `ten_nv`, `ngay_sinh`, `gioi_tinh`, `dia_chi`, `sdt_nv`, `username`, `password`, `phan_quyen`, `thoi_gian`, `luong`) VALUES
(6, 'Nhân Viên', '12/3/1034', 'nam', 'Hà Nội', '1234567', 'nhanvien123', '111111', 0, 7, 12000),
(7, 'Dung', '10/01/2000', 'nu', 'Quảng Ninh', '123423234', 'dungkei', '111111', 1, 0, 15000),
(8, 'Ngọc', '10/09/2000', 'nu', 'Nam Định', '2739063', 'ngoccaro', '111111', 1, 0, 15000),
(14, 'Phượng', '10/7/2000', 'nu', 'Thanh Hóa', '1234', 'phuong', '111111', 1, NULL, 15000);

-- --------------------------------------------------------

--
-- Table structure for table `nhap_hang`
--

CREATE TABLE `nhap_hang` (
  `ma_nhap` int(11) NOT NULL,
  `ma_ncc` int(11) NOT NULL,
  `ma_nv` int(11) NOT NULL,
  `ngay_nhap` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `thanh_tien` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhap_hang`
--

INSERT INTO `nhap_hang` (`ma_nhap`, `ma_ncc`, `ma_nv`, `ngay_nhap`, `thanh_tien`) VALUES
(26, 1, 7, '2021/12/27 23:55:27', 4),
(29, 3, 7, '2021/12/28 00:07:02', 4),
(30, 3, 7, '2021/12/28 00:23:09', 9),
(31, 3, 7, '2021/12/28 00:23:55', 4),
(32, 5, 7, '2021/12/28 00:47:43', 25),
(34, 3, 7, '2021/12/28 19:14:35', 1),
(35, 1, 7, '2021/12/28 19:33:30', 9),
(36, 3, 7, '2021/12/28 19:50:06', 4),
(37, 1, 7, '2021/12/28 20:16:24', 1),
(38, 1, 7, '2021/12/28 21:45:27', 1),
(39, 1, 7, '2021/12/28 21:48:17', 3),
(40, 1, 7, '2022/01/01 21:50:02', 4000),
(41, 1, 7, '2022/01/01 22:02:32', 4),
(42, 1, 7, '2022/01/01 22:04:19', 4),
(43, 1, 7, '2022/01/01 22:11:19', 1),
(44, 1, 7, '2022/01/01 22:16:46', 4),
(45, 1, 7, '2022/01/01 23:16:06', 1),
(46, 1, 7, '2022/01/01 23:20:21', 2000),
(47, 1, 7, '2022/01/01 23:21:48', 10000),
(48, 1, 7, '2022/01/01 23:55:14', 20000),
(49, 1, 7, '2022/01/01 23:55:35', 70000),
(51, 1, 7, '2022/01/02 00:02:56', 4000),
(52, 1, 7, '2022/01/02 00:03:41', 2),
(53, 3, 7, '2022/01/02 00:34:23', 1000),
(54, 3, 7, '2022/01/02 00:41:16', 1000),
(55, 3, 7, '2022/01/02 00:41:42', 1000);

-- --------------------------------------------------------

--
-- Table structure for table `nha_cc`
--

CREATE TABLE `nha_cc` (
  `ma_ncc` int(11) NOT NULL,
  `ten_ncc` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `sdt_ncc` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nha_cc`
--

INSERT INTO `nha_cc` (`ma_ncc`, `ten_ncc`, `sdt_ncc`) VALUES
(1, 'Cong ty sua Milo', '7410852963'),
(3, 'Cong ty samsung', '012345678'),
(5, 'Công ty sữa Vinamilk 1', '012232021'),
(6, 'Công ty mỳ tôm Kokomi', '0306122');

-- --------------------------------------------------------

--
-- Table structure for table `phan_loai`
--

CREATE TABLE `phan_loai` (
  `id` int(11) NOT NULL,
  `ten_loai` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phan_loai`
--

INSERT INTO `phan_loai` (`id`, `ten_loai`) VALUES
(1, 'sua'),
(4, 'bút'),
(5, 'bánh'),
(6, 'my tom');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chi_tiet_hd`
--
ALTER TABLE `chi_tiet_hd`
  ADD PRIMARY KEY (`ma_chitiet_hd`),
  ADD KEY `ma_hd` (`ma_hd`),
  ADD KEY `ma_hang` (`ma_hang`);

--
-- Indexes for table `chi_tiet_nhap`
--
ALTER TABLE `chi_tiet_nhap`
  ADD PRIMARY KEY (`ma_chi_tiet_nhap`),
  ADD KEY `ma_nhap` (`ma_nhap`),
  ADD KEY `ma_hang` (`ma_hang`);

--
-- Indexes for table `hang_hoa`
--
ALTER TABLE `hang_hoa`
  ADD PRIMARY KEY (`ma_hang`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD PRIMARY KEY (`ma_hd`),
  ADD KEY `ma_nv` (`manv_hd`),
  ADD KEY `ma_khach` (`ma_khach`);

--
-- Indexes for table `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`ma_khach`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`ma_nv`);

--
-- Indexes for table `nhap_hang`
--
ALTER TABLE `nhap_hang`
  ADD PRIMARY KEY (`ma_nhap`),
  ADD KEY `ma_ncc` (`ma_ncc`),
  ADD KEY `ma_nv` (`ma_nv`);

--
-- Indexes for table `nha_cc`
--
ALTER TABLE `nha_cc`
  ADD PRIMARY KEY (`ma_ncc`);

--
-- Indexes for table `phan_loai`
--
ALTER TABLE `phan_loai`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chi_tiet_hd`
--
ALTER TABLE `chi_tiet_hd`
  MODIFY `ma_chitiet_hd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT for table `chi_tiet_nhap`
--
ALTER TABLE `chi_tiet_nhap`
  MODIFY `ma_chi_tiet_nhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `hang_hoa`
--
ALTER TABLE `hang_hoa`
  MODIFY `ma_hang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `hoa_don`
--
ALTER TABLE `hoa_don`
  MODIFY `ma_hd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- AUTO_INCREMENT for table `khach_hang`
--
ALTER TABLE `khach_hang`
  MODIFY `ma_khach` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `ma_nv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `nhap_hang`
--
ALTER TABLE `nhap_hang`
  MODIFY `ma_nhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT for table `nha_cc`
--
ALTER TABLE `nha_cc`
  MODIFY `ma_ncc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `phan_loai`
--
ALTER TABLE `phan_loai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chi_tiet_hd`
--
ALTER TABLE `chi_tiet_hd`
  ADD CONSTRAINT `chi_tiet_hd_ibfk_1` FOREIGN KEY (`ma_hang`) REFERENCES `hang_hoa` (`ma_hang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chi_tiet_hd_ibfk_2` FOREIGN KEY (`ma_hd`) REFERENCES `hoa_don` (`ma_hd`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `chi_tiet_nhap`
--
ALTER TABLE `chi_tiet_nhap`
  ADD CONSTRAINT `chi_tiet_nhap_ibfk_1` FOREIGN KEY (`ma_hang`) REFERENCES `hang_hoa` (`ma_hang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chi_tiet_nhap_ibfk_2` FOREIGN KEY (`ma_nhap`) REFERENCES `nhap_hang` (`ma_nhap`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hang_hoa`
--
ALTER TABLE `hang_hoa`
  ADD CONSTRAINT `hang_hoa_ibfk_1` FOREIGN KEY (`id`) REFERENCES `phan_loai` (`id`);

--
-- Constraints for table `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD CONSTRAINT `hoa_don_ibfk_1` FOREIGN KEY (`manv_hd`) REFERENCES `nhanvien` (`ma_nv`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hoa_don_ibfk_2` FOREIGN KEY (`ma_khach`) REFERENCES `khach_hang` (`ma_khach`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `nhap_hang`
--
ALTER TABLE `nhap_hang`
  ADD CONSTRAINT `nhap_hang_ibfk_1` FOREIGN KEY (`ma_ncc`) REFERENCES `nha_cc` (`ma_ncc`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nhap_hang_ibfk_2` FOREIGN KEY (`ma_nv`) REFERENCES `nhanvien` (`ma_nv`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
