/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 27/10/2024 23:52:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment`  (
  `id` int NOT NULL,
  `studentId` int NULL DEFAULT NULL,
  `teacherId` int NULL DEFAULT NULL,
  `parentId` int NULL DEFAULT NULL,
  `appointment` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES (1, 101, 201, 301, '2024-10-27');
INSERT INTO `appointment` VALUES (2, 102, 202, 302, '2024-10-28');
INSERT INTO `appointment` VALUES (3, 103, 203, 303, '2024-10-29');
INSERT INTO `appointment` VALUES (4, 104, 204, 304, '2024-10-30');
INSERT INTO `appointment` VALUES (5, 105, 205, 305, '2024-10-31');
INSERT INTO `appointment` VALUES (6, 106, 206, 306, '2024-11-01');
INSERT INTO `appointment` VALUES (7, 107, 207, 307, '2024-11-02');
INSERT INTO `appointment` VALUES (8, 108, 208, 308, '2024-11-03');
INSERT INTO `appointment` VALUES (9, 109, 209, 309, '2024-11-04');
INSERT INTO `appointment` VALUES (10, 110, 210, 310, '2024-11-05');

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `blogId` int NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `publisher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role` int NOT NULL,
  `category` int NOT NULL,
  `blogCreateTime` timestamp NOT NULL,
  PRIMARY KEY (`blogId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, 'Introduction to Java', 'Content about Java programming', 'John Doe', 1, 101, '2024-01-01 10:00:00');
INSERT INTO `blog` VALUES (2, 'Advanced Python', 'Deep dive into Python features', 'Jane Smith', 2, 102, '2024-02-01 11:00:00');
INSERT INTO `blog` VALUES (3, 'Web Development', 'Basics of web development', 'Alice Brown', 1, 103, '2024-03-01 12:00:00');
INSERT INTO `blog` VALUES (4, 'AI in Healthcare', 'Applications of AI in medical field', 'Bob White', 2, 104, '2024-04-01 13:00:00');
INSERT INTO `blog` VALUES (5, 'Blockchain Basics', 'Understanding blockchain technology', 'Charlie Green', 3, 105, '2024-05-01 14:00:00');
INSERT INTO `blog` VALUES (6, 'Cloud Computing', 'Introduction to cloud services', 'Daniel Blue', 1, 106, '2024-06-01 15:00:00');
INSERT INTO `blog` VALUES (7, 'Data Science 101', 'Overview of data science techniques', 'Emily Black', 2, 107, '2024-07-01 16:00:00');
INSERT INTO `blog` VALUES (8, 'Mobile Development', 'How to build mobile applications', 'Frank Gray', 1, 108, '2024-08-01 17:00:00');
INSERT INTO `blog` VALUES (9, 'Cybersecurity Basics', 'Protecting information systems', 'Grace Yellow', 3, 109, '2024-09-01 18:00:00');
INSERT INTO `blog` VALUES (10, 'Big Data Analytics', 'Working with large data sets', 'Harry Violet', 2, 110, '2024-10-01 19:00:00');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `commentId` int NOT NULL,
  `role` int NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `publisher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `createTime` timestamp NOT NULL,
  `blogId` int NULL DEFAULT NULL,
  PRIMARY KEY (`commentId`) USING BTREE,
  INDEX `blogId`(`blogId`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`blogId`) REFERENCES `blog` (`blogId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, 'Great post on Java!', 'John Doe', '2024-01-02 10:30:00', 1);
INSERT INTO `comment` VALUES (2, 2, 'Python tips were really helpful.', 'Jane Smith', '2024-02-02 11:30:00', 2);
INSERT INTO `comment` VALUES (3, 1, 'Interesting article on web development.', 'Alice Brown', '2024-03-02 12:30:00', 3);
INSERT INTO `comment` VALUES (4, 2, 'AI applications are fascinating!', 'Bob White', '2024-04-02 13:30:00', 4);
INSERT INTO `comment` VALUES (5, 3, 'Blockchain seems promising.', 'Charlie Green', '2024-05-02 14:30:00', 5);
INSERT INTO `comment` VALUES (6, 1, 'Cloud computing is the future.', 'Daniel Blue', '2024-06-02 15:30:00', 6);
INSERT INTO `comment` VALUES (7, 2, 'Data science overview was insightful.', 'Emily Black', '2024-07-02 16:30:00', 7);
INSERT INTO `comment` VALUES (8, 1, 'Mobile app development is exciting.', 'Frank Gray', '2024-08-02 17:30:00', 8);
INSERT INTO `comment` VALUES (9, 3, 'Cybersecurity is crucial in today\'s world.', 'Grace Yellow', '2024-09-02 18:30:00', 9);
INSERT INTO `comment` VALUES (10, 2, 'Big data analytics is a game changer.', 'Harry Violet', '2024-10-02 19:30:00', 10);

