-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 29, 2020 lúc 10:48 AM
-- Phiên bản máy phục vụ: 10.1.36-MariaDB
-- Phiên bản PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bookshop`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `author`
--

CREATE TABLE `author` (
  `id` int(11) NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `author`
--

INSERT INTO `author` (`id`, `address`, `email`, `name`) VALUES
(1, '5 Tomscot Junction', 'lbarajaz0@dion.ne.jp', 'Lilias Barajaz'),
(2, '0 Esker Drive', 'blenz1@ebay.co.uk', 'Barty Lenz'),
(3, '89 Sunbrook Crossing', 'aelkin2@de.vu', 'Ansley Elkin'),
(4, '0 Shopko Pass', 'ccorderoy3@flavors.me', 'Cort Corderoy'),
(5, '400 Cambridge Crossing', 'spietron4@exblog.jp', 'Shaun Pietron'),
(6, '3 Veith Center', 'mfirmin5@soundcloud.com', 'Meredithe Firmin'),
(7, '32803 Eastlawn Center', 'rbechley6@ifeng.com', 'Rossy Bechley'),
(8, '139 Fair Oaks Avenue', 'jwhitwood7@pagesperso-orange.fr', 'Jobye Whitwood'),
(9, '6 Monica Parkway', 'fcamin8@cam.ac.uk', 'Flossie Camin'),
(10, '064 Longview Park', 'nbrotherton9@123-reg.co.uk', 'Nicoline Brotherton'),
(11, '30 Upham Crossing', 'eshellsheerea@gnu.org', 'Elsi Shellsheere'),
(12, '17871 Hudson Drive', 'sgodilingtonb@etsy.com', 'Sib Godilington'),
(13, '757 Marcy Park', 'rpopelayc@geocities.com', 'Rici Popelay'),
(14, '246 Shasta Lane', 'jgrigoryevd@umich.edu', 'Josefina Grigoryev'),
(16, '31786 Forest Run Hill', 'ggutteridgef@who.int', 'Genni Gutteridge'),
(17, '51185 Dottie Street', 'fcardillog@google.cn', 'Frasco Cardillo'),
(18, '7666 Clarendon Point', 'kchevinh@cloudflare.com', 'Kathi Chevin'),
(19, '5 Sage Park', 'gweekleyi@tripod.com', 'Gratia Weekley');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  `publisher_id` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `book`
--

INSERT INTO `book` (`id`, `amount`, `image`, `name`, `price`, `author_id`, `publisher_id`, `created_date`) VALUES
(88, 40, '/books/file/1584716141-r1.jpg', 'New World', '100000', 2, 4, '2020-03-20 14:55:43'),
(89, 50, '/books/file/1584716162-r2.jpg', 'Fisher Queen\'s Dinasty', '90000', 3, 4, '2020-03-20 14:56:46'),
(90, 80, '/books/file/1584716213-r3.jpg', 'Barry Eisler', '70000', 4, 2, '2020-03-20 14:57:23'),
(91, 78, '/books/file/1584716252-r4.jpg', 'From Paris', '89000', 5, 1, '2020-03-20 14:58:04'),
(92, 67, '/books/file/1584716291-r5.jpg', 'Trust me not', '99000', 6, 4, '2020-03-20 14:58:32'),
(93, 67, '/books/file/1584716322-img1.jpg', 'Lilly Singh', '89000', 7, 1, '2020-03-20 14:59:14'),
(94, 100, '/books/file/1584716360-img2.jpg', 'How to write', '109000', 8, 1, '2020-03-20 14:59:48'),
(95, 50, '/books/file/1584716397-img3.jpg', '7-Day Self', '150000', 8, 4, '2020-03-20 15:00:24'),
(96, 70, '/books/file/1584716434-img4.jpg', 'The Ring of Truth', '105000', 9, 4, '2020-03-20 15:01:07'),
(97, 47, '/books/file/1584777368-nxbtre_full_06372017_103735.u547.d20170117.t105220.139884.jpg', 'Từ tốt đến vĩ đại', '50000', 9, 1, '2020-03-21 07:56:33'),
(98, 23, '/books/file/1584777437-nhalanhdao.u2769.d20170307.t090846.484463.jpg', 'Nhà lãnh đạo không chức danh', '67000', 4, 1, '2020-03-21 07:57:41'),
(99, 56, '/books/file/1584777487-cee4bf9b4a4a4aa31e71f9509cdda6dd.jpg', '3 người thầy vĩ đại', '56000', 12, 1, '2020-03-21 07:58:30'),
(100, 56, '/books/file/1584777530-cc713d2bcecd12ba82d5596ddbcac2d7.jpg', 'Đắc nhân tâm', '48000', 13, 4, '2020-03-21 07:59:07'),
(101, 43, '/books/file/1584777564-312bac222584d52fea5e9d644369b254.jpg', 'Nhà giả kim', '56000', 13, 4, '2020-03-21 07:59:40'),
(102, 23, '/books/file/1584777593-55ab191412e029275824004acb358fce.jpg', 'Tỉ phú bán giày', '77000', 1, 1, '2020-03-21 08:00:07'),
(103, 55, '/books/file/1584777801-0e56b45bddc01b57277484865818ab9b.jpg', 'Đừng lựa chọn an nhàn khi còn trẻ', '45000', 18, 1, '2020-03-21 08:03:36'),
(104, 55, '/books/file/1584777824-841d0260cc305115f6753c25caadd5b0.jpg', 'Đọc vị bất kỳ ai', '56000', 16, 1, '2020-03-21 08:03:59'),
(105, 34, '/books/file/1584777850-bfebf4adcb31c8eb5c39fd3779cc4b68.jpg', 'Bạn đáng giá bao nhiêu', '65000', 12, 4, '2020-03-21 08:04:27'),
(106, 45, '/books/file/1584777891-9f680d49c05be61065c81a6e6fce4faa.jpg', 'Đừng bao giờ đi ăn một mình', '77000', 14, 2, '2020-03-21 08:05:13'),
(107, 55, '/books/file/1584793771-khi-hoi-tho-hoa-thinh-khong.u5464.d20170726.t170655.288851.jpg', 'Khi hơi thở hóa thinh không', '69000', 12, 1, '2020-03-21 12:29:49'),
(108, 56, '/books/file/1584793825-img301.u3059.d20170616.t102644.74862.jpg', 'Nếu tôi biết được khi còn 20', '60000', 17, 4, '2020-03-21 12:30:56'),
(109, 67, '/books/file/1584793983-f88080bba78a779fb78e1b76b73a9813.jpg', 'Sống thực tế giữa đời thực dụng', '60000', 5, 7, '2020-03-21 12:33:21'),
(110, 66, '/books/file/1584794009-999460db5daf4fef7d8e61529eec43b6.jpg', 'Tìm mình trong thế giới hậu tuổi thơ', '68000', 13, 6, '2020-03-21 12:33:57'),
(111, 78, '/books/file/1584794044-6304c47fec56e6f0b2110be65af0c7c2.jpg', 'Dám bị ghét', '69000', 6, 5, '2020-03-21 12:34:22'),
(112, 55, '/books/file/1584794069-71adf6efc20c62819cb93633953f822c.jpg', 'Sức mạnh tiềm thức', '49000', 5, 5, '2020-03-21 12:34:50'),
(113, 77, '/books/file/1584794098-2f70de3ea7eec9c34f55e402254e27ed.jpg', 'Bước chậm lại giữa thế gian vội vã', '67000', 10, 5, '2020-03-21 12:35:27'),
(114, 88, '/books/file/1584794133-0de85aae6089eec7055eeb3e0239d312.jpg', 'Cà phê cùng Tony', '78000', 6, 3, '2020-03-21 12:35:53'),
(115, 88, '/books/file/1584794159-0ba349a0af272577cd7e6290c1c1b52e.jpg', 'Điểm đến của cuộc đời', '78000', 19, 5, '2020-03-21 12:36:16'),
(116, 200, '/books/file/1584716045-product1.jpg', 'Harry Potter', '40000', 1, 1, '2020-03-20 14:54:08'),
(119, 196, '/books/file/1585412372-yeu_lam_anh__1_2018_07_05_09_21_59.jpg', 'Yêu lầm anh', '45000', 4, 7, '2020-03-28 16:20:01');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book_category`
--

