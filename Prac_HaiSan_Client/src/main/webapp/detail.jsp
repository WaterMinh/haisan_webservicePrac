<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Product Information</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${hs.id}</td>
		</tr>
		<tr>
			<th>Tên sản phẩm</th>
			<td>${hs.ten}</td>
		</tr>
		<tr>
			<th>Nhà cung cấp</th>
			<td>${hs.ncc}</td>
		</tr>
		<tr>
			<th>Đơn vị tính</th>
			<td>${hs.dvt}</td>
		</tr>
		<tr>
			<th>Số lượng</th>
			<td>${hs.soluong}</td>
		</tr>
		<tr>
			<th>Gía tiền</th>
			<td>${hs.giatien}</td>
		</tr>
		<tr>
			<th>Tình trạng</th>
			<td>${hs.tinhtrang?"Còn":"Hết"}</td>
		</tr>
		<tr>
			<th>Anh</th>
			<td>${hs.anh}</td>
		</tr>
	</table>
	<a href="Home">Back</a>

</body>
</html>