-- ----------------------------
-- Table structure for conversation
-- ----------------------------
DROP TABLE IF EXISTS `conversation`;
CREATE TABLE `conversation`  (
  `id` int NOT NULL,
  `message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `conversationDate` datetime NULL DEFAULT NULL,
  `teacherId` int NULL DEFAULT NULL,
  `studentId` int NULL DEFAULT NULL,
  `parentId` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of conversation
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `credit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `teacherId` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'Mathematics', 'Introduction to Algebra and Calculus', '4', 101);
INSERT INTO `course` VALUES (2, 'Physics', 'Basics of Mechanics and Thermodynamics', '3', 102);
INSERT INTO `course` VALUES (3, 'Chemistry', 'Organic and Inorganic Chemistry', '4', 103);
INSERT INTO `course` VALUES (4, 'Biology', 'Cell Biology and Genetics', '3', 104);
INSERT INTO `course` VALUES (5, 'Computer Science', 'Introduction to Programming', '5', 105);
INSERT INTO `course` VALUES (6, 'History', 'World History from 1500', '3', 106);
INSERT INTO `course` VALUES (7, 'Philosophy', 'Ethics and Logic', '2', 107);
INSERT INTO `course` VALUES (8, 'Economics', 'Microeconomics and Macroeconomics', '4', 108);
INSERT INTO `course` VALUES (9, 'Literature', 'Introduction to English Literature', '3', 109);
INSERT INTO `course` VALUES (10, 'Art', 'History of Modern Art', '2', 110);

-- ----------------------------
-- Table structure for forum
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum`  (
  `id` int NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of forum
-- ----------------------------
INSERT INTO `forum` VALUES (1, 'The Great Gatsby', 'Literature');
INSERT INTO `forum` VALUES (2, 'To Kill a Mockingbird', 'Literature');
INSERT INTO `forum` VALUES (3, '1984', 'Dystopian');
INSERT INTO `forum` VALUES (4, 'A Brief History of Time', 'Science');
INSERT INTO `forum` VALUES (5, 'The Selfish Gene', 'Science');
INSERT INTO `forum` VALUES (6, 'The Catcher in the Rye', 'Literature');
INSERT INTO `forum` VALUES (7, 'Sapiens: A Brief History of Humankind', 'History');
INSERT INTO `forum` VALUES (8, 'Thinking, Fast and Slow', 'Psychology');
INSERT INTO `forum` VALUES (9, 'The Art of War', 'Strategy');
INSERT INTO `forum` VALUES (10, 'The Lean Startup', 'Business');

-- ----------------------------
-- Table structure for gallery
-- ----------------------------
DROP TABLE IF EXISTS `gallery`;
CREATE TABLE `gallery`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `imgUrl` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片地址',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of gallery
-- ----------------------------
INSERT INTO `gallery` VALUES (1, '/test', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int NOT NULL,
  `enrollmentDate` datetime NULL DEFAULT NULL,
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '2021-09-01 00:00:00', 'Computer Science');
INSERT INTO `student` VALUES (2, '2021-09-01 00:00:00', 'Mechanical Engineering');
INSERT INTO `student` VALUES (3, '2021-09-01 00:00:00', 'Business Administration');
INSERT INTO `student` VALUES (4, '2021-09-01 00:00:00', 'Electrical Engineering');
INSERT INTO `student` VALUES (5, '2021-09-01 00:00:00', 'Biology');
INSERT INTO `student` VALUES (6, '2022-09-01 00:00:00', 'Chemistry');
INSERT INTO `student` VALUES (7, '2022-09-01 00:00:00', 'Physics');
INSERT INTO `student` VALUES (8, '2022-09-01 00:00:00', 'Mathematics');
INSERT INTO `student` VALUES (9, '2022-09-01 00:00:00', 'Economics');
INSERT INTO `student` VALUES (10, '2022-09-01 00:00:00', 'Art History');

SET FOREIGN_KEY_CHECKS = 1;
