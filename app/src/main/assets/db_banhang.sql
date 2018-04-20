-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 10, 2018 lúc 12:24 PM
-- Phiên bản máy phục vụ: 10.1.25-MariaDB
-- Phiên bản PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `db_banhang`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bills`
--

CREATE TABLE `bills` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `gender` varchar(50) NOT NULL,
  `date_order` date DEFAULT NULL,
  `total` float DEFAULT NULL COMMENT 'tổng tiền',
  `payment` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'hình thức thanh toán',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `bills`
--

INSERT INTO `bills` (`id`, `name`, `email`, `phone`, `address`, `gender`, `date_order`, `total`, `payment`, `note`, `created_at`, `updated_at`) VALUES
(14, 'truong', 'truong@gmail.com', '01648815367', 'Ha Noi', 'Nam', '2017-03-23', 160000, 'COD', 'k', '2018-04-04 13:46:14', '2017-03-23 04:46:05'),
(13, 'truongdang', 'truong2@gmail.com', '1235555', 'a', 'Nu', '2017-03-21', 400000, 'ATM', 'Vui lòng giao hàng trước 5h', '2018-04-04 13:46:35', '2017-03-21 07:29:31'),
(12, 'admin', '', '', NULL, '', '2017-03-21', 520000, 'COD', 'Vui lòng chuyển đúng hạn', '2018-04-04 13:43:41', '2017-03-21 07:20:07'),
(11, 'a', '', '', NULL, '', '2017-03-21', 420000, 'COD', 'không chú', '2018-04-04 13:46:49', '2017-03-21 07:16:09'),
(15, 'b', '', '', NULL, '', '2017-03-24', 220000, 'COD', 'e', '2018-04-04 13:46:56', '2017-03-24 07:14:32'),
(16, 'b', '', '', NULL, '', '2017-10-27', 120000, 'COD', 'hello', '2018-04-04 13:47:04', '2017-10-27 04:16:30'),
(17, 'cd', '', '', NULL, '', '2017-10-27', 300000, 'COD', 'Xin chào, tôi muốn mua bánh cho buổi tiệc', '2018-04-04 13:47:10', '2017-10-27 04:20:48'),
(18, 'gh', '', '', NULL, '', '2017-10-27', 360000, 'ATM', 'hello', '2018-04-04 13:47:22', '2017-10-27 06:40:36'),
(19, 'tr', '', '', NULL, '', '2017-11-20', 180000, 'COD', 'Gà Giòn', '2018-04-04 13:47:30', '2017-11-20 02:53:43'),
(20, '', '', '', NULL, '', '2017-11-27', 580000, 'COD', 'Xin chao', '2017-11-27 09:47:24', '2017-11-27 09:47:24'),
(21, '', '', '', NULL, '', '2017-12-07', 160000, 'COD', 'Hay giao cho toi truoc chieu nay', '2017-12-07 04:09:32', '2017-12-07 04:09:32'),
(22, '', '', '', NULL, '', '2017-12-20', 620000, 'COD', 'Hang 15 phut', '2017-12-20 01:33:52', '2017-12-20 01:33:52'),
(23, '', '', '', NULL, '', '2018-04-03', 660000, 'COD', 'Giao hàng cho tôi vào ngày mai', '2018-04-03 13:40:36', '2018-04-03 13:40:36'),
(24, '', '', '', NULL, '', '2018-04-03', 660000, 'COD', 'Giao hàng cho tôi vào ngày mai', '2018-04-03 13:41:09', '2018-04-03 13:41:09'),
(25, '', '', '', NULL, '', '2018-04-03', 660000, 'COD', 'ha noi', '2018-04-03 13:44:59', '2018-04-03 13:44:59'),
(26, '', '', '', NULL, '', '2018-04-03', 660000, 'COD', 'a', '2018-04-03 13:52:55', '2018-04-03 13:52:55'),
(27, '', '', '', NULL, '', '2018-04-03', 660000, 'COD', 'a', '2018-04-03 13:54:16', '2018-04-03 13:54:16'),
(28, '', '', '', NULL, '', '2018-04-03', 660000, 'COD', 'a', '2018-04-03 13:55:31', '2018-04-03 13:55:31'),
(29, '', '', '', NULL, '', '2018-04-03', 440000, 'COD', 'Giao hàng cho tôi vào ngày mai', '2018-04-03 14:07:24', '2018-04-03 14:07:24'),
(30, '', '', '', NULL, '', '2018-04-03', 650000, 'COD', 'Giao hàng cho tôi ngày mai nhá', '2018-04-03 14:11:13', '2018-04-03 14:11:13');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill_detail`
--

