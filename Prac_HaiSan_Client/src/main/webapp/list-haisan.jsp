<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hai San Web</title>
</head>
<body>
	<h1>Wellcome to Hai San web</h1>
	<form action="Home" method="get">
		<input type="text" name="txtSearch"
			placeholder="Tên sản phẩm / Nhà cung cấp"> <input
			type="submit" value="Tìm kiếm">
	</form>

	<hr>
	<a href="insert.jsp">Insert</a>
	<hr>
	<c:forEach items="${page}" var="pg">
		<a href="Home?page=${pg.pageOffset}">${pg.pageNo +1} </a>
	</c:forEach>

	<hr>
	<table border="1">

		<tr>
			<th>ID</th>
			<th>Tên sản phẩm</th>
			<th>Nhà cung cấp</th>
			<th>Đơn vị tính</th>
			<th>Số lượng</th>
			<th>Giá tiền</th>
			<th>Tình trạng</th>
			<th>Ảnh</th>

		</tr>

		<c:forEach items="${lst}" var="hs">
			<tr>
				<td>${hs.id}</td>
				<td>${hs.ten}</td>
				<td>${hs.ncc}</td>
				<td>${hs.dvt}</td>
				<td>${hs.soluong}</td>
				<td>${hs.giatien}</td>
				<td>${hs.tinhtrang?"Còn":"Hết"}</td>
				<td><form
						action="http://localhost:8080/Prac_HaiSan/api/hai-san/upload"
						method="post" enctype="multipart/form-data">
						<input type="file"
							name="file" required="required"> <input type="submit"
							value="Upload file">
					</form></td>
				<td align="center"><a href="Detail?id=${hs.id}">Detail</a></td>
				<td align="center"><a href="Update?idHaiSan=${hs.id}">Update</a></td>
				<td align="center"><a href="Delete?id=${hs.id}">Delete</a></td>
				
			</tr>

		</c:forEach>



	</table>
	<c:forEach items="${page}" var="pg">
		<a href="Home?page=${pg.pageOffset}">${pg.pageNo +1} </a>
	</c:forEach>



</body>
</html>