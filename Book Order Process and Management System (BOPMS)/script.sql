USE [master]
GO
/****** Object:  Database [dbBOPMS]    Script Date: 9/24/2020 4:03:50 PM ******/
CREATE DATABASE [dbBOPMS]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'dbBOPMS', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\dbBOPMS.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'dbBOPMS_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\dbBOPMS_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [dbBOPMS] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [dbBOPMS].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [dbBOPMS] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [dbBOPMS] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [dbBOPMS] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [dbBOPMS] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [dbBOPMS] SET ARITHABORT OFF 
GO
ALTER DATABASE [dbBOPMS] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [dbBOPMS] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [dbBOPMS] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [dbBOPMS] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [dbBOPMS] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [dbBOPMS] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [dbBOPMS] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [dbBOPMS] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [dbBOPMS] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [dbBOPMS] SET  DISABLE_BROKER 
GO
ALTER DATABASE [dbBOPMS] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [dbBOPMS] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [dbBOPMS] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [dbBOPMS] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [dbBOPMS] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [dbBOPMS] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [dbBOPMS] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [dbBOPMS] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [dbBOPMS] SET  MULTI_USER 
GO
ALTER DATABASE [dbBOPMS] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [dbBOPMS] SET DB_CHAINING OFF 
GO
ALTER DATABASE [dbBOPMS] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [dbBOPMS] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [dbBOPMS] SET DELAYED_DURABILITY = DISABLED 
GO
USE [dbBOPMS]
GO
/****** Object:  Table [dbo].[admin]    Script Date: 9/24/2020 4:03:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[admin](
	[adminId] [varchar](50) NOT NULL,
	[adminName] [varchar](50) NULL,
	[adminEmail] [varchar](50) NULL,
	[adminPassword] [varchar](10) NOT NULL,
	[adminAddress] [varchar](200) NULL,
	[adminPhone] [varchar](14) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[adminId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[books]    Script Date: 9/24/2020 4:03:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[books](
	[bookISBN] [varchar](13) NOT NULL,
	[bookName] [varchar](50) NOT NULL,
	[bookAuthor] [varchar](200) NOT NULL,
	[bookPublisher] [varchar](50) NOT NULL,
	[bookCategory] [varchar](50) NOT NULL,
	[buyingPrice] [real] NULL,
	[sellingPrice] [real] NULL,
	[stocks] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[bookISBN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[customer]    Script Date: 9/24/2020 4:03:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[customer](
	[customerId] [varchar](50) NOT NULL,
	[customerName] [varchar](50) NOT NULL,
	[customerEmail] [varchar](50) NULL,
	[customerAddress] [varchar](200) NULL,
	[customerPhone] [varchar](11) NOT NULL,
	[customerType] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[customerId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[perPerchaseOrder]    Script Date: 9/24/2020 4:03:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[perPerchaseOrder](
	[poId] [varchar](50) NOT NULL,
	[adminId] [varchar](50) NOT NULL,
	[customerId] [varchar](50) NULL,
	[poDate] [datetime] NULL DEFAULT (getdate()),
	[deliveryDate] [date] NULL,
	[deliveredOrNot] [tinyint] NULL,
	[totalIncome] [real] NULL,
PRIMARY KEY CLUSTERED 
(
	[poId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[perPObooks]    Script Date: 9/24/2020 4:03:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[perPObooks](
	[bookISBN] [varchar](13) NOT NULL,
	[bookPieces] [int] NOT NULL,
	[poId] [varchar](50) NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[perSbooks]    Script Date: 9/24/2020 4:03:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[perSbooks](
	[bookISBN] [varchar](13) NOT NULL,
	[bookPieces] [int] NOT NULL,
	[supplyId] [varchar](50) NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[perSupplies]    Script Date: 9/24/2020 4:03:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[perSupplies](
	[supplyId] [varchar](50) NOT NULL,
	[adminId] [varchar](50) NOT NULL,
	[payment] [real] NULL,
	[supplierId] [varchar](50) NULL,
	[supplyDate] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[supplyId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[supplier]    Script Date: 9/24/2020 4:03:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[supplier](
	[supplierId] [varchar](50) NOT NULL,
	[supplierName] [varchar](50) NOT NULL,
	[supplierEmail] [varchar](50) NULL,
	[supplierPhone] [varchar](11) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[supplierId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[admin] ([adminId], [adminName], [adminEmail], [adminPassword], [adminAddress], [adminPhone]) VALUES (N'A02', N'Fahmid', N'fahmid@gmail.com', N'058', N'Khilgaon', N'01612457846')
INSERT [dbo].[admin] ([adminId], [adminName], [adminEmail], [adminPassword], [adminAddress], [adminPhone]) VALUES (N'A03', N'Najrul', N'najrul@gmail.com', N'061', N'Mohakhli', N'01612457847')
INSERT [dbo].[books] ([bookISBN], [bookName], [bookAuthor], [bookPublisher], [bookCategory], [buyingPrice], [sellingPrice], [stocks]) VALUES (N'B001', N'DRACULA', N'Bram Stoker', N'Sheba', N'Horror', 145, 170, 28)
INSERT [dbo].[books] ([bookISBN], [bookName], [bookAuthor], [bookPublisher], [bookCategory], [buyingPrice], [sellingPrice], [stocks]) VALUES (N'B002', N'Oliver Twist', N'Charles Dickens', N'Panjeri', N'Horror', 123, 150, 15)
INSERT [dbo].[books] ([bookISBN], [bookName], [bookAuthor], [bookPublisher], [bookCategory], [buyingPrice], [sellingPrice], [stocks]) VALUES (N'B003', N'Moyurakkhi', N'Humayun Ahmed', N'Anondo', N'Horror', 120, 150, 23)
INSERT [dbo].[books] ([bookISBN], [bookName], [bookAuthor], [bookPublisher], [bookCategory], [buyingPrice], [sellingPrice], [stocks]) VALUES (N'B004', N'Jiib', N'chill', N'chill', N'chill', 130, 160, 48)
INSERT [dbo].[books] ([bookISBN], [bookName], [bookAuthor], [bookPublisher], [bookCategory], [buyingPrice], [sellingPrice], [stocks]) VALUES (N'B007', N'test', N'test', N'test', N'test', 120, 220, 7)
INSERT [dbo].[books] ([bookISBN], [bookName], [bookAuthor], [bookPublisher], [bookCategory], [buyingPrice], [sellingPrice], [stocks]) VALUES (N'b008', N'a', N'a', N'a', N'a', 12, 11, 30)
INSERT [dbo].[books] ([bookISBN], [bookName], [bookAuthor], [bookPublisher], [bookCategory], [buyingPrice], [sellingPrice], [stocks]) VALUES (N'B009', N'dd', N'd', N'd', N'd', 100, 200, 5)
INSERT [dbo].[books] ([bookISBN], [bookName], [bookAuthor], [bookPublisher], [bookCategory], [buyingPrice], [sellingPrice], [stocks]) VALUES (N'c', N'c', N'c', N'c', N'c', 1, 2, 3)
INSERT [dbo].[customer] ([customerId], [customerName], [customerEmail], [customerAddress], [customerPhone], [customerType]) VALUES (N'C01', N'Rahim', N'ra@gmail.com', N'Gulshan', N'01622457835', N'REGULAR')
INSERT [dbo].[customer] ([customerId], [customerName], [customerEmail], [customerAddress], [customerPhone], [customerType]) VALUES (N'C02', N'Karim', N'ka@gmail.com', N'Dhaka', N'01622457836', N'PREMIUM')
INSERT [dbo].[customer] ([customerId], [customerName], [customerEmail], [customerAddress], [customerPhone], [customerType]) VALUES (N'C03', N'Abul', N'ab@gmail.com', N'Uttora', N'01622457837', N'REGULAR')
INSERT [dbo].[customer] ([customerId], [customerName], [customerEmail], [customerAddress], [customerPhone], [customerType]) VALUES (N'C4', N'check', N'check', N'check', N'02315025455', N'REGULAR')
INSERT [dbo].[customer] ([customerId], [customerName], [customerEmail], [customerAddress], [customerPhone], [customerType]) VALUES (N'C5', N'a', N'a', N'a', N'a', N'REGULAR')
INSERT [dbo].[customer] ([customerId], [customerName], [customerEmail], [customerAddress], [customerPhone], [customerType]) VALUES (N'C6', N'b', N'b', N'b', N'b', N'REGULAR')
INSERT [dbo].[customer] ([customerId], [customerName], [customerEmail], [customerAddress], [customerPhone], [customerType]) VALUES (N'C7', N'c', N'c', N'c', N'c', N'REGULAR')
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'O001', N'A02', NULL, CAST(N'2020-09-24 03:15:37.880' AS DateTime), NULL, NULL, 1)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'O2', N'A02', NULL, CAST(N'2020-09-24 03:17:33.547' AS DateTime), NULL, NULL, 1)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'O3', N'A02', N'C02', CAST(N'2020-09-24 03:19:35.610' AS DateTime), NULL, 1, 1)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P001', N'A02', N'C02', CAST(N'2020-09-22 03:53:18.100' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P10', N'A02', N'C02', CAST(N'2020-09-22 17:32:48.907' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P11', N'A02', N'C02', CAST(N'2020-09-22 17:34:11.257' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P12', N'A02', N'C02', CAST(N'2020-09-22 17:43:46.513' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P13', N'A02', N'C02', CAST(N'2020-09-22 17:46:51.433' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P14', N'A02', N'C02', CAST(N'2020-09-22 17:49:33.377' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P15', N'A02', N'C02', CAST(N'2020-09-22 17:51:16.513' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P16', N'A02', N'C02', CAST(N'2020-09-22 17:52:02.240' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P17', N'A02', N'C02', CAST(N'2020-09-22 21:41:50.153' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P18', N'A02', N'C01', CAST(N'2020-09-22 21:44:47.310' AS DateTime), NULL, 1, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P19', N'A02', N'C02', CAST(N'2020-09-23 02:17:35.290' AS DateTime), NULL, 1, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P2', N'A02', N'C02', CAST(N'2020-09-22 03:53:39.440' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P20', N'A02', N'C02', CAST(N'2020-09-23 02:21:03.400' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P21', N'A02', N'C02', CAST(N'2020-09-23 02:26:02.990' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P22', N'A02', N'C02', CAST(N'2020-09-23 02:29:12.000' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P23', N'A02', N'C02', CAST(N'2020-09-23 02:33:50.920' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P24', N'A02', N'C02', CAST(N'2020-09-23 02:34:47.427' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P25', N'A02', N'C02', CAST(N'2020-09-23 03:03:53.627' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P26', N'A02', N'C02', CAST(N'2020-09-23 03:16:26.513' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P27', N'A02', N'C02', CAST(N'2020-09-23 03:27:10.427' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P28', N'A02', N'C02', CAST(N'2020-09-23 03:31:46.467' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P29', N'A02', N'C03', CAST(N'2020-09-23 03:37:31.167' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P3', N'A02', N'C02', CAST(N'2020-09-22 03:55:15.403' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P30', N'A02', NULL, CAST(N'2020-09-23 15:14:06.350' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P31', N'A02', NULL, CAST(N'2020-09-23 15:16:32.567' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P32', N'A02', NULL, CAST(N'2020-09-23 15:19:58.727' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P33', N'A02', NULL, CAST(N'2020-09-23 15:22:48.257' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P34', N'A03', N'C01', CAST(N'2020-09-24 14:11:28.757' AS DateTime), CAST(N'2020-09-25' AS Date), 0, 756)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P4', N'A02', N'C02', CAST(N'2020-09-22 03:57:56.147' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P5', N'A02', N'C02', CAST(N'2020-09-22 04:04:19.640' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P6', N'A02', N'C02', CAST(N'2020-09-22 04:05:55.617' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P7', N'A02', N'C02', CAST(N'2020-09-22 04:06:26.983' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P8', N'A02', N'C02', CAST(N'2020-09-22 17:26:19.297' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPerchaseOrder] ([poId], [adminId], [customerId], [poDate], [deliveryDate], [deliveredOrNot], [totalIncome]) VALUES (N'P9', N'A02', N'C02', CAST(N'2020-09-22 17:30:16.827' AS DateTime), NULL, NULL, 100)
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B002', 2, N'P6')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B003', 2, N'P7')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B001', 1, N'P7')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B003', 1, N'P13')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B002', 1, N'P13')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B002', 1, N'P14')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B001', 1, N'P15')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B001', 3, N'P19')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B003', 2, N'P20')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B002', 3, N'P24')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B001', 3, N'P26')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B002', 1, N'P28')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B003', 1, N'P29')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B002', 3, N'P30')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B002', 2, N'P32')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B001', 1, N'P34')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B002', 1, N'P8')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B002', 1, N'P9')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B001', 1, N'P10')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B003', 1, N'P12')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B002', 2, N'P19')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B001', 2, N'P21')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B001', 2, N'P27')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B002', 1, N'P34')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B003', 1, N'P11')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B002', 1, N'P12')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B002', 1, N'P20')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B003', 1, N'P21')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B002', 3, N'P22')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B003', 2, N'P23')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B003', 3, N'P25')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B003', 1, N'P27')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B002', 2, N'P29')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B002', 1, N'P31')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B003', 1, N'P33')
INSERT [dbo].[perPObooks] ([bookISBN], [bookPieces], [poId]) VALUES (N'B004', 2, N'P34')
INSERT [dbo].[supplier] ([supplierId], [supplierName], [supplierEmail], [supplierPhone]) VALUES (N'R01', N'Nayem', N'na@gmail.com', N'01522457837')
INSERT [dbo].[supplier] ([supplierId], [supplierName], [supplierEmail], [supplierPhone]) VALUES (N'R02', N'Moin', N'mo@gmail.com', N'01522457838')
INSERT [dbo].[supplier] ([supplierId], [supplierName], [supplierEmail], [supplierPhone]) VALUES (N'R03', N'Sadman', N'sa@gmail.com', N'01522457839')
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__admin__62E337FDCA32625C]    Script Date: 9/24/2020 4:03:50 PM ******/
ALTER TABLE [dbo].[admin] ADD UNIQUE NONCLUSTERED 
(
	[adminPhone] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__customer__311068C43C877A07]    Script Date: 9/24/2020 4:03:50 PM ******/