CREATE TABLE `bill_detail` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_bill` int(10) NOT NULL,
  `id_product` int(10) NOT NULL,
  `quantity` int(11) NOT NULL COMMENT 'số lượng',
  `unit_price` double NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `bill_detail`
--

INSERT INTO `bill_detail` (`id`, `id_bill`, `id_product`, `quantity`, `unit_price`, `created_at`, `updated_at`) VALUES
(18, 15, 62, 5, 220000, '2017-03-24 07:14:32', '2017-03-24 07:14:32'),
(17, 14, 2, 1, 160000, '2017-03-23 04:46:05', '2017-03-23 04:46:05'),
(16, 13, 60, 1, 200000, '2017-03-21 07:29:31', '2017-03-21 07:29:31'),
(15, 13, 59, 1, 200000, '2017-03-21 07:29:31', '2017-03-21 07:29:31'),
(14, 12, 60, 2, 200000, '2017-03-21 07:20:07', '2017-03-21 07:20:07'),
(13, 12, 61, 1, 120000, '2017-03-21 07:20:07', '2017-03-21 07:20:07'),
(12, 11, 61, 1, 120000, '2017-03-21 07:16:09', '2017-03-21 07:16:09'),
(11, 11, 57, 2, 150000, '2017-03-21 07:16:09', '2017-03-21 07:16:09'),
(19, 16, 1, 1, 120000, '2017-10-27 04:16:31', '2017-10-27 04:16:31'),
(20, 17, 1, 1, 120000, '2017-10-27 04:20:48', '2017-10-27 04:20:48'),
(21, 17, 6, 1, 180000, '2017-10-27 04:20:48', '2017-10-27 04:20:48'),
(22, 18, 6, 2, 180000, '2017-10-27 06:40:36', '2017-10-27 06:40:36'),
(23, 19, 6, 1, 180000, '2017-11-20 02:53:43', '2017-11-20 02:53:43'),
(24, 20, 1, 1, 120000, '2017-11-27 09:47:25', '2017-11-27 09:47:25'),
(25, 20, 13, 1, 280000, '2017-11-27 09:47:25', '2017-11-27 09:47:25'),
(26, 20, 6, 1, 180000, '2017-11-27 09:47:25', '2017-11-27 09:47:25'),
(27, 21, 7, 1, 160000, '2017-12-07 04:09:32', '2017-12-07 04:09:32'),
(28, 22, 7, 1, 160000, '2017-12-20 01:33:52', '2017-12-20 01:33:52'),
(29, 22, 5, 1, 10000, '2017-12-20 01:33:52', '2017-12-20 01:33:52'),
(30, 22, 1, 1, 120000, '2017-12-20 01:33:52', '2017-12-20 01:33:52'),
(31, 22, 8, 1, 150000, '2017-12-20 01:33:52', '2017-12-20 01:33:52'),
(32, 22, 12, 1, 180000, '2017-12-20 01:33:52', '2017-12-20 01:33:52'),
(33, 29, 3, 1, 120000, '2018-04-03 14:07:24', '2018-04-03 14:07:24'),
(34, 29, 15, 1, 320000, '2018-04-03 14:07:24', '2018-04-03 14:07:24'),
(35, 30, 1, 1, 120000, '2018-04-03 14:11:13', '2018-04-03 14:11:13'),
(36, 30, 30, 1, 350000, '2018-04-03 14:11:13', '2018-04-03 14:11:13'),
(37, 30, 12, 1, 180000, '2018-04-03 14:11:13', '2018-04-03 14:11:13');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `boss`
--

CREATE TABLE `boss` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `image` varchar(100) NOT NULL,
  `introduction` varchar(400) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `boss`
--

INSERT INTO `boss` (`id`, `name`, `image`, `introduction`) VALUES
(1, 'Đặng Trường', 'boss1.jpg', 'Nemo enim ipsam voluptatem quia voluptas ngồi asatur aut autoproduct fugit, sed quia kết hợp với magni dolores eos người quyết định số lượng lớn sequi. Neque por quisquam est, qui dolorem ipsum quia dolor ngồi amet, consectetur, adipisci velit, sed quia không numquam.'),
(2, 'Bob Robertson', 'boss2.jpg', 'Nemo enim ipsam voluptatem quia voluptas ngồi asatur aut autoproduct fugit, sed quia kết hợp với magni dolores eos người quyết định số lượng lớn sequi. Neque por quisquam est, qui dolorem ipsum quia dolor ngồi amet, consectetur, adipisci velit, sed quia không numquam.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chef`
--

