-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: thuvien
-- ------------------------------------------------------
-- Server version	8.0.18
create database final;
use final;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(200) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `publisher` varchar(200) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `images` varchar(100) DEFAULT NULL,
  `des` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (15,'Lê Minh Hoàng','Giải Thuật Và Lập Trình','NXB Giáo Dục Việt Nam','Giáo trình',11,'giaotrinh1.jpg','Nếu bạn là người đam mê tin học, nếu bạn là người muốn khám phá về lập trình, hẳn bạn phải biết đến một cuốn sách tin học rất nổi tiếng ở Việt Nam trong nhiều năm trở lại đây. Từ những học sinh không chuyên đến những thành viên đội tuyển thi quốc tế tin học, có lẽ không một ai chưa từng học qua cuốn sách được biên soạn bởi một thầy giáo trẻ những đầy tài năng của trường Đại học Sư phạm Hà Nội, thầy Lê Minh Hoàng.'),(16,'Thomas H. Cormen - Charles E. Leiserson','Giáo Trình Thuật Toán','Addison Wesley','Giáo trình',5,'giaotrinh2.jpg','Được sự quan tâm của rất nhiều lập trình viên và sinh viên các trường đại học trên khắp thế giới, ấn bản thứ hai (second edition) của Introduction to Algorithms đã thật sự tạo nên một hiện tượng trong lĩnh vực thuật toán. Với tính chất rõ ràng, toán học chặt chẽ, trong khi vẫn có thể tiếp cận được bởi những người không am hiểu toán học, quyển sách đã thiết lập nên một tiêu chuẩn cho sách giáo khoa; đồng thời là tài liệu tham khảo tốt nhất cho việc giải những bài toán tin học.'),(17,' Nhiều tác giả','Công Nghệ Blockchain','Manning','Giáo trình',7,'giaotrinh3.jpg','Blockchain là chủ đề đang vô cùng nóng trên toàn cầu hiện nay. Nó cùng với Bitcoin và tiền kỹ thuật số trở thành đề tài bàn luận trên rất nhiều mặt báo và trong những cuộc trò chuyện của mọi người. Tuy nhiên, khi nói về blockchain vẫn còn nhiều tranh cãi. Có người lo lắng rằng Bitcoin có thể chỉ là bong bóng, nhiều người cho rằng công nghệ phía sau nó là một sự đột phá, và công nghệ ấy sẽ tiếp tục con đường của mình cho đến khi được chấp nhận và tích hợp với Internet.'),(18,'Nathan Wu','Laravel 5 Cookbook','PACKT Publishing','Giáo trình',8,'giaotrinh4.jpg','Learning Laravel 5: Building Practical Applications is the easiest way to learn web development using Laravel. Throughout 5 chapters, instructor Nathan Wu will teach you how to build many real-world applications from scratch. This bestseller is also completely about you. It has been structured very carefully, teaching you all you need to know from installing your Laravel 5.1 app to deploying it to a live server.'),(19,'Emmett Dulaney','Linux All-In-One For Dummies - 5Th Edition','Manning','Giáo trình',11,'giaotrinh5.jpg','Linux All-in-One For Dummies giải thích mọi thứ bạn cần để bắt đầu và chạy với hệ điều hành Linux phổ biến. Được viết trong phong cách thân thiện và dễ tiếp cận, cuốn sách lý tưởng cho người mới dùng Linux và người đã có một ít kinh nghiệm với hệ điều hành này, cũng như bất kỳ ai đang học chứng chỉ Linux cấp độ 1.'),(20,'Trường Đại Học Luật Hà Nội','Giáo Trình Luật Hành Chính Việt Nam','NXB Giáo Dục Việt Nam','Sách báo',12,'sach1.jpg','Luật hành chính Việt Nam là tổng thể những quy phạm pháp luật điều chỉnh những quan hệ chấp hành và điều chỉnh những quan hệ chấp hành và điều hành phát sinh, phát triển trong lĩnh vực tổ chức và hoạt động hành chính nhà nước. Những quy phạm pháp luật hành chính là công cụ pháp lý cơ bản để thực hiện quản lý nhà nước, thực thi quyền hành pháp – một trong ba loại quyền cơ bản được phân công, phối hợp giữa các cơ quan nhà nước trên cơ sở quyền lực nhà nước được thống nhất'),(21,'Nhiều tác giả','3000 Từ Vựng Tiếng Anh Thông Dụng Nhất','NXB Việt Nam','Sách báo',25,'sach3.jpg','Từ vựng đóng một vai trò đặc biệt quan trọng, nhất là trong giao tiếp. Nhằm đáp ứng nhu cầu đó chúng tôi xin giới thiệu với bạn đọc cuốn 3000 Từ vựng Tiếng Anh thông dụng nhất. Cuốn sách bao gồm 3000 từ vựng căn bản và thông dụng nhất nhằm giúp các bạn nâng cao vốn từ vựng của mình.'),(22,'Nhiều Tác Giả','Bão Lửa U23 – Thường Châu Tuyết Trắng','NXB Việt Nam','Sách báo',32,'sach4.jpg','Đây là một cuốn sách rất đáng đọc vào lúc này, khi những dư âm của chiến công U23 vẫn còn, nhưng cũng là để ngẫm ngợi sâu hơn về nhiều điều liên quan đến họ nói riêng và cả nền bóng đá Việt Nam nói chung.'),(23,'Nguyễn Tứ','Các Kiểu Kiến Trúc Trên Thế Giới','NXB Giáo Dục Việt Nam','Sách báo',7,'sach6.jpg','Các kiểu kiến trúc trên thế giới sẽ cho bạn đọc một bức tranh toàn cảnh về các công trình kiến trúc mà loài người đã tạo dựng nên theo trình tự lịch sử từ thời Trung cổ, phục hưng Châu Âu, thời đại công nghiệp và cho đến hiện đại ngày nay.'),(24,'Michael Duff Newton','Hành Trình Của Linh Hồn','Wrox','Sách báo',13,'sach5.jpg','Bạn có sợ chết không? Bạn có tự hỏi điều gì sẽ xảy ra sau khi bạn chết không? Có thể nào bạn có một linh hồn đến từ đâu đó và sẽ trở về đó sau khi thân xác bạn chết đi, hay đó chỉ là một điều ước ao vì bạn quá sợ hãi?'),(25,' Nguyễn Ngọc Huy',' Võ Hiệp KIM DUNG','NXB Giáo Dục Việt Nam','Văn học',35,'van1.jpg','Một tác phẩm đặc biệt rất hay mặc dù đề tài chỉ nói về tiểu thuyết võ hiệp vốn chỉ có giá trị khi trà dư tửu hậu hay lúc tâm hồn cô đơn trống rỗng. Cuốn sách sẽ giải thích những quan điểm chính trị của tác gia Kim Dung trên góc độ học thuật. Bên cạnh đó giúp bạn đọc giải đáp nhiều thắc mắc khi đọc truyện Kim Dung'),(26,'Trần Bạch Đằng','Lịch Sử Việt Nam','NXB Giáo Dục Việt Nam','Văn học',15,'van2.jpg','Lịch Sử Việt Nam Bằng Tranh là nỗ lực đáng trân trọng của tác giả nhằm phản ánh đất nước và con người Việt Nam theo đúng tiến trình lịch sử với không gian, văn hóa, y phục, tính cách phù hợp với từng thời kỳ, triều đại cụ thể. Bộ sách gồm nhiều tập, mỗi tập viết về thời kỳ hay một nhân vật, một vấn đề tiêu biểu của thời kỳ đó.'),(27,'Terry Eagleton','Tại Sao Mác Đúng?','Manning','Văn học',20,'van3.jpg','Tại sao Mác đúng? là một tác phẩm có giá trị tham khảo tốt, mang lại cho chúng ta thêm một cách nhìn mới, một cơ sở mới để củng cố niềm tin vào chủ nghĩa Mác với vai trò là nền tảng tư tưởng của công cuộc cách mạng xây dựng phát triển đất nước theo con đường xã hội chủ nghĩa.'),(28,'Nhà xuất bản Chính trị quốc gia','Hồ Chí Minh Toàn Tập','Nhà xuất bản Chính trị quốc gia','Văn học',14,'van4.jpg','Hồ Chí Minh toàn tập là bộ sách sưu tầm tổng hợp những bài báo, thư từ, bài diễn văn, bản báo cáo, và các trả lời phỏng vấn truyền thông, báo chí trong và ngoài nước của Hồ Chí Minh, còn được lưu lại từ ghi âm và các số báo cũ hiện lưu giữ trong các viện bảo tàng, do Nhà xuất bản Chính trị quốc gia - Sự thật xuất bản vào năm 1990, 2000, và dự kiến ra mắt độc giả vào năm 2011.'),(29,'Đào Duy Anh','Nguồn gốc dân tộc Việt Nam','NXB Giáo Dục Việt Nam','Văn học',13,'van5.jpg','Trong khóa Đông-phương cổ-sử tôi nhận giảng ở trường Đại-học cách đây mấy tháng, tôi mới bắt đầu giảng về Việt-nam cổ-sử được ít lâu thì trường Đại-học đình giảng. Có mấy người sinh viên yêu cầu tôi cho xuất bản luôn cả tập giảng khóa ấy, hoặc công bố những tập khảo biện về Việt-nam cổ-sử mà tôi đã căn cứ để soạn bài giảng, để giúp những người sinh-viên học cổ-sử có thể tiếp tục sự nghiên cứu của họ');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_lending`
--

DROP TABLE IF EXISTS `book_lending`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_lending` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `lend_date` date NOT NULL,
  `due_date` date NOT NULL,
  `return_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `book_id` (`book_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `book_lending_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `book_lending_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_lending`
--

LOCK TABLES `book_lending` WRITE;
/*!40000 ALTER TABLE `book_lending` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_lending` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `soluong` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `invoice_id` int(11) DEFAULT NULL,
  `options` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (116,2,15,151,1),(117,1,27,151,1),(118,1,23,152,1),(119,1,26,152,1),(120,2,21,152,1),(121,3,23,153,1),(122,2,25,154,1),(123,1,24,155,1),(124,1,27,155,1),(125,1,23,156,0),(126,1,15,157,1),(127,3,19,158,0),(128,1,20,159,1),(129,1,22,160,1),(130,2,25,160,1),(131,2,28,161,1),(132,1,26,162,1),(133,2,19,162,1),(134,1,23,163,0),(135,1,29,164,0);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `ngaymuon` date DEFAULT NULL,
  `ngayhen` date DEFAULT NULL,
  `ngaytra` date DEFAULT NULL,
  `trangthai` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (160,10,'2020-09-01','2020-09-16','2020-09-21','Đã trả',1),(161,10,'2020-09-01','2020-09-23','2020-09-21','Đã trả',1),(162,10,'2020-09-01','2020-09-09','2020-09-21','Đã trả',1),(163,10,'2020-09-01',NULL,NULL,NULL,0),(164,10,'2020-09-01',NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(45) NOT NULL,
  `featured` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Duc','HN','acb@gmail.com','ducvt','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.','ROLE_ADMIN',1),(2,'duc','HN','a@gmail.com','ducc','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.','ROLE_ADMIN',1),(3,'DucVT','HN','a@gmail.com','duc1','$2a$10$W08t1W6BHqQrdM96FloG6.r/6ERb3QRjwszQ0.sihQKeL91ckdaTy','ROLE_USER',1),(10,'Võ Bảo Nguyên','210 Quang Trung, Hà Đông','buiquangson123@gmail.com','son','$2a$10$Ic9TcVHiPAvsSL1N2PsPp.7Q9nDPRqCFQdudvMP/xwaa5po5GcZIe','ROLE_USER',1),(12,'Nguyễn Thị Linh','12 Quang Trung, Hà Đông','buiquangson21@gmail.com','linh','$2a$10$M5ivcLr7USrINpcpIqXbsuIfzdp1Pf/r3fdgzOp6KUo89XZNL1haa','ROLE_USER',1),(14,'Võ Bảo Nguyên','210 Quang Trung, Hà Đông','buiquangson19091998@gmail.com','admin111','$2a$10$b8cr875J7/luTvsWOmoQA./QvfQy2mGhlMANChZ/Jpa4/eV6yKA3e','ROLE_USER',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-21  9:26:08