ALTER TABLE [dbo].[customer] ADD UNIQUE NONCLUSTERED 
(
	[customerPhone] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__supplier__0BFF4A212C3ED119]    Script Date: 9/24/2020 4:03:50 PM ******/
ALTER TABLE [dbo].[supplier] ADD UNIQUE NONCLUSTERED 
(
	[supplierPhone] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[perSupplies] ADD  DEFAULT (getdate()) FOR [supplyDate]
GO
ALTER TABLE [dbo].[perPerchaseOrder]  WITH CHECK ADD FOREIGN KEY([adminId])
REFERENCES [dbo].[admin] ([adminId])
GO
ALTER TABLE [dbo].[perPerchaseOrder]  WITH CHECK ADD FOREIGN KEY([customerId])
REFERENCES [dbo].[customer] ([customerId])
GO
ALTER TABLE [dbo].[perPObooks]  WITH CHECK ADD FOREIGN KEY([bookISBN])
REFERENCES [dbo].[books] ([bookISBN])
GO
ALTER TABLE [dbo].[perPObooks]  WITH CHECK ADD FOREIGN KEY([poId])
REFERENCES [dbo].[perPerchaseOrder] ([poId])
GO
ALTER TABLE [dbo].[perSbooks]  WITH CHECK ADD FOREIGN KEY([bookISBN])
REFERENCES [dbo].[books] ([bookISBN])
GO
ALTER TABLE [dbo].[perSbooks]  WITH CHECK ADD FOREIGN KEY([supplyId])
REFERENCES [dbo].[perSupplies] ([supplyId])
GO
ALTER TABLE [dbo].[perSupplies]  WITH CHECK ADD FOREIGN KEY([adminId])
REFERENCES [dbo].[admin] ([adminId])
GO
ALTER TABLE [dbo].[perSupplies]  WITH CHECK ADD FOREIGN KEY([supplierId])
REFERENCES [dbo].[supplier] ([supplierId])
GO
USE [master]
GO
ALTER DATABASE [dbBOPMS] SET  READ_WRITE 
GO