CREATE TABLE `chef` (
  `id` int(11) NOT NULL,
  `image` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `introduction` varchar(400) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chef`
--

INSERT INTO `chef` (`id`, `image`, `name`, `introduction`) VALUES
(1, 'team1.jpg', 'Mark Priston', 'Chuyên gia bánh kem Việt Nam.\r\nNổi tiếng với các món ăn mang hương vị truyền thống và hiện đại.'),
(2, 'team2.jpg', 'Bob Robertson', 'Chuyên gia bánh kem đến từ xứ sở mặt trời mọc.\r\nNổi tiếng với các loại bánh trung thu cổ truyền'),
(3, 'team3.jpg', 'Mike Greenwood', 'Chuyên gia bánh kem đến từ Italia\r\nNổi tiếng với các loại bánh kem mang hương vị Châu Âu'),
(4, 'team4.jpg', 'David Black', 'Đầu bếp nổi tiếng đạt nhiều giải thướng\r\nĐược mệnh danh là vua đầu bếp Mỹ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `note` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`id`, `name`, `gender`, `email`, `address`, `phone_number`, `note`, `created_at`, `updated_at`) VALUES
(32, 'Truong Dang', 'nam', 'dangvantruong1996@gmail.com', 'Hà Nội', '01648815367', 'Giao hàng cho tôi vào ngày mai', '2018-04-03 13:40:35', '2018-04-03 13:40:35'),
(31, 'Hang kaliee', 'nữ', 'hang@gmail.com', 'Ha Noi', '01699', 'Hang 15 phut', '2017-12-20 01:33:51', '2017-12-20 01:33:51'),
(29, 'Dang Van Truong', 'nam', 'dangvantruong1996@gmail.com', 'Thanh Hoa', '01648815367', 'Xin chao', '2017-11-27 09:47:24', '2017-11-27 09:47:24'),
(30, 'Dang Van Truong', 'nam', 'dangvantruong1996@gmail.com', 'Ha Noi', '01648815367', 'Hay giao cho toi truoc chieu nay', '2017-12-07 04:09:31', '2017-12-07 04:09:31'),
(28, 'Dang Van Truong 1996', 'nam', 'dangvantruong1996@gmail.com', 'Ha Noi', '01648815367', 'Gà Giòn', '2017-11-20 02:53:43', '2017-11-20 02:53:43'),
(16, 'Đặng Văn Trường', 'nam', 'dangvantruong1996@gmail.com', 'Hà Nội', '01648815367', 'Hello tôi muốn đặt hàng', '2017-10-27 04:02:49', '2017-10-27 04:02:49'),
(17, 'Đặng Văn Trường', 'nam', 'dangvantruong1996@gmail.com', 'Hà Nội', '01648815367', 'Hello tôi muốn đặt hàng', '2017-10-27 04:05:19', '2017-10-27 04:05:19'),
(18, 'Đặng Văn Trường', 'nam', 'dangvantruong1996@gmail.com', 'Hà Nội', '01648815367', 'Hello tôi muốn đặt hàng', '2017-10-27 04:05:26', '2017-10-27 04:05:26'),
(19, 'Đặng Văn Trường', 'nam', 'dangvantruong1996@gmail.com', 'Hà Nội', '01648815367', 'Hello  tôi muốn mua bánh', '2017-10-27 04:07:04', '2017-10-27 04:07:04'),
(20, 'Dang Van Truong', 'nam', 'dangvantruong1996@gmail.com', 'Hà Nội', '01648815367', 'hello', '2017-10-27 04:11:58', '2017-10-27 04:11:58'),
(21, 'Dang Van Truong', 'nam', 'dangvantruong1996@gmail.com', 'Hà Nội', '01648815367', 'hello', '2017-10-27 04:14:05', '2017-10-27 04:14:05'),
(22, 'Dang Van Truong', 'nam', 'dangvantruong1996@gmail.com', 'Hà Nội', '01648815367', 'hello', '2017-10-27 04:15:19', '2017-10-27 04:15:19'),
(23, 'Dang Van Truong', 'nam', 'dangvantruong1996@gmail.com', 'Hà Nội', '01648815367', 'hello', '2017-10-27 04:15:40', '2017-10-27 04:15:40'),
(24, 'Dang Van Truong', 'nam', 'dangvantruong1996@gmail.com', 'Hà Nội', '01648815367', 'hello', '2017-10-27 04:15:54', '2017-10-27 04:15:54'),
(25, 'Dang Van Truong', 'nam', 'dangvantruong1996@gmail.com', 'Hà Nội', '01648815367', 'hello', '2017-10-27 04:16:30', '2017-10-27 04:16:30'),
(26, 'Dang Van Truong', 'nam', 'dangvantruong1996@gmail.com', 'Thanh Hoa', '01648815367', 'Xin chào, tôi muốn mua bánh cho buổi tiệc', '2017-10-27 04:20:47', '2017-10-27 04:20:47'),
(27, 'Truong', 'nam', 'dangvantruong1996@gmail.com', 'Hà Nội', '01648815367', 'hello', '2017-10-27 06:40:36', '2017-10-27 06:40:36'),
(33, 'Truong Dang', 'nam', 'dangvantruong1996@gmail.com', 'Hà Nội', '01648815367', 'Giao hàng cho tôi vào ngày mai', '2018-04-03 13:41:09', '2018-04-03 13:41:09'),
(34, 'Admin', 'nam', 'dangvantruong1996@gmail.com', 'Hà Nội', '01648815367', 'ha noi', '2018-04-03 13:44:59', '2018-04-03 13:44:59'),
(35, 'Admin', 'nam', 'dangvantruong1996@gmail.com', 'Hà Nội', '01648815367', 'a', '2018-04-03 13:52:55', '2018-04-03 13:52:55'),
(36, 'Admin', 'nam', 'admin96@gmail.com', 'a', '01648815367', 'a', '2018-04-03 13:54:16', '2018-04-03 13:54:16'),
(37, 'Admin', 'nam', 'admin96@gmail.com', 'a', '01648815367', 'a', '2018-04-03 13:55:31', '2018-04-03 13:55:31'),
(38, 'admin', 'nam', 'admin96@gmail.com', 'Hà Nội', '01648815367', 'Giao hàng cho tôi vào ngày mai', '2018-04-03 14:07:24', '2018-04-03 14:07:24'),
(39, 'Admin', 'nam', 'admin96@gmail.com', 'Hà Nội', '01648815367', 'Giao hàng cho tôi ngày mai nhá', '2018-04-03 14:11:13', '2018-04-03 14:11:13');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `intro`
--

CREATE TABLE `intro` (
  `id` int(11) NOT NULL,
  `image` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `coment` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `intro`
--

INSERT INTO `intro` (`id`, `image`, `name`, `address`, `coment`) VALUES
(1, '2003a.jpg', 'VietNam-Japan', 'Suite 127 / 267 – 277 Brussel St,\r\n62 Croydon, NYC\r\nNew York', 'Nemo enim ipsam voluptatem quia voluptas sit asatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque por quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam.'),
(2, '2004.jpg', 'VietNam-Japan', 'Suite 127 / 267 – 277 Brussel St,\r\n62 Croydon, NYC\r\nNew York', 'Hãy đến với chúng tôi'),
(3, '2005.jpg', 'VietNam-Japan', 'VietNam-Japan', 'Nemo enim ipsam voluptatem quia voluptas sit asatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque por quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam.'),
(4, '2007.jpg', 'VietNam-Japan', 'VietNam-Japan', 'Hãy đến với chúng tôi'),
(5, '2009.jpg', 'VietNam-Japan', 'VietNam-Japan', 'Nemo enim ipsam voluptatem quia voluptas sit asatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque por quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam.'),
(6, '2011.jpg', 'Project', 'LIFETIME VIETNAM-JAPAN', 'Hãy đến với cửa hàng chúng tôi '),
(7, '2014.jpg', 'Dang Truong', 'Suite 127 / 267 – 277 Brussel St,\r\n62 Croydon, NYC\r\nNew York', 'Nemo enim ipsam voluptatem quia voluptas sit asatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque por quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2017_12_27_162941_create_pots_table', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `news`
--

CREATE TABLE `news` (
  `id` int(10) NOT NULL,
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'tiêu đề',
  `content` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'nội dung',
  `image` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'hình',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `news`
--

INSERT INTO `news` (`id`, `title`, `content`, `image`, `create_at`, `update_at`) VALUES
(1, 'Mùa trung thu năm nay, Hỷ Lâm Môn muốn gửi đến quý khách hàng sản phẩm mới xuất hiện lần đầu tiên tại Việt nam \"Bánh trung thu Bơ Sữa HongKong\".', 'Những ý tưởng dưới đây sẽ giúp bạn sắp xếp tủ quần áo trong phòng ngủ chật hẹp của mình một cách dễ dàng và hiệu quả nhất. ', 'sample1.jpg', '2017-03-11 06:20:23', '0000-00-00 00:00:00'),
(2, 'Tư vấn cải tạo phòng ngủ nhỏ sao cho thoải mái và thoáng mát', 'Chúng tôi sẽ tư vấn cải tạo và bố trí nội thất để giúp phòng ngủ của chàng trai độc thân thật thoải mái, thoáng mát và sáng sủa nhất. ', 'sample2.jpg', '2016-10-20 02:07:14', '0000-00-00 00:00:00'),
(3, 'Đồ gỗ nội thất và nhu cầu, xu hướng sử dụng của người dùng', 'Đồ gỗ nội thất ngày càng được sử dụng phổ biến nhờ vào hiệu quả mà nó mang lại cho không gian kiến trúc. Xu thế của các gia đình hiện nay là muốn đem thiên nhiên vào nhà ', 'sample3.jpg', '2016-10-20 02:07:14', '0000-00-00 00:00:00'),
(4, 'Hướng dẫn sử dụng bảo quản đồ gỗ, nội thất.', 'Ngày nay, xu hướng chọn vật dụng làm bằng gỗ để trang trí, sử dụng trong văn phòng, gia đình được nhiều người ưa chuộng và quan tâm. Trên thị trường có nhiều sản phẩm mẫu ', 'sample4.jpg', '2016-10-20 02:07:14', '0000-00-00 00:00:00'),
(5, 'Phong cách mới trong sử dụng đồ gỗ nội thất gia đình', 'Đồ gỗ nội thất gia đình ngày càng được sử dụng phổ biến nhờ vào hiệu quả mà nó mang lại cho không gian kiến trúc. Phong cách sử dụng đồ gỗ hiện nay của các gia đình hầu h ', 'sample5.jpg', '2016-10-20 02:07:14', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pots`
--

CREATE TABLE `pots` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `slug` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_type` int(10) UNSIGNED DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci,
  `unit_price` float DEFAULT NULL,
  `promotion_price` float DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `unit` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `new` tinyint(4) DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `name`, `id_type`, `description`, `unit_price`, `promotion_price`, `image`, `unit`, `new`, `created_at`, `updated_at`) VALUES
(1, 'Phở Bò Tái', 5, 'Phở Bò Tái', 50000, 40000, 'phobotai.jpg', 'hộp', 1, '2016-10-26 03:00:16', '2016-10-24 22:11:00'),
(3, 'Phở Gà', 5, 'Phở Gà', 100000, 100000, 'phoga.jpg', 'hộp', 1, '2016-10-26 03:00:16', '2018-04-03 14:11:57'),
(4, 'Phở Chay', 5, 'Phở Thanh Tịnh', 160000, 12000, 'phochay.jpg', 'hộp', 0, '2016-10-26 03:00:16', '2017-12-06 16:02:28'),
(5, 'Phở vịt quay', 5, NULL, 260000, 220000, 'phovitquay.jpg', 'hộp', 0, '2016-10-26 03:00:16', '2017-12-06 16:03:37'),
(6, 'Bún thịt nướng', 5, '', 200000, 180000, 'bunthitnuong.jpg', 'hộp', 1, '2016-10-26 03:00:16', '2016-10-24 22:11:00'),
(7, 'Phở Cao Vân', 5, '', 230000, 230000, 'phocaovan.jpg', 'hộp', 1, '2016-10-26 03:00:16', '2016-10-24 22:11:00'),
(8, 'Bún riêu cua', 5, '', 160000, 150000, 'bunrieu.jpg', 'hộp', 0, '2016-10-26 03:00:16', '2016-10-24 22:11:00'),
(9, 'Bún riêu ốc', 5, '', 160000, 150000, 'bunrieuoc.jpg', 'hộp', 0, '2016-10-26 03:00:16', '2016-10-24 22:11:00'),
(11, 'Tào phớ', 3, '', 250000, 0, 'taopho.jpg', 'cái', 0, '2016-10-12 02:00:00', '2016-10-27 02:24:00'),
(12, 'Sữa chua mít', 3, '', 200000, 180000, 'suachuamit.jpg', 'cái', 0, '2016-10-12 02:00:00', '2016-10-27 02:24:00'),
(13, 'Sữa chua nếp cẩm mít', 3, '', 300000, 280000, 'suachuanepcam.jpg', 'cái', 1, '2016-10-12 02:00:00', '2016-10-27 02:24:00'),
(14, 'Chè khúc bạch', 3, '', 300000, 280000, 'chekhucbach.jpg', 'cái', 0, '2016-10-12 02:00:00', '2016-10-27 02:24:00'),
(15, 'Chè caramen thập cẩm', 3, '', 350000, 320000, 'caramenthapcam.jpg', 'cái', 1, '2016-10-12 02:00:00', '2016-10-27 02:24:00'),
(16, 'Chè bưởi', 3, '', 150000, 120000, 'chebuoi.jpg', 'hộp', 0, '2016-10-12 02:00:00', '2016-10-27 02:24:00'),
(17, 'Chè ngô', 3, '', 250000, 240000, 'chengo.jpg', 'cai', 0, '2016-10-12 02:00:00', '2016-10-27 02:24:00'),
(18, 'Bánh ngọt nhân cream táo', 2, '', 180000, 0, '20131108144733.jpg', 'hộp', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(19, 'Bánh Chocolate Trái cây', 2, '', 150000, 0, 'Fruit-Cake_7976.jpg', 'hộp', 1, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(20, 'Bánh Chocolate Trái cây II', 2, '', 150000, 0, 'Fruit-Cake_7981.jpg', 'hộp', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(21, 'Peach Cake', 2, '', 160000, 150000, 'Peach-Cake_3294.jpg', 'cái', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(22, 'Trà sữa chân châu', 1, '', 160000, 150000, 'trasuachantrau.jpg', 'hộp', 1, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(23, 'Vina cafe', 1, '', 180000, 0, 'cafe.jpg', 'hộp', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(24, 'Nước dừa', 1, '', 180000, 0, 'nuoc_dua.jpg', 'hộp', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(25, 'Pepsi', 1, '', 80000, 70000, 'pepsi.jpg', 'hộp', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(26, 'Cocacola', 1, '', 50000, 0, 'cocacola.jpg', 'hộp', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(27, 'Bò húc', 1, '', 100000, 80000, 'bo-huc-Thai.jpg', 'hộp', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(28, 'Sting', 1, '', 120000, 0, 'sting.jpg', 'hộp', 1, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(29, 'Number one', 1, '', 100000, 0, 'numberone.jpg', 'hộp', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(30, 'Combo gà giòn', 4, '', 380000, 350000, 'combogaran.jpg', 'cái', 1, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(31, 'Burger Gà Cay', 4, '', 380000, 350000, 'burgergacay.jpg', 'cái', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(32, 'Gà rán truyền thống', 4, '', 380000, 350000, 'gagiontruyenthong.jpg', 'cái', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(33, 'Gà lắc', 4, '', 280000, 250000, 'galac.jpg', 'cái', 1, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(34, 'Gà viên', 4, '', 280000, 0, 'gavien.jpg', 'cái', 1, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(35, 'Gà viên Cola', 4, '', 320000, 300000, 'gaviencola.jpg', 'cái', 1, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(36, 'Đùi gà chiên xù', 4, '', 320000, 300000, 'duiga.jpg', 'cái', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(37, 'Gà giòn cay', 4, '', 320000, 300000, 'gagioncay.jpg', 'cái', 1, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(38, 'Gà chiên gión', 4, '', 350000, 330000, 'gachiengion.jpg', 'cái', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(39, 'Chân gà chiên giòn', 4, '', 350000, 330000, 'changachien.jpg', 'cái', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(40, 'Cánh gà chiên mắm', 4, '', 350000, 330000, 'canhgachien.jpg', 'cái', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(41, 'Cánh gà chiên giòn', 4, '', 350000, 330000, 'canhgachiengion.jpg', 'cái', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(42, 'Lẩu cá trắm', 6, 'Thịt bò xay, ngô, sốt BBQ, phô mai mozzarella', 150000, 130000, 'lauca.jpg', 'cái', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(43, 'Lẩu cá khoai', 6, 'Sốt cà chua, ham , dứa, pho mai mozzarella', 120000, 0, 'laucakhoai.jpg', 'cái', 1, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(44, 'Lẩu riêu cua gà ta', 6, 'Gà hun khói,nấm, sốt cà chua, pho mai mozzarella.', 120000, 0, 'laurieucuagata.jpg', 'cái', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(45, 'Lẩu ếch nấu măng', 6, 'Xúc xích klobasa, Nấm, Ngô, sốtcà chua, pho mai Mozzarella.', 120000, 0, 'lauech.jpg', 'cái', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(46, 'Lẩu tôm chua cay', 6, 'Tôm , mực, xào cay,ớt xanh, hành tây, cà chua, phomai mozzarella.', 120000, 0, 'lautom.jpg', 'cái', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(47, 'Lẩu ghẹ', 6, 'Ham, bacon, chorizo, pho mai mozzarella.', 140000, 0, 'laughe.jpg', 'cái', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(48, 'Lẩu Thái hải sản', 6, 'Cá Ngừ, sốt Mayonnaise,sốt càchua, hành tây, pho mai Mozzarella', 140000, 0, 'lauthai.jpg', 'cái', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(49, 'Buffet lẩu nướng', 7, '', 120000, 100000, 'bufferlaunuong.jpg', 'cái', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(50, 'Mực nướng', 7, '', 120000, 100000, 'mucnuong.jpg', 'cái', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(51, 'Tôm nướng', 7, '', 150000, 0, 'tomnuong.jpg', 'hộp', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(52, 'Thịt nướng', 7, '', 150000, 0, 'thitnuong.jpg', 'hộp', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(53, 'Cá viên nướng', 7, '', 150000, 0, 'caviennuong.jpg', 'hộp', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(54, 'Xúc xích nướng', 7, '', 150000, 0, 'xucxichnuong.jpg', 'hộp', 1, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(55, 'Cá nướng', 7, '', 150000, 0, 'canuong.jpg', 'hộp', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(56, 'Thịt bò nướng', 7, '', 150000, 0, 'thitbonuong.jpg', 'hộp', 0, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(57, 'Thịt xiên nướng rau củ', 7, '', 150000, 0, 'xiennuongraucu.jpg', 'hộp', 1, '2016-10-13 02:20:00', '2016-10-19 03:20:00'),
(58, 'Bánh Macaron Pháp', 2, 'Thưởng thức macaron, người ta có thể tìm thấy từ những hương vị truyền thống như mâm xôi, chocolate, cho đến những hương vị mới như nấm và trà xanh. Macaron với vị giòn tan của vỏ bánh, béo ngậy ngọt ngào của phần nhân, với vẻ ngoài đáng yêu và nhiều màu sắc đẹp mắt, đây là món bạn không nên bỏ qua khi khám phá nền ẩm thực Pháp.', 200000, 180000, 'Macaron9.jpg', '', 0, '2016-10-26 17:00:00', '2016-10-11 17:00:00'),
(59, 'Bánh Tiramisu - Italia', 2, 'Chỉ cần cắn một miếng, bạn sẽ cảm nhận được tất cả các hương vị đó hòa quyện cùng một chính vì thế người ta còn ví món bánh này là Thiên đường trong miệng của bạn', 200000, 0, '234.jpg', '', 0, '2016-10-26 17:00:00', '2016-10-11 17:00:00'),
(60, 'Bánh Táo - Mỹ', 2, 'Bánh táo Mỹ với phần vỏ bánh mỏng, giòn mềm, ẩn chứa phần nhân táo thơm ngọt, điểm chút vị chua dịu của trái cây quả sẽ là một lựa chọn hoàn hảo cho những tín đồ bánh ngọt trên toàn thế giới.', 200000, 0, '1234.jpg', '', 0, '2016-10-26 17:00:00', '2016-10-11 17:00:00'),
(61, 'Lẩu riêu cua bắp bò', 6, 'Những chiếc cupcake có cấu tạo gồm phần vỏ bánh xốp mịn và phần kem trang trí bên trên rất bắt mắt với nhiều hình dạng và màu sắc khác nhau. Cupcake còn được cho là chiếc bánh mang lại niềm vui và tiếng cười như chính hình dáng đáng yêu của chúng.', 150000, 120000, 'laurieubo.jpg', 'cái', 1, NULL, NULL),
(62, 'Lẩu mắm cá lóc', 6, 'Sachertorte là một loại bánh xốp được tạo ra bởi loại&nbsp;chocholate&nbsp;tuyệt hảo nhất của nước Áo. Sachertorte có vị ngọt nhẹ, gồm nhiều lớp bánh được làm từ ruột bánh mì và bánh sữa chocholate, xen lẫn giữa các lớp bánh là mứt mơ. Món bánh chocholate này nổi tiếng tới mức thành phố Vienna của Áo đã ấn định&nbsp;tổ chức một ngày Sachertorte quốc gia, vào 5/12 hằng năm', 250000, 220000, 'laumamca.jpg', 'cái', 0, NULL, NULL),
(71, 'Chè thập cẩm', 3, 'Bánh ngon nhà làm', 15000, 20000, 'chethapcam.jpg', NULL, 0, '2017-11-27 09:43:20', '2017-12-06 10:35:34'),
(75, 'Phở Bò Nam Định', 5, 'Vi ngon thang12', 18000, 15000, 'phobo.jpg', NULL, 0, '2017-12-25 03:10:34', '2018-02-02 07:03:06'),
(78, 'Phớ cuốn', 3, 'Ngon', 200000, 150000, NULL, NULL, 0, '2018-04-03 12:57:32', '2018-04-03 12:57:33');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `slide`
--

CREATE TABLE `slide` (
  `id` int(11) NOT NULL,
  `link` varchar(100) NOT NULL,
  `image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `slide`
--

INSERT INTO `slide` (`id`, `link`, `image`) VALUES
(1, '', 'banner1.jpg'),
(2, '', 'banner2.jpg'),
(3, '', 'banner3.jpg'),
(4, '', 'banner4.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `floor`
--

CREATE TABLE `floor` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `floor`
--

INSERT INTO `floor` (`id`, `name`) VALUES
(1, 'Tầng 1'),
(2, 'Tầng 2'),
(3, 'Tầng 3'),
(4, 'Tầng 4');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `table`
--

CREATE TABLE `table` (
  `id` int(11) NOT NULL,
  `id_floor` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `table`
--

INSERT INTO `table` (`id`, `id_floor`, `name`, `type`) VALUES
(1,1, '101','SQUARE_2'),
(2,1, '102','SQUARE_2'),
(3,1, '103','SQUARE_2'),
(4,1, '104','SQUARE_2'),
(5,1, '105','SQUARE_2'),
(6,1, '106','SQUARE_2'),
(7,1, '107','SQUARE_2'),
(8,1, '108','SQUARE_2'),
(9,1, '109','SQUARE_2'),
(10,1, '110','SQUARE_2'),
(11,2, '201','SQUARE_4'),
(12,2, '202','SQUARE_4'),
(13,2, '203','SQUARE_4'),
(14,2, '204','SQUARE_4'),
(15,2, '205','SQUARE_4'),
(16,2, '206','SQUARE_4'),
(17,2, '207','SQUARE_4'),
(18,2, '208','SQUARE_4'),
(19,2, '209','SQUARE_4'),
(20,2, '210','SQUARE_4'),
(21,3, '301','SQUARE_6'),
(22,3, '302','SQUARE_6'),
(23,3, '303','SQUARE_6'),
(24,3, '304','SQUARE_6'),
(25,3, '305','SQUARE_6'),
(26,3, '306','SQUARE_6'),
(27,3, '307','SQUARE_6'),
(28,3, '308','SQUARE_6'),
(29,3, '309','SQUARE_6'),
(30,3, '310','SQUARE_6'),
(31,4, '401','CIRCLE_10'),
(32,4, '402','CIRCLE_10'),
(33,4, '403','CIRCLE_10'),
(34,4, '404','CIRCLE_10'),
(35,4, '405','CIRCLE_10'),
(36,4, '406','CIRCLE_10'),
(37,4, '407','CIRCLE_10'),
(38,4, '408','CIRCLE_10'),
(39,4, '409','CIRCLE_10'),
(40,4, '410','CIRCLE_10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order`
--

CREATE TABLE `order` (
  `id` int(11) NOT NULL,
  `id_table` int(11) NOT NULL,
  `people_count` int(11) NULL,
  `total` double NOT NULL,
  `state` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `order`
--

INSERT INTO `order` (`id`, `id_table`, `people_count`, `total`, `state`) VALUES
(1, 1,2,100000,0),
(2, 5,2,520000,0),
(3, 7,2,460000,0),
(4, 3,2,200000,0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_detail`
--

CREATE TABLE `order_detail` (
  `id_order` int(10) NOT NULL,
  `id_product` int(10) NOT NULL,
  `quantity` int(11) NOT NULL COMMENT 'số lượng',
  `unit_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `order_detail`
--

INSERT INTO `order_detail` (`id_order`, `id_product`, `quantity`, `unit_price`) VALUES
(1, 1,2,50000),
(2, 5,2,260000),
(3, 7,2,230000),
(4, 3,2,100000);

-- --------------------------------------------------------


--
-- Cấu trúc bảng cho bảng `type_products`
--

CREATE TABLE `type_products` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `type_products`
--

INSERT INTO `type_products` (`id`, `name`, `description`, `image`, `created_at`, `updated_at`) VALUES
(1, 'Đồ uống', 'Nếu từng bị mê hoặc bởi các loại tarlet ngọt thì chắn chắn bạn không thể bỏ qua những loại tarlet mặn. Ngoài hình dáng bắt mắt, lớp vở bánh giòn giòn cùng với nhân mặn như thịt gà, nấm, thị heo ,… của bánh sẽ chinh phục bất cứ ai dùng thử.', 'banh-man-thu-vi-nhat-1.jpg', NULL, NULL),
(2, 'Món tráng miệng', 'Bánh ngọt là một loại thức ăn thường dưới hình thức món bánh dạng bánh mì từ bột nhào, được nướng lên dùng để tráng miệng. Bánh ngọt có nhiều loại, có thể phân loại dựa theo nguyên liệu và kỹ thuật chế biến như bánh ngọt làm từ lúa mì, bơ, bánh ngọt dạng bọt biển. Bánh ngọt có thể phục vụ những mục đính đặc biệt như bánh cưới, bánh sinh nhật, bánh Giáng sinh, bánh Halloween..', '20131108144733.jpg', '2016-10-12 02:16:15', '2016-10-13 01:38:35'),
(3, 'Chè ngon', 'Bánh trái cây, hay còn gọi là bánh hoa quả, là một món ăn chơi, không riêng gì của Huế nhưng khi \"lạc\" vào mảnh đất Cố đô, món bánh này dường như cũng mang chút tinh tế, cầu kỳ và đặc biệt. Lấy cảm hứng từ những loại trái cây trong vườn, qua bàn tay khéo léo của người phụ nữ Huế, món bánh trái cây ra đời - ngọt thơm, dịu nhẹ làm đẹp lòng biết bao người thưởng thức.', 'banhtraicay.jpg', '2016-10-18 00:33:33', '2016-10-15 07:25:27'),
(4, 'Gà Giòn', 'Với người Việt Nam thì bánh ngọt nói chung đều hay được quy về bánh bông lan – một loại tráng miệng bông xốp, ăn không hoặc được phủ kem lên thành bánh kem. Tuy nhiên, cốt bánh kem thực ra có rất nhiều loại với hương vị, kết cấu và phương thức làm khác nhau chứ không chỉ đơn giản là “bánh bông lan” chung chung đâu nhé!', 'banhkem.jpg', '2016-10-26 03:29:19', '2016-10-26 02:22:22'),
(5, 'Phở', 'Crepe là một món bánh nổi tiếng của Pháp, nhưng từ khi du nhập vào Việt Nam món bánh đẹp mắt, ngon miệng này đã làm cho biết bao bạn trẻ phải “xiêu lòng”', 'crepe.jpg', '2016-10-28 04:00:00', '2016-10-27 04:00:23'),
(6, 'Lẩu', 'Pizza đã không chỉ còn là một món ăn được ưa chuộng khắp thế giới mà còn được những nhà cầm quyền EU chứng nhận là một phần di sản văn hóa ẩm thực châu Âu. Và để được chứng nhận là một nhà sản xuất pizza không hề đơn giản. Người ta phải qua đủ mọi các bước xét duyệt của chính phủ Ý và liên minh châu Âu nữa… tất cả là để đảm bảo danh tiếng cho món ăn này.', 'pizza.jpg', '2016-10-25 17:19:00', NULL),
(7, 'Đồ nướng', 'Bánh su kem là món bánh ngọt ở dạng kem được làm từ các nguyên liệu như bột mì, trứng, sữa, bơ.... đánh đều tạo thành một hỗn hợp và sau đó bằng thao tác ép và phun qua một cái túi để định hình thành những bánh nhỏ và cuối cùng được nướng chín. Bánh su kem có thể thêm thành phần Sô cô la để tăng vị hấp dẫn. Bánh có xuất xứ từ nước Pháp.', 'sukemdau.jpg', '2016-10-25 17:19:00', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `isAdmin` tinyint(1) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remember_token` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `isAdmin`, `name`, `email`, `password`, `phone`, `address`, `remember_token`, `created_at`, `updated_at`) VALUES
(6, 0, 'Hương Hương', 'huonghuong08.php@gmail.com', '$2y$10$rGY4KT6ZSMmLnxIbmTXrsu2xdgRxm8x0UTwCyYCAzrJ320kYheSRq', '23456789', 'Hoàng Diệu 2', NULL, '2017-03-23 07:17:33', '2017-03-23 07:17:33'),
(13, NULL, 'Dang Kieu Nga', 'dangthivan30@gmail.com', '$2y$10$4tpevRV4lKcvF8rAMMu6KufN4cj4NF9FjTmXCXoYK3uu8xgvek2mG', '01648915367', 'Thanh Hoa', '2iww4N2VHWUI63ooahwqD0XZK6Dxs0ZuKEcUOWbGYVIyCzSof5gefyllEmE1', '2017-12-10 10:07:17', '2017-12-10 10:07:17'),
(15, NULL, 'dangvantruong', 'dangvantruong199896@gmail.com', '$2y$10$uqSkrmHehv78S7/wM1fXkeg4exdsvc2SnEYIWhN24R3g226YcI0G.', '12345678', 'Hà Nội', 'pYGxKietYxTzuJRJxJlaQQSif9ityyomUtPg6z1j3yTflGpvTbB4uiKRb9YV', '2017-12-11 08:00:40', '2017-12-11 08:00:40'),
(19, 0, 'Truong Dang', 'dangvantruong199996@gmail.com', '$2y$10$owoOK6OWIBGqTMNlJe.W4ugS4abfMcK6LU6hssNnkK6ppBWuneKLa', '01648815367', 'Hà Nội', 'MXiVAtjYclev5aEYMC1ZhWVpQVRpJZRdZeaMaGoddD6re8yK7sHFvqXw0qWC', '2017-12-22 03:08:00', '2017-12-22 03:08:00'),
(20, NULL, 'Dang Van Truong', 'dangvantruong1996@gmail.com', '$2y$10$5p4m7ym/SCsBy9ubeQKt..ZeY5naBppGhi3dblAVd8tzTFYuGjn0S', '01648815367', 'Hà Nội', 'JelgdK9aa513fvy5Pxx21RrY32homMLkuM85qLcTWrVg3pvBiKf9g9u1nGaz', '2018-01-12 08:26:28', '2018-01-12 08:26:28'),
(21, NULL, 'Đặng Văn Trường', 'dangvantruong19996@gmail.com', '$2y$10$RLo7Is8gAlW.cKyilRd30u7lsBhF2m9t3n8L07ksbloJ3SZ1XRwPq', '01648815367', 'Hà Nội', NULL, '2018-01-24 06:52:58', '2018-01-24 06:52:58'),
(22, NULL, 'Admin', 'dangtruong1996@gmail.com', '$2y$10$TVC26xccaXDbBCuEZz8tZ.rZzjTQykzkYnv61iutpP4b.TAQRofxi', '01648815367', '29', NULL, '2018-02-01 01:39:19', '2018-02-01 01:39:19');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bills`
--
ALTER TABLE `bills`
  ADD PRIMARY KEY (`id`);
--
-- Chỉ mục cho bảng `table`
--
ALTER TABLE `table`
  ADD PRIMARY KEY (`id`);
--
-- Chỉ mục cho bảng `floor`
--
ALTER TABLE `floor`
  ADD PRIMARY KEY (`id`);
--
-- Chỉ mục cho bảng `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bill_detail_ibfk_2` (`id_product`);

--
-- Chỉ mục cho bảng `boss`
--
ALTER TABLE `boss`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `chef`
--
ALTER TABLE `chef`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `intro`
--
ALTER TABLE `intro`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `pots`
--
ALTER TABLE `pots`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `products_id_type_foreign` (`id_type`);

--
-- Chỉ mục cho bảng `slide`
--
ALTER TABLE `slide`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `type_products`
--
ALTER TABLE `type_products`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `bills`
--
ALTER TABLE `bills`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT cho bảng `bill_detail`
--
ALTER TABLE `bill_detail`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
--
-- AUTO_INCREMENT cho bảng `order`
--
ALTER TABLE `order`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT cho bảng `floor`
--
ALTER TABLE `floor`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
--
-- AUTO_INCREMENT cho bảng `table`
--
ALTER TABLE `table`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
--
-- AUTO_INCREMENT cho bảng `boss`
--
ALTER TABLE `boss`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT cho bảng `chef`
--
ALTER TABLE `chef`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT cho bảng `intro`
--
ALTER TABLE `intro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT cho bảng `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT cho bảng `pots`
--
ALTER TABLE `pots`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;
--
-- AUTO_INCREMENT cho bảng `slide`
--
ALTER TABLE `slide`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT cho bảng `type_products`
--
ALTER TABLE `type_products`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_id_type_foreign` FOREIGN KEY (`id_type`) REFERENCES `type_products` (`id`);
COMMIT;
--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `table`
  ADD CONSTRAINT `floor_id_foreign` FOREIGN KEY (`id_floor`) REFERENCES `floor` (`id`);
COMMIT;
--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `order_id_foreign` FOREIGN KEY (`id_order`) REFERENCES `order` (`id`);
COMMIT;
--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `product_id_foreign` FOREIGN KEY (`id_product`) REFERENCES `products` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
