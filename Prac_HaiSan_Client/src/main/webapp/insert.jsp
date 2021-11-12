<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Product</title>
</head>
<body>
	<h2>Insert Product</h2>
	
	<form action="Insert" method="post">
		<table border=1>
			<tr>
				<th>Tên </th>
				<td><input type="text" name="ten" value="${hs.ten}" /></td>
			</tr>
			<tr>
				<th>Nhà sản xuất</th>
				<td><input type="text" name="ncc" value="${hs.ncc}" /></td>
			</tr>
			<tr>
				<th>Đơn vị tính</th>
				<td><input type="text" name="dvt" value="${hs.dvt}"/></td>
			</tr>
			<tr>
				<th>Số lượng</th>
				<td><input type="number" name="soluong" value="${hs.soluong}"
					 /></td>
			</tr>
			<tr>
				<th>Gía tiền </th>
				<td><input type="number" name="giatien" value="${hs.giatien}"/></td>
			</tr>
			<tr>
				<th>Tình trạng</th>
				<td><input type="radio" name="tinhtrang" value="${hs.tinhtrang}"/></td>
			</tr>
			<tr>
				<th>Anh</th>
				<td><input type="image" name="anh" value="${hs.anh}"/></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="Thêm mới" /></td>
			</tr>
		</table>
	</form>
	<a href="Home">Back</a>

</body>
</html>