CREATE TABLE `book_category` (
  `book_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `total_money` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `cart`
--

INSERT INTO `cart` (`id`, `created_date`, `total_money`, `user_id`, `status`) VALUES
(8, '2020-03-25 14:57:23', '272000', 11, b'1'),
(9, '2020-03-25 18:28:58', '257000', 16, b'1'),
(10, '2020-03-26 04:19:38', '134000', 11, b'1'),
(11, '2020-03-26 04:34:04', '67000', 11, b'1'),
(12, '2020-03-26 05:43:58', '67000', 16, b'1'),
(13, '2020-03-26 07:03:53', '127000', 24, b'1'),
(14, '2020-03-26 07:23:03', '903000', 24, b'1'),
(15, '2020-03-26 09:14:39', '217000', 24, b'1'),
(16, '2020-03-26 09:46:32', '100000', 24, b'1'),
(17, '2020-03-26 10:45:38', '478000', 24, b'1'),
(18, '2020-03-26 16:23:05', '838000', 24, b'1'),
(19, '2020-03-26 17:23:03', '432000', 12, b'1'),
(20, '2020-03-26 17:36:14', '67000', 12, b'1'),
(22, '2020-03-26 17:41:03', '99000', 12, b'1'),
(23, '2020-03-26 17:44:08', '89000', 12, b'1'),
(24, '2020-03-26 17:55:28', '300000', 12, b'1'),
(25, '2020-03-26 18:19:12', '300000', 12, b'1'),
(26, '2020-03-27 03:19:04', '112000', 12, b'1'),
(27, '2020-03-27 03:19:58', '379000', 13, b'1'),
(28, '2020-03-27 03:22:31', '471000', 14, b'1'),
(29, '2020-03-27 03:29:53', '40000', 14, b'1'),
(30, '2020-03-27 03:30:23', '40000', 15, b'1'),
(31, '2020-03-27 03:40:32', '256000', 15, b'1'),
(32, '2020-03-27 03:56:41', '180000', 15, b'1'),
(33, '2020-03-27 04:01:39', '231000', 24, b'1'),
(34, '2020-03-27 04:02:53', '109000', 24, b'1'),
(35, '2020-03-27 04:05:07', '327000', 24, b'1'),
(36, '2020-03-27 04:10:06', '100000', 24, b'1'),
(37, '2020-03-27 06:00:06', '761000', 24, b'1'),
(38, '2020-03-27 06:20:56', '100000', 24, b'1'),
(39, '2020-03-27 06:21:39', '78000', 24, b'1'),
(40, '2020-03-27 07:30:31', '134000', 16, b'1'),
(41, '2020-03-27 07:59:47', '67000', 16, b'1'),
(42, '2020-03-27 08:01:02', '67000', 16, b'1'),
(43, '2020-03-27 08:24:42', '145000', 12, b'1'),
(44, '2020-03-27 08:26:43', '70000', 12, b'0'),
(45, '2020-03-27 08:30:21', '49000', 24, b'1'),
(46, '2020-03-27 08:31:51', '67000', 24, b'1'),
(47, '2020-03-27 08:38:38', '140000', 24, b'1'),
(48, '2020-03-27 13:24:50', '210000', 24, b'1'),
(49, '2020-03-27 13:25:35', '78000', 24, b'1'),
(50, '2020-03-27 13:29:57', '67000', 16, b'1'),
(51, '2020-03-27 16:29:47', '423000', 24, b'1'),
(52, '2020-03-29 07:20:23', '201000', 24, b'1'),
(53, '2020-03-29 07:27:38', '207000', 24, b'1'),
(55, '2020-03-29 07:52:27', '89000', 19, b'0'),
(56, '2020-03-29 08:37:10', '78000', 24, b'1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart_detail`
--

CREATE TABLE `cart_detail` (
  `id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `total_money` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `cart_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `cart_detail`
--

INSERT INTO `cart_detail` (`id`, `amount`, `total_money`, `book_id`, `cart_id`) VALUES
(15, 2, '156000', 115, 8),
(16, 1, '49000', 112, 8),
(17, 1, '67000', 113, 8),
(18, 1, '78000', 115, 9),
(19, 2, '112000', 104, 9),
(20, 1, '67000', 113, 10),
(21, 1, '67000', 113, 10),
(22, 1, '67000', 113, 11),
(23, 1, '67000', 113, 9),
(24, 1, '67000', 113, 12),
(32, 1, '49000', 112, 13),
(33, 1, '78000', 114, 13),
(34, 2, '178000', 93, 14),
(35, 3, '201000', 113, 14),
(36, 5, '390000', 115, 14),
(37, 2, '134000', 113, 14),
(42, 1, '150000', 95, 15),
(44, 1, '67000', 113, 15),
(45, 1, '100000', 88, 16),
(46, 1, '78000', 115, 17),
(47, 4, '400000', 88, 17),
(48, 7, '546000', 114, 18),
(50, 1, '67000', 113, 18),
(51, 3, '147000', 112, 18),
(54, 2, '178000', 91, 19),
(55, 2, '98000', 112, 19),
(56, 2, '156000', 115, 19),
(59, 1, '67000', 113, 20),
(60, 1, '99000', 92, 22),
(61, 1, '89000', 93, 23),
(62, 3, '300000', 88, 24),
(63, 2, '300000', 95, 25),
(64, 2, '112000', 101, 26),
(65, 2, '134000', 113, 27),
(66, 5, '245000', 112, 27),
(67, 1, '45000', 103, 28),
(68, 1, '77000', 102, 28),
(69, 2, '154000', 106, 28),
(70, 3, '195000', 105, 28),
(73, 1, '78000', 115, 31),
(74, 2, '178000', 93, 31),
(77, 2, '180000', 89, 32),
(79, 3, '231000', 106, 33),
(80, 1, '109000', 94, 34),
(82, 3, '327000', 94, 35),
(83, 1, '100000', 88, 36),
(84, 10, '560000', 99, 37),
(85, 3, '201000', 113, 37),
(86, 2, '100000', 97, 38),
(87, 1, '78000', 114, 39),
(88, 2, '134000', 113, 40),
(89, 1, '67000', 113, 41),
(90, 1, '67000', 113, 42),
(91, 1, '67000', 113, 43),
(92, 1, '78000', 115, 43),
(93, 1, '70000', 90, 44),
(94, 1, '49000', 112, 45),
(95, 1, '67000', 113, 46),
(96, 2, '140000', 90, 47),
(97, 2, '210000', 96, 48),
(98, 1, '78000', 115, 49),
(99, 1, '67000', 113, 50),
(101, 1, '99000', 92, 51),
(102, 2, '90000', 119, 51),
(103, 3, '234000', 115, 51),
(104, 3, '201000', 113, 52),
(105, 2, '140000', 90, 53),
(107, 1, '89000', 91, 55),
(108, 1, '67000', 113, 53),
(109, 1, '78000', 114, 56);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `publisher`
--

CREATE TABLE `publisher` (
  `id` int(11) NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `publisher`
--

INSERT INTO `publisher` (`id`, `address`, `email`, `name`) VALUES
(1, '66 Lakewood Gardens Terrace', 'cgulliver0@paginegialle.it', 'NXB Kim Đồng'),
(2, '20 Novick Circle', 'tpond1@joomla.org', 'NXB Trẻ'),
(3, '27 Grover Terrace', 'eclutheram2@hubpages.com', 'NXB Giáo Dục'),
(4, '6 Namekagon Junction', 'mwalstow3@dion.ne.jp', 'NXB Tri Thức'),
(5, '6559 Lake View Junction', 'kchallender4@geocities.com', 'NXB Thế Giới'),
(6, '24 Saint Paul Park', 'hvipan5@wisc.edu', 'NXB Tổng Hợp'),
(7, '333 5th Junction', 'homonahan6@ucoz.ru', 'NXB Lao Động - Xã Hội');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'USER'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `address`, `birthday`, `email`, `name`, `password`, `phone`, `role`) VALUES
(11, 'Thanh xuân, Hà Đông, Hà Nội', NULL, 'duongnguyen@gmail.com', 'Thu Thuy', 'Ha Noi', '0924123456', 'ADMIN'),
(12, 'Luong Yen, Tay Ho, Ha Noi', NULL, 'duong1@gmail.com', 'Pham Dinh hung', '$2a$12$ovELqtfZICEVFZqLRUx/fOHdv7jFrAbQe7bnO3B7I5QgcRzDh7wFi', '0924563112', 'ADMIN'),
(13, 'Tam Trinh, Hoang Mai, Ha Noi', NULL, 'duong2@gmail.com', 'Ho Van Tung', '$2a$12$4zqM.bydJ4Qjh0V55jNgn.4GsdUGf9aHE83Qd94fy5nHkJxElmEgS', '0923543111', 'USER'),
(14, 'Hai Ba Trung, Thanh Xuan, Ha Noi', NULL, 'duong3@gmail.com', 'Le Minh Anh', '$2a$12$9cbnkj1ztT2DhL3vo//LmOKRc6iNjMhfibW1VjsbEMAO8bx2AeYI.', '0941334221', 'USER'),
(15, 'Hai Ba Trung, Ha Noi', NULL, 'duong4@gmail.com', 'Anh Dung', '$2a$12$TXfRs8BcP0ptB0i7homqWunRE3DErKhJdh6lUI3.mn51RmYHmtfC2', '0946553112', 'USER'),
(16, 'Phung Khoang, Ha Dong, Ha Noi', NULL, 'duong5@gmail.com', 'Hoang Van Thai', '$2a$12$lSESI1OBkQMTmrRufNkWBu61xpvn8gxQxB5xSAQZyPWYWmGRGbLyO', '0924667888', 'USER'),
(17, NULL, NULL, 'duong6@gmail.com', 'Hồ Văn Tùng', '$2a$12$H8cJDiVPQ9NkeXogDVFhwOk/hMWRChOrEgKoFxn8w3dAXHwG1Blum', NULL, 'USER'),
(18, NULL, NULL, 'duong7@gmail.com', 'Lê Đình Bảo', '$2a$12$0RP7dSWrYNr6Q0i.KQY6w.qvRIPFxpC3RNlLFZyNu3dlsltJJJBgq', NULL, 'USER'),
(19, 'Hoàng Mai', NULL, 'duong8@gmail.com', 'An Duong', '$2a$12$8UWcblcl6dqaJunyvKOfXuTAQLh0sD4oR5Enf3kDmhNru40YFuuEi', '0924556334', 'USER'),
(20, NULL, NULL, 'duong9@gmall.com', 'Tung Duong', '$2a$12$5eFGaF.CXqsPp/AXhI2m1.B7ovOSOROP/s4ad59oNVUPmtHri.GnK', NULL, 'USER'),
(21, NULL, NULL, 'duong11@gmail.com', 'Hien', '$2a$12$WxjCSxamaWPypPqhm3NKVu8Y5vqo7gagXmJSRjN1jdM1Z33yjHtD.', NULL, 'USER'),
(22, NULL, NULL, 'duong12@gmail.com', 'Nguyễn Minh Tuấn', '$2a$12$Xz1FVxF8LQQhj8XWhkuj1eWP6VEHpyD7WcImA18NXl4oQKvsWdCDK', NULL, 'USER'),
(23, NULL, NULL, 'duong10@gmail.com', 'Hoàng Thế Sơn', '$2a$12$hmpMm6qJ7SO6Rpo1H9SHeOypLFDxMOkkUoJ0.P7o214WQ7ir4Xb7e', NULL, 'USER'),
(24, 'Lê Trọng Tấn, Thanh Xuân, Hà Nội', NULL, 'duong@gmail.com', 'Lê Huỳnh Đức', '$2a$12$ctLq1yDBZ19tgpev1Mu7K.Ccy.QEEJqiYpleQNuJZWAc5l.bbETm6', '0924567998', 'ADMIN');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKklnrv3weler2ftkweewlky958` (`author_id`),
  ADD KEY `FKgtvt7p649s4x80y6f4842pnfq` (`publisher_id`);

--
-- Chỉ mục cho bảng `book_category`
--
ALTER TABLE `book_category`
  ADD KEY `FK72omolospjmdbithvtqe3h3u6` (`category_id`),
  ADD KEY `FKl9nrswqw7tf43i1vyy2u5uqh4` (`book_id`);

--
-- Chỉ mục cho bảng `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl70asp4l4w0jmbm1tqyofho4o` (`user_id`);

--
-- Chỉ mục cho bảng `cart_detail`
--
ALTER TABLE `cart_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKflpu1psdex9le27p7owju2piw` (`book_id`),
  ADD KEY `FKrg4yopd2252nwj8bfcgq5f4jp` (`cart_id`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `author`
--
ALTER TABLE `author`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT cho bảng `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123;

--
-- AUTO_INCREMENT cho bảng `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT cho bảng `cart_detail`
--
ALTER TABLE `cart_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `publisher`
--
ALTER TABLE `publisher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FKgtvt7p649s4x80y6f4842pnfq` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`),
  ADD CONSTRAINT `FKklnrv3weler2ftkweewlky958` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`);

--
-- Các ràng buộc cho bảng `book_category`
--
ALTER TABLE `book_category`
  ADD CONSTRAINT `FK72omolospjmdbithvtqe3h3u6` FOREIGN KEY (`category_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `FKl9nrswqw7tf43i1vyy2u5uqh4` FOREIGN KEY (`book_id`) REFERENCES `category` (`id`);

--
-- Các ràng buộc cho bảng `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `FKl70asp4l4w0jmbm1tqyofho4o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `cart_detail`
--
ALTER TABLE `cart_detail`
  ADD CONSTRAINT `FKflpu1psdex9le27p7owju2piw` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `FKrg4yopd2252nwj8bfcgq5f4jp` